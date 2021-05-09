package cl.uchile.dcc.scrabble.gui;

import java.util.Objects;

public class SFloat {

    private double numero;

    public SFloat(double numero){
        this.numero=numero;
    }

    public double getNumero() {
        return numero;
    }

    public String intoSString(){
        String string = String.valueOf(getNumero());
        return string;
    }

    public double intoSFloat(){
        return getNumero();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SFloat sFloat = (SFloat) o;
        return Double.compare(sFloat.getNumero(), getNumero()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumero());
    }

    @Override
    public String toString() {
        return "Float{" +
                "numero=" + getNumero() +
                '}';
    }
}
