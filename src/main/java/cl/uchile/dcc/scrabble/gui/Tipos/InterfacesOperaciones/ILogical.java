package cl.uchile.dcc.scrabble.gui.Tipos.InterfacesOperaciones;

import cl.uchile.dcc.scrabble.gui.Tipos.ClasesSTypes.SBinary;
import cl.uchile.dcc.scrabble.gui.Tipos.ClasesSTypes.SBool;

/**
 * Interfaz que tiene las operaciones entre objetos que tienen logica booleana (SBinary y SBool)
 */


public interface ILogical extends IUnion {

    /**
     * Método que utiliza Double-Dispatch
     *
     * @param logical que va a hacer la operacion AND con this
     * @return ILogical que representa la conjuncion entre ILogicals
     */

    ILogical and(ILogical logical);

    /**
     * @param logical SBool que va a hacer la operacion AND con un ILogical
     * @return ILogical que representa la conjuncion entre logical y ILogical
     */

    ILogical andSBool(SBool logical);

    /**
     * @param logical que va a hacer la operacion AND con un ILogical
     * @return ILogical que representa la conjuncion entre logical y ILogical
     */

    ILogical andSBinary(SBinary logical);

    /**
     * Método que utiliza Double-Dispatch
     *
     * @param logical ILogical que va a hacer la operacion OR con un ILogical
     * @return ILogical que representa OR entre logical y ILogical
     */

    ILogical or(ILogical logical);

    /**
     * @param logical SBool que va a hacer la operacion OR con un ILogical
     * @return ILogical que representa OR entre logical y ILogical
     */

    ILogical orSBool(SBool logical);

    /**
     * @param logical SBinary que va a hacer la operacion OR con un ILogical
     * @return ILogical que representa la operacion OR entre logical y ILogical
     */


    ILogical orSBinary(SBinary logical);

    /**
     * @return ILogical que representa la negacion de un ILogical(this)
     */

    ILogical negacion();
}
