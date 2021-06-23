package cl.uchile.dcc.scrabble.gui.Tipos.Composite.OperadoresBinarios;

import cl.uchile.dcc.scrabble.gui.Tipos.ClasesSTypes.SFloat;
import cl.uchile.dcc.scrabble.gui.Tipos.ClasesSTypes.SInt;
import cl.uchile.dcc.scrabble.gui.Tipos.Composite.ArbolFactory;
import cl.uchile.dcc.scrabble.gui.Tipos.Composite.InterfazOperadores.OperadorFloat;
import cl.uchile.dcc.scrabble.gui.Tipos.Composite.InterfazOperadores.OperadorInt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class MultTest {


    private OperadorInt mult1;
    private OperadorInt mult1copia;
    private OperadorInt mult1diff;
    private OperadorInt mult2;

    private OperadorFloat mult1double;
    private OperadorFloat mult1doublecopia;
    private OperadorFloat multdoublediff;

    private int seed;
    private Random rng;
    ArbolFactory arbolFactory;
    int numero;
    int numero2;
    int numerodiff;
    double numdouble;
    double numdouble2;


    @BeforeEach
    void setUp() {


        numero = new Random().nextInt(10000);
        if (numero==0){
            numero++;
        }

        numero2 = new Random().nextInt(10000);

        if (numero2==0){
            numero2++;
        }


        numdouble = new Random().nextDouble();
        numdouble2 = new Random().nextDouble();

        arbolFactory=new ArbolFactory();
        mult1=arbolFactory.Mult(new SInt(numero),new SInt(numero2));
        mult1copia=arbolFactory.Mult(new SInt(numero),new SInt(numero2));
        mult1diff=arbolFactory.Mult(new SInt(numero+1),new SInt(numero2));

        mult1double=arbolFactory.Mult(new SFloat(numdouble),new SFloat(numdouble2));
        mult1doublecopia=arbolFactory.Mult(new SFloat(numdouble2),new SFloat(numdouble));
        multdoublediff=arbolFactory.Mult(new SFloat(numdouble+1),new SFloat(numdouble2));



    }

    @RepeatedTest(20)
    void constructorTest(){

        //Constructor Int con Int
        assertEquals(mult1,mult1copia);
        assertEquals(mult1,mult1);

        assertNotEquals(mult1diff,mult1);

        //Constructor Double con Double
        assertEquals(mult1double,mult1doublecopia);
        assertEquals(mult1double,mult1double);

        assertNotEquals(mult1double,multdoublediff);

        //Constructor Double con Int

        //

    }
}