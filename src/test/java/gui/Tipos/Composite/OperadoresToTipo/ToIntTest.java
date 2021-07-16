package gui.Tipos.Composite.OperadoresToTipo;

import cl.uchile.dcc.scrabble.gui.Tipos.ClasesSTypes.SBinary;
import cl.uchile.dcc.scrabble.gui.Tipos.ClasesSTypes.SInt;
import cl.uchile.dcc.scrabble.gui.Tipos.ClasesSTypes.STypeFactory;
import cl.uchile.dcc.scrabble.gui.Tipos.Composite.ArbolFactory;
import cl.uchile.dcc.scrabble.gui.Tipos.Composite.InterfazOperadores.Operador;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ToIntTest {


    private ArbolFactory arbolfact;

    //SSInt
    private int numero = new Random().nextInt();
    private int seed;
    private Random rng;
    private SInt sInt;
    private SInt sIntcopia;


    //SBinary
    private SBinary sBinary;
    private String string1;


    @BeforeEach
    void setUp() {

        arbolfact = new ArbolFactory();

        //SInt setup
        sInt = STypeFactory.getSInt(numero);
        sIntcopia = STypeFactory.getSInt(numero);


        //SBinary setup
        seed = new Random().nextInt(20) + 1;
        rng = new Random(seed);
        int strSize = rng.nextInt(seed) + 1; //+1 para que nunca sea 0 el strSize
        string1 = RandomStringUtils.random(strSize, "01");
        sBinary = STypeFactory.getSBinary(string1);


    }

    @RepeatedTest(20)
    void constructorTest() {

        //2do constructor
        Operador constructor2int = arbolfact.ToInt(sInt);
        Operador constructor2intcopia = arbolfact.ToInt(sIntcopia);
        Operador constructor2binary = arbolfact.ToInt(sBinary);

        SInt expectedsInt2int = STypeFactory.getSInt(numero);
        SInt expectedsInt2binary = STypeFactory.getSInt(sBinary.intoSInt().getTipoInfo());

        assertEquals(constructor2int, constructor2intcopia);
        assertEquals(expectedsInt2int, constructor2int.resultado());
        assertEquals(expectedsInt2binary, constructor2binary.resultado());
        assertEquals(sInt, constructor2int.resultado());

        //1er constructor

        Operador constructor1int = arbolfact.ToInt(constructor2int);
        Operador constructor1binary = arbolfact.ToInt(constructor2binary);

        assertEquals(expectedsInt2int, constructor1int.resultado());
        assertEquals(expectedsInt2binary, constructor1binary.resultado());


    }

}