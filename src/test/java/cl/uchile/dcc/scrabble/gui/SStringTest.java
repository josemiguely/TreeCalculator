package cl.uchile.dcc.scrabble.gui;

import cl.uchile.dcc.scrabble.gui.Tipos.SFloat;
import cl.uchile.dcc.scrabble.gui.Tipos.SInt;
import cl.uchile.dcc.scrabble.gui.Tipos.SString;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class SStringTest {

    SString string;
    SString string2;
    //String palabra3= new RandomStringUtils().random();
    String palabra;
    String diffpalabra;
    private int seed;
    private Random rng;

    @BeforeEach
    void setUp(){
        seed = new Random().nextInt();
        rng = new Random(seed);
        int strSize= rng.nextInt(20);
        palabra= RandomStringUtils.random(strSize,0,Character.MAX_CODE_POINT,true,true,null,rng);
        diffpalabra=palabra+"a";
        string= new SString(palabra);
        string2= new SString(palabra);

    }

    @RepeatedTest(20)
    void constructorTest(){
        assertEquals(string,string2);
        assertEquals(string.hashCode(),string2.hashCode());
        assert(string.toString().equals(string2.toString()));

        SString diffstring=new SString(diffpalabra);
        assertNotEquals(diffstring,string);
    }

    @RepeatedTest(20)
    void intoSStringTest(){

        SString actual=string.intoSString();
        SString expected=new SString(string.getTipoInfo());

        assertEquals(expected,actual);

    }

    @RepeatedTest(10)
    void intoSIntTest(){

        assertEquals(null,string.intoSInt());
    }

    @RepeatedTest(10)
    void intoSFloatTest(){
        assertEquals(null,string.intoSFloat());
    }

    @RepeatedTest(10)
    void intoSBinaryTest(){
        assertEquals(null,string.intoSBinary());
    }

    @RepeatedTest(10)
    void intoSBoolTest(){
        assertEquals(null,string.intoSBool());
    }

}