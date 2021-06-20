package cl.uchile.dcc.scrabble.gui.Tipos.Composite;

import cl.uchile.dcc.scrabble.gui.Tipos.Composite.Element.ElementNumber;
import cl.uchile.dcc.scrabble.gui.Tipos.InterfacesOperaciones.IRealNumbers;

public class Mult implements OperadoresNum {

    Operador nodoizq;
    Operador nodoDer;



    public Mult(Operador nodoizq,Operador nodoDer){
        this.nodoizq=nodoizq;
        this.nodoDer=nodoDer;
    }


    @Override
    public ElementNumber eval() {
        IRealNumbers Tipo=(IRealNumbers)nodoizq.eval().getTipo();
        return new ElementNumber(Tipo.Mult((IRealNumbers) nodoDer.eval().getTipo()));
    }
}
