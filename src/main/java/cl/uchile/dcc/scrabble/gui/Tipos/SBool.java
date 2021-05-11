package cl.uchile.dcc.scrabble.gui.Tipos;

import java.util.Objects;

public class SBool implements ITypes {

    private boolean truthvalue;

    public SBool(boolean truthvalue) {
        this.truthvalue = truthvalue;
    }

    @Override
    public SBinary intoSBinary() {
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
     * Metodo que transforma SBool a SString
     *
     * @return SString
     */

    public SString intoSString() {

        return new SString(String.valueOf(this.truthvalue));
    }

    /**
     * Metodo que transforma SBool a un Sbool
     *
     * @return SBool
     */

    public SBool intoSBool() {

        return new SBool(getTipoInfo());
    }



    public boolean getTipoInfo() {
        return truthvalue;
    }


    /**
     *
     *Revisa si dos objetos representan el mismo SBool
     *
     * @param o Objeto que se quiere comparar
     * @return Verdadero si representan el mismo SBool, Falso cualquier otro caso
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SBool sBool = (SBool) o;
        return this.getTipoInfo() == sBool.getTipoInfo();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTipoInfo());
    }

    @Override
    public String toString() {
        return "Bool{" +
                "truthvalue=" + getTipoInfo() +
                '}';
    }
}
