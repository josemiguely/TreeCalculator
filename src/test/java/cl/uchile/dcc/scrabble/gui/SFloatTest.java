package cl.uchile.dcc.scrabble.gui;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SFloatTest {
    private SFloat float1;
    private SFloat float2;

    @BeforeEach
    void setUp(){
        float1= new SFloat(1234.56);
        float2= new SFloat(1234.56);
    }

    @Test
    void constructorTest(){
        assertEquals(float1.hashCode(),float2.hashCode());
        assertEquals(float1,float2);
        assert(float1.toString().equals(float2.toString()));

        SFloat diffloat=new SFloat(1234.567);
        assertNotEquals(float1,diffloat);
    }
    @Test
    void IntoSStringTest(){
        String floatstring=float1.intoSString();
        SString expected=new SString(floatstring);

        SString actual=new SString("1234.56");
        assertEquals(expected,actual);

    }
    @Test
    void IntoSFloatTest(){
        double floatfloat=float1.intoSFloat();
        SFloat expected=new SFloat(floatfloat);

        assertEquals(expected,float2);
    }

}