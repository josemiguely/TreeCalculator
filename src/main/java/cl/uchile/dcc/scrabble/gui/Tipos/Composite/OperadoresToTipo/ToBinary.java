package cl.uchile.dcc.scrabble.gui.Tipos.Composite.OperadoresToTipo;

import cl.uchile.dcc.scrabble.gui.Tipos.Composite.Element.Element;
import cl.uchile.dcc.scrabble.gui.Tipos.Composite.InterfazOperadores.Operador;
import cl.uchile.dcc.scrabble.gui.Tipos.Composite.InterfazOperadores.OperadorBinary;
import cl.uchile.dcc.scrabble.gui.Tipos.InterfacesOperaciones.INumber;
import cl.uchile.dcc.scrabble.gui.Tipos.InterfacesOperaciones.IUnion;

public class ToBinary implements OperadorBinary {

    Operador nodo;

    public ToBinary(Operador nodo){
        this.nodo=nodo;
    }

    @Override
    public Element eval() {
        INumber tipo= (INumber) nodo.eval().getTipo();
        return new Element(tipo.intoSBinary());
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
