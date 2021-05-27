package cl.uchile.dcc.scrabble.gui;

import cl.uchile.dcc.scrabble.gui.Tipos.*;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class SIntTest {
    SInt int1;
    SInt int2;
    SInt int3;
    SFloat float1;
    int numero = new Random().nextInt();
    int numerodiff = numero + 1;
    int numero2 = new Random().nextInt();
    double numdouble = new Random().nextDouble();

    @BeforeEach
    void setUp() {
        int1 = new SInt(numero);
        int2 = new SInt(numero);
        int3 = new SInt(numero2);
        float1=new SFloat(numdouble);
    }

    @RepeatedTest(20)
    void constructorTest() {
        assertEquals(int1.hashCode(), int2.hashCode());
        assertEquals(int1, int2);
        assert (int1.toString().equals(int2.toString()));

        SInt diffint = new SInt(numerodiff);
        assertNotEquals(int1, diffint);
    }

    @RepeatedTest(20)
    void intoSStringTest() {
        SString actual = int1.intoSString();
        SString expected = new SString(String.valueOf(int1.getTipoInfo()));

        assertEquals(actual, expected);
    }

    @RepeatedTest(20)
    void intoSIntTest() {
        SInt actual = int1.intoSInt();
        assertEquals(int1, actual);
    }

    @RepeatedTest(20)
    void intoSFloatTest() {

        SFloat actual = int1.intoSFloat();
        SFloat expected = new SFloat(int1.getTipoInfo());

        assertEquals(expected, actual);
    }

    @Test
    void intoSBinaryTest() {

        SInt prueba = new SInt(5);
        SInt pruebaneg=new SInt(-24);
        SBinary actual = prueba.intoSBinary();
        SBinary expected = new SBinary("0101");
        assertEquals(expected, actual);

        SBinary actual2=pruebaneg.intoSBinary();
        SBinary expected2=new SBinary("11000");
    }

    @RepeatedTest(10)
    void intoSBoolTest() {
        assertEquals(null, int1.intoSBool());
    }

    @Test
    void SumaTest() {

        //Suma int con int
        SInt int3 = new SInt(numero2);

        SInt expected = new SInt(numero + numero2);

        SInt actual = int1.SumaSInt(int3);

        assertEquals(expected, actual);

        //Suma Int con Float

        SFloat float1 = new SFloat(numdouble);

        SFloat expected2 = new SFloat(numero2 + numdouble);

        SFloat actual2 = (SFloat) int3.Suma(float1);

        assertEquals(expected2, actual2);

        //Suma Int con Binary

        SBinary binary1 = new SBinary("0111");//7
        SInt actual3 = (SInt) int3.Suma(binary1);
        SInt expected3 = new SInt(7 + numero2);
        assertEquals(expected3, actual3);
    }

    @RepeatedTest(10)
    void RestaTest() {

        //Resta entre SInt y SInt
        SInt actual = (SInt) int1.Resta(int3);
        SInt expected = new SInt(numero-numero2);

        assertEquals(expected, actual);

        //Resta entre SInt y SFloat
        SFloat actual2=(SFloat)int1.Resta(float1);
        SFloat expected2=new SFloat(numero-numdouble);
        assertEquals(expected2,actual2);

        //Resta entre SInt y SBinary

        SBinary binario1=new SBinary("01110");
        SInt actual3=(SInt)int1.Resta(binario1);
        SInt expected3=new SInt(numero-14);

    }

    @RepeatedTest(10)
    void MultTest() {

        SInt actual = (SInt) int1.Mult(int3);
        SInt expected = new SInt(numero*numero2);

        assertEquals(expected, actual);

    }

    @Test
    void DivTest() {
        //Div de SInt y SInt
        SInt actual = (SInt) int1.Div(int2);
        SInt expected = new SInt(int1.getTipoInfo() / int2.getTipoInfo());
        assertEquals(expected, actual);

        //Div de SInt con SFloat
        SFloat float1 = new SFloat(numdouble);
        SFloat actual2 = (SFloat) int1.Div(float1);
        SFloat expected2 = new SFloat(int1.getTipoInfo() / float1.getTipoInfo());
        assertEquals(expected2, actual2);

        //Div de Int con SBinary
        SBinary binary1 = new SBinary("0111");
        SInt actual3 = (SInt) int1.Div(binary1);
        SInt expected3 = new SInt(int1.getTipoInfo() / 7);
        assertEquals(expected3, actual3);
    }


}