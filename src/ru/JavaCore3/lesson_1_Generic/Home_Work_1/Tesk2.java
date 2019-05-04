package ru.JavaCore3.lesson_1_Generic.Home_Work_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tesk2 {
    public static void main(String[] args) {
        String[] words = new String[] {"one","two","three"};
        toArray(words);
    }
    private static void toArray(String[] words) {
        List<String> wordsList = new ArrayList<>(Arrays.asList(words));
        System.out.println(wordsList);
    }
}
