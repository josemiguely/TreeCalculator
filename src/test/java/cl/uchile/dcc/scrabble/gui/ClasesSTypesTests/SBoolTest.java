package cl.uchile.dcc.scrabble.gui.ClasesSTypesTests;


import cl.uchile.dcc.scrabble.gui.Tipos.ClasesSTypes.SBinary;
import cl.uchile.dcc.scrabble.gui.Tipos.ClasesSTypes.SBool;
import cl.uchile.dcc.scrabble.gui.Tipos.ClasesSTypes.SInt;
import cl.uchile.dcc.scrabble.gui.Tipos.ClasesSTypes.SString;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;


class SBoolTest {
    private SBool truthvalue1;
    private SBool truthvalue2;
    private SBinary binario1;
    private SString sstring;
    private String string1;
    private String string2;
    private boolean seed;
    private int seed2;
    private Random rng;

    SBool valorv=new SBool(true);
    SBool valorv2=new SBool(true);
    SBool valorf=new SBool(false);


    @BeforeEach
    void setUp(){
        seed = new Random().nextBoolean();
        truthvalue1=new SBool(seed);
        truthvalue2=new SBool(seed);

        seed2 = new Random().nextInt(20)+1;//para que el bound sea nunca 0
        rng = new Random(seed2);
        int strSize = rng.nextInt(seed2)+1;//+1 para que el size del str nunca sea 0
        string1 = RandomStringUtils.random(strSize, "01");
        string2=RandomStringUtils.random(strSize,0,0,true,true,null,rng);
        binario1= new SBinary(string1);
        sstring=new SString(string2);
    }

    @RepeatedTest(20)
    void constructorTest(){
        assertEquals(truthvalue1.hashCode(),truthvalue2.hashCode());
        assertEquals(truthvalue1,truthvalue2);
        assertEquals(truthvalue1.toString(), truthvalue2.toString());

        SBool differenttruthvalue=new SBool(!seed);
        assertNotEquals(truthvalue1,differenttruthvalue);

        SInt int1=new SInt(22);

        assertFalse(truthvalue1.equals(int1));
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
    void and(){
        //and entre SBool

        SBool expected=new SBool(true);
        SBool actual=(SBool) valorv.and(valorv2);
        assertEquals(expected,actual);

        SBool actual2=(SBool) valorv.and(valorf);
        assertEquals(valorf,actual2);

        //and entre SBool y Sbinary


        SBinary actualbinary= (SBinary) valorv.and(binario1);
        SBinary expectedbinary= new SBinary(string1);
        assertEquals(expectedbinary,actualbinary);

        SBinary actualbinary2=(SBinary) valorf.and(binario1);
        int largo0=string1.length();
        String expectedString="";


        for (int i=0;i<largo0;i++){
            expectedString=expectedString+"0";
        }
        SBinary expectedbinary2=new SBinary(expectedString);
        assertEquals(expectedbinary2,actualbinary2);

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

        SBinary actualbinary=(SBinary) valorv.or(binario);

        SBinary actualbinaryf=(SBinary) valorf.or(binario);
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
        SBool actual=truthvalue1.negacion();
        assertEquals(expected,actual);
    }
    @RepeatedTest(10)
    void SumaSString(){

        SString actual=truthvalue1.SumaSString(sstring);
        SString expected= new SString(string2+truthvalue1.getTipoInfo());
        assertEquals(expected,actual);


    }
    @RepeatedTest(10)
    void TestRobusto(){
        SBool truthvaluecopy=truthvalue1.intoSBool();
        assertEquals(truthvalue1,truthvaluecopy);
        SBool negtruth=truthvaluecopy.negacion();
        assertNotEquals(truthvalue1,negtruth);
        SBool expected=new SBool(!seed);
        assertEquals(expected,negtruth);
        SString negtruthstring=negtruth.intoSString();
        SString expected2=new SString(String.valueOf(!seed));
        assertEquals(expected2,negtruthstring);

        SString actual=negtruthstring.SumaSString(sstring);
        SString expected3=new SString(string2+negtruthstring.getTipoInfo());
        assertEquals(expected3,actual);
    }



}