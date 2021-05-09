package cl.uchile.dcc.scrabble.gui;

import java.util.Objects;

public class SString {

    private String string;

    public SString(String input){

        this.string=input;
    }

    public String getString() {
        return string;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SString sString = (SString) o;
        return Objects.equals(getString(), sString.getString());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getString());
    }

    @Override
    public String toString() {
        return "Strings{" +
                "string='" + getString() + '\'' +
                '}';
    }


}
