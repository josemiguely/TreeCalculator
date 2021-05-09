package cl.uchile.dcc.scrabble.gui;

import java.util.Objects;

public class SBinary {

    private String numero;

    public SBinary(String numero) {

        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }

    public String intoSString(){
        return getNumero();
    }

    public String intoSBinary(){
        return getNumero();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SBinary sBinary = (SBinary) o;
        return Objects.equals(getNumero(), sBinary.getNumero());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumero());
    }

    @Override
    public String toString() {
        return "Binary{" +
                "numero='" + getNumero() + '\'' +
                '}';
    }
}
