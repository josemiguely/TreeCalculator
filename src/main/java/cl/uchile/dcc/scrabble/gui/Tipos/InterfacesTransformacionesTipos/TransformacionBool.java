package cl.uchile.dcc.scrabble.gui.Tipos.InterfacesTransformacionesTipos;

import cl.uchile.dcc.scrabble.gui.Tipos.SBool;

/**
 * Interfaz que maneja la transformacion entre tipos que comparten intoSBool
 */

public interface TransformacionBool extends ITypes {


    /**
     * Metodo que transforma a SBool
     *
     * @return el objeto transformado a SBool
     */

    SBool intoSBool();
}
