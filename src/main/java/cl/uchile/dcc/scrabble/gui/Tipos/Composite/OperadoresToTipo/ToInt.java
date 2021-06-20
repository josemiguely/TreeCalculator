package cl.uchile.dcc.scrabble.gui.Tipos.Composite.OperadoresToTipo;

import cl.uchile.dcc.scrabble.gui.Tipos.Composite.Element.ElementBinary;
import cl.uchile.dcc.scrabble.gui.Tipos.Composite.Element.ElementNumber;
import cl.uchile.dcc.scrabble.gui.Tipos.Composite.Operador;
import cl.uchile.dcc.scrabble.gui.Tipos.InterfacesOperaciones.INumber;

public class ToInt implements Operador {
    Operador nodo;

    public ToInt(ElementBinary nodo){
        this.nodo=nodo;
    }

    public ToInt(ElementNumber nodo){ this.nodo=nodo;}//Solo deberia ser int-> Josemiguel del futuro arreglalo si hay problemas

    @Override
    public ElementNumber eval() {
        INumber tipo= (INumber) nodo.eval().getTipo();
        return new ElementNumber(tipo.intoSInt());
    }


}
