package cl.uchile.dcc.scrabble.gui.Tipos.Composite.InterfazOperadores;

import cl.uchile.dcc.scrabble.gui.Tipos.Composite.Element.Element;
import cl.uchile.dcc.scrabble.gui.Tipos.InterfacesOperaciones.IUnion;

/**
 * Interfaz de composite: Un operador puede ser una operador (+,-,x,/,and,or,not,toType) o un Elemento(ElementNumber,ElementLogical,ElementString)
 * Un operador puede tener como hijos tanto operadores como elementos
 */

public interface Operador {

    /**
     * Evalua la parte del arbol correspondiente
     *
     * @return Un elemento que es el resultado de las operaciones
     */

    Element eval();

    /**
     * Printea en estructura Arbol
     */
    String print();

    /**
     * Evalua y obtiene el SType correspondiente
     *
     * @return
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
