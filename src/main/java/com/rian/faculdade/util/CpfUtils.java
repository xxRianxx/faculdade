package com.rian.faculdade.util;

public class CpfUtils {

    public static boolean isValid(String cpf) {
        if (cpf == null) return false;
        String onlyDigits = cpf.replaceAll("\\D", "");
        if (onlyDigits.length() != 11) return false;
        // despacha casos repetidos
        if (onlyDigits.chars().distinct().count() == 1) return false;

        try {
            int[] digits = new int[11];
            for (int i = 0; i < 11; i++) digits[i] = Character.getNumericValue(onlyDigits.charAt(i));

            int sum = 0;
            for (int i = 0; i < 9; i++) sum += digits[i] * (10 - i);
            int check1 = 11 - (sum % 11);
            if (check1 >= 10) check1 = 0;
            if (check1 != digits[9]) return false;

            sum = 0;
            for (int i = 0; i < 10; i++) sum += digits[i] * (11 - i);
            int check2 = 11 - (sum % 11);
            if (check2 >= 10) check2 = 0;
            return check2 == digits[10];
        } catch (Exception e) {
            return false;
        }
    }
}

