package cl.uchile.dcc.scrabble.gui.Tipos;

import java.util.Objects;

public class SBinary implements ITypes {

    private String numero;

    public SBinary(String numero) {

        this.numero = numero;
    }

    public String getTipoInfo() {
        return numero;
    }

    /**
     *Metodo que transforma SBinary a SString
     *
     * @return SString
     */

    public SString intoSString(){
        return new SString(getTipoInfo());
    }

    /**
     * Metodo que transforma  SBinary a  Sbinary
     *
     * @return SBinary
     */

    public SBinary intoSBinary()
    {
        return new SBinary(getTipoInfo());
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
     *
     *Revisa si dos objetos representan el mismo SBinary
     *
     * @param o Objeto que se quiere comparar
     * @return Verdadero si representan el mismo SBinary, Falso cualquier otro caso
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SBinary sBinary = (SBinary) o;
        return Objects.equals(getTipoInfo(), sBinary.getTipoInfo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTipoInfo());
    }

    @Override
    public String toString() {
        return "Binary{" +
                "numero='" + getTipoInfo() + '\'' +
                '}';
    }
}
