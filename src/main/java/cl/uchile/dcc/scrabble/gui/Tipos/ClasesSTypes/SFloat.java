package cl.uchile.dcc.scrabble.gui.Tipos.ClasesSTypes;

import cl.uchile.dcc.scrabble.gui.Tipos.InterfacesOperaciones.IRealNumbers;
import cl.uchile.dcc.scrabble.gui.Tipos.InterfacesOperaciones.IUnion;

import java.util.Objects;


public class SFloat implements IRealNumbers {

    private double numero;

    public SFloat(double numero) {
        this.numero = numero;
    }

    public double getTipoInfo() {
        return this.numero;
    }

    /**
     * Metodo que transforma  SFloat a SSTring
     *
     * @return SString
     */

    @Override
    public SString intoSString() {

        return STypeFactory.getSString(String.valueOf(this.getTipoInfo()));
    }

    @Override
    public String getInfoAsString() {
        return String.valueOf(getTipoInfo());
    }


    /**
     * Metodo que transforma SFloat a SFloat
     *
     * @return Sfloat
     */

    @Override
    public SFloat intoSFloat() {
        return STypeFactory.getSFloat(getTipoInfo());
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof SFloat) {
            SFloat sFloat = (SFloat) o;
            return getTipoInfo() == sFloat.getTipoInfo();
        }

        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTipoInfo());
    }

    @Override
    public String toString() {
        return "Float{" +
                "numero=" + getTipoInfo() +
                '}';
    }

    @Override
    public IRealNumbers Suma(IUnion number) {
        return ((IRealNumbers) number).SumaSFloat(this);
    }

    /**
     * @param number SInt a ser sumado con un SFloat
     * @return SFloat que representa la suma entre number y SFloat
     */

    @Override
    public SFloat SumaSInt(SInt number) {
        return STypeFactory.getSFloat(this.numero + number.getTipoInfo());
    }

    /**
     * @param number SFloat a ser sumado con un SFloat
     * @return SFloat que representa la suma entre number y SFloat
     */

    @Override
    public SFloat SumaSFloat(SFloat number) {
        return STypeFactory.getSFloat(this.getTipoInfo() + number.getTipoInfo());
    }

    /**
     * @param number SString a ser sumado con un SFloat
     * @return SString que representa la suma entre number y SFloat
     */

    @Override
    public SString SumaSString(SString number) {
        return STypeFactory.getSString(number.getTipoInfo() + this.getTipoInfo());
    }

    @Override
    public IRealNumbers Resta(IRealNumbers number) {
        return number.RestaSFloat(this);
    }

    /**
     * @param number SInt a ser restado con un SFloat
     * @return SFloat que representa la resta entre number y SFloat
     */

    @Override
    public SFloat RestaSInt(SInt number) {
        return STypeFactory.getSFloat(number.getTipoInfo() - this.getTipoInfo());
    }

    /**
     * @param number SFloat a ser restado con un SFloat
     * @return SFloat que representa la resta entre number y SFloat
     */

    @Override
    public SFloat RestaSFloat(SFloat number) {
        return STypeFactory.getSFloat(number.getTipoInfo() - this.getTipoInfo());
    }


    @Override
    public IRealNumbers Mult(IRealNumbers number) {
        return number.MultFloat(this);
    }

    /**
     * @param number SInt a ser multiplicado con un SFloat
     * @return SFloat que representa la multiplicacion entre number con un SFloat
     */

    @Override
    public SFloat MultInt(SInt number) {
        return STypeFactory.getSFloat(this.getTipoInfo() * number.getTipoInfo());
    }

    /**
     * @param number SFloat a ser multiplicado con un SFloat
     * @return SFloat que representa la multiplicacion entre number con un SFloat
     */

    @Override
    public SFloat MultFloat(SFloat number) {
        return STypeFactory.getSFloat(number.getTipoInfo() * this.getTipoInfo());
    }


    @Override
    public IRealNumbers Div(IRealNumbers number) {
        return number.DivFloat(this);
    }

    /**
     * @param number SInt a ser dividido con un SFloat
     * @return SFloat que representa la division entre number con un SFloat
     */

    @Override
    public SFloat DivInt(SInt number) {
        return STypeFactory.getSFloat(number.getTipoInfo() / this.getTipoInfo());
    }

    /**
     * @param number SFloat a ser dividido con un SFloat
     * @return SFloat que representa la division entre number con un SFloat
     */

    @Override
    public SFloat DivFloat(SFloat number) {
        return STypeFactory.getSFloat(number.getTipoInfo() / this.getTipoInfo());
    }

}
