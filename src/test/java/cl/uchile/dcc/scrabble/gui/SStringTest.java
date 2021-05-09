package cl.uchile.dcc.scrabble.gui;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SStringTest {

    SString string;
    SString string2;
    String palabra="Hola";
    String palabra2="Hola";
    String diffpalabra="Hola2";

    @BeforeEach
    void setUp(){
        string= new SString(palabra);
        string2= new SString(palabra2);

    }

    @Test
    void constructorTest(){
        assertEquals(string,string2);
        assertEquals(string.hashCode(),string2.hashCode());
        assert(string.toString().equals(string2.toString()));

        SString diffstring=new SString(diffpalabra);
        assertNotEquals(diffstring,string);

    }
}