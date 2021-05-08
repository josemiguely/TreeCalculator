package cl.uchile.dcc.scrabble.gui;

public class SFloat {

    float numero;

    public SFloat(float numero){
        this.numero=numero;
    }

    public String intoSString(){
        String string = String.valueOf(this.numero);
        return string;
    }

    @Override
    public String toString() {
        return "Float{" +
                "numero=" + numero +
                '}';
    }
}
