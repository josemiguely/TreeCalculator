package cl.uchile.dcc.scrabble.gui;

import cl.uchile.dcc.scrabble.gui.Tipos.SBinary;
import cl.uchile.dcc.scrabble.gui.Tipos.SString;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class SBinaryTest {
    SBinary binary1;
    SBinary binary2;
    String string1;
    int seed;
    private String Alphabet= "01";
    char[] alfabeto= {'0','1'};
    Random rng;


    @BeforeEach
    void setUp(){
        seed = new Random().nextInt(20)+1;
        rng = new Random(seed);
        int strSize= rng.nextInt(seed);
        string1= RandomStringUtils.random(strSize,"01");
        String diffpalabra=string1+"1";
        binary1= new SBinary(string1);
        binary2= new SBinary(string1);
    }

    @RepeatedTest(20)
    void constructorTest(){
        assertEquals(binary1.hashCode(),binary2.hashCode());
        assertEquals(binary1,binary2);
        assert(binary1.toString().equals(binary1.toString()));

    }

    @RepeatedTest(20)
    void intoSString(){
        SString expected=binary1.intoSString();
        SString actual=new SString(binary1.getTipoInfo());

        assertEquals(expected,actual);
    }

    @RepeatedTest(20)
    void intoSBinaryTest(){
        SBinary expected=binary1.intoSBinary();
        SBinary actual=binary1;

        assertEquals(expected,actual);
    }

    @RepeatedTest(10)
    void intoSBoolTest(){
        assertEquals(null,binary1.intoSBool());
    }

    @RepeatedTest(10)
    void intoSFloatTest(){
        assertEquals(null,binary1.intoSFloat());
    }

    @RepeatedTest(10)
    void intoSIntTest(){
        assertEquals(null,binary1.intoSInt());
    }

}