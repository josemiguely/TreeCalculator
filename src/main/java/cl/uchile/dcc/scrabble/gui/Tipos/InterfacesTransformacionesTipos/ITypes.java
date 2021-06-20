package cl.uchile.dcc.scrabble.gui.Tipos.InterfacesTransformacionesTipos;

import cl.uchile.dcc.scrabble.gui.Tipos.InterfacesOperaciones.IUnion;
import cl.uchile.dcc.scrabble.gui.Tipos.SString;

/**
 * Interfaz que maneja la transformacion entre tipos que comparten todos(intoSString)
 */

public interface ITypes extends IUnion{

    /**
     * Metodo que transforma a SString
     *
     * @return el objeto  transformado a SString
     */

    SString intoSString();

}
