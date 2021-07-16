package gui.Tipos.Composite.OperadoresBinarios;

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

class OrTest {
    private ArbolFactory arbolfact;

    //SSInt
    private int seed;
    private Random rng;

    //SBinary
    private SBinary sBinary;
    private SBinary sBinary2;
    private String string1;
    private String diffstring;


    //Bool

    private SBool sBool;
    private SBool sBool2;


    @BeforeEach
    void setUp() {

        arbolfact = new ArbolFactory();


        //SBinary setup
        seed = new Random().nextInt(20) + 1;
        rng = new Random(seed);
        int strSize = rng.nextInt(seed) + 1; //+1 para que nunca sea 0 el strSize
        string1 = RandomStringUtils.random(strSize, "01");
        diffstring = "101" + string1;
        sBinary = STypeFactory.getSBinary(string1);
        sBinary2 = STypeFactory.getSBinary(diffstring);


        //SBool setup
        sBool = STypeFactory.getSBool(true);
        sBool2 = STypeFactory.getSBool(false);


    }

    @RepeatedTest(20)
    void constructorTest() {


        //4to constructor

        Operador constructor4 = arbolfact.Or(sBinary, sBinary2);
        Operador constructor4copia = arbolfact.Or(sBinary2, sBinary);


        SBinary expectedsBinary4 = STypeFactory.getSBinary(diffstring);
        assertEquals(constructor4, constructor4copia);
        if (string1.charAt(0) == '0') {
            assertEquals(expectedsBinary4, constructor4.resultado());
        } else {
            assertNotEquals(expectedsBinary4, constructor4.resultado());
        }

        //1er constructor


        Operador constructor1 = arbolfact.Or(constructor4, constructor4copia);
        Operador constructur1copia = arbolfact.Or(constructor4copia, constructor4);
        assertEquals(constructor1, constructur1copia);

        if (string1.charAt(0) == '0') {
            assertEquals(expectedsBinary4, constructor4.resultado());
        } else {
            assertNotEquals(expectedsBinary4, constructor4.resultado());
        }


        //2do constructor
        String binaryexpected = "1";
        for (int i = 1; i < diffstring.length(); i++) {
            binaryexpected = "1" + binaryexpected;
        }

        Operador constructor2 = arbolfact.Or(sBool, constructur1copia);
        Operador constructor2copia = arbolfact.Or(constructor1, sBool);
        SBinary expectedsBinary2 = STypeFactory.getSBinary(binaryexpected);
        assertEquals(constructor2, constructor2copia);
        assertEquals(expectedsBinary2, constructor2.resultado());


        //3er constructor

        Operador constructor3 = arbolfact.Or(constructor2, sBool2);
        Operador constructur3copia = arbolfact.Or(sBool2, constructor2);

        assertEquals(constructor3, constructur3copia);
        assertEquals(expectedsBinary2, constructor3.resultado());


    }

}