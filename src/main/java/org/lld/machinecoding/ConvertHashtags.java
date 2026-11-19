package org.lld.machinecoding;

import java.util.Arrays;
import java.util.Locale;
import java.util.stream.Collectors;

/**
 * Converts a sentence into a hashtag.
 *
 * <p>Rules:
 * <ul>
 *     <li>Words are separated by one or more spaces (leading/trailing spaces are ignored).</li>
 *     <li>The first letter of every word is upper-cased and the remaining letters are lower-cased.</li>
 *     <li>Words are joined without spaces and the result is prefixed with '#'.</li>
 *     <li>A null or blank sentence produces an empty string.</li>
 * </ul>
 *
 * <p>Example: {@code "  hello   JAVA world  "} becomes {@code "#HelloJavaWorld"}.
 */
public class ConvertHashtags {

    public static void main(String[] args) {
        String[] sentences = {
                "I love computer science",
                "  hello   JAVA world  ",
                "single",
                "   ",
                null
        };

        for (String sentence : sentences) {
            System.out.printf("\"%s\" -> \"%s\"%n", sentence, convertToHashtag(sentence));
        }
    }

    // Java 8 streams: O(n) time and O(n) space, where n is the sentence length.
    static String convertToHashtag(String sentence) {
        if (sentence == null || sentence.trim().isEmpty()) {
            return "";
        }

        return Arrays.stream(sentence.trim().split("\\s+"))
                .map(ConvertHashtags::capitalize)
                .collect(Collectors.joining("", "#", ""));
    }

    private static String capitalize(String word) {
        return word.substring(0, 1).toUpperCase(Locale.ROOT)
                + word.substring(1).toLowerCase(Locale.ROOT);
    }
}
