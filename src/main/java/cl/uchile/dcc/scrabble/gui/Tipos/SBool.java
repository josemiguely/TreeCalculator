package cl.uchile.dcc.scrabble.gui.Tipos;

import java.util.Objects;

public class SBool implements ITypes,ILogical {
    private boolean truthvalue;

    public SBool(boolean truthvalue) {
        this.truthvalue=truthvalue;
    }

    public boolean getTipoInfo() {
        return this.truthvalue;
    }

    /**
     * Metodo que transforma SBool a SString
     *
     * @return SString
     */

    @Override
    public SString intoSString() {

        return new SString(String.valueOf(getTipoInfo()));
    }

    /**
     * Metodo que transforma SBool a un Sbool
     *
     * @return SBool
     */

    @Override
    public SBool intoSBool() {

        return new SBool(getTipoInfo());
    }

    @Override
    public SFloat intoSFloat() {
        return null;
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


    @Override
    public ILogical and(ILogical logical) {
        return logical.andSBool(this);
    }

    @Override
    public ILogical andSBool(SBool sbool) {
        return new SBool(this.getTipoInfo() && sbool.getTipoInfo());
    }

    @Override
    public ILogical andSBinary(SBinary logical) {
        return null;
    }

    @Override
    public ILogical or(ILogical logical) {
        return null;
    }

    @Override
    public ILogical orSBool(SBool logical) {
        return null;
    }

    @Override
    public ILogical orSBinary(SBinary logical) {
        return null;
    }

    @Override
    public ILogical negacion(ILogical logical) {
        return new SBool(!this.getTipoInfo());
    }
}
