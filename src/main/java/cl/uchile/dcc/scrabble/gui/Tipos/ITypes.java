package cl.uchile.dcc.scrabble.gui.Tipos;

/**
 * Interfaz que maneja la transformacion entre tipos:
 */

public interface ITypes {

    SBinary intoSBinary();

    SBool intoSBool();

    SFloat intoSFloat();

    SInt intoSInt();

    SString intoSString();

}
