package cl.uchile.dcc.scrabble.gui.Tipos;

/**
 * Interfaz que define operaciones que un IRealNumbers y un SString comparten (Solo la suma por ahora)
 */

public interface INumberandStrings {

    /**
     *
     * Método que utiliza Double-Disptach
     *
     * @param number INumberandStrings que va a sumarse a this
     * @return INumberandStrings que representa la suma entre INumberandStrings
     */

    INumberandStrings Suma(INumberandStrings number);

}
