package cl.uchile.dcc.scrabble.gui;

public class SBool {

    private boolean truthvalue;

    public SBool(boolean truthvalue) {
        this.truthvalue = truthvalue;
    }

    public String intoSString() {
        String string = String.valueOf(this.truthvalue);
        return string;
    }

    public boolean intoSSbool() {
        return truthvalue;
    }


    @Override
    public String toString() {
        return "Bool{" +
                "truthvalue=" + truthvalue +
                '}';
    }
}
