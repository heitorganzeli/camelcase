package br.com.ganzeli.camelcase;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
        

public class CamelCaseTest {
    @Test
    public void testSingleWordLowerCase() {
        String camelCaseString = "nome";
        List<String> wordList = CamelCase.converterCamelCase(camelCaseString);
        assertThat(wordList, equalTo(Arrays.asList("nome")));
    }
    
    @Test
    public void testSingleCaptalizedWord() {
        String camelCaseString = "Nome";
        List<String> wordList = CamelCase.converterCamelCase(camelCaseString);
        assertThat(wordList, equalTo(Arrays.asList("nome")));
    }
    
    @Test
    public void testComposedWord() {
        String camelCaseString = "nomeComposto";
        List<String> wordList = CamelCase.converterCamelCase(camelCaseString);
        
        assertThat(wordList, equalTo(Arrays.asList("nome", "composto")));
    }
    
    @Test
    public void testCaptalizedComposedWord() {
        String camelCaseString = "NomeComposto";
        List<String> wordList = CamelCase.converterCamelCase(camelCaseString);
        
        assertThat(wordList, equalTo(Arrays.asList("nome", "composto")));
    }
    
    @Test
    public void testAcronym() {
        String camelCaseString = "CPF";
        List<String> wordList = CamelCase.converterCamelCase(camelCaseString);
        
        assertThat(wordList, equalTo(Arrays.asList("CPF")));
    }
    
    @Test
    public void testComposedWordWithAcronym() {
        String camelCaseString = "numeroCPF";
        List<String> wordList = CamelCase.converterCamelCase(camelCaseString);
        
        assertThat(wordList, equalTo(Arrays.asList("numero", "CPF")));
    }
    
    @Test
    public void testComposedWordWithAcronymInTheMiddle() {
        String camelCaseString = "numeroCPFContribuinte";
        List<String> wordList = CamelCase.converterCamelCase(camelCaseString);
        
        assertThat(wordList, equalTo(Arrays.asList("numero", "CPF", "contribuinte")));
    }
    
    @Test
    public void testComposedWordWithNumberInTheMiddle() {
        String camelCaseString = "recupera10Primeiros";
        List<String> wordList = CamelCase.converterCamelCase(camelCaseString);
        
        assertThat(wordList, equalTo(Arrays.asList("recupera", "10", "primeiros")));
    }
    
    @Test(expected = InvalidNumberStartException.class)
    public void testInvalidNumberStart() {
        String camelCaseString = "10Primeiros";
        CamelCase.converterCamelCase(camelCaseString);
    }
    
    @Test(expected = InvalidSpecialCharactersException.class)
    public void testInvalidSpecialCharacters() {
        String camelCaseString = "nome#Composto";
        CamelCase.converterCamelCase(camelCaseString);
    }
    
    
}
