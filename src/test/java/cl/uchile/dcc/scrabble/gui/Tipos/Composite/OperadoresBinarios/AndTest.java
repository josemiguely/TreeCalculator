package cl.uchile.dcc.scrabble.gui.Tipos.Composite.OperadoresBinarios;

import cl.uchile.dcc.scrabble.gui.Tipos.ClasesSTypes.SBinary;
import cl.uchile.dcc.scrabble.gui.Tipos.ClasesSTypes.SInt;
import cl.uchile.dcc.scrabble.gui.Tipos.Composite.ArbolFactory;
import cl.uchile.dcc.scrabble.gui.Tipos.Composite.InterfazOperadores.OperadorBinary;
import cl.uchile.dcc.scrabble.gui.Tipos.Composite.InterfazOperadores.OperadorInt;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class AndTest {
    private OperadorBinary binary1;
    private OperadorBinary binary1copia;
    private OperadorBinary binary2;
    //private SBinary binarydiff;
    private String string1;
    private String diffpalabra;
    private int seed;
    private Random rng;
    ArbolFactory arbolFactory;

    @BeforeEach
    void setUp() {
        seed = new Random().nextInt(20) + 1;
        rng = new Random(seed);
        int strSize = rng.nextInt(seed) +1; //para que nunca sea 0 el strSize
        string1 = RandomStringUtils.random(strSize, "01");
        diffpalabra = string1 + "101";

        arbolFactory=new ArbolFactory();
        binary1=arbolFactory.And(new SBinary(string1),new SBinary(diffpalabra));
        binary1copia=arbolFactory.And(new SBinary(string1),new SBinary(diffpalabra));
        binary2=arbolFactory.And(new SBinary(diffpalabra),new SBinary(string1));

        //binary1=arbolFactory.And("101","101101");
        //binary2=arbolFactory.And("101101","101");*/

    }

    @RepeatedTest(10)
    void constructorTest(){

        assertEquals(binary1,binary1);
        assertEquals(binary1,binary1copia);
        assertEquals(binary1,binary2);

    }

    @Test
    void eval() {


        OperadorInt sub=arbolFactory.Sub(new SInt(2),new SInt(5));//2-5=-3 int

        OperadorBinary subbinary=arbolFactory.ToBinary(sub); //-3 --> 101

        OperadorBinary binaryactual1= arbolFactory.And(new SBinary("10100"),subbinary);//10100 and 11101 = 10100

        //System.out.println(binaryactual1.resultado());

        SBinary binaryexpected=new SBinary("10100");

        assertEquals(binaryexpected,binaryactual1.resultado());
        assertEquals(binaryactual1.resultado(),binaryexpected);

        OperadorBinary binaryactual2=arbolFactory.And(binaryactual1,binaryactual1);//10100 and 10100 = 10100

        assertEquals(binaryexpected,binaryactual2.resultado()); //10100

        OperadorBinary binary3= arbolFactory.And(binaryactual1,new SBinary("000100"));//10100 and 000100 = 000100
        SBinary binaryexpected2=new SBinary("000100");

        assertEquals(binaryexpected2,binary3.resultado());

        OperadorBinary binary_or=arbolFactory.Or(binary3,new SBinary("11"));
        SBinary binaryexpected3=new SBinary("111111");

        assertEquals(binaryexpected3,binary_or.resultado());

    }
}