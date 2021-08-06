package cl.uchile.dcc.scrabble.gui.Tipos.ClasesSTypes;

import cl.uchile.dcc.scrabble.gui.Tipos.InterfacesOperaciones.INumber;
import cl.uchile.dcc.scrabble.gui.Tipos.InterfacesOperaciones.INumberandStrings;
import cl.uchile.dcc.scrabble.gui.Tipos.InterfacesOperaciones.IRealNumbers;
import cl.uchile.dcc.scrabble.gui.Tipos.InterfacesOperaciones.IUnion;

import java.util.Objects;

public class SInt implements INumber {

    private int numero;

    public SInt(int numero) {
        this.numero = numero;
    }

    public int getTipoInfo() {
        return numero;
    }

    /**
     * Metodo que transforma SInt a SString
     *
     * @return SString
     */

    public SString intoSString() {

        return STypeFactory.getSString(String.valueOf(this.getTipoInfo()));
    }

    @Override
    public String getInfoAsString() {
        return String.valueOf(getTipoInfo());
    }

    /**
     * Metodo que transforma SInt a SFloat
     *
     * @return SFloat
     */

    @Override
    public SFloat intoSFloat() {

        return STypeFactory.getSFloat((double) getTipoInfo());
    }

    /**
     * Metodo que transforma SInt a SInt
     *
     * @return Sint
     */

    @Override
    public SInt intoSInt() {
        return STypeFactory.getSInt(getTipoInfo());
    }

    /**
     * Metodo que transforma SInt a SBinary
     *
     * @return SBinary
     */

    @Override
    public SBinary intoSBinary() {
        int absolute = Math.abs(this.numero);
        String b = positiveIntToBinary(absolute);
        if (this.numero < 0) {
            b = TwosComplement(b);
        }
        return STypeFactory.getSBinary(b);
    }


    private String positiveIntToBinary(int numero) {
        String s = "";
        while (numero > 0) {
            s = ((numero % 2) == 0 ? "0" : "1") + s;
            numero = numero / 2;
        }
        return "0" + s;
    }


    private String TwosComplement(String str) {
        StringBuffer string = new StringBuffer(str);
        int n = string.length();

        int i;
        for (i = n - 1; i >= 0; i--)
            if (string.charAt(i) == '1')
                break;

        if (i == -1)
            return str + "1";

        for (int k = i - 1; k >= 0; k--) {

            if (str.charAt(k) == '1')
                string.replace(k, k + 1, "0");
            else
                string.replace(k, k + 1, "1");
        }

        return string.toString();
    }

    @Override
    public INumberandStrings Suma(IUnion number) {
        return ((IRealNumbers) number).SumaSInt(this);
    }

    /**
     * @param number SInt a ser sumado con un SInt
     * @return SInt que representa la suma entre number y SInt
     */

    @Override
    public SInt SumaSInt(SInt number) {
        int sum = this.getTipoInfo() + number.getTipoInfo();
        SInt ResultSuma = STypeFactory.getSInt(sum);
        return ResultSuma;
    }

    /**
     * @param number SFloat a ser sumado con un SInt
     * @return SFloat que representa la suma entre number y SInt
     */
    @Override
    public SFloat SumaSFloat(SFloat number) {
        double sum = this.getTipoInfo() + number.getTipoInfo();
        return STypeFactory.getSFloat(sum);
    }

    /**
     * @param number SBinary a ser sumado con un SInt
     * @return SBinary que representa la suma entre number y SInt
     */
    @Override
    public SBinary SumaSBinary(SBinary number) {
        SInt Int1 = number.intoSInt();
        SInt Int2 = Int1.SumaSInt(this);
        return Int2.intoSBinary();
    }

    /**
     * @param number SString a ser sumado con un SInt
     * @return SString que representa la suma entre number y SInt
     */

    @Override
    public SString SumaSString(SString number) {
        return STypeFactory.getSString(number.getTipoInfo() + this.getTipoInfo());
    }


    @Override
    public IRealNumbers Resta(IRealNumbers number) {
        return number.RestaSInt(this);
    }

    /**
     * @param number SInt a ser restado con un SInt
     * @return SInt que representa la resta entre number y SInt
     */
    public SInt RestaSInt(SInt number) {
        int res = number.getTipoInfo() - this.getTipoInfo();
        return STypeFactory.getSInt(res);
    }

    /**
     * @param number SFLoat a ser restado con un SInt
     * @return SFloat que representa la resta entre number y SInt
     */

    @Override
    public SFloat RestaSFloat(SFloat number) {
        return STypeFactory.getSFloat(number.getTipoInfo() - this.getTipoInfo());
    }

    /**
     * @param number SBinary a ser restado con un SInt
     * @return SBinary que representa la resta entre number y SInt
     */

    @Override
    public SBinary RestaSBinary(SBinary number) {
        SInt Int1 = number.intoSInt();
        SInt result = STypeFactory.getSInt(Int1.getTipoInfo() - this.getTipoInfo());
        return result.intoSBinary();
    }

    @Override
    public IRealNumbers Mult(IRealNumbers number) {
        return number.MultInt(this);
    }

    /**
     * @param number SInt a ser multiplicado con un SInt
     * @return SInt que representa la multiplicacion entre number con un SInt
     */

    @Override
    public SInt MultInt(SInt number) {
        return STypeFactory.getSInt(this.getTipoInfo() * number.getTipoInfo());
    }

    /**
     * @param number SFloat a ser multiplicado con un SInt
     * @return SFloat que representa la multiplicacion entre number con un SInt
     */

    @Override
    public SFloat MultFloat(SFloat number) {
        return STypeFactory.getSFloat(number.getTipoInfo() * this.getTipoInfo());
    }

    /**
     * @param number SBinary a ser multiplicado con un SInt
     * @return SBinary que representa la multiplicacion entre number con un SInt
     */

    @Override
    public SBinary MultBinary(SBinary number) {
        SInt Int1 = number.intoSInt();
        SInt Res = STypeFactory.getSInt(Int1.getTipoInfo() * this.getTipoInfo());
        SBinary ResToBin = Res.intoSBinary();
        return ResToBin;
    }

    @Override
    public IRealNumbers Div(IRealNumbers number) {
        return number.DivInt(this);
    }

    /**
     * @param number SInt a ser dividido con un SInt
     * @return SInt que representa la division entre number con un SInt
     */

    @Override
    public SInt DivInt(SInt number) {
        return STypeFactory.getSInt(number.getTipoInfo() / this.getTipoInfo());
    }

    /**
     * @param number SFloat a ser dividido con un SInt
     * @return SFloat que representa la division entre number con un SInt
     */

    @Override
    public SFloat DivFloat(SFloat number) {
        return STypeFactory.getSFloat(number.getTipoInfo() / this.getTipoInfo());
    }

    /**
     * @param number SBinary a ser dividido con un SInt
     * @return SBinary que representa la division entre number con un SInt
     */

    @Override
    public SBinary DivBinary(SBinary number) {
        SInt Int1 = number.intoSInt();
        SInt Result = (SInt) Int1.Div(this);
        SBinary ResultBinary = Result.intoSBinary();
        return ResultBinary;
    }

    @Override
    public String toString() {
        return "Int{" +
                "numero=" + getTipoInfo() +
                '}';
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof SInt) {
            SInt sInt = (SInt) o;
            return getTipoInfo() == sInt.getTipoInfo();
        }

        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTipoInfo());
    }


}
