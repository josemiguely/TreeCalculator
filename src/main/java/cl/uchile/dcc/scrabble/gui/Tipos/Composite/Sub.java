package cl.uchile.dcc.scrabble.gui.Tipos.Composite;

import cl.uchile.dcc.scrabble.gui.Tipos.Composite.Element.ElementBinary;
import cl.uchile.dcc.scrabble.gui.Tipos.Composite.Element.ElementNumber;
import cl.uchile.dcc.scrabble.gui.Tipos.InterfacesOperaciones.IRealNumbers;

public class Sub implements OperadoresNum {

    Operador nodoizq;
    Operador nodoDer;



    public Sub(OperadoresNum nodoizq,OperadoresNum nodoDer){
        this.nodoizq=nodoizq;
        this.nodoDer=nodoDer;
    }

    public Sub(ElementNumber nodoizq, ElementBinary nodoDer){
        this.nodoizq=nodoizq;
        this.nodoDer=nodoDer;
    }

    public Sub(ElementNumber nodoizq, ElementNumber nodoDer){
        this.nodoizq=nodoizq;
        this.nodoDer=nodoDer;
    }


    @Override
    public ElementNumber eval() {
        IRealNumbers Tipo=(IRealNumbers)nodoizq.eval().getTipo();
        return new ElementNumber(Tipo.Resta((IRealNumbers) nodoDer.eval().getTipo()));
    }


}
