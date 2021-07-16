package cl.uchile.dcc.scrabble.gui.Tipos.Composite.InterfazOperadores;

import cl.uchile.dcc.scrabble.gui.Tipos.Composite.Element.Element;
import cl.uchile.dcc.scrabble.gui.Tipos.InterfacesOperaciones.IUnion;

/**
 * Interfaz de diseño composite: Un operador puede ser una operador (+,-,x,/,and,or,not,toType) o un Element
 * Un operador puede tener como hijos tanto operadores como elementos
 */

public interface Operador {

    /**
     * Evalua la parte del arbol correspondiente
     *
     * @return Un Element (nodo hoja) que es el resultado de las operaciones
     */

    Element eval();


    /**
     * Evalua y obtiene el SType correspondiente
     *
     * @return un SType de IUnion(SBool,SString,SBinary,SInt,SFloat)
     */
    IUnion resultado();


    /**
     * Dos operadores son iguales si al ser evaluados contienen el mismo SType con la misma informacion
     *
     * @param o Objeto a comparar con this
     * @return True si dos objetos son iguales, Falso en Caso contrario
     */

    boolean equals(Object o);


}
