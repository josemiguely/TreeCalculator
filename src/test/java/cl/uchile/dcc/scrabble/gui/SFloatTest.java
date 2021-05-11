package cl.uchile.dcc.scrabble.gui;

import cl.uchile.dcc.scrabble.gui.Tipos.SFloat;
import cl.uchile.dcc.scrabble.gui.Tipos.SString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class SFloatTest {
    private SFloat float1;
    private SFloat float2;
    private double seed;


    @BeforeEach
    void setUp(){
        seed= new Random().nextDouble();
        float1= new SFloat(seed);
        float2= new SFloat(seed);
    }

    @RepeatedTest(20)
    void constructorTest(){
        assertEquals(float1.hashCode(),float2.hashCode());
        assertEquals(float1,float2);
        assert(float1.toString().equals(float2.toString()));

        SFloat diffloat=new SFloat(seed+1);
        assertNotEquals(float1,diffloat);
    }
    @RepeatedTest(20)
    void IntoSStringTest(){
        SString actual=float1.intoSString();

        SString expected=new SString(String.valueOf(float1.getTipoInfo()));
        assertEquals(expected,actual);

    }
    @RepeatedTest(20)
    void IntoSFloatTest(){
        SFloat actual=float1.intoSFloat();
        SFloat expected=new SFloat(float1.getTipoInfo());

        assertEquals(expected,actual);
    }

    @RepeatedTest(10)
    void intoSIntTest(){
        assertEquals(null,float1.intoSInt());
    }

    @RepeatedTest(10)
    void intoSBoolTest(){
        assertEquals(null,float1.intoSBool());
    }

    @RepeatedTest(10)
    void intoSBinaryTest(){
        assertEquals(null,float1.intoSBinary());
    }
}