package cl.uchile.dcc.scrabble.gui.Tipos;

public interface INumber {

     INumber Suma(INumber number);

     INumber SumaSInt(SInt number);

     SFloat SumaSFloat(SFloat number);

     INumber SumaSBinary(SBinary number);

     INumber Resta(INumber number);

     INumber RestaSInt(SInt number);

     SFloat RestaSFloat(SFloat number);

     INumber RestaSBinary(SBinary number);


}
