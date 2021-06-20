package cl.uchile.dcc.scrabble.gui.Tipos.Composite.OperadoresUnarios;

import cl.uchile.dcc.scrabble.gui.Tipos.Composite.Element.ElementBinary;
import cl.uchile.dcc.scrabble.gui.Tipos.Composite.Element.ElementBool;
import cl.uchile.dcc.scrabble.gui.Tipos.Composite.Element.ElementLogical;
import cl.uchile.dcc.scrabble.gui.Tipos.Composite.Element.ElementNumber;
import cl.uchile.dcc.scrabble.gui.Tipos.Composite.Operador;
import cl.uchile.dcc.scrabble.gui.Tipos.InterfacesOperaciones.ILogical;
import cl.uchile.dcc.scrabble.gui.Tipos.InterfacesOperaciones.INumber;

public class Negacion implements Operador {

    Operador nodo;

    public Negacion(ElementBinary nodo){
        this.nodo=nodo;
    }

    public Negacion(ElementNumber nodo){ this.nodo=nodo;}

    @Override
    public ElementLogical eval() {
        ILogical tipo= (ILogical) nodo.eval().getTipo();
        return new ElementLogical(tipo.negacion());
    }
}
