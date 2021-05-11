package cl.uchile.dcc.scrabble.gui.Tipos;

import java.util.Objects;

public class SInt implements ITypes{

    private int numero;

    public SInt(int numero){
        this.numero=numero;
    }

    public int getTipoInfo() {
        return numero;
    }

    /**
     * Metodo que transforma  SInt a  SString
     *
     * @return SString
     */

    public SString intoSString(){

        return new SString(String.valueOf(this.getTipoInfo()));
    }

    @Override
    public SBinary intoSBinary() {
        return null;
    }

    @Override
    public SBool intoSBool() {
        return null;
    }

    /**
     * Metodo que transforma SInt a  SFloat
     *
     * @return Sfloat
     */

    public SFloat intoSFloat(){

        return new SFloat((double)getTipoInfo());
    }

    @Override
    public SInt intoSInt() {
        return new SInt(getTipoInfo());
    }

    @Override
    public String toString() {
        return "Int{" +
                "numero=" + getTipoInfo() +
                '}';
    }

    /**
     *Revisa si dos objetos representan el mismo SInt
     *
     * @param o Objeto que se quiere comparar
     * @return Verdadero si representan el mismo SInt, Falso cualquier otro caso
     */


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SInt sInt = (SInt) o;
        return getTipoInfo() == sInt.getTipoInfo();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTipoInfo());
    }
}
