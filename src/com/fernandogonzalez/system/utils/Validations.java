/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fernandogonzalez.system.utils;

/**
 *
 * @author informatica
 */
public class Validations {

    public Validations() {

    }

    public Boolean equalsText(String textOriginal, String textCompare) {
        return textOriginal.equals(textCompare);
    }

    public boolean emptyText(String text) {
        boolean isEmpty = false;

        if (text.isEmpty() || text.isBlank()) {
            isEmpty = true;
        }
        return isEmpty;
    }

    public Boolean validateLengthText(String text, int lengthMax) {
        return text.length() <= lengthMax;
    }

    public Boolean validateEmail(String email) {
        int dotCount = 0;
        int arrobeCount = 0;
        //Regex
        for (int index = 0; index < email.length(); index++) {
            if (email.charAt(index) == '.') {
                dotCount++;
            }
            if (dotCount > 1) {
                return false;
            }
        }
        //Validar  la existencia de un solo arroba
        for (int index = 0; index < email.length(); index++) {
            if (email.charAt(index) == '@') {
                arrobeCount++;
            }
        }
        if (arrobeCount != 1) {
            return false;
        }
        return true;
    }
}
