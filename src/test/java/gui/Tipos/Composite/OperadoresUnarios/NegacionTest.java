package gui.Tipos.Composite.OperadoresUnarios;

import cl.uchile.dcc.scrabble.gui.Tipos.ClasesSTypes.SBinary;
import cl.uchile.dcc.scrabble.gui.Tipos.ClasesSTypes.SBool;
import cl.uchile.dcc.scrabble.gui.Tipos.ClasesSTypes.STypeFactory;
import cl.uchile.dcc.scrabble.gui.Tipos.Composite.ArbolFactory;
import cl.uchile.dcc.scrabble.gui.Tipos.Composite.InterfazOperadores.Operador;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class NegacionTest {


    private ArbolFactory arbolfact;


    //SBinary
    private int seed;
    private Random rng;
    private SBinary sBinary;
    private SBinary sBinarycopia;

    private String string1;


    //Bool

    private SBool sBool;
    private SBool sBool2;
    private SBool sBoolcopia;


    @BeforeEach
    void setUp() {

        arbolfact = new ArbolFactory();

        //SBinary setup
        seed = new Random().nextInt(20) + 1;
        rng = new Random(seed);
        int strSize = rng.nextInt(seed) + 1; //+1 para que nunca sea 0 el strSize
        string1 = RandomStringUtils.random(strSize, "01");
        sBinary = STypeFactory.getSBinary(string1);
        sBinarycopia = STypeFactory.getSBinary(string1);


        //SBool setup
        sBool = STypeFactory.getSBool(true);
        sBoolcopia = STypeFactory.getSBool(true);
        sBool2 = STypeFactory.getSBool(false);
    }

    @RepeatedTest(20)
    void constructorTest() {

        //constructor2 SBool

        Operador constructor2 = arbolfact.Negacion(sBool);
        Operador constructor2copia = arbolfact.Negacion(sBoolcopia);
        Operador constructor2not = arbolfact.Negacion(sBool2);
        SBool expectedsBool = STypeFactory.getSBool(false);
        SBool expectednotsBool = STypeFactory.getSBool(true);

        assertEquals(constructor2, constructor2copia);
        assertEquals(expectedsBool, constructor2.resultado());

        assertNotEquals(constructor2, constructor2not);
        assertEquals(expectednotsBool, constructor2not.resultado());


        //constructor2 SBinary

        Operador constructor2binary = arbolfact.Negacion(sBinary);
        Operador constructor2copiabinary = arbolfact.Negacion(sBinarycopia);
        SBinary expectedsBinary = STypeFactory.getSBinary(sBinary.negacion().getTipoInfo());

        assertEquals(constructor2binary, constructor2copiabinary);
        assertEquals(expectedsBinary, constructor2binary.resultado());


        //constructor1 SBool

        Operador constructor1 = arbolfact.Negacion(constructor2);
        Operador constructor1not = arbolfact.Negacion(constructor2not);

        assertEquals(constructor2not, constructor1);
        assertEquals(constructor2, constructor1not);


        //constructor1 SBinary

        Operador constructor1binary = arbolfact.Negacion(constructor2binary);

        assertEquals(sBinary, constructor1binary.resultado());


    }
}