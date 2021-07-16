package gui.Tipos.Composite.OperadoresToTipo;

import cl.uchile.dcc.scrabble.gui.Tipos.ClasesSTypes.SFloat;
import cl.uchile.dcc.scrabble.gui.Tipos.ClasesSTypes.SInt;
import cl.uchile.dcc.scrabble.gui.Tipos.ClasesSTypes.STypeFactory;
import cl.uchile.dcc.scrabble.gui.Tipos.Composite.ArbolFactory;
import cl.uchile.dcc.scrabble.gui.Tipos.Composite.InterfazOperadores.Operador;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class ToFloatTest {


    private ArbolFactory arbolfact;

    //SSInt
    private int numero = new Random().nextInt();
    private int seed;
    private Random rng;
    private SInt sInt;


    //Float
    private double seeddouble;
    private SFloat sFloat;


    @BeforeEach
    void setUp() {

        arbolfact = new ArbolFactory();

        //SInt setup
        sInt = STypeFactory.getSInt(numero);

        //SBinary setup
        seed = new Random().nextInt(20) + 1;
        rng = new Random(seed);


        //SFloat setup
        seeddouble = new Random().nextDouble();
        sFloat = STypeFactory.getSFloat(seeddouble);


    }

    @RepeatedTest(20)
    void constructorTest() {

        //2do constructor
        Operador constructor2int = arbolfact.ToFloat(sInt);
        Operador constructor2float = arbolfact.ToFloat(sFloat);

        SFloat expectedsFloat2int = STypeFactory.getSFloat(numero + 0.0);
        SFloat expectedsFloat2float = STypeFactory.getSFloat(seeddouble);

        assertEquals(expectedsFloat2int, constructor2int.resultado());
        assertEquals(expectedsFloat2float, constructor2float.resultado());
        assertEquals(sFloat, constructor2float.resultado());
        assertNotEquals(constructor2int, constructor2float);

        //1er constructor

        Operador constructor1int = arbolfact.ToFloat(constructor2int);
        Operador constructor1float = arbolfact.ToFloat(constructor2float);

        assertEquals(expectedsFloat2int, constructor1int.resultado());
        assertEquals(expectedsFloat2float, constructor1float.resultado());
        assertEquals(sFloat, constructor1float.resultado());
        assertNotEquals(constructor1int, constructor1float);


    }

}