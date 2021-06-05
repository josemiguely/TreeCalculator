package cl.uchile.dcc.scrabble.gui.Tipos.InterfacesOperaciones;

import cl.uchile.dcc.scrabble.gui.Tipos.SBinary;

/**
 * Interfaz que tiene  operaciones validas entre INumerosReals y objetos que simulan ser numeros(SBinary)
 */

public interface INumber extends IRealNumbers {

     /**
      * @param number SBinary a ser sumado con un INumber
      * @return INumber que representa la suma entre number con un INumber
      */

     INumber SumaSBinary(SBinary number);

     /**
      * @param number SBinary a ser restado con un INumber
      * @return INumber que representa la resta entre number con un INumber
      */

     INumber RestaSBinary(SBinary number);

     /**
      * @param number SBinary a ser multiplicado con un INumber
      * @return INumber que representa la multiplicado entre number con un INumber
      */


     INumber MultBinary(SBinary number);

     /**
      * @param number SBinary a ser dividido con un INumber
      * @return INumber que representa la division entre number con un INumber
      */

     INumber DivBinary(SBinary number);

}
