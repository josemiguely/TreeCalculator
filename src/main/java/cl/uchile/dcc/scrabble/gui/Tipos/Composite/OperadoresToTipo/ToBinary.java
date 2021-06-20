package cl.uchile.dcc.scrabble.gui.Tipos.Composite;

import cl.uchile.dcc.scrabble.gui.Tipos.Composite.Element.ElementBinary;
import cl.uchile.dcc.scrabble.gui.Tipos.Composite.Element.ElementNumber;
import cl.uchile.dcc.scrabble.gui.Tipos.InterfacesTransformacionesTipos.TransformacionIntBinary;

public class ToBinary implements Operador{

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
        TransformacionIntBinary tipo= (TransformacionIntBinary) nodo.eval().getTipo();
        return new ElementBinary(tipo.intoSBinary());
    }
}
