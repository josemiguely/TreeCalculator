package cl.uchile.dcc.scrabble.gui.Tipos;

import java.util.Objects;

public class SBool implements ITypes,ILogical {
    private boolean truthvalue;

    public SBool(boolean truthvalue) {
        this.truthvalue=truthvalue;
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
     * Metodo que transforma SBool a un Sbool
     *
     * @return SBool
     */

    @Override
    public SBool intoSBool() {

        return new SBool(getTipoInfo());
    }

    @Override
    public SFloat intoSFloat() {
        return null;
    }

    @Override
    public SInt intoSInt() {
        return null;
    }

    @Override
    public SBinary intoSBinary() {
        return null;
    }



    /**
     *
     *Revisa si dos objetos representan el mismo SBool
     *
     * @param o Objeto que se quiere comparar
     * @return Verdadero si representan el mismo SBool, Falso cualquier otro caso
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SBool sBool = (SBool) o;
        return this.getTipoInfo() == sBool.getTipoInfo();
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

    @Override
    public ILogical andSBool(SBool sbool) {
        return new SBool(this.getTipoInfo() && sbool.getTipoInfo());
    }

    @Override
    public ILogical andSBinary(SBinary logical) {
        String binario= logical.getTipoInfo();
        int largo=logical.getTipoInfo().length();
        boolean truthvalue=this.getTipoInfo();
        String s="";
        int i=0;
        if (truthvalue && binario.charAt(i)=='1'){
            return new SBinary(binario);
        }
        while(i<largo){
                s="0"+s;
            i++;
        }
        return new SBinary(s);
    }

    @Override
    public ILogical or(ILogical logical) {
        return logical.orSBool(this);
    }

    @Override
    public ILogical orSBool(SBool logical) {
        return new SBool(this.getTipoInfo() || logical.getTipoInfo());
    }

    @Override
    public ILogical orSBinary(SBinary logical) {
        String binario= logical.getTipoInfo();
        int largo=logical.getTipoInfo().length();
        boolean truthvalue=this.getTipoInfo();
        String s="";
        int i=0;
        while(i<largo){
            if (truthvalue){
                s="1"+s;
            }
            else{
                s=binario.charAt(i)+s;
            }
            i++;
        }
        return new SBinary(s);
    }

    @Override
    public ILogical negacion() {
        return new SBool(!this.getTipoInfo());
    }
}
