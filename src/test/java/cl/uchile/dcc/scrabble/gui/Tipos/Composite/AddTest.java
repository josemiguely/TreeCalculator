package cl.uchile.dcc.scrabble.gui.Tipos.Composite;

import cl.uchile.dcc.scrabble.gui.Tipos.Composite.Element.ElementBinary;
import cl.uchile.dcc.scrabble.gui.Tipos.Composite.Element.ElementNumber;
import cl.uchile.dcc.scrabble.gui.Tipos.Composite.Element.ElementString;
import cl.uchile.dcc.scrabble.gui.Tipos.SBinary;
import cl.uchile.dcc.scrabble.gui.Tipos.SFloat;
import cl.uchile.dcc.scrabble.gui.Tipos.SInt;
import cl.uchile.dcc.scrabble.gui.Tipos.SString;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class AddTest {

    @Test
    void setUp() {

        ArbolAST arbolast;

        Add a1=new Add(new ElementNumber(new SInt(3)),new ElementNumber (new SInt(8)));//3+8=11

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

        System.out.println(a4.eval().getTipo());
    }

    @RepeatedTest(4)
    void Testeo(){

        Sub sub1=new Sub(new ElementNumber(new SInt(25)),new ElementBinary(new SBinary("0101")));
        //System.out.println(sub1.eval().getTipo());

        ToBinary binary= new ToBinary(sub1);

        //System.out.println(binary.eval().getTipo());

        Or or1=new Or(new ElementBinary(new SBinary("1000")),binary);

        //System.out.println("rest = "+or1.eval().getTipo());

        Add addxd=new Add(new ElementNumber(new SFloat(6.9)),or1);

        System.out.println("rest = "+addxd.eval().getTipo());




    }
}