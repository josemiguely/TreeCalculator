package cl.uchile.dcc.scrabble.gui.Tipos.Composite.OperadoresToTipo;

import cl.uchile.dcc.scrabble.gui.Tipos.Composite.Element.Element;
import cl.uchile.dcc.scrabble.gui.Tipos.Composite.InterfazOperadores.Operador;
import cl.uchile.dcc.scrabble.gui.Tipos.InterfacesOperaciones.INumber;
import cl.uchile.dcc.scrabble.gui.Tipos.InterfacesOperaciones.IRealNumbers;
import cl.uchile.dcc.scrabble.gui.Tipos.InterfacesOperaciones.IUnion;

public class ToFloat implements Operador {

    Operador nodo;

    public ToFloat(Operador nodo) {
        this.nodo = nodo;
    }


    @Override
    public Element eval() {
        IRealNumbers tipo = (IRealNumbers) nodo.eval().getTipo();
        return new Element(tipo.intoSFloat());
    }

    /**
     * Evalua y obtiene el SType correspondiente
     *
     * @return un SType de IUnion(SBool,SString,SBinary,SInt,SFloat)
     */
    @Override
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
