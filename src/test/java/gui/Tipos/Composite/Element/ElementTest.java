package gui.Tipos.Composite.Element;

import cl.uchile.dcc.scrabble.gui.Tipos.ClasesSTypes.*;
import cl.uchile.dcc.scrabble.gui.Tipos.Composite.ArbolFactory;
import cl.uchile.dcc.scrabble.gui.Tipos.Composite.Element.Element;
import cl.uchile.dcc.scrabble.gui.Tipos.Composite.InterfazOperadores.Operador;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ElementTest {

    public ArbolFactory arbolfact;

    //SSInt
    private int numero = new Random().nextInt();
    private int seed;
    private Random rng;
    private SInt sInt;


    //SBinary
    private SBinary sBinary;
    private String string1;


    //SString
    private String palabra;
    private SString sString;


    //Float
    private double seeddouble;
    private SFloat sFloat;

    //Bool

    private SBool sBool;


    @BeforeEach
    void setUp() {
        arbolfact = new ArbolFactory();

        //SInt setup
        sInt = STypeFactory.getSInt(numero);


        //SBinary setup
        seed = new Random().nextInt(20) + 1;
        rng = new Random(seed);
        int strSize = rng.nextInt(seed) + 1; //+1 para que nunca sea 0 el strSize
        string1 = RandomStringUtils.random(strSize, "01");
        sBinary = STypeFactory.getSBinary(string1);


        //SString setup
        palabra = RandomStringUtils.random(strSize, 0, 0, true, true, null, rng);
        sString = STypeFactory.getSString(palabra);


        //SFloat setup
        seeddouble = new Random().nextDouble();
        sFloat = STypeFactory.getSFloat(seeddouble);


        //SBool setup

        sBool = STypeFactory.getSBool(true);


    }

    /*
    Se testea solo el metodo resultado ya que los otros estan testeados implicitamente en los demas tests
     */
    @RepeatedTest(10)
    void resultado() {

        //constructor

        Operador constructorbinary = new Element(sBinary);
        Operador constructorint = new Element(sInt);
        Operador constructorfloat = new Element(sFloat);
        Operador constructorString = new Element(sString);
        Operador constructorBool = new Element(sBool);

        SBinary expectedsBinary = STypeFactory.getSBinary(string1);
        SInt expectedsInt = STypeFactory.getSInt(numero);
        SFloat expectedsFloat = STypeFactory.getSFloat(seeddouble);
        SString expectedsString = STypeFactory.getSString(palabra);
        SBool expectedsBool = STypeFactory.getSBool(true);

        assertEquals(expectedsBinary, constructorbinary.resultado());
        assertEquals(expectedsInt, constructorint.resultado());
        assertEquals(expectedsFloat, constructorfloat.resultado());
        assertEquals(expectedsString, constructorString.resultado());
        assertEquals(expectedsBool, constructorBool.resultado());


    }

}