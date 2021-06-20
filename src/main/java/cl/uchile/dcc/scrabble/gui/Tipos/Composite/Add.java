package cl.uchile.dcc.scrabble.gui.Tipos.Composite;

import cl.uchile.dcc.scrabble.gui.Tipos.Composite.Element.AbstractElement;
import cl.uchile.dcc.scrabble.gui.Tipos.Composite.Element.ElementBinary;
import cl.uchile.dcc.scrabble.gui.Tipos.Composite.Element.ElementNumber;
import cl.uchile.dcc.scrabble.gui.Tipos.Composite.Element.ElementString;
import cl.uchile.dcc.scrabble.gui.Tipos.InterfacesOperaciones.INumberandStrings;

public class Add implements OperadoresNum {
    Operador nodoizq;
    Operador nodoDer;



    /**public Add(Operador nodoizq,Operador nodoDer){
        this.nodoizq=nodoizq;
        this.nodoDer=nodoDer;
    }**/

    public Add(ElementNumber nodoizq,ElementNumber nodoDer){
        this.nodoizq=nodoizq;
        this.nodoDer=nodoDer;
    }

    public Add(ElementString nodoizq, ElementNumber nodoDer){
        this.nodoizq=nodoizq;
        this.nodoDer=nodoDer;
    }

    public Add(ElementString nodoizq, ElementString nodoDer){
        this.nodoizq=nodoizq;
        this.nodoDer=nodoDer;
    }

    public Add(OperadoresNum nodoizq, ElementBinary nodoDer){
        this.nodoizq=nodoizq;
        this.nodoDer=nodoDer;
    }

    public Add(OperadoresNum nodoizq, OperadoresNum nodoDer){
        this.nodoizq=nodoizq;
        this.nodoDer=nodoDer;
    }
    public Add(ElementNumber nodoizq,Operador nodoDer){
        this.nodoizq=nodoizq;
        this.nodoDer=nodoDer;
    }





    @Override
    public AbstractElement eval() {
        INumberandStrings Tipo=(INumberandStrings) nodoizq.eval().getTipo();
        return new ElementNumber(Tipo.Suma(nodoDer.eval().getTipo()));
    }


}
