package cl.uchile.dcc.scrabble.gui.Tipos.Composite.OperadoresBinarios;

import cl.uchile.dcc.scrabble.gui.Tipos.Composite.Element.Element;
import cl.uchile.dcc.scrabble.gui.Tipos.Composite.InterfazOperadores.Operador;
import cl.uchile.dcc.scrabble.gui.Tipos.Composite.InterfazOperadores.OperadorBinary;
import cl.uchile.dcc.scrabble.gui.Tipos.Composite.InterfazOperadores.OperadorBool;
import cl.uchile.dcc.scrabble.gui.Tipos.Composite.InterfazOperadores.OperadorLogical;
import cl.uchile.dcc.scrabble.gui.Tipos.InterfacesOperaciones.ILogical;
import cl.uchile.dcc.scrabble.gui.Tipos.InterfacesOperaciones.IUnion;

import java.util.Objects;

public class And implements OperadorBinary, OperadorBool {


    Operador nodoizq;
    Operador nodoDer;

    public And(Operador nodoizq,Operador nodoDer){
        this.nodoizq=nodoizq;
        this.nodoDer=nodoDer;
    }


    @Override
    public Element eval() {
        ILogical Tipo=(ILogical) nodoizq.eval().getTipo();
        return new Element(Tipo.and((ILogical) nodoDer.eval().getTipo()));
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


    @Override
    public int hashCode() {
        return Objects.hash(nodoizq, nodoDer);
    }

    @Override
    public String toString() {
        return "And{" +
                "nodoizq=" + nodoizq +
                ", nodoDer=" + nodoDer +
                '}';
    }
}
