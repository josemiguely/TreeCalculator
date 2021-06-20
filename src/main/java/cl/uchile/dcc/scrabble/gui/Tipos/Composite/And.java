package cl.uchile.dcc.scrabble.gui.Tipos.Composite;

import cl.uchile.dcc.scrabble.gui.Tipos.Composite.Element.ElementLogical;
import cl.uchile.dcc.scrabble.gui.Tipos.InterfacesOperaciones.ILogical;

public class And implements OperadorLogical {


    Operador nodoizq;
    Operador nodoDer;

    public And(Operador nodoizq,Operador nodoDer){
        this.nodoizq=nodoizq;
        this.nodoDer=nodoDer;
    }

    @Override
    public ElementLogical eval() {
        ILogical Tipo=(ILogical) nodoizq.eval().getTipo();
        return new ElementLogical(Tipo.and((ILogical) nodoDer.eval().getTipo()));
    }
}
