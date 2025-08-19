
package com.mycompany.calculadora;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalculadoraTest {
    private Calculadora calc;

    @Before
    public void setUp() { calc = new Calculadora(); }

    @Test public void testSumar() { assertEquals(5, calc.sumar(2, 3)); }
    @Test public void testRestar() { assertEquals(6, calc.restar(10, 4)); }
    @Test public void testMultiplicar() { assertEquals(42, calc.multiplicar(6, 7)); }
    @Test public void testDividir() { assertEquals(2.5, calc.dividir(10, 4), 1e-4); }
    @Test(expected = ArithmeticException.class)
    public void testDividirPorCero() { calc.dividir(10, 0); }

    @Test public void testPromedioEHistorial() {
        calc.sumar(2,3); calc.restar(10,4); calc.multiplicar(6,7); calc.dividir(10,4);
        assertEquals(4, calc.obtenerHistorial().size());
        assertEquals(13.875, calc.promedioHistorial(), 1e-4);
    }
}