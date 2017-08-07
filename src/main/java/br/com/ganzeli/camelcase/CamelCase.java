package br.com.ganzeli.camelcase;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class CamelCase {

    private static final Pattern acronym = Pattern.compile("[A-Z]+");

    static List<String> converterCamelCase(String camelCaseString) {
        List<String> words = new ArrayList<>();

        for (int i = 0; i < camelCaseString.toCharArray().length; i++) {
            if (shouldBreak(camelCaseString, i)) {

                words.add(formatWord(camelCaseString.substring(0, i)));
                camelCaseString = camelCaseString.substring(i);
                i = 0;
            }
        }

        words.add(formatWord(camelCaseString));
        System.out.println(String.join(", ", words));
        return words;
    }

    private static boolean shouldBreak(String camelCaseString, int i) {
        return isCapitalLetterOrNumber(camelCaseString.toCharArray()[i])
                && i != 0
                && (!isCapitalLetterOrNumber(camelCaseString.toCharArray()[i - 1])
                || (i < camelCaseString.length() - 1
                && !isCapitalLetterOrNumber(camelCaseString.toCharArray()[i + 1])));
    }

    private static boolean isCapitalLetterOrNumber(char c) {
        return (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
    }

    private static String formatWord(String word) {
        if (!acronym.matcher(word).matches()) {
            word = word.toLowerCase();
        }
        return word;
    }

}
