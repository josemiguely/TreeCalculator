package cl.uchile.dcc.scrabble.gui.Tipos.Composite.OperadoresBinarios;

import cl.uchile.dcc.scrabble.gui.Tipos.ClasesSTypes.SInt;
import cl.uchile.dcc.scrabble.gui.Tipos.Composite.ArbolFactory;
import cl.uchile.dcc.scrabble.gui.Tipos.Composite.InterfazOperadores.OperadorInt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class DivTest {
    private OperadorInt div1;
    private OperadorInt div1copia;
    private OperadorInt div1diff;
    private OperadorInt div2;

    private int seed;
    private Random rng;
    ArbolFactory arbolFactory;
    int numero;
    int numero2;
    int numerodiff;
    double numdouble;


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

        arbolFactory=new ArbolFactory();
        div1=arbolFactory.Div(new SInt(numero),new SInt(numero2));
        div1copia=arbolFactory.Div(new SInt(numero),new SInt(numero2));

        if (numero>numero2){
        div1diff=arbolFactory.Div(new SInt(Math.abs(numero2*numero)),new SInt(Math.abs(numero2)));
        }
        else{
            div1diff=arbolFactory.Div(new SInt(Math.abs(numero2*numero)),new SInt(Math.abs(numero)));
        }

    }
    @Test()
   void constructorTest(){


        assertEquals(div1,div1copia);
        assertEquals(div1,div1);

        assertNotEquals(div1diff,div1);

    }

}