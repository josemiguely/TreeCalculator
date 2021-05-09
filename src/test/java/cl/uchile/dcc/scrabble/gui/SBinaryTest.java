package cl.uchile.dcc.scrabble.gui;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SBinaryTest {
    SBinary binary1;
    SBinary binary2;
    String string1="1010";


    @BeforeEach
    void setUp(){
        binary1= new SBinary(string1);
        binary2= new SBinary(string1);
    }

    @Test
    void constructorTest(){
        assertEquals(binary1.hashCode(),binary2.hashCode());
        assertEquals(binary1,binary2);
        assert(binary1.toString().equals(binary1.toString()));

    }

    @Test
    void intoSString(){
        String binario=binary1.intoSString();
        SString expected=new SString(binario);

        SString actual=new SString(string1);

        assertEquals(expected,actual);
    }

    @Test
    void intoBinaryTest(){
        String binario=binary1.intoSBinary();
        SBinary expected=new SBinary(binario);

        assertEquals(expected,binary2);
    }

}