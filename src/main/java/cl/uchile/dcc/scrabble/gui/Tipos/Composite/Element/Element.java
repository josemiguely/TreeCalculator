package cl.uchile.dcc.scrabble.gui.Tipos.Composite.Element;

import cl.uchile.dcc.scrabble.gui.Tipos.Composite.InterfazOperadores.Operador;
import cl.uchile.dcc.scrabble.gui.Tipos.InterfacesOperaciones.IUnion;

/**
 * Nodo hoja del composite
 */

public class Element implements Operador {
    private IUnion tipo;

    public Element(IUnion tipo) {
        this.tipo = tipo;
    }

    public IUnion getTipo() {
        return tipo;
    }


    /**
     * Evalua y obtiene el SType correspondiente contenido dentro de Element
     *
     * @return el SType que contiene el elemento
     */
    @Override
    public IUnion resultado() {
        return this.eval().getTipo();
    }

    /**
     * Evalua y obtiene Elemento usando un diseño de Composite
     *
     * @return Element del composite
     */

    @Override
    public Element eval() {
        return this;
    }
}
