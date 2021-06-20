package cl.uchile.dcc.scrabble.gui.Tipos.Composite.OperadoresToTipo;

import cl.uchile.dcc.scrabble.gui.Tipos.Composite.Element.ElementBinary;
import cl.uchile.dcc.scrabble.gui.Tipos.Composite.Element.ElementNumber;
import cl.uchile.dcc.scrabble.gui.Tipos.Composite.Operador;
import cl.uchile.dcc.scrabble.gui.Tipos.InterfacesOperaciones.INumber;

public class ToFloat implements Operador {

    Operador nodo;

    public ToFloat(ElementBinary nodo){
        this.nodo=nodo;
    }

    public ToFloat(ElementNumber nodo){ this.nodo=nodo;}

    @Override
    public ElementNumber eval() {
        INumber tipo= (INumber) nodo.eval().getTipo();
        return new ElementNumber(tipo.intoSFloat());
    }

}
