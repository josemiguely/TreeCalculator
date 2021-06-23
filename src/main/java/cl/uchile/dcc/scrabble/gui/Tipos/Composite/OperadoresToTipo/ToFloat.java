package cl.uchile.dcc.scrabble.gui.Tipos.Composite.OperadoresToTipo;

import cl.uchile.dcc.scrabble.gui.Tipos.Composite.Element.Element;
import cl.uchile.dcc.scrabble.gui.Tipos.Composite.InterfazOperadores.Operador;
import cl.uchile.dcc.scrabble.gui.Tipos.Composite.InterfazOperadores.OperadorFloat;
import cl.uchile.dcc.scrabble.gui.Tipos.InterfacesOperaciones.INumber;
import cl.uchile.dcc.scrabble.gui.Tipos.InterfacesOperaciones.IUnion;

public class ToFloat implements OperadorFloat {

    Operador nodo;

    public ToFloat(Operador nodo){
        this.nodo=nodo;
    }


    @Override
    public Element eval() {
        INumber tipo= (INumber) nodo.eval().getTipo();
        return new Element(tipo.intoSFloat());
    }

    /**
     * Printea en estructura Arbol
     */
    @Override
    public String print() {
        return nodo.print();
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
