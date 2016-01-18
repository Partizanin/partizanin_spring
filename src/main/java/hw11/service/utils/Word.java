package hw11.service.utils;

/**
 * Created with Intellij IDEA.
 * Project name: Partizanin_Spring.
 * Date: 16.01.2016.
 * Time: 18:36.
 * To change this template use File|Setting|Editor|File and Code Templates.
 */
public class Word {
    private Character character;

    private Integer hash;

    private String lang;

    public Word(Character character) {
        this.character = character;
        this.hash = Character.hashCode(character);
        this.lang = getLang(character);
    }

    public Character getCharacter() {
        return character;
    }

    public Integer getHash() {

        return hash;
    }

    public String getLang() {
        return lang;
    }

    private String getLang(char character) {
        int hash = Character.hashCode(character);
        if (hash == 1111 ||
                hash == 1110 ||
                hash == 1169 ||
                hash == 1108
                ) {
            return "ukr";
        }
        if (hash == 1105 ||
                hash == 1060 ||
                hash == 1099 ||
                hash == 1101 ||
                hash == 1098
                ) {
            return "rus";
        }
        for (char c = 'a'; c <= 'z'; c++) {
            if (c == character) {
                return "eng";
            }
        }

        if (hash >= 107 && hash <= 1103) {
            return "rusUkr";
        }

        return "notLang";
    }
}
