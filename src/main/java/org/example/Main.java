package org.example;

public class Main {
    public static void main(String[] args) {
        StringToNumberConversor stringConversor = new StringToNumberConversor();
        System.out.println(stringConversor.numberize("a"));
        System.out.println(stringConversor.numberize("ab"));
        System.out.println(stringConversor.numberize("hola Como estas"));
        System.out.println(stringConversor.numberize("Carlos del Olmo Borràs"));
    }
}