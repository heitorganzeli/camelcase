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
}
