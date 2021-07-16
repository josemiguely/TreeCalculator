package gui.Tipos.Composite.OperadoresToTipo;

import cl.uchile.dcc.scrabble.gui.Tipos.ClasesSTypes.SBinary;
import cl.uchile.dcc.scrabble.gui.Tipos.ClasesSTypes.SInt;
import cl.uchile.dcc.scrabble.gui.Tipos.ClasesSTypes.STypeFactory;
import cl.uchile.dcc.scrabble.gui.Tipos.Composite.ArbolFactory;
import cl.uchile.dcc.scrabble.gui.Tipos.Composite.InterfazOperadores.Operador;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ToBinaryTest {


    private ArbolFactory arbolfact;

    //SSInt
    private int numero = new Random().nextInt();
    private int numerodiff = numero + 1;
    private SInt sInt;
    private SInt sIntcopia;
    private SInt sInt2;


    @BeforeEach
    void setUp() {

        arbolfact = new ArbolFactory();

        //SInt setup
        sInt = STypeFactory.getSInt(numero);
        sIntcopia = STypeFactory.getSInt(numero);
        sInt2 = STypeFactory.getSInt(numerodiff);


    }

    @RepeatedTest(20)
    void constructorTest() {

        //2do constructor
        Operador constructor2 = arbolfact.ToBinary(sInt);
        Operador constructor2copia = arbolfact.ToBinary(sIntcopia);

        SBinary expectedsInt2 = STypeFactory.getSBinary(sInt.intoSBinary().getTipoInfo());

        assertEquals(constructor2, constructor2copia);
        assertEquals(expectedsInt2, constructor2.resultado());

        //1er constructor

        Operador operando = arbolfact.Add(sInt, sInt2);

        Operador constructor1 = arbolfact.ToBinary(operando);

        SInt sIntexp = STypeFactory.getSInt(numero + numerodiff);

        SBinary expectedsBinary1 = STypeFactory.getSBinary(sIntexp.intoSBinary().getTipoInfo());

        assertEquals(expectedsBinary1, constructor1.resultado());


    }

}