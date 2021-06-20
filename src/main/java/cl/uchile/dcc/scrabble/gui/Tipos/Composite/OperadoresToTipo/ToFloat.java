package cl.uchile.dcc.scrabble.gui.Tipos.Composite;

import cl.uchile.dcc.scrabble.gui.Tipos.Composite.Element.ElementBinary;
import cl.uchile.dcc.scrabble.gui.Tipos.Composite.Element.ElementNumber;
import cl.uchile.dcc.scrabble.gui.Tipos.InterfacesOperaciones.INumber;
import cl.uchile.dcc.scrabble.gui.Tipos.InterfacesTransformacionesTipos.TransformacionIntBinary;

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
