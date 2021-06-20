package cl.uchile.dcc.scrabble.gui.Tipos.Composite.OperadoresToTipo;

import cl.uchile.dcc.scrabble.gui.Tipos.Composite.Element.ElementString;
import cl.uchile.dcc.scrabble.gui.Tipos.Composite.Operador;

public class ToString implements Operador {

    Operador nodo;

    public ToString(Operador nodo){
        this.nodo=nodo;
    }

    @Override
    public ElementString eval() {
        return new ElementString(nodo.eval().getTipo().intoSString());
    }
}
