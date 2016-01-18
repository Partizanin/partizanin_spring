package hw11.service.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created with Intellij IDEA.
 * Project name: partizanin_spring
 * User: Partizanin
 * Date: 24.09.2014
 * Time:  18:40
 * To change this template use File|Setting|File Templates.
 */
public class Utils {

    private List<Character> rusCharacters = new ArrayList<>();
    private List<Character> ukrCharacters = new ArrayList<>();
    private List<Character> engCharacters = new ArrayList<>();
    private List<Character> numbers = new ArrayList<>();

    public Utils() {
        initialize();
    }

    private void initialize() {
        for (int i = 0; i < 10; i++) {
            numbers.add(String.valueOf(i).charAt(0));
        }
        numbers.add('+');

        for (char c = 'а'; c <= 'я'; c++) {
            rusCharacters.add(c);
        }

        for (char c = 'a'; c <= 'z'; c++) {
            engCharacters.add(c);
        }

        String chars = "абвгґдеєжзиіїйклмнопрстуфхцчшщьюя";
        for (int i = 0; i < chars.length(); i++) {
            ukrCharacters.add(chars.charAt(i));
        }
    }

    public static void main(String[] args) {
        Utils utils = new Utils();

    }

    public String passCheck(String s) {
/*пароль и его подтверждение (должен быть не менее 8 символов,
 включать большие и маленькие буквы, цифры, должен совпадать с подтверждением)*/


        if (s.length() >= 8) {

            boolean upperCase = false;
            boolean lowCase = false;
            boolean numbersBool = false;

            for (int i = 0; i < s.length(); i++) {
                char schar = s.charAt(i);
                if (!upperCase || !lowCase) {
                    for (Character rusCharacter : rusCharacters) {
                        if (!upperCase) {
                            if (Character.toUpperCase(rusCharacter) == schar) {
                                upperCase = true;
                            }
                        }

                        if (!lowCase) {
                            if (Character.toLowerCase(rusCharacter) == schar) {
                                lowCase = true;
                            }
                        }
                    }

                    for (Character ukrCharacter : ukrCharacters) {
                        if (!upperCase) {
                            if (Character.toUpperCase(ukrCharacter) == schar) {
                                upperCase = true;
                            }
                        }

                        if (!lowCase) {
                            if (Character.toLowerCase(ukrCharacter) == schar) {
                                lowCase = true;
                            }
                        }

                    }

                    for (Character engCharacter : engCharacters) {
                        if (!upperCase) {
                            if (Character.toUpperCase(engCharacter) == schar) {
                                upperCase = true;
                            }
                        }

                        if (!lowCase) {
                            if (Character.toLowerCase(engCharacter) == schar) {
                                lowCase = true;
                            }
                        }
                    }
                }

                if (!numbersBool) {

                    for (Character number : numbers) {
                        if (number == schar) {
                            numbersBool = true;
                            break;
                        }
                    }
                }

                if (upperCase && lowCase && numbersBool) {
                    break;
                }

            }

            if (!lowCase) {

                return "Password must have low case word";
            }
            if (!numbersBool) {

                return "Password must have numbers";
            }

            if (!upperCase) {

                return "Password must have upper case word";
            }


        } else {

            return "Password should be longer than eight characters";
        }

        return "true";
    }

    public String numberCheck(String s) {

        if (s.length() < 9) {

            return "number length must be longer than 10 symbols";

        } else if (s.length() > 13) {

            return "number length must be shorter than 13 symbols";

        } else if (s.length() == 12) {

            if (s.charAt(0) == '+') {
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

    public String wordCheck(String line) {

        boolean badChar = false;
        List<Character> allChars = ukrCharacters;
        allChars.addAll(rusCharacters);
        allChars.addAll(engCharacters);

        StringBuilder badChars = new StringBuilder();

        for (int i = 0; i < line.length(); i++) {
            char currentChar = line.charAt(i);
            if (!allChars.contains(currentChar)) {
                badChar = true;
                badChars.append(currentChar);
            }
        }
        if (badChar) {
            return badChars.toString();
        }
        return "true";
    }

    public Objects idCheck(String id) {
        return null;
    }

    public Objects passwordCheck(String pass) {
        return null;
    }

    public Objects loginCheck(String login) {
        return null;
    }

    public String nameSurnameCheck(String name) {
        return null;
    }

    public String phoneNumberCheck(String phoneNumber) {
        return null;
    }

    public class Client {

        public String nameSurnameCheck(String s) {
            return wordCheck(s);
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
        public Admin() {

        }

        public String loginCheck(String s) {

            return wordCheck(s);
        }

        public String passwordCheck(String s) {
            return passCheck(s);
        }
    }

    public class Operator {

        public String loginCheck(String s) {

            return wordCheck(s);
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

    public List<Character> getEngCharacters() {
        return engCharacters;
    }

    public List<Character> getNumbers() {
        return numbers;
    }

    public List<Character> getRusCharacters() {
        return rusCharacters;
    }

    public List<Character> getUkrCharacters() {
        return ukrCharacters;
    }
}
