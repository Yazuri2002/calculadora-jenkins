package com.mycompany.calculadora;

public class app {
    public static void main(String[] args) {
        Calculadora calc = new Calculadora();
        System.out.println("2 + 4 = " + calc.sumar(2, 4));
        System.out.println("10 - 4 = " + calc.restar(10, 4));
        System.out.println("6 * 7 = " + calc.multiplicar(6, 7));
        System.out.println("10 / 4 = " + calc.dividir(10, 4));
        System.out.println("Promedio historial = " + calc.promedioHistorial());
        System.out.println("Historial = " + calc.obtenerHistorial());
    }
}