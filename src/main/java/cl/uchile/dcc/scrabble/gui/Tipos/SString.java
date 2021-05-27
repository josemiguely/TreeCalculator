package cl.uchile.dcc.scrabble.gui.Tipos;

import java.util.Objects;

public class SString implements ITypes,INumberandStrings {

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
    public INumberandStrings Suma(INumberandStrings number) {
        SString string=(SString)number;
        return new SString(this.getTipoInfo()+string.getTipoInfo());
    }
}
