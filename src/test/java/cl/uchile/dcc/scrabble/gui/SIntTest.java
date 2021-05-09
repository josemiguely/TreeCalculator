package cl.uchile.dcc.scrabble.gui;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SIntTest {
    SInt int1;
    SInt int2;
    int numero=12345;
    int numerodiff=123456;

    @BeforeEach
    void setUp() {
        int1=new SInt(numero);
        int2=new SInt(numero);
    }

    @Test
    void constructorTest(){
        assertEquals(int1.hashCode(),int2.hashCode());
        assertEquals(int1,int2);
        assert(int1.toString().equals(int2.toString()));

        SInt diffint=new SInt(numerodiff);
        assertNotEquals(int1,diffint);
    }

    @Test
    void intoSStringTest(){
        String string=int1.intoSString();

        SString actual=new SString(string);
        SString expected=new SString(String.valueOf(numero));
        assertEquals(actual,expected);
    }
    @Test
    void intoSFloatTest(){
        double floatnum= int1.intoSFloat();
        SFloat actual=new SFloat(floatnum);
        SFloat expected=new SFloat( (double)int1.getNumero());

        assertEquals(expected,actual);

    }
}