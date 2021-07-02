package cl.uchile.dcc.scrabble.gui.Tipos.Composite.OperadoresBinarios;

import cl.uchile.dcc.scrabble.gui.Tipos.ClasesSTypes.*;
import cl.uchile.dcc.scrabble.gui.Tipos.Composite.ArbolFactory;
import cl.uchile.dcc.scrabble.gui.Tipos.Composite.InterfazOperadores.*;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;


class AddTest {
    public ArbolFactory arbolfact;

    //SSInt
    private int numero = new Random().nextInt();
    private int numerodiff = numero + 1;
    private int seed;
    private Random rng;
    private SInt sInt;
    private SInt sInt2;


    //SString
    private String palabra;
    private SString sString;


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


        //SString setup
        palabra = RandomStringUtils.random(strSize, 0, 0, true, true, null, rng);
        sString = STypeFactory.getSString(palabra);


        //SFloat setup
        seeddouble = new Random().nextDouble();
        sFloat = STypeFactory.getSFloat(seeddouble);


    }

    /*
    Se testean todas las combinaciones del constructor Add(,)
     */
    @RepeatedTest(20)
    void constructorTest() {

        //4to constructor

        Operador constructor4 = arbolfact.Add(sInt, sInt2);
        Operador constructor4copia = arbolfact.Add(sInt2, sInt);
        SInt expectedsInt4 = STypeFactory.getSInt(numero + numerodiff);
        assertEquals(constructor4, constructor4copia);
        assertEquals(expectedsInt4, constructor4.resultado());


        //1er constructor


        Operador constructor1 = arbolfact.Add(constructor4, constructor4copia);
        Operador constructur1copia = arbolfact.Add(constructor4copia, constructor4);
        SInt expectedsInt1 = STypeFactory.getSInt(2 * (numero + numerodiff));
        assertEquals(constructor1, constructur1copia);
        assertEquals(expectedsInt1, constructor1.resultado());

        //3er constructor
        Operador constructor3 = arbolfact.Add(constructor1, sInt);
        Operador constructur3copia = arbolfact.Add(sInt, constructor1);
        SInt expectedsInt3 = STypeFactory.getSInt(2 * (numero + numerodiff) + numero);
        assertEquals(constructor3, constructur3copia);
        assertEquals(expectedsInt3, constructor3.resultado());


        //2do constructor

        int n = 2 * (numero + numerodiff);


        Operador constructor2 = arbolfact.Add(sFloat, constructur1copia);
        Operador constructor2copia = arbolfact.Add(constructor1, sFloat);
        SFloat expectedsFloat2 = STypeFactory.getSFloat(seeddouble + n);
        assertEquals(constructor2, constructor2copia);
        assertEquals(expectedsFloat2, constructor2.resultado());


        double x = seeddouble + n;

        Operador constructor22 = arbolfact.Add(sString, constructor2);
        SString expectedsString22 = STypeFactory.getSString(palabra + x);
        assertEquals(expectedsString22, constructor22.resultado());


    }


    @Test
    void eval() {

        //Ejemplo de las instrucciones

        Operador sub1 = arbolfact.Sub(STypeFactory.getSInt(25), STypeFactory.getSBinary("0101"));

        Operador binary = arbolfact.ToBinary(sub1);

        Operador or1 = arbolfact.Or(STypeFactory.getSBinary("1000"), binary);

        Operador addfinal = arbolfact.Add(STypeFactory.getSFloat(6.9), or1);

        SFloat floatexpected = STypeFactory.getSFloat(2.9000000000000004);
        assertEquals(floatexpected, addfinal.resultado());


    }


}