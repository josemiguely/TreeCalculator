package cl.uchile.dcc.scrabble.gui.ClasesSTypesTests;

import cl.uchile.dcc.scrabble.gui.Tipos.ClasesSTypes.SBinary;
import cl.uchile.dcc.scrabble.gui.Tipos.ClasesSTypes.SFloat;
import cl.uchile.dcc.scrabble.gui.Tipos.ClasesSTypes.SInt;
import cl.uchile.dcc.scrabble.gui.Tipos.ClasesSTypes.SString;
import org.apache.commons.lang3.RandomStringUtils;
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
    SString string;
    int numero = new Random().nextInt();
    int numerodiff = numero + 1;
    int numero2 = new Random().nextInt();
    double numdouble = new Random().nextDouble();
    private int seed;
    private Random rng;
    String palabra;

    @BeforeEach
    void setUp() {

        int1 = new SInt(numero);
        int2 = new SInt(numero);
        int3 = new SInt(numero2);
        float1=new SFloat(numdouble);
        seed = new Random().nextInt();
        rng = new Random(seed);
        int strSize= rng.nextInt(20);
        palabra= RandomStringUtils.random(strSize,0,0,true,true,null,rng);
        string= new SString(palabra);
    }

    @RepeatedTest(20)
    void constructorTest() {
        assertEquals(int1.hashCode(), int2.hashCode());
        assertEquals(int1, int2);
        assert (int1.toString().equals(int2.toString()));

        SInt diffint = new SInt(numerodiff);
        assertNotEquals(int1, diffint);

        assertFalse(int1.equals(float1));
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
        SInt pruebaneg2=new SInt(-16);

        SBinary actual = prueba.intoSBinary();
        SBinary expected = new SBinary("0101");
        assertEquals(expected, actual);

        SBinary actual2=pruebaneg.intoSBinary();
        SBinary expected2=new SBinary("101000");

        assertEquals(expected2,actual2);

        SBinary actual3=pruebaneg2.intoSBinary();
        SBinary expected3=new SBinary("110000");
        assertEquals(expected3,actual3);
    }


    @RepeatedTest(10)
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
        assertEquals(expected3,actual3);

    }

    @RepeatedTest(10)
    void MultTest() {

        //Mult entre SInt
        SInt actual = (SInt) int1.Mult(int3);
        SInt expected = new SInt(numero*numero2);

        assertEquals(expected, actual);

        //Mult entre SInt y Sfloat
        SFloat actual2 =(SFloat) int1.Mult(float1);
        SFloat expected2=new SFloat(numero*numdouble);
        assertEquals(expected2,actual2);

        //Mult entre SInt y SBinary
        SBinary binario1=new SBinary("0111");//7
        SInt actual3=(SInt) int1.Mult(binario1);
        SInt expected3=new SInt(numero*7);
        assertEquals(expected3,actual3);

    }

    @RepeatedTest(10)
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

    /**
     * Pruebas opcionales y menos estructuradas para probar operaciones secuenciales (de SInt y SFloat)
     */
    @RepeatedTest(10)
    void TestRobusto(){
        SBinary binario = new SBinary("0101");//5

        SInt copyint=int1.intoSInt();
        assertEquals(copyint,int1);

        SInt copyint2=(SInt) copyint.Resta(binario);
        SInt expec=new SInt(copyint.getTipoInfo()-5);
        assertEquals(expec,copyint2);

        SInt copyint3=(SInt) copyint2.Mult(copyint);
        SInt expec2=new SInt(copyint2.getTipoInfo()*copyint.getTipoInfo());
        assertEquals(copyint3,expec2);

        SInt copyint4=(SInt)copyint3.Div(binario);
        SInt expec3=new SInt(copyint3.getTipoInfo()/5);
        assertEquals(expec3,copyint4);


        SFloat floatn1=copyint.intoSFloat();
        SFloat floatres=(SFloat) copyint.Suma(floatn1);
        SFloat expected=new SFloat(copyint.getTipoInfo()+floatn1.getTipoInfo());
        assertEquals(expected,floatres);


        SFloat floatresbin=(SFloat) floatres.Suma(binario);
        SFloat expected2=new SFloat(floatres.getTipoInfo()+5);
        assertEquals(expected2,floatresbin);
        SFloat floatmult=(SFloat) floatresbin.Mult(copyint);
        SFloat expected3=new SFloat(floatresbin.getTipoInfo()*numero);
        assertEquals(expected3,floatmult);
        SFloat floatmdiv=(SFloat) floatmult.Div(int1);
        SFloat expected4=new SFloat(floatmult.getTipoInfo()/numero);
        assertEquals(expected4,floatmdiv);
        SFloat floatresta=(SFloat) floatmdiv.Resta(binario);
        SFloat expected5=new SFloat(floatmdiv.getTipoInfo()-5);
        assertEquals(expected5,floatresta);

        SString sstringactual=floatresta.intoSString();
        SString sstringexpected=new SString(String.valueOf(floatresta.getTipoInfo()));
        assertEquals(sstringexpected,sstringactual);
    }


}