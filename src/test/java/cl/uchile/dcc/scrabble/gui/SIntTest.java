package cl.uchile.dcc.scrabble.gui;

import cl.uchile.dcc.scrabble.gui.Tipos.*;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class SIntTest {
    SInt int1;
    SInt int2;
    int numero= new Random().nextInt();
    int numerodiff=numero+1;
    int numero2=new Random().nextInt();
    double numdouble=new Random().nextDouble();

    @BeforeEach
    void setUp() {
        int1=new SInt(numero);
        int2=new SInt(numero);
    }

    @RepeatedTest(20)
    void constructorTest(){
        assertEquals(int1.hashCode(),int2.hashCode());
        assertEquals(int1,int2);
        assert(int1.toString().equals(int2.toString()));

        SInt diffint=new SInt(numerodiff);
        assertNotEquals(int1,diffint);
    }

    @RepeatedTest(20)
    void intoSStringTest(){
        SString actual=int1.intoSString();
        SString expected=new SString(String.valueOf(int1.getTipoInfo()));

        assertEquals(actual,expected);
    }

    @RepeatedTest(20)
    void intoSIntTest(){
        SInt actual=int1.intoSInt();
        assertEquals(int1,actual);
    }

    @RepeatedTest(20)
    void intoSFloatTest(){

        SFloat actual=int1.intoSFloat();
        SFloat expected=new SFloat(int1.getTipoInfo());

        assertEquals(expected,actual);
    }

    @Test
    void intoSBinaryTest(){

        SInt prueba=new SInt(5);
        SBinary actual=prueba.intoSBinary();
        SBinary expected=new SBinary("101");
        assertEquals(expected,actual);
    }

    @RepeatedTest(10)
    void intoSBoolTest(){
        assertEquals(null,int1.intoSBool());
    }

    @Test
    void SumaIntTest(){
        SInt int3= new SInt(numero2);

        SInt expected=new SInt(numero+numero2);

        SInt actual=int1.SumaSInt(int3);

        assertEquals(expected,actual);
    }

    @Test
    void SumaFloatTest(){
        //SInt int3= new SInt(numero2);

        //SFloat float1=new SFloat(numdouble);

        //SFloat expected=new SFloat(numero2+numdouble);

        //SFloat actual= int3.Suma(float1);

    }

}