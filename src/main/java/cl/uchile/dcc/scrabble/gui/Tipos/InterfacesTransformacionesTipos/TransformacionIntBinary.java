package cl.uchile.dcc.scrabble.gui.Tipos.InterfacesTransformacionesTipos;

import cl.uchile.dcc.scrabble.gui.Tipos.SBinary;
import cl.uchile.dcc.scrabble.gui.Tipos.SInt;

/**
 * Interfaz que maneja la transformacion entre tipos que comparten intoSInt y intoSBinary(Solo SInt y SBinary)
 */

public interface TransformacionIntBinary extends ITypes {

    /**
     * Metodo que transforma a SInt
     *
     * @return el objeto transformado a SInt
     */

    SInt intoSInt();

    /**
     * Metodo que transforma a SBinary
     *
     * @return el objeto transformado a SBinary
     */

    SBinary intoSBinary();
}

