package cl.uchile.dcc.scrabble.gui.Tipos;

import java.util.Objects;

public class SString implements ITypes,INumber {

    private String string;

    public SString(String input){

        this.string=input;
    }

    public String getTipoInfo() {
        return string;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SString sString = (SString) o;
        return Objects.equals(getTipoInfo(), sString.getTipoInfo());
    }


    @Override
    public SBinary intoSBinary() {
        return null;
    }

    @Override
    public SBool intoSBool() {
        return null;
    }

    @Override
    public SFloat intoSFloat() {
        return null;
    }

    @Override
    public SInt intoSInt() {
        return null;
    }

    /**
     * Metodo que transforma  SString a  SString
     *
     * @return SString
     */

    public SString intoSString(){
        return new SString(getTipoInfo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTipoInfo());
    }

    @Override
    public String toString() {
        return "Strings{" +
                "string='" + getTipoInfo() + '\'' +
                '}';
    }

    @Override
    public INumber Suma(INumber number) {
        SString string=(SString)number;
        return new SString(this.getTipoInfo()+string.getTipoInfo());
    }

    @Override
    public INumber SumaSInt(SInt number) {
        return null;
    }

    @Override
    public SFloat SumaSFloat(SFloat number) {
        return null;
    }

    @Override
    public INumber SumaSBinary(SBinary number) {
        return null;
    }

    @Override
    public INumber Resta(INumber number) {
        return null;
    }

    @Override
    public INumber RestaSInt(SInt number) {
        return null;
    }

    @Override
    public SFloat RestaSFloat(SFloat number) {
        return null;
    }

    @Override
    public INumber RestaSBinary(SBinary number) {
        return null;
    }

    @Override
    public INumber Mult(INumber number) {
        return null;
    }

    @Override
    public INumber MultInt(SInt number) {
        return null;
    }

    @Override
    public INumber MultFloat(SFloat number) {
        return null;
    }

    @Override
    public INumber MultBinary(SBinary number) {
        return null;
    }

    @Override
    public INumber Div(INumber number) {
        return null;
    }

    @Override
    public INumber DivInt(SInt number) {
        return null;
    }

    @Override
    public INumber DivFloat(SFloat number) {
        return null;
    }

    @Override
    public INumber DivBinary(SBinary number) {
        return null;
    }
}
