package cl.uchile.dcc.scrabble.gui.Tipos.Composite.Element;

import cl.uchile.dcc.scrabble.gui.Tipos.SBinary;
import cl.uchile.dcc.scrabble.gui.Tipos.SString;

public class ElementBinary extends AbstractElement {

        public ElementBinary(SBinary tipo) {
            super(tipo);
        }

        @Override
        public AbstractElement eval() {
            return this;
        }
    }


