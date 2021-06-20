package cl.uchile.dcc.scrabble.gui.Tipos.Composite;

import cl.uchile.dcc.scrabble.gui.Tipos.Composite.Element.AbstractElement;
import cl.uchile.dcc.scrabble.gui.Tipos.Composite.Element.ElementLogical;
import cl.uchile.dcc.scrabble.gui.Tipos.InterfacesOperaciones.ILogical;
import cl.uchile.dcc.scrabble.gui.Tipos.InterfacesOperaciones.IRealNumbers;

public class Or implements Operador{
    Operador nodoizq;
    Operador nodoDer;

    public Or(Operador nodoizq,Operador nodoDer){
        this.nodoizq=nodoizq;
        this.nodoDer=nodoDer;
    }

    @Override
    public ElementLogical eval() {
        ILogical Tipo=(ILogical) nodoizq.eval().getTipo();
        ILogical Tipo2=(ILogical) nodoDer.eval().getTipo();
        return new ElementLogical(Tipo.or(Tipo2));
    }
}
