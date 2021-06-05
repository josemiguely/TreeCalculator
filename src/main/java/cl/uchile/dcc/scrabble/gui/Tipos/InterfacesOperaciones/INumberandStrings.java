package cl.uchile.dcc.scrabble.gui.Tipos.InterfacesOperaciones;

import cl.uchile.dcc.scrabble.gui.Tipos.SString;

/**
 * Interfaz que define operaciones que un IRealNumbers y un strings comparten (Solo la suma por ahora)
 */

public interface INumberandStrings extends IUnion {

    /**
     *
     * Método que utiliza Double-Disptach
     *
     * @param number INumberandStrings que va a sumarse a this
     * @return INumberandStrings que representa la suma entre INumberandStrings
     */

    INumberandStrings Suma(IUnion number);



}
