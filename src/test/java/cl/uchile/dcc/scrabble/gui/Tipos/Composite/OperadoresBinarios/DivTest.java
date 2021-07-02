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

class DivTest {
    public ArbolFactory arbolfact;

    //SSInt
    private int numero = new Random().nextInt();
    private int numerodiff = numero + 1;
    private int seed;
    private Random rng;
    private SInt sInt;
    private SInt sInt2;


    //Float
    private double seeddouble;
    private SFloat sFloat;


    @BeforeEach
    void setUp() {

        arbolfact = new ArbolFactory();

        //SInt setup
        sInt = STypeFactory.getSInt(numero);
        sInt2 = STypeFactory.getSInt(numerodiff);


        //SBinary setup
        seed = new Random().nextInt(20) + 1;
        rng = new Random(seed);
        int strSize = rng.nextInt(seed) + 1; //+1 para que nunca sea 0 el strSize


        //SFloat setup
        seeddouble = new Random().nextDouble();
        sFloat = STypeFactory.getSFloat(seeddouble);


    }

    @RepeatedTest(20)
    void constructorTest() {
        arbolfact = new ArbolFactory();
        if (numero / numerodiff == 0) {
            int temp = numero;
            numero = numerodiff;
            numerodiff = temp;
            sInt = STypeFactory.getSInt(numero);
            sInt2 = STypeFactory.getSInt(numerodiff);
        }


        //4to constructor

        Operador constructor4 = arbolfact.Div(sInt, sInt2);
        Operador constructor4distinto = arbolfact.Div(sInt2, sInt);
        SInt expectedsInt4 = STypeFactory.getSInt(numero / numerodiff);
        assertNotEquals(constructor4, constructor4distinto);
        System.out.println("numero = " + numero + " numero diff= " + numerodiff);
        System.out.println("constructur4res " + constructor4.resultado());
        assertEquals(expectedsInt4, constructor4.resultado());

        //1er constructor


        Operador constructor1 = arbolfact.Div(constructor4, constructor4);
        SInt expectedsInt1 = STypeFactory.getSInt(numero / numerodiff / (numero / numerodiff));
        assertEquals(expectedsInt1, constructor1.resultado());


        //2do constructor

        int n = numero / numerodiff / (numero / numerodiff);


        Operador constructor2 = arbolfact.Div(sFloat, constructor1);
        SFloat expectedsFloat2 = STypeFactory.getSFloat(seeddouble / n);
        assertEquals(expectedsFloat2, constructor2.resultado());

        //3er constructor
        double x = seeddouble / n;

        Operador constructor3 = arbolfact.Div(constructor2, sInt);
        SFloat expectedsInt3 = STypeFactory.getSFloat(x / numero);
        assertEquals(expectedsInt3, constructor3.resultado());

    }

    @Test
    void eval() {


        Operador div = arbolfact.Div(STypeFactory.getSInt(20), STypeFactory.getSInt(10));//20/10=2 int

        Operador floatdiv = arbolfact.ToFloat(div); //2 --> 2.0

        SFloat floatexpected = STypeFactory.getSFloat(2.0);

        assertEquals(floatexpected, floatdiv.resultado());

        SBinary binary = STypeFactory.getSBinary("10100");//-12

        Operador floatbinary = arbolfact.Mult(floatdiv, binary);//2.0*-12=-24.0

        SFloat floatexpected2 = STypeFactory.getSFloat(-24.0);

        assertEquals(floatexpected2, floatbinary.resultado());

        Operador floatfloat = arbolfact.ToFloat(floatbinary);//-24.0 Float --> -24.0 Float

        assertEquals(floatfloat, floatbinary);

        Operador divfloatfloat = arbolfact.Div(STypeFactory.getSFloat(100.5), floatfloat);//100.5/-24.0= -4.1875 float

        SFloat floatexpected3 = STypeFactory.getSFloat(-4.1875);

        assertEquals(floatexpected3, divfloatfloat.resultado());

        Operador floattostring = arbolfact.ToString(floatexpected3);

        SString stringsum = STypeFactory.getSString("Hola Mundo");

        Operador sumstringfloat = arbolfact.Add(floattostring, stringsum);

        SString expectedstring = STypeFactory.getSString("-4.1875" + "Hola Mundo");

        assertEquals(expectedstring, sumstringfloat.resultado());


    }

}