package cl.uchile.dcc.scrabble.gui.Tipos.Composite.Element;

import cl.uchile.dcc.scrabble.gui.Tipos.Composite.Element.AbstractElement;
import cl.uchile.dcc.scrabble.gui.Tipos.InterfacesOperaciones.INumberandStrings;

public class ElementNumber extends AbstractElement {

    public ElementNumber(INumberandStrings tipo) {
        super(tipo);
    }


    @Override
    public AbstractElement eval() {
        return this;
    }
}
