package cl.uchile.dcc.scrabble.gui.Tipos.InterfacesOperaciones;

import cl.uchile.dcc.scrabble.gui.Tipos.Composite.Operador;
import cl.uchile.dcc.scrabble.gui.Tipos.SString;

/**
 * Interfaz que tiene operacion que pueden utilizar todos (por ahora SumaSString metodo usado en Double Dispatch)
 */

public interface IUnion {

    /**
     *
     * @param number SString que va a ser sumado con un IUnion
     * @return SString que representa la suma entre number y IUnion
     */

    SString SumaSString(SString number);
}
