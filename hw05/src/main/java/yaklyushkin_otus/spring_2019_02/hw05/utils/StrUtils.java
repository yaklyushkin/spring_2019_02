package yaklyushkin_otus.spring_2019_02.hw05.utils;

import yaklyushkin_otus.spring_2019_02.hw05.consts.StringConsts;

import org.apache.commons.lang3.StringUtils;

import java.util.Locale;

public class StrUtils {

    public static Locale getLocale(String language) {
        Locale locale = null;
        if (language.equals(StringConsts.LANGUAGE_RUSSIAN)) {
            locale = new Locale("ru", "RU");
        } else if (language.equals(StringConsts.LANGUAGE_ENGLISH)) {
            locale = Locale.ENGLISH;
        }
        return locale;
    }

    public static boolean isBlank(String str) {
        return StringUtils.isBlank(str);
    }

    public static String toCamelCase(String str) {
        if (str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(str.length());
        boolean isWhitespace = false;
        for (Character ch : str.toCharArray()) {
            if (isWhitespace) {
                if (Character.isAlphabetic(ch)) {
                    ch = Character.toUpperCase(ch);
                    isWhitespace = false;
                } else {
                    isWhitespace = Character.isWhitespace(ch);
                }
            } else {
                isWhitespace = Character.isWhitespace(ch);
            }
            sb.append(ch);
        }
        return StringUtils.capitalize(sb.toString());
    }

    public static String toOnlyOneInnerSpace(String str) {
        if (str == null) {
            return null;
        }
        return str.replaceAll("\\s+"," ");
    }

    public static String toOnlyOneInnerSpaceWithTrim(String str) {
        if (str == null) {
            return null;
        }
        return toOnlyOneInnerSpace(str.trim());
    }

    public static String capitalize(String str) {
        if (str == null) {
            return null;
        }
        return StringUtils.capitalize(str);
    }
}
