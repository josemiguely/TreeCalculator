package cl.uchile.dcc.scrabble.gui.Tipos.InterfacesTransformacionesTipos;

import cl.uchile.dcc.scrabble.gui.Tipos.SFloat;

/**
 * Interfaz que maneja la transformacion entre tipos que comparten intoSFloat
 */

public interface TransformacionFloat extends ITypes {

    /**
     * Metodo que transforma a SFloat
     *
     * @return el objeto transformado a SFloat
     */

    SFloat intoSFloat();
}
