package cl.uchile.dcc.scrabble.gui.Tipos.Composite.OperadoresBinarios;

import cl.uchile.dcc.scrabble.gui.Tipos.ClasesSTypes.SBinary;
import cl.uchile.dcc.scrabble.gui.Tipos.ClasesSTypes.SInt;
import cl.uchile.dcc.scrabble.gui.Tipos.Composite.ArbolFactory;
import cl.uchile.dcc.scrabble.gui.Tipos.Composite.InterfazOperadores.OperadorBinary;
import cl.uchile.dcc.scrabble.gui.Tipos.Composite.InterfazOperadores.OperadorFloat;
import cl.uchile.dcc.scrabble.gui.Tipos.ClasesSTypes.SFloat;
import cl.uchile.dcc.scrabble.gui.Tipos.Composite.InterfazOperadores.OperadorInt;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AddTest {

    @Test
    void setUp() {


       /* Add a1=new Add(new ElementNumber(new SInt(3)),new ElementNumber (new SInt(8)));//3+8=11

        Sub a2=new Sub(new ElementNumber(new SInt(5)),new ElementNumber (new SInt(7)));//5-7=-2

        Add arbol=new Add(a1,a2); //   11-2=9

        ElementNumber res= (ElementNumber) arbol.eval();
        //System.out.println("puta");
        System.out.println(res.getTipo());


        Add a3= new Add(new ElementString(new SString("hola")),new ElementString(new SString(" chao")));

        System.out.println(a3.eval().getTipo());

        Add a4= new Add(new ElementString(new SString("chao")),new ElementNumber(new SInt(99)));

        System.out.println(a4.eval().getTipo());

        //Add a5= new Add(new ElementNumber(new SInt(4)),new ElementString(new SString("poto")));

        System.out.println(a4.eval().getTipo());*/
    }




    @Test
    void eval(){

        //Ejemplo de las instrucciones

        ArbolFactory arbolfact=new ArbolFactory();

        OperadorInt sub1=arbolfact.Sub(new SInt(25),new SBinary("0101"));

        OperadorBinary binary=arbolfact.ToBinary(sub1);

        OperadorBinary or1=arbolfact.Or(new SBinary("1000"),binary);

        OperadorFloat addfinal=arbolfact.Add(new SFloat(6.9),or1);

        SFloat floatexpected=new SFloat(2.9000000000000004);
        assertEquals(floatexpected,addfinal.resultado());


    }
}