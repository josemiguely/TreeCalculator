package cl.uchile.dcc.scrabble.gui.Tipos.Composite.OperadoresBinarios;

import cl.uchile.dcc.scrabble.gui.Tipos.Composite.Element.*;
import cl.uchile.dcc.scrabble.gui.Tipos.Composite.InterfazOperadores.*;
import cl.uchile.dcc.scrabble.gui.Tipos.InterfacesOperaciones.INumberandStrings;
import cl.uchile.dcc.scrabble.gui.Tipos.InterfacesOperaciones.IUnion;

public class Add implements Operador {
    Operador nodoizq;
    Operador nodoDer;

    public Add(Operador nodoizq, Operador nodoDer) {
        this.nodoizq = nodoizq;
        this.nodoDer = nodoDer;
    }

    /**
     * Evalua la parte del arbol correspondiente
     *
     * @return Un Element (nodo hoja) que es el resultado de las operaciones
     */

    @Override
    public Element eval() {
        INumberandStrings Tipo = (INumberandStrings) nodoizq.eval().getTipo();
        return new Element(Tipo.Suma(nodoDer.eval().getTipo()));
    }

    /**
     * Evalua y obtiene el SType correspondiente
     *
     * @return un SType de IUnion(SBool,SString,SBinary,SInt,SFloat)
     */

    public IUnion resultado() {
        return this.eval().getTipo();
    }

    /**
     * Dos operadores son iguales si al ser evaluados contienen el mismo SType con la misma informacion
     *
     * @param o Objeto a comparar con this
     * @return True si dos objetos son iguales, Falso en Caso contrario
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (o instanceof Operador) {
            Operador operador2 = (Operador) o;
            return this.resultado().equals(operador2.resultado());
        }
        return false;
    }


}