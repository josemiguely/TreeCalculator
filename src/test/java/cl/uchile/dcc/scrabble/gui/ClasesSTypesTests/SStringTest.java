package cl.uchile.dcc.scrabble.gui.ClasesSTypesTests;

import cl.uchile.dcc.scrabble.gui.Tipos.ClasesSTypes.*;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class SStringTest {

    private SString string;
    private SString string2;
    private SString string3;
    private String palabra;
    private String diffpalabra;
    private String palabra3;
    private int seed;
    private Random rng;

    int numero = new Random().nextInt();
    double aDouble = new Random().nextDouble();
    private SInt int1;
    private SFloat float1;
    private String stringbinario;
    private SBinary binary1;
    private SBool boolv;
    private SBool boolf;

    @BeforeEach
    void setUp(){
        seed = new Random().nextInt();
        rng = new Random(seed);
        int strSize= rng.nextInt(20);
        palabra= RandomStringUtils.random(strSize,0,0,true,true,null,rng);
        palabra3=RandomStringUtils.random(strSize,0,0,true,true,null,rng);
        diffpalabra=palabra+"a";
        string= new SString(palabra);
        string2= new SString(palabra);
        string3= new SString(palabra3);

        int1 = new SInt(numero);
        float1=new SFloat(aDouble);


        stringbinario = RandomStringUtils.random(strSize, "01");
        binary1= new SBinary(stringbinario);

        boolv=new SBool(true);
        boolf=new SBool(false);

    }

    @RepeatedTest(20)
    void constructorTest(){

        assertEquals(string,string2);
        assertEquals(string.hashCode(),string2.hashCode());
        assert(string.toString().equals(string2.toString()));

        SString diffstring=new SString(diffpalabra);
        assertNotEquals(diffstring,string);

        SInt int1=new SInt(22);

        assertFalse(string.equals(int1));
    }

    @RepeatedTest(20)
    void intoSStringTest(){

        SString actual=string.intoSString();
        SString expected=new SString(string.getTipoInfo());

        assertEquals(expected,actual);

    }



    @RepeatedTest(10)
    void SumaTest(){
        //Suma SString
        SString expected=new SString(palabra+palabra);
        SString actual=(SString) string.Suma(string2);

        assertEquals(expected,actual);

        SString expected2=new SString(palabra3+palabra);
        SString actual2=(SString) string3.Suma(string);

        assertEquals(expected2,actual2);

        //Suma SString con SInt
        SString expected3=new SString(palabra+numero);
        SString actual3=(SString) string.Suma(int1);

        assertEquals(expected3,actual3);

        //Suma SString con SFloat

        SString expected4=new SString(palabra+aDouble);
        SString actual4=(SString) string.Suma(float1);

        assertEquals(expected4,actual4);

        //Suma SString con SBinary

        SString expected5=new SString(palabra+stringbinario);
        SString actual5=(SString) string.Suma(binary1);
        assertEquals(expected5,actual5);

        //Suma SString con SBool

        SString expected6=new SString(palabra+true);
        SString actual6=(SString) string.Suma(boolv);
        assertEquals(expected6,actual6);


        SString expected7=new SString(palabra+false);
        SString actual7=(SString) string.Suma(boolf);
        assertEquals(expected7,actual7);
    }

}