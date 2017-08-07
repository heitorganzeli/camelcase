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
    
    
    
    
}
