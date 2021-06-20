package cl.uchile.dcc.scrabble.gui.Tipos.Composite.OperadoresToTipo;

import cl.uchile.dcc.scrabble.gui.Tipos.Composite.Element.ElementBinary;
import cl.uchile.dcc.scrabble.gui.Tipos.Composite.Element.ElementNumber;
import cl.uchile.dcc.scrabble.gui.Tipos.Composite.Operador;
import cl.uchile.dcc.scrabble.gui.Tipos.InterfacesOperaciones.INumber;

public class ToBinary implements Operador {

    Operador nodo;

    public ToBinary(ElementBinary nodo){
        this.nodo=nodo;
    }

    public ToBinary(ElementNumber nodo){
        this.nodo=nodo;
    }

    public ToBinary(Operador nodo){
        this.nodo=nodo;
    }

    @Override
    public ElementBinary eval() {
        INumber tipo= (INumber) nodo.eval().getTipo();
        return new ElementBinary(tipo.intoSBinary());
    }
}
