package cl.uchile.dcc.scrabble.gui;


import cl.uchile.dcc.scrabble.gui.Tipos.SBinary;
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

    SBool valorv=new SBool(true);
    SBool valorv2=new SBool(true);
    SBool valorf=new SBool(false);


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

    @RepeatedTest(10)
    void and(){
        //and entre SBool

        SBool expected=new SBool(true);
        SBool actual=(SBool) valorv.and(valorv2);
        assertEquals(expected,actual);

        SBool actual2=(SBool) valorv.and(valorf);
        assertEquals(valorf,actual2);

        //and entre SBool y Sbinary

        SBinary binary1=new SBinary("101");
        SBinary actualbinary= (SBinary) valorv.and(binary1);
        SBinary expectedbinary= new SBinary("101");
        assertEquals(actualbinary,actualbinary);

        SBinary actualbinary2=(SBinary) valorf.and(binary1);
        SBinary expectedbinary2=new SBinary("000");
        assertEquals(actualbinary2,expectedbinary2);

    }
    @RepeatedTest(10)
    void or(){
        //or entre SBool
        SBool expected=new SBool(true);
        SBool actual=(SBool) valorv.or(valorv);
        assertEquals(expected,actual);

        SBool expected2=new SBool(true);
        SBool actual2=(SBool) valorv.or(valorf);
        assertEquals(expected2,actual2);

        SBool expected3=new SBool(true);
        SBool actual3=(SBool) valorf.or(valorv);
        assertEquals(expected3,actual3);

        SBool expected4=new SBool(false);
        SBool actual4=(SBool) valorf.or(valorf);
        assertEquals(expected4,actual4);

        //or entre SBool y SBinary
        SBinary binario=new SBinary("101");
        SBinary expectedbinary=new SBinary("111");
        SBinary actualbinary=(SBinary) valorv.orSBinary(binario);
        SBinary actualbinaryf=(SBinary) valorf.orSBinary(binario);
        assertEquals(expectedbinary,actualbinary);

        SBinary exp=new SBinary("101");
        assertEquals(exp,actualbinaryf);


        SBinary expectedbinary2=new SBinary("111");
        SBinary actualbinary2=(SBinary) valorv.or(binario);
        assertEquals(expectedbinary2,actualbinary2);


    }

    @RepeatedTest(10)
    void negacionTest(){
        SBool expected=new SBool(!seed);
        SBool actual=(SBool) truthvalue1.negacion();
        assertEquals(expected,actual);
    }


}