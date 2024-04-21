package com.koubeisi.interview.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * @author KouBeisi
 * @since 2024/4/21
 */
public class ReverseSentenceTest {


    public static String reverseSentence2(String str) {
        if (str == null) {
            return null;
        } else if (str.isEmpty()) {
            return "";
        }

        String[] words = str.split(" ");
        StringBuilder sentence = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            sentence.append(words[i]).append(" ");
        }
        return sentence.toString().trim();
    }


    @ParameterizedTest
    @MethodSource("provideSentence")
    void test2(String sentence, String expected) {
        String result = reverseSentence2(sentence);
        Assertions.assertEquals(expected, result);
    }


    static Stream<Arguments> provideSentence() {
        return Stream.of(
                Arguments.of("I am a student", "student a am I"),
                Arguments.of("", ""),
                Arguments.of(null, null),
                Arguments.of("I am a student.", "student. a am I"),
                Arguments.of("I am a student!", "student! a am I"));
    }

}
