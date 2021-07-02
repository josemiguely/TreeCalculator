package cl.uchile.dcc.scrabble.gui.Tipos.Composite.OperadoresBinarios;

import cl.uchile.dcc.scrabble.gui.Tipos.ClasesSTypes.*;
import cl.uchile.dcc.scrabble.gui.Tipos.Composite.ArbolFactory;
import cl.uchile.dcc.scrabble.gui.Tipos.Composite.InterfazOperadores.Operador;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class AndTest {

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

        Operador constructor4 = arbolfact.And(sBinary, sBinary2);
        Operador constructor4copia = arbolfact.And(sBinary2, sBinary);

        SBinary expectedsBinary4 = STypeFactory.getSBinary(diffstring);
        assertEquals(constructor4, constructor4copia);

        if (string1.charAt(0) != '0') {
            assertEquals(expectedsBinary4, constructor4.resultado());
        } else {
            assertNotEquals(expectedsBinary4, constructor4.resultado());
        }
        //1er constructor


        Operador constructor1 = arbolfact.And(constructor4, constructor4copia);
        Operador constructur1copia = arbolfact.And(constructor4copia, constructor4);
        assertEquals(constructor1, constructur1copia);

        if (string1.charAt(0) != '0') {
            assertEquals(expectedsBinary4, constructor1.resultado());
        } else {

            assertNotEquals(expectedsBinary4, constructor1.resultado());
        }


        //2do constructor

        Operador constructor2 = arbolfact.And(sBool, constructur1copia);
        Operador constructor2copia = arbolfact.And(constructor1, sBool);
        assertEquals(constructor2, constructor2copia);
        assertEquals(constructor1.resultado(), constructor2.resultado());

        //3er constructor

        Operador constructor3 = arbolfact.And(constructor2, sBool2);
        Operador constructur3copia = arbolfact.And(sBool2, constructor2);

        String binaryexpected = "0";
        for (int i = 1; i < diffstring.length(); i++) {
            binaryexpected = "0" + binaryexpected;
        }
        SBinary expectedsBinary3 = STypeFactory.getSBinary(binaryexpected);
        assertEquals(constructor3, constructur3copia);
        assertEquals(expectedsBinary3, constructor3.resultado());


    }

    @Test
    void eval() {


        Operador sub = arbolfact.Sub(STypeFactory.getSInt(2), STypeFactory.getSInt(5));//2-5=-3 int

        Operador subbinary = arbolfact.ToBinary(sub); //-3 --> 101

        Operador binaryactual1 = arbolfact.And(STypeFactory.getSBinary("10100"), subbinary);//10100 and 11101 = 10100


        SBinary binaryexpected = STypeFactory.getSBinary("10100");

        assertEquals(binaryexpected, binaryactual1.resultado());
        assertEquals(binaryactual1.resultado(), binaryexpected);

        Operador binaryactual2 = arbolfact.And(binaryactual1, binaryactual1);//10100 and 10100 = 10100

        assertEquals(binaryexpected, binaryactual2.resultado()); //10100

        Operador binary3 = arbolfact.And(binaryactual1, STypeFactory.getSBinary("000100"));//10100 and 000100 = 000100
        SBinary binaryexpected2 = STypeFactory.getSBinary("000100");

        assertEquals(binaryexpected2, binary3.resultado());

        Operador binary_or = arbolfact.Or(binary3, STypeFactory.getSBinary("11")); //000100 or 11 = 111111 (dado que 11 se alarga con 1)
        SBinary binaryexpected3 = STypeFactory.getSBinary("111111");

        assertEquals(binaryexpected3, binary_or.resultado());

        Operador binary_negado = arbolfact.Negacion(binary_or); //negacion(111111) = 000000
        SBinary binaryexpected4 = STypeFactory.getSBinary("000000");

        assertEquals(binaryexpected4, binary_negado.resultado());

        Operador orbinaries = arbolfact.Or(binary_negado, binary_or); //111111 or 000000 = 111111

        assertEquals(binaryexpected3, orbinaries.resultado());

        Operador orbinariesInt = arbolfact.ToInt(orbinaries); //toInt(111111) = -1

        SInt expecint = STypeFactory.getSInt(-1);

        assertEquals(expecint, orbinariesInt.resultado());


    }
}