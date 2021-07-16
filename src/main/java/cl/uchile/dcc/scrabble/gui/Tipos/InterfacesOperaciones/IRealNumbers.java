package cl.uchile.dcc.scrabble.gui.Tipos.InterfacesOperaciones;

import cl.uchile.dcc.scrabble.gui.Tipos.ClasesSTypes.SFloat;
import cl.uchile.dcc.scrabble.gui.Tipos.ClasesSTypes.SInt;

/**
 * Interfaz que tiene las operaciones entre objetos que contienen informacion de numeros reales/primitivos (ie int,double)
 */


public interface IRealNumbers extends INumberandStrings {

    /**
     * @param number SInt a ser sumado con un IRealNumbers
     * @return IRealNumbers que representa la suma entre number y IRealNumbers
     */
    IRealNumbers SumaSInt(SInt number);

    /**
     * @param number SFloat a ser sumado con un IRealNumbers
     * @return SFloat que representa la suma entre number y IRealNumbers
     */

    SFloat SumaSFloat(SFloat number);

    /**
     * Metodo que utiliza Double-Dispatch
     *
     * @param number IRealNumbers que va a dividir  a this
     * @return IRealNumbers que representa la division entre IRealNumbers
     */

    IRealNumbers Resta(IRealNumbers number);

    /**
     * @param number SInt a ser restado con un IRealNumbers
     * @return IRealNumbers que representa la resta entre number y Realnumbers
     */

    IRealNumbers RestaSInt(SInt number);

    /**
     * @param number SFloat a ser restado con un IRealNumbers
     * @return SFloat que representa la resta entre number y un IRealNumbers
     */
    SFloat RestaSFloat(SFloat number);

    /**
     * Metodo que utiliza Double-Dispatch
     *
     * @param number IRealNumbers que va a multiplicar  a this
     * @return IRealNumbers que representa la multiplicacion entre IRealNumbers
     */

    IRealNumbers Mult(IRealNumbers number);

    /**
     * @param number SInt a ser multiplicado con un IRealNumbers
     * @return IRealNumbers que representa la multiplicacion entre number con un IRealNumbers
     */

    IRealNumbers MultInt(SInt number);

    /**
     * @param number SFloat a ser multiplicado con un IRealNumbers
     * @return IRealNumbers que representa la multiplicacion entre number con un IRealNumbers
     */

    IRealNumbers MultFloat(SFloat number);

    /**
     * Metodo que utiliza Double-Dispatch
     *
     * @param number IRealNumbers que va a dividir  a this
     * @return IRealNumbers que representa la division entre IRealNumbers
     */

    IRealNumbers Div(IRealNumbers number);

    /**
     * @param number SInt a ser dividido con un IRealNumbers
     * @return IRealNumbers que representa la division entre number con un IRealNumbers
     */

    IRealNumbers DivInt(SInt number);

    /**
     * @param number SFloat a ser dividido con un IRealNumbers
     * @return IRealNumbers que representa la division entre number con un IRealNumbers
     */

    IRealNumbers DivFloat(SFloat number);

    SFloat intoSFloat();


}
