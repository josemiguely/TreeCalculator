package cl.uchile.dcc.scrabble.gui.Tipos.Composite.OperadoresBinarios;

import cl.uchile.dcc.scrabble.gui.Tipos.Composite.Element.*;
import cl.uchile.dcc.scrabble.gui.Tipos.Composite.InterfazOperadores.*;
import cl.uchile.dcc.scrabble.gui.Tipos.Composite.InterfazOperadores.OperadorInt;
import cl.uchile.dcc.scrabble.gui.Tipos.InterfacesOperaciones.INumberandStrings;
import cl.uchile.dcc.scrabble.gui.Tipos.InterfacesOperaciones.IUnion;

public class Add implements OperadorString, OperadorFloat, OperadorInt, OperadorBinary {
    Operador nodoizq;
    Operador nodoDer;

    public Add(Operador nodoizq,Operador nodoDer) {
        this.nodoizq = nodoizq;
        this.nodoDer = nodoDer;
    }


    @Override
    public Element eval() {
        INumberandStrings Tipo=(INumberandStrings) nodoizq.eval().getTipo();
        return new Element(Tipo.Suma(nodoDer.eval().getTipo()));
    }

    public IUnion resultado(){
        return this.eval().getTipo();
    }

    @Override
    public boolean equals(Object o) {
        System.out.println("PUTAAAA");
        if (this == o) return true;
        if (o == null ) return false;
        if(o instanceof Operador) {
            Operador operador2 = (Operador) o;
            return this.resultado().equals(operador2.resultado());
        }
        return false;
    }


}