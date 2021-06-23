package cl.uchile.dcc.scrabble.gui.Tipos.ClasesSTypes;


import cl.uchile.dcc.scrabble.gui.Tipos.InterfacesOperaciones.INumberandStrings;
import cl.uchile.dcc.scrabble.gui.Tipos.InterfacesOperaciones.IUnion;

import java.util.Objects;

public class SString implements INumberandStrings {

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
        if(o instanceof SString) {
            SString sString = (SString) o;
            getTipoInfo().equals(sString.getTipoInfo());
            return getTipoInfo().equals(sString.getTipoInfo());
        }

        return false;
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

    /**
     *
     * @param number SString que va a ser sumado con un SString
     * @return SString que representa la suma entre number y SString
     */

    @Override
    public SString SumaSString(SString number) {
        return new SString(number.getTipoInfo()+this.getTipoInfo());
    }


    @Override
    public INumberandStrings Suma(IUnion number) {
        return (number).SumaSString(this);
    }
}
