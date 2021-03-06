package gui.Tipos.Composite.OperadoresBinarios;

import cl.uchile.dcc.scrabble.gui.Tipos.ClasesSTypes.SFloat;
import cl.uchile.dcc.scrabble.gui.Tipos.ClasesSTypes.SInt;
import cl.uchile.dcc.scrabble.gui.Tipos.ClasesSTypes.STypeFactory;
import cl.uchile.dcc.scrabble.gui.Tipos.Composite.ArbolFactory;
import cl.uchile.dcc.scrabble.gui.Tipos.Composite.InterfazOperadores.Operador;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SubTest {
    public ArbolFactory arbolfact;

    //SSInt
    private int numero = new Random().nextInt();
    private int numerodiff = numero + 1;
    private SInt sInt;
    private SInt sIntnegativo;
    private SInt sInt2;
    private SInt sInt2negativo;


    //Float
    private double seeddouble;
    private SFloat sFloat;


    @BeforeEach
    void setUp() {
        arbolfact = new ArbolFactory();

        //SInt setup
        sInt = STypeFactory.getSInt(numero);
        sIntnegativo = STypeFactory.getSInt(-numero);
        sInt2 = STypeFactory.getSInt(numerodiff);
        sInt2negativo = STypeFactory.getSInt(-numerodiff);


        //SFloat setup
        seeddouble = new Random().nextDouble();
        sFloat = STypeFactory.getSFloat(seeddouble);


    }

    @RepeatedTest(20)
    void constructorTest() {
        arbolfact = new ArbolFactory();

        //4to constructor

        Operador constructor4 = arbolfact.Sub(sInt, sInt2);
        Operador constructor4copia = arbolfact.Sub(sInt2negativo, sIntnegativo);
        SInt expectedsInt4 = STypeFactory.getSInt(numero - numerodiff);
        assertEquals(constructor4, constructor4copia);
        assertEquals(expectedsInt4, constructor4.resultado());

        //1er constructor


        Operador constructor1 = arbolfact.Sub(constructor4, constructor4copia);
        SInt expectedsInt1 = STypeFactory.getSInt(numero - numerodiff - (numero - numerodiff));
        assertEquals(expectedsInt1, constructor1.resultado());


        //2do constructor

        int n = numero - numerodiff - (numero - numerodiff);


        Operador constructor2 = arbolfact.Sub(sFloat, constructor1);
        SFloat expectedsFloat2 = STypeFactory.getSFloat(seeddouble - n);
        assertEquals(expectedsFloat2, constructor2.resultado());

        //3er constructor
        double x = seeddouble - n;

        Operador constructor3 = arbolfact.Sub(constructor2, sInt);
        SFloat expectedsInt3 = STypeFactory.getSFloat(x - numero);
        assertEquals(expectedsInt3, constructor3.resultado());


    }
}