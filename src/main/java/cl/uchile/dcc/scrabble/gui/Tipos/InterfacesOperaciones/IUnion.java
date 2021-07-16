package cl.uchile.dcc.scrabble.gui.Tipos.InterfacesOperaciones;

import cl.uchile.dcc.scrabble.gui.Tipos.ClasesSTypes.SString;

/**
 * Interfaz que tiene operacion que pueden utilizar todos (por ahora SumaSString metodo usado en Double Dispatch)
 */

public interface IUnion {

    /**
     * @param number SString que va a ser sumado con un IUnion
     * @return SString que representa la suma entre number y IUnion
     */

    SString SumaSString(SString number);

    /**
     * Metodo que transforma a SString
     *
     * @return el objeto  transformado a SString
     */

    SString intoSString();
}
