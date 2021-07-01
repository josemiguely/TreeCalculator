package cl.uchile.dcc.scrabble.gui.Tipos.Composite.Element;

import cl.uchile.dcc.scrabble.gui.Tipos.Composite.InterfazOperadores.Operador;
import cl.uchile.dcc.scrabble.gui.Tipos.InterfacesOperaciones.IUnion;

import java.util.Objects;

public class Element implements Operador {
    private IUnion tipo;

    public Element(IUnion tipo){
        this.tipo=tipo;
    }

    public IUnion getTipo() {
        return tipo;
    }


    @Override
    public int hashCode() {
        return Objects.hash(tipo);
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
        return this;
    }
}
