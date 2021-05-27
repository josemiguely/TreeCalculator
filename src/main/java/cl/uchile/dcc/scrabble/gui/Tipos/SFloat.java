package cl.uchile.dcc.scrabble.gui.Tipos;

import java.util.Objects;

public class SFloat implements ITypes,IRealNumbers {

    private double numero;

    public SFloat(double numero){
        this.numero=numero;
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
    public SString intoSString(){

        return new SString(String.valueOf(this.getTipoInfo()));
    }


    @Override
    public SBool intoSBool() {
        return null;
    }

    /**
     * Metodo que transforma SFloat a SFloat
     *
     * @return Sfloat
     */

    @Override
    public SFloat intoSFloat(){
        return new SFloat(getTipoInfo());
    }

    @Override
    public SInt intoSInt() {
        return null;
    }

    @Override
    public SBinary intoSBinary() {
        return null;
    }


    /**
     *Revisa si dos objetos representan el mismo SFloat
     *
     * @param o Objeto que se quiere comparar
     * @return Verdadero si representan el mismo Float, Falso cualquier otro caso
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SFloat sFloat = (SFloat) o;
        return Double.compare(sFloat.getTipoInfo(), getTipoInfo()) == 0;
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
    public IRealNumbers Suma(INumberandStrings number) {
        return ((IRealNumbers) number).SumaSFloat(this);
    }

    @Override
    public SFloat SumaSInt(SInt number) {
        return new SFloat(this.numero+number.getTipoInfo());
    }

    @Override
    public SFloat SumaSFloat(SFloat number) {
        return new SFloat(this.getTipoInfo()+number.getTipoInfo());
    }


    @Override
    public IRealNumbers Resta(IRealNumbers number) {
        return number.RestaSFloat(this);
    }

    @Override
    public IRealNumbers RestaSInt(SInt number) {
        return new SFloat(number.getTipoInfo()-this.getTipoInfo());
    }

    @Override
    public SFloat RestaSFloat(SFloat number) {
        return new SFloat(number.getTipoInfo()-this.getTipoInfo());
    }


    @Override
    public IRealNumbers Mult(IRealNumbers number) {
        return number.MultFloat(this);
    }

    @Override
    public IRealNumbers MultInt(SInt number) {
        return new SFloat(this.getTipoInfo()*number.getTipoInfo());
    }

    @Override
    public IRealNumbers MultFloat(SFloat number) {
        return new SFloat(number.getTipoInfo()*this.getTipoInfo());
    }


    @Override
    public IRealNumbers Div(IRealNumbers number) {
        return number.DivFloat(this);
    }

    @Override
    public IRealNumbers DivInt(SInt number) {
        return new SFloat(number.getTipoInfo()/this.getTipoInfo());
    }

    @Override
    public IRealNumbers DivFloat(SFloat number) {
        return new SFloat(number.getTipoInfo()/this.getTipoInfo());
    }

}
