package cl.uchile.dcc.scrabble.gui.Tipos.Composite.Element;

import cl.uchile.dcc.scrabble.gui.Tipos.InterfacesOperaciones.INumberandStrings;
import cl.uchile.dcc.scrabble.gui.Tipos.SString;

public class ElementString extends AbstractElement{

    public ElementString(SString tipo) {
        super(tipo);
    }

    @Override
    public AbstractElement eval() {
        return this;
    }
}
