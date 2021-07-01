package cl.uchile.dcc.scrabble.gui.Tipos.Composite.OperadoresBinarios;

import cl.uchile.dcc.scrabble.gui.Tipos.ClasesSTypes.*;
import cl.uchile.dcc.scrabble.gui.Tipos.Composite.ArbolFactory;
import cl.uchile.dcc.scrabble.gui.Tipos.Composite.InterfazOperadores.OperadorFloat;
import cl.uchile.dcc.scrabble.gui.Tipos.Composite.InterfazOperadores.OperadorInt;
import cl.uchile.dcc.scrabble.gui.Tipos.Composite.InterfazOperadores.OperadorString;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class SubTest {
    public ArbolFactory arbolfact;

    //SSInt
    private int numero = new Random().nextInt();
    private int numerodiff = numero+1;
    private int seed;
    private Random rng;
    private SInt sInt;
    private SInt sIntcopia;
    private SInt sInt2;

    //SBinary
    private SBinary sBinary;
    private SBinary sBinarycopia;
    private SBinary sBinary2;
    private String string1;

    //SString
    private String palabra;
    private SString sString;
    private SString sStringcopia;
    private SString sString2;

    //Float
    private double seeddouble;
    private SFloat sFloat;
    private SFloat sFloatcopia;
    private SFloat sFloat2;

    //Bool

    private SBool sBool;
    private SBool sBool2;
    private SBool sBoolcopia;

    @BeforeEach
    void setUp() {
        arbolfact=new ArbolFactory();

        //SInt setup
        sInt= STypeFactory.getSInt(numero);
        sIntcopia=STypeFactory.getSInt(numero);
        sInt2=STypeFactory.getSInt(numerodiff);


        //SBinary setup
        seed = new Random().nextInt(20) + 1;
        rng = new Random(seed);
        int strSize = rng.nextInt(seed) +1; //+1 para que nunca sea 0 el strSize
        string1 = RandomStringUtils.random(strSize, "01");
        String diffstring = string1 + "101";
        sBinary = STypeFactory.getSBinary(string1);
        sBinarycopia = STypeFactory.getSBinary(string1);
        sBinary2= STypeFactory.getSBinary(diffstring);

        //SString setup
        palabra= RandomStringUtils.random(strSize,0,0,true,true,null,rng);
        String diffpalabra = palabra + "101";
        sString=STypeFactory.getSString(palabra);
        sStringcopia=STypeFactory.getSString(palabra);
        sString2=STypeFactory.getSString(diffpalabra);


        //SFloat setup
        seeddouble=new Random().nextDouble();
        double diffdouble=seeddouble+1;
        sFloat=STypeFactory.getSFloat(seeddouble);
        sFloatcopia=STypeFactory.getSFloat(seeddouble);
        sFloat2=STypeFactory.getSFloat(diffdouble);

        //SBool setup

        boolean seedboolean = new Random().nextBoolean();
        boolean diifbolean = !seedboolean;
        sBool=STypeFactory.getSBool(seedboolean);
        sBoolcopia=STypeFactory.getSBool(seedboolean);
        sBool2=STypeFactory.getSBool(diifbolean);

    }
    @RepeatedTest(10)
    void constructorTest() {
        arbolfact = new ArbolFactory();
        OperadorInt operadorInt = arbolfact.Sub(sInt, sInt2);
        OperadorInt operadorInt2 = arbolfact.Sub(sIntcopia, sInt2);
        SInt expectedInt = new SInt(numero - numerodiff);

        assertEquals(operadorInt, operadorInt2);
        assertEquals(expectedInt, operadorInt.resultado());

    }
}