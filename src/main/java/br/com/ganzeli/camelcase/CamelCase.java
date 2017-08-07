package br.com.ganzeli.camelcase;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class CamelCase {

    private static final Pattern ACRONYM = Pattern.compile("[A-Z]+");
    private static final Pattern STARTS_WITH_NUMBER = Pattern.compile("^[0-9].*");
    private static final Pattern ALLOWED_CHARS = Pattern.compile("^[0-9A-Za-zz]+$");

    static List<String> converterCamelCase(String camelCaseString) {
        verifyValidString(camelCaseString);

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

    private static void verifyValidString(String camelCaseString) {
        if (STARTS_WITH_NUMBER.matcher(camelCaseString).matches()) {
            throw new InvalidNumberStartException("não deve começar com números");
        }
        
        if (!ALLOWED_CHARS.matcher(camelCaseString).matches()) {
            throw new InvalidSpecialCharactersException("caracteres especiais não são permitidos, somente letras e números");
        }
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
        if (!ACRONYM.matcher(word).matches()) {
            word = word.toLowerCase();
        }
        return word;
    }

}
