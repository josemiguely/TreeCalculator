package cl.uchile.dcc.scrabble.gui.Tipos.Composite.Element;

import cl.uchile.dcc.scrabble.gui.Tipos.Composite.Element.AbstractElement;
import cl.uchile.dcc.scrabble.gui.Tipos.InterfacesOperaciones.ILogical;

public class ElementLogical extends AbstractElement {

    public ElementLogical(ILogical tipo) {
        super(tipo);
    }

    @Override
    public AbstractElement eval() {
        return this;
    }
}
