package hw11.service.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Project name: Partizanin_Spring.
 * Date: 16.01.2016.
 * Time: 18:26.
 * To change this template use File|Setting|Editor|File and Code Templates.
 */
public class LangChecker {

    private List<Word> words = new ArrayList<>();

    private String checkLanguage(String word) {
        words.clear();
        StringBuilder rusWords = new StringBuilder();
        StringBuilder ukrWords = new StringBuilder();
        StringBuilder engWords = new StringBuilder();
        StringBuilder rusUkrWords = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            words.add(new Word(Character.toLowerCase(word.charAt(i))));
        }

        for (Word wordsLangValue : words) {
            String words = String.valueOf(wordsLangValue.getCharacter());
            switch (wordsLangValue.getLang()) {
                case "notLang":
                    return String.valueOf(wordsLangValue.getCharacter());
                case "rus":
                    rusWords.append(words);
                    break;
                case "rusUkr":
                    rusUkrWords.append(words);
                    break;
                case "eng":
                    engWords.append(words);
                    break;
                case "ukr":
                    ukrWords.append(words);
                    break;
            }
        }

        int max = getMax(ukrWords.length(), rusWords.length(), rusUkrWords.length(), engWords.length());

        if (max == rusWords.length()) {
            if (engWords.length() != 0) {
                return engWords.toString();
            } else if (ukrWords.length() != 0) {
                return ukrWords.toString();
            } else {
                return "rus";
            }


        } else if (max == rusUkrWords.length()) {

            if (engWords.length() != 0) {
                return engWords.toString();
            } else if (ukrWords.length() != 0) {

                if (rusWords.length() != 0) {

                    return rusWords.toString();
                } else {
                    return "ukr";
                }
            } else {
                return "rus";
            }

        } else if (max == ukrWords.length()) {
            if (engWords.length() != 0) {
                return engWords.toString();
            } else if (rusWords.length() != 0) {
                return rusWords.toString();
            } else {
                return "ukr";
            }

        } else if (max == engWords.length()) {
            if (ukrWords.length() != 0) {
                return ukrWords.toString();
            } else if (rusWords.length() != 0) {
                return rusWords.toString();
            } else if (rusUkrWords.length() != 0) {
                return rusUkrWords.toString();
            } else {
                return "eng";
            }
        }

        return "";
    }

    private int getMax(int ukr, int rus, int rusUkr, int eng) {

        int[] arr = {ukr, rus, rusUkr, eng};
        Arrays.sort(arr);

        return arr[arr.length - 1];
    }

}
