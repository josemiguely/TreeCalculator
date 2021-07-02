package cl.uchile.dcc.scrabble.gui.Tipos.Composite.OperadoresToTipo;

import cl.uchile.dcc.scrabble.gui.Tipos.ClasesSTypes.*;
import cl.uchile.dcc.scrabble.gui.Tipos.Composite.ArbolFactory;
import cl.uchile.dcc.scrabble.gui.Tipos.Composite.InterfazOperadores.Operador;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class ToStringTest {


    private ArbolFactory arbolfact;

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

    @RepeatedTest(20)
    void constructorTest() {

        //2do constructor
        Operador constructor2int = arbolfact.ToString(sInt);
        Operador constructor2float = arbolfact.ToString(sFloat);
        Operador constructor2string = arbolfact.ToString(sString);
        Operador constructor2binary = arbolfact.ToString(sBinary);
        Operador constructor2bool = arbolfact.ToString(sBool);


        SString expectedsString2int = STypeFactory.getSString(String.valueOf(numero));
        SString expectedsString2float = STypeFactory.getSString(String.valueOf(seeddouble));
        SString expectedsString2string = STypeFactory.getSString(palabra);
        SString expectedsString2binary = STypeFactory.getSString(string1);
        SString expectedsString2bool = STypeFactory.getSString(String.valueOf(true));


        assertEquals(expectedsString2int, constructor2int.resultado());
        assertEquals(expectedsString2float, constructor2float.resultado());
        assertEquals(expectedsString2string, constructor2string.resultado());
        assertEquals(expectedsString2binary, constructor2binary.resultado());
        assertEquals(expectedsString2bool, constructor2bool.resultado());


        //1er constructor

        Operador constructor1int = arbolfact.ToString(constructor2int);
        Operador constructor1float = arbolfact.ToString(constructor2float);
        Operador constructor1string = arbolfact.ToString(constructor2string);
        Operador constructor1binary = arbolfact.ToString(constructor2binary);
        Operador constructor1bool = arbolfact.ToString(constructor2bool);

        assertEquals(constructor2int, constructor1int);
        assertEquals(constructor2float, constructor1float);
        assertEquals(constructor2string, constructor1string);
        assertEquals(constructor2binary, constructor1binary);
        assertEquals(constructor2bool, constructor1bool);


    }

}