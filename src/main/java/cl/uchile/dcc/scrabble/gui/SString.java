package cl.uchile.dcc.scrabble.gui;

public class SString {

    private String string;

    public SString(String input){

        this.string=input;
    }
    
    @Override
    public String toString() {
        return "Strings{" +
                "string='" + string + '\'' +
                '}';
    }
}
