package cl.uchile.dcc.scrabble.gui;

import java.util.Objects;

public class SBool {

    private boolean truthvalue;

    public SBool(boolean truthvalue) {
        this.truthvalue = truthvalue;
    }

    public String intoSString() {
        String string = String.valueOf(this.truthvalue);
        return string;
    }

    public boolean getTruthvalue() {
        return truthvalue;
    }

    public boolean intoSSbool() {
        return this.getTruthvalue();
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SBool sBool = (SBool) o;
        return this.getTruthvalue() == sBool.getTruthvalue();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTruthvalue());
    }

    @Override
    public String toString() {
        return "Bool{" +
                "truthvalue=" + getTruthvalue() +
                '}';
    }
}
