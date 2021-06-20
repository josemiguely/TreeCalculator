package cl.uchile.dcc.scrabble.gui.Tipos.Composite.Element;

import cl.uchile.dcc.scrabble.gui.Tipos.Composite.Operador;
import cl.uchile.dcc.scrabble.gui.Tipos.InterfacesOperaciones.IUnion;

public abstract class AbstractElement implements Operador {
    private IUnion tipo;

    public AbstractElement(IUnion tipo){
        this.tipo=tipo;
    }

    public IUnion getTipo() {
        return tipo;
    }
}
