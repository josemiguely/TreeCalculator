package cl.uchile.dcc.scrabble.gui.Tipos;

import java.util.Objects;

public class SFloat implements ITypes,INumber {

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
    public INumber Suma(INumber number) {
        return number.SumaSFloat(this);
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
    public INumber SumaSBinary(SBinary number) {
        return null;
    }

    @Override
    public INumber Resta(INumber number) {
        return number.RestaSFloat(this);
    }

    @Override
    public INumber RestaSInt(SInt number) {
        return new SFloat(number.getTipoInfo()-this.getTipoInfo());
    }

    @Override
    public SFloat RestaSFloat(SFloat number) {
        return new SFloat(number.getTipoInfo()-this.getTipoInfo());
    }

    @Override
    public INumber RestaSBinary(SBinary number) {
        SBinary floattobin=this.intoSBinary();
        return null;
    }

    @Override
    public INumber Mult(INumber number) {
        return number.MultFloat(this);
    }

    @Override
    public INumber MultInt(SInt number) {
        return new SFloat(this.getTipoInfo()*number.getTipoInfo());
    }

    @Override
    public INumber MultFloat(SFloat number) {
        return new SFloat(number.getTipoInfo()*this.getTipoInfo());
    }

    @Override
    public INumber MultBinary(SBinary number) {
        return null;
    }

    @Override
    public INumber Div(INumber number) {
        return number.DivFloat(this);
    }

    @Override
    public INumber DivInt(SInt number) {
        return new SFloat(number.getTipoInfo()/this.getTipoInfo());
    }

    @Override
    public INumber DivFloat(SFloat number) {
        return new SFloat(number.getTipoInfo()/this.getTipoInfo());
    }

    @Override
    public INumber DivBinary(SBinary number) {
        return null;
    }


}
