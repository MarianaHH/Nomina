/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.web.security;

/**
 *
 * @author Gustavo
 */
public class ValidationPassword {

    public static boolean validarLetras(String contrasena) {
        char[] letrasMinisculas = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'ñ', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        char[] letrasMayusculas = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'Ñ', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        for (int i = 0; i < contrasena.length(); i++) {
            CharSequence cadenaMunisculas = "";
            CharSequence cadenaMayusculas = "";
            for (int j = i; j < (i + 3); j++) {
                cadenaMunisculas += letrasMinisculas[j] + "";
                cadenaMayusculas += letrasMayusculas[j] + "";
            }
            if (contrasena.contains(cadenaMunisculas)) {
                return true;
            }
            if (contrasena.contains(cadenaMayusculas)) {
                return true;
            }
        }
        return false;
    }

    public static boolean validarNumeros(String contrasena) {

        char[] numeros = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};

        for (int i = 0; i < contrasena.length(); i++) {
            CharSequence cadenaNumeros = "";

            for (int j = i; j < (i + 3); j++) {
                cadenaNumeros += numeros[j] + "";

            }
            if (contrasena.contains(cadenaNumeros)) {
                return true;
            } else {
                return false;
            }

        }
        return false;
    }

    public static boolean validaNumerosConsecutivos(String contrasena) {
        char[] numerosIguales = {'1', '1', '1', '2', '2', '2', '3', '3', '3', '4', '4', '4', '5', '5', '5', '6', '6', '6', '7', '7', '7', '8', '8', '8', '9', '9', '9'};
        for (int i = 0; i < contrasena.length(); i++) {
            CharSequence cadenaNumerosIguales = "";
            for (int j = 0; j < (i + 3); j++) {
                cadenaNumerosIguales += numerosIguales[j] + "";
            }
            if (contrasena.contains(cadenaNumerosIguales)) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public static boolean validarAdyacentes(String contrasena) {
        String[] palabrasAdyacentes = {"qwertui", "qazxsw", "qwerty", "zxcvbnm", "asdfghjklñ", "qwertyuiop"};
        for (String palabrasAdyacente : palabrasAdyacentes) {
            if (contrasena.contains(palabrasAdyacente)) {
                return true;
            }
        }
        return false;
    }
}
