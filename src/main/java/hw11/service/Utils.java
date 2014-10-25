package hw11.service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Intellij IDEA.
 * Project name: proff16
 * User: Partizanin
 * Date: 24.09.2014
 * Time:  18:40
 * To change this template use File|Setting|File Templates.
 */
public class Utils {

    private String passCheck(String s) {
/*пароль и его подтверждение (должен быть не менее 8 символов,
 включать большие и маленькие буквы, цифры, должен совпадать с подтверждением)*/
        List<Character> alphabet = new ArrayList<>();
        alphabet.add('A');
        alphabet.add('A');
        alphabet.add('B');
        alphabet.add('C');
        alphabet.add('D');
        alphabet.add('E');
        alphabet.add('F');
        alphabet.add('G');
        alphabet.add('H');
        alphabet.add('I');
        alphabet.add('J');
        alphabet.add('K');
        alphabet.add('L');
        alphabet.add('M');
        alphabet.add('N');
        alphabet.add('O');
        alphabet.add('P');
        alphabet.add('Q');
        alphabet.add('R');
        alphabet.add('S');
        alphabet.add('T');
        alphabet.add('U');
        alphabet.add('V');
        alphabet.add('W');
        alphabet.add('X');
        alphabet.add('Y');
        alphabet.add('Z');

        String language = languageCheck(s);

        if (s.equals("true")) {

            if (s.length() < 8) {
                return "Password should be longer than eight characters";
            }

            ArrayList<Character> characterArrayList = new ArrayList<>(s.length());

            boolean upperCase = false;
            boolean lowCase = false;

            for (int i = 0; i < s.length(); i++) {

                if (alphabet.contains(s.charAt(i))) {
                    upperCase = true;
                }

            }

            for (int i = 0; i < s.length(); i++) {

                for (Character anAlphabet : alphabet) {

                    if (s.charAt(i) == Character.toLowerCase(anAlphabet)) {
                        lowCase = true;
                        break;
                    }
                }
            }


            if (!lowCase) {

                return "Password must have low case word";
            }

            if (!upperCase) {

                return "Password must have upper case word";
            }


        } else {

            return language;
        }

        return "true";
    }

    private String languageCheck(String line) {

        List<Character> chars = new ArrayList<>();
        List<Character> numbers = new ArrayList<>();
        chars.add('A');
        chars.add('A');
        chars.add('B');
        chars.add('C');
        chars.add('D');
        chars.add('E');
        chars.add('F');
        chars.add('G');
        chars.add('H');
        chars.add('I');
        chars.add('J');
        chars.add('K');
        chars.add('L');
        chars.add('M');
        chars.add('N');
        chars.add('O');
        chars.add('P');
        chars.add('Q');
        chars.add('R');
        chars.add('S');
        chars.add('T');
        chars.add('U');
        chars.add('V');
        chars.add('W');
        chars.add('X');
        chars.add('Y');
        chars.add('Z');

        numbers.add('1');
        numbers.add('2');
        numbers.add('3');
        numbers.add('4');
        numbers.add('5');
        numbers.add('6');
        numbers.add('7');
        numbers.add('8');
        numbers.add('9');
        numbers.add('0');

        for (int i = 0; i < line.length(); i++) {

            if (!chars.contains(Character.toUpperCase(line.charAt(i)))) {

                if (!numbers.contains(line.charAt(i))) {
                    return String.valueOf(line.charAt(i));

                }

            }

        }
        return "true";
    }

    public class Client {

        public String nameSurnameCheck(String s) {
            return languageCheck(s);
        }

        public String phoneNumberCheck(String s) {

            return numberCheck(s);
        }

        private String numberCheck(String s) {
            List<Character> numbers = new ArrayList<>();
            numbers.add('1');
            numbers.add('2');
            numbers.add('3');
            numbers.add('4');
            numbers.add('5');
            numbers.add('6');
            numbers.add('7');
            numbers.add('8');
            numbers.add('9');
            numbers.add('0');
            numbers.add('+');

            if (s.length() < 10) {

                return "number length < 10";
            } else if (s.length() == 12) {

                if (s.charAt(0) != '+') {
                    return String.valueOf(s.charAt(0));
                }
            }

            for (int i = 0; i < s.length(); i++) {

                if (!numbers.contains(s.charAt(i))) {
                    return String.valueOf(s.charAt(i));
                }
            }


            return "true";
        }

    }

    public class Admin {

        public String loginCheck(String s) {

            return languageCheck(s);
        }

        public String passwordCheck(String s) {
            return passCheck(s);
        }
    }

    public class Operator {

        public String loginCheck(String s) {

            return languageCheck(s);
        }

        public String idCheck(String s) {
            return numberCheck(s);
        }

        public String passwordCheck(String s) {

            return passCheck(s);
        }

        private String numberCheck(String s) {
            List<Character> numbers = new ArrayList<>();
            numbers.add('1');
            numbers.add('2');
            numbers.add('3');
            numbers.add('4');
            numbers.add('5');
            numbers.add('6');
            numbers.add('7');
            numbers.add('8');
            numbers.add('9');
            numbers.add('0');


            for (int i = 0; i < s.length(); i++) {

                if (!numbers.contains(s.charAt(i))) {
                    return String.valueOf(s.charAt(i));
                }
            }


            return "true";
        }
    }
}
