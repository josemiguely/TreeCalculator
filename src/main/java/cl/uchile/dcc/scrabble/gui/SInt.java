package cl.uchile.dcc.scrabble.gui;

public class SInt {

    int numero;

    public SInt(int numero){
        this.numero=numero;
    }


    public String intoSString(){
        String string=String.valueOf(this.numero);
        return string;
    }

    public float intoSFloat(){
        float numero=(float) this.numero;
        return numero;
    }

    public int getNumero() {
        return numero;
    }

    @Override
    public String toString() {
        return "Int{" +
                "numero=" + numero +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof SInt) {
            SInt intnumber=(SInt)obj;
            return intnumber.getNumero()==this.getNumero();
        }
        return false;
    }


}
