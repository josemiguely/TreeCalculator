package cl.uchile.dcc.scrabble.gui.Tipos.Composite.OperadoresUnarios;

import cl.uchile.dcc.scrabble.gui.Tipos.Composite.Element.*;
import cl.uchile.dcc.scrabble.gui.Tipos.Composite.InterfazOperadores.Operador;
import cl.uchile.dcc.scrabble.gui.Tipos.Composite.InterfazOperadores.OperadorBinary;
import cl.uchile.dcc.scrabble.gui.Tipos.Composite.InterfazOperadores.OperadorBool;
import cl.uchile.dcc.scrabble.gui.Tipos.Composite.InterfazOperadores.OperadorLogical;
import cl.uchile.dcc.scrabble.gui.Tipos.InterfacesOperaciones.ILogical;
import cl.uchile.dcc.scrabble.gui.Tipos.InterfacesOperaciones.IUnion;

public class Negacion implements OperadorBool, OperadorBinary {

    Operador nodo;

    public Negacion(Operador nodo){
        this.nodo=nodo;
    }

    @Override
    public Element eval() {
        ILogical tipo= (ILogical) nodo.eval().getTipo();
        return new Element(tipo.negacion());
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
