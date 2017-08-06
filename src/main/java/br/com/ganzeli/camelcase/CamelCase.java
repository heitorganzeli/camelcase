package br.com.ganzeli.camelcase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CamelCase {

    
    static List<String> converterCamelCase(String camelCaseString) {
        List<String> words = new ArrayList<>();
        
        int wordStart=0;
        for (int i = 0; i < camelCaseString.toCharArray().length; i++) {
            if ((camelCaseString.toCharArray()[i] >= 'A' && 
                    camelCaseString.toCharArray()[i] <= 'Z') &&
                    i != wordStart) {
                
                words.add(camelCaseString.substring(wordStart, i).toLowerCase());
                wordStart = i;
            }
        }
        words.add(camelCaseString.substring(wordStart, camelCaseString.length()).toLowerCase());
        return words;
    }
    
}
