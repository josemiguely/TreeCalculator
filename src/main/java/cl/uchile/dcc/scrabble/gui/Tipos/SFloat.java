package cl.uchile.dcc.scrabble.gui.Tipos;

import java.util.Objects;

public class SFloat implements ITypes {

    private double numero;

    public SFloat(double numero){
        this.numero=numero;
    }

    public double getTipoInfo() {
        return numero;
    }

    /**
     * Metodo que transforma  SFloat a SSTring
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
     * Metodo que transforma SFloat a SFloat
     *
     * @return Sfloat
     */


    public SFloat intoSFloat(){
        return new SFloat(getTipoInfo());
    }

    @Override
    public SInt intoSInt() {
        return null;
    }

    /**
     *Revisa si dos objetos representan el mismo SFloat
     *
     * @param o Objeto que se quiere comparar
     * @return Verdadero si representan el mismo Float, Falso cualquier otro caso
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SFloat sFloat = (SFloat) o;
        return Double.compare(sFloat.getTipoInfo(), getTipoInfo()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTipoInfo());
    }

    @Override
    public String toString() {
        return "Float{" +
                "numero=" + getTipoInfo() +
                '}';
    }
}
