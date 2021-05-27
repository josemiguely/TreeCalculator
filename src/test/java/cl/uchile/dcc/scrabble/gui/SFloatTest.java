package cl.uchile.dcc.scrabble.gui;

import cl.uchile.dcc.scrabble.gui.Tipos.SBinary;
import cl.uchile.dcc.scrabble.gui.Tipos.SFloat;
import cl.uchile.dcc.scrabble.gui.Tipos.SInt;
import cl.uchile.dcc.scrabble.gui.Tipos.SString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class SFloatTest {
    private SFloat float1;
    private SFloat float2;
    private double seed;
    private int seed2;


    @BeforeEach
    void setUp(){
        seed= new Random().nextDouble();
        seed2=new Random().nextInt();
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

    @RepeatedTest(5)
    void Suma(){

        //Suma de floats

        SFloat expected=new SFloat(float1.getTipoInfo()+ float2.getTipoInfo());
        SFloat actual=(SFloat)float1.Suma(float2);
        assertEquals(expected,actual);

        //Suma de float con int

        SInt int1=new SInt(seed2);
        SFloat actual2=(SFloat) float1.Suma(int1);
        SFloat expected2=new SFloat(int1.getTipoInfo()+float1.getTipoInfo());
        assertEquals(expected2,actual2);

        //Suma de SFloat con SBinary

        SBinary binary1=new SBinary("0111");
        SFloat actual3=(SFloat) float1.Suma(binary1);
        SFloat expected3=new SFloat(5+float1.getTipoInfo());
    }
    @RepeatedTest(5)
    void Resta(){
        //Resta de Floats
        SFloat actual=(SFloat) float1.Resta(float2);
        SFloat expected=new SFloat(float1.getTipoInfo()- float2.getTipoInfo());
        assertEquals(expected,actual);

        //Resta de Float con Int
        SInt int1=new SInt(seed2);
        SFloat actual2=(SFloat) float1.Resta(int1);
        SFloat expected2=new SFloat(float1.getTipoInfo()-int1.getTipoInfo());
        assertEquals(expected2,actual2);

        //Resta de SFloat con SBinary

        SBinary binary1=new SBinary("0111");//7
        SFloat actual3=(SFloat) float1.Resta(binary1);
        SFloat expected3=new SFloat(float1.getTipoInfo()-7);
        assertEquals(expected3,actual3);
    }

    @RepeatedTest(5)
    void Mult(){
        //Mult de Floats
        SFloat actual=(SFloat) float1.Mult(float2);
        SFloat expected=new SFloat(float1.getTipoInfo()*float2.getTipoInfo());
        assertEquals(expected,actual);

        //Mult de Float con Int
        SInt int1=new SInt(seed2);
        SFloat actual2=(SFloat) float1.Mult(int1);
        SFloat expected2=new SFloat(float1.getTipoInfo()*int1.getTipoInfo());
        assertEquals(expected2,actual2);

        //Mult de SFloat con SBinary
        SBinary binary1=new SBinary("0111");
        SFloat actual3=(SFloat) float1.Mult(binary1);
        SFloat expected3=new SFloat(float1.getTipoInfo()*5);
    }
    @RepeatedTest(5)
    void Div(){

        //Div de Float
        SFloat actual=(SFloat) float1.Div(float2);
        SFloat expected=new SFloat(float1.getTipoInfo()/float2.getTipoInfo());
        assertEquals(expected,actual);

        //Div de Float con Int
        SInt int1=new SInt(seed2);
        SFloat actual2=(SFloat) float1.Div(int1);
        SFloat expected2=new SFloat(float1.getTipoInfo()/int1.getTipoInfo());
        assertEquals(expected2,actual2);

        //Div de SFloat con SBinary
        SBinary binary1=new SBinary("0111");
        SFloat actual3=(SFloat) float1.Div(binary1);
        SFloat expected3=new SFloat(float1.getTipoInfo()/5);
    }

}