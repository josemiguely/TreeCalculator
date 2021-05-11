package cl.uchile.dcc.scrabble.gui;


import cl.uchile.dcc.scrabble.gui.Tipos.SBool;
import cl.uchile.dcc.scrabble.gui.Tipos.SString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


class SBoolTest {
    private SBool truthvalue1;
    private SBool truthvalue2;
    private boolean seed;
    private Random rng;


    @BeforeEach
    void setUp(){
        seed = new Random().nextBoolean();
        truthvalue1=new SBool(seed);
        truthvalue2=new SBool(seed);
    }

    @RepeatedTest(20)
    void constructorTest(){
        assertEquals(truthvalue1.hashCode(),truthvalue2.hashCode());
        assertEquals(truthvalue1,truthvalue2);
        assert(truthvalue1.toString().equals(truthvalue2.toString()));

        SBool differenttruthvalue=new SBool(!seed);
        assertNotEquals(truthvalue1,differenttruthvalue);
    }

    @RepeatedTest(20)
    void intoSStringTest(){
        SString actual=truthvalue1.intoSString();
        SString expected=new SString(String.valueOf(truthvalue1.getTipoInfo()));
        assertEquals(expected,actual);
    }
    @RepeatedTest(20)
    void intoSBoolTest(){
        SBool actual= truthvalue1.intoSBool();
        SBool expected= new SBool(truthvalue1.getTipoInfo());
        assertEquals(expected,actual);
    }
    @RepeatedTest(10)
    void intoFloatTest(){
        assertEquals(null,truthvalue1.intoSFloat());
    }

    @RepeatedTest(10)
    void intoSIntTest(){
        assertEquals(null,truthvalue1.intoSInt());
    }

    @RepeatedTest(10)
    void intoSBinaryTest(){
        assertEquals(null,truthvalue1.intoSBinary());
    }


}