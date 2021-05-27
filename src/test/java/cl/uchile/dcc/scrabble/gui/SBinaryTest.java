package cl.uchile.dcc.scrabble.gui;

import cl.uchile.dcc.scrabble.gui.Tipos.*;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class SBinaryTest {
    SBinary binary1;
    SBinary binary2;
    String string1;
    int seed;
    private String Alphabet = "01";
    char[] alfabeto = {'0', '1'};
    Random rng;


    @BeforeEach
    void setUp() {
        seed = new Random().nextInt(20) + 1;
        rng = new Random(seed);
        int strSize = rng.nextInt(seed);
        string1 = RandomStringUtils.random(strSize, "01");
        String diffpalabra = string1 + "1";
        binary1 = new SBinary(string1);
        binary2 = new SBinary(string1);
    }

    @RepeatedTest(20)
    void constructorTest() {
        assertEquals(binary1.hashCode(), binary2.hashCode());
        assertEquals(binary1, binary2);
        assert (binary1.toString().equals(binary1.toString()));

    }

    @RepeatedTest(20)
    void intoSString() {
        SString expected = binary1.intoSString();
        SString actual = new SString(binary1.getTipoInfo());

        assertEquals(expected, actual);
    }

    @RepeatedTest(20)
    void intoSBinaryTest() {
        SBinary expected = binary1.intoSBinary();
        SBinary actual = binary1;

        assertEquals(expected, actual);
    }

    @RepeatedTest(10)
    void intoSBoolTest() {
        assertEquals(null, binary1.intoSBool());
    }

    @Test()
    void intoSFloatTest() {
        SBinary binfloat = new SBinary("0011111111010000000000000000000000000000000000000000000000000000");
        SFloat floatss = binfloat.intoSFloat();
        System.out.println(floatss.toString());

    }

    @Test
    void intoSIntTest() {
        SBinary binary5 = new SBinary("10000001");
        SInt numero5 = new SInt(-127);
        SInt binaint = binary5.intoSInt();

        assertEquals(numero5, binaint);
    }

    @Test()
    void Suma() {

        //Suma de Binary
        SBinary binarysum1 = new SBinary("0111");//7
        SBinary binarysum2 = new SBinary("0101");//5

        SBinary expected = new SBinary("01100");
        SBinary actual = (SBinary) binarysum1.Suma(binarysum2);
        assertEquals(expected, actual);

        //Suma de Binary con SInt

        SInt int1 = new SInt(5);
        SBinary actual2 = (SBinary) binarysum1.Suma(int1);
        assertEquals(expected, actual2);


    }

    @Test
    void Resta() {
        //Resta de SBinary

        SBinary binaryresta1 = new SBinary("0101");//5
        SBinary binaryresta2 = new SBinary("001");//1


        SBinary actual = (SBinary) binaryresta1.Resta(binaryresta2);
        SBinary expected = new SBinary("0100");
        assertEquals(expected, actual);

        //Resta SBinary con SInt

        SInt int1 = new SInt(1);
        SBinary actual2 = (SBinary) binaryresta1.Resta(int1);
        assertEquals(expected, actual2);


    }


    @Test
    void MultTest() {

        //SBinary con SBinary

        SBinary binarymult1 = new SBinary("0111");//7
        SBinary binarymult2 = new SBinary("011");//3


        SBinary actualmult = (SBinary) binarymult1.Mult(binarymult2);
        SBinary expected = new SBinary("010101");//21

        assertEquals(expected, actualmult);

        //SBinary con SInt
        SInt int1 = new SInt(3);
        SBinary actualmultint = (SBinary) binarymult1.Mult(int1);
        assertEquals(expected, actualmultint);

    }

    @Test
    void DivTest() {
        //Div de SBinary con SBinary
        SBinary binarydiv1 = new SBinary("01110");//14
        SBinary binarydiv2 = new SBinary("0111");//7
        SBinary actual = (SBinary) binarydiv1.Div(binarydiv2);
        SBinary expected = new SBinary("010");
        assertEquals(expected, actual);

        //Div de SBinary con SInt
        SInt int1 = new SInt(7);
        SBinary actual2 = (SBinary) binarydiv1.Div(int1);
        assertEquals(expected, actual2);

    }
    @Test
    void andTest(){
        //and de SBinary con SBinary
        SBinary binary1 = new SBinary("1111010");
        SBinary binary2 = new SBinary("1010010");
        SBinary actual=(SBinary) binary1.and(binary2);
        SBinary expected=new SBinary("1010010");

        assertEquals(expected,actual);

        //and de SBinary con SBool

        SBool boolv=new SBool(true);
        SBool boolf=new SBool(false);

        SBinary actual2=(SBinary) binary1.and(boolv);
        SBinary expected2=new SBinary("1111010");
        assertEquals(expected2,actual2);

        SBinary actual3=(SBinary) binary2.and(boolf);
        SBinary expected3=new SBinary("0000000");
        assertEquals(expected3,actual3);
    }

    @Test
    void orTest(){
        //or de SBinary con SBinary
        SBinary binary1 = new SBinary("1111010");
        SBinary binary2 = new SBinary("1010010");
        SBinary actual=(SBinary) binary1.or(binary2);
        SBinary expected=new SBinary("1111010");

        assertEquals(expected,actual);

        //or de SBinary con SBool

        SBool boolv=new SBool(true);
        SBool boolf=new SBool(false);

        SBinary actual2=(SBinary) binary1.or(boolv);
        SBinary expected2=new SBinary("1111111");
        assertEquals(expected2,actual2);

        SBinary actual3=(SBinary) binary2.or(boolf);
        SBinary expected3=new SBinary("1010010");
        assertEquals(expected3,actual3);
    }

    @Test()
    void negacionTest(){
        SBinary binary1 = new SBinary("1111010");
        SBinary binary2 = new SBinary("1010010");

        SBinary actual=(SBinary) binary1.negacion();
        SBinary expected=new SBinary("0000101");
        assertEquals(expected,actual);

        SBinary actual2=(SBinary) binary2.negacion();
        SBinary expected2=new SBinary("0101101");
        assertEquals(expected2,actual2);

    }


}