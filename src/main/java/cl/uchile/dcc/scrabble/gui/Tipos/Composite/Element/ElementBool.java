package cl.uchile.dcc.scrabble.gui.Tipos.Composite.Element;

import cl.uchile.dcc.scrabble.gui.Tipos.InterfacesOperaciones.IUnion;
import cl.uchile.dcc.scrabble.gui.Tipos.SBool;

public class ElementBool extends AbstractElement{


    public ElementBool(SBool tipo) {
        super(tipo);
    }

    @Override
    public AbstractElement eval() {
        return null;
    }
}
