package cl.uchile.dcc.scrabble.gui;

import java.util.Objects;

public class SInt {

    private int numero;

    public SInt(int numero){
        this.numero=numero;
    }

    public int getNumero() {
        return numero;
    }


    public String intoSString(){
        String string=String.valueOf(getNumero());
        return string;
    }

    public double intoSFloat(){
        double numero=(double) getNumero();
        return numero;
    }

    @Override
    public String toString() {
        return "Int{" +
                "numero=" + getNumero() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SInt sInt = (SInt) o;
        return getNumero() == sInt.getNumero();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumero());
    }
}
