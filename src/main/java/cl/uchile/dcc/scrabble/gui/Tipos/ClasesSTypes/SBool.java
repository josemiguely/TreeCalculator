package cl.uchile.dcc.scrabble.gui.Tipos.ClasesSTypes;

import cl.uchile.dcc.scrabble.gui.Tipos.InterfacesOperaciones.ILogical;

import java.util.Objects;

public class SBool implements ILogical {
    private boolean truthvalue;

    public SBool(boolean truthvalue) {
        this.truthvalue = truthvalue;
    }

    public boolean getTipoInfo() {
        return this.truthvalue;
    }


    /**
     * Metodo que transforma SBool a SString
     *
     * @return SString
     */

    @Override
    public SString intoSString() {

        return new SString(String.valueOf(getTipoInfo()));
    }

    /**
     * Metodo que transforma SBool a SBool
     *
     * @return SBool
     */


    public SBool intoSBool() {

        return new SBool(getTipoInfo());
    }


    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof SBool) {
            SBool sBool = (SBool) o;
            return this.getTipoInfo() == sBool.getTipoInfo();
        }

        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTipoInfo());
    }

    @Override
    public String toString() {
        return "Bool{" +
                "truthvalue=" + getTipoInfo() +
                '}';
    }


    @Override
    public ILogical and(ILogical logical) {
        return logical.andSBool(this);
    }

    /**
     * @param logical que va a hacer la operacion AND con un Sbool
     * @return SBool que representa la conjuncion entre logical y ILogical
     */

    @Override
    public SBool andSBool(SBool logical) {
        return new SBool(this.getTipoInfo() && logical.getTipoInfo());
    }

    /**
     * @param logical que va a hacer la operacion AND con un SBool
     * @return Sbinary que representa la conjuncion entre logical y SBool
     */
    @Override
    public ILogical andSBinary(SBinary logical) {
        String binario = logical.getTipoInfo();
        int largo = logical.getTipoInfo().length();
        boolean truthvalue = this.getTipoInfo();
        String s = "";
        int i = 0;
        if (truthvalue) {
            return new SBinary(binario);
        }
        while (i < largo) {
            s = s + "0";
            i++;
        }
        return new SBinary(s);
    }


    @Override
    public ILogical or(ILogical logical) {
        return logical.orSBool(this);
    }

    /**
     * @param logical SBool que va a hacer la operacion OR con un SBool
     * @return SBool que representa OR entre logical y SBool
     */

    @Override
    public SBool orSBool(SBool logical) {
        return new SBool(this.getTipoInfo() || logical.getTipoInfo());
    }

    /**
     * @param logical SBinary que va a hacer la operacion OR con un SBool
     * @return SBinary que representa la operacion OR entre logical y SBool
     */
    @Override
    public ILogical orSBinary(SBinary logical) {
        String binario = logical.getTipoInfo();
        int largo = logical.getTipoInfo().length();
        boolean truthvalue = this.getTipoInfo();
        String s = "";
        if (truthvalue == false) {
            return new SBinary(binario);
        }
        int i = 0;
        while (i < largo) {
            if (truthvalue) {
                s = "1" + s;
                i++;
            }
        }
        return new SBinary(s);
    }

    /**
     * @return SBool que representa la negacion de un SBool(this)
     */
    @Override
    public SBool negacion() {
        return new SBool(!this.getTipoInfo());
    }


    /**
     * @param number SString que va a ser sumado con un SBool
     * @return SString que representa la suma entre number y SString
     */

    @Override
    public SString SumaSString(SString number) {
        return new SString(number.getTipoInfo() + getTipoInfo());
    }


}
