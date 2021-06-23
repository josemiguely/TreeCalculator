package cl.uchile.dcc.scrabble.gui.Tipos.Composite.OperadoresBinarios;

import cl.uchile.dcc.scrabble.gui.Tipos.Composite.Element.Element;
import cl.uchile.dcc.scrabble.gui.Tipos.Composite.InterfazOperadores.*;
import cl.uchile.dcc.scrabble.gui.Tipos.Composite.InterfazOperadores.OperadorInt;
import cl.uchile.dcc.scrabble.gui.Tipos.InterfacesOperaciones.IRealNumbers;
import cl.uchile.dcc.scrabble.gui.Tipos.InterfacesOperaciones.IUnion;

public class Sub implements  OperadorFloat, OperadorInt, OperadorBinary {

    Operador nodoizq;
    Operador nodoDer;



    public Sub(Operador nodoizq,Operador nodoDer){
        this.nodoizq=nodoizq;
        this.nodoDer=nodoDer;
    }

    @Override
    public String print() {
        String str=nodoDer.print()+"-"+"-"+nodoizq.print();
        return str;
    }

    /**
     * Evalua y obtiene el SType correspondiente
     *
     * @return
     */
    @Override
    public IUnion resultado() {
        return this.eval().getTipo();
    }

    @Override
    public Element eval() {
        IRealNumbers Tipo=(IRealNumbers)nodoizq.eval().getTipo();
        return new Element(Tipo.Resta((IRealNumbers) nodoDer.eval().getTipo()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null ) return false;
        if(o instanceof Operador) {
            Operador operador2 = (Operador) o;
            return this.resultado().equals(operador2.resultado());
        }
        return false;
    }


}
