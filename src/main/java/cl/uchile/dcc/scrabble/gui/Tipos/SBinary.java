package cl.uchile.dcc.scrabble.gui.Tipos;

import java.math.BigInteger;
import java.util.Objects;

public class SBinary implements ITypes,INumber,ILogical {

    private String numero;

    public SBinary(String numero) {
        this.numero = numero;
    }

    public String getTipoInfo() {
        return this.numero;
    }

    /**
     * Metodo que transforma SBinary a SString
     *
     * @return SString
     */

    @Override
    public SString intoSString() {
        return new SString(getTipoInfo());
    }

    /**
     * Metodo que transforma  SBinary a  Sbinary
     *
     * @return SBinary
     */

    @Override
    public SBool intoSBool() {
        return null;
    }

    @Override
    public SFloat intoSFloat() {
        String s=this.getTipoInfo();
        double doubleVal = Double.longBitsToDouble(new BigInteger(s, 2).longValue());
        return new SFloat(doubleVal);
    }


    @Override
    public SInt intoSInt() {

        if (bitToInt(getTipoInfo().charAt(0)) == 0) {
            return positiveBinToInt(getTipoInfo());
        } else {
            return negativeBinaryToInt(getTipoInfo());
        }
    }

    private int bitToInt(char bit) {
        return bit == '0' ? 0 : 1;
    }

    private SInt positiveBinToInt(String binary) {
        int w = 0;
        for (int i = binary.length() - 1, j = 0; i > 0; i--, j++) {
            w += (int) Math.pow(2, j) * bitToInt(binary.charAt(i));
        }
        return new SInt(w);
    }

    private SInt negativeBinaryToInt(String binary) {
        int n = binary.length() - 1;
        int w = -bitToInt(binary.charAt(0)) * (int) Math.pow(2, n);
        for (int i = n, j = 0; i > 0; i--, j++) {
            w += (int) Math.pow(2, j) * (binary.charAt(i) == '1' ? 1 : 0);
        }
        return new SInt(w);
    }


    @Override
    public SBinary intoSBinary() {
        return new SBinary(getTipoInfo());
    }


    /**
     * Revisa si dos objetos representan el mismo SBinary
     *
     * @param o Objeto que se quiere comparar
     * @return Verdadero si representan el mismo SBinary, Falso cualquier otro caso
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SBinary sBinary = (SBinary) o;
        return Objects.equals(getTipoInfo(), sBinary.getTipoInfo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTipoInfo());
    }

    @Override
    public String toString() {
        return "Binary{" +
                "numero='" + getTipoInfo() + '\'' +
                '}';
    }

    @Override
    public INumber Suma(INumber number) {
        return number.SumaSBinary(this);
    }

    @Override
    public INumber SumaSInt(SInt number) {
        //int result = binarytoint(this.getTipoInfo());
        SInt int1=(this.intoSInt());
        int result= int1.getTipoInfo();
        System.out.println("result= "+result);
        return new SInt(result + number.getTipoInfo());
    }

    public int binarytoint(String binary) {
        int largo = binary.length();
        int i = largo - 1;
        int result = 0;
        while (i >= 0) {
            if (getTipoInfo().charAt(i) == 1) {
                result += Math.pow(2, i);
            }
            i--;
        }
        return result;
    }

    @Override
    public SFloat SumaSFloat(SFloat number) {
        int result = binarytoint(this.getTipoInfo());
        return new SFloat(result + number.getTipoInfo());
    }

    @Override
    public INumber SumaSBinary(SBinary number) {
        SInt Int1=number.intoSInt();
        SInt Int2=this.intoSInt();
        SInt Int3=(SInt) Int1.Suma(Int2);
        SBinary Binary=Int3.intoSBinary();
        return Binary;
    }
        /*String a = this.getTipoInfo();
        String b = this.getTipoInfo();

        // Initialize result
        String result = "";

        // Initialize digit sum
        int s = 0;

        // Traverse both strings starting
        // from last characters
        int i = a.length() - 1, j = b.length() - 1;
        while (i >= 0 || j >= 0 || s == 1) {

            // Comput sum of last
            // digits and carry
            s += ((i >= 0) ? a.charAt(i) - '0' : 0);
            s += ((j >= 0) ? b.charAt(j) - '0' : 0);

            // If current digit sum is
            // 1 or 3, add 1 to result
            result = (char) (s % 2 + '0') + result;

            // Compute carry
            s /= 2;

            // Move to next digits
            i--;
            j--;
        }

        return new SBinary(result);
    }*/

    @Override
    public INumber Resta(INumber number) {
        return number.RestaSBinary(this);
    }

    @Override
    public INumber RestaSInt(SInt number) {
        SInt binarytoint = this.intoSInt();
        return new SInt(number.getTipoInfo() - binarytoint.getTipoInfo());
    }

    @Override
    public SFloat RestaSFloat(SFloat number) {
        SFloat binarytofloat = this.intoSFloat();
        return new SFloat(number.getTipoInfo() - binarytofloat.getTipoInfo());
    }

    @Override
    public INumber RestaSBinary(SBinary number) {
        SInt Int1 = number.intoSInt();
        SInt Int2 = this.intoSInt();
        SInt Int3 = new SInt(Int1.getTipoInfo() - Int2.getTipoInfo());
        SBinary result = Int3.intoSBinary();
        return result;
    }

    @Override
    public INumber Mult(INumber number) {
        return number.MultBinary(this);
    }

    @Override
    public INumber MultInt(SInt number) {
        SInt Int1=this.intoSInt();
        return new SInt(number.getTipoInfo()* Int1.getTipoInfo());
    }

    @Override
    public INumber MultFloat(SFloat number) {
        return null;
    }

    @Override
    public INumber MultBinary(SBinary number) {
        SInt Int1= number.intoSInt();
        SInt Int2=this.intoSInt();
        SInt Int3= new SInt(Int1.getTipoInfo()* Int2.getTipoInfo());
        return Int3.intoSBinary();
    }

    @Override
    public INumber Div(INumber number) {
        return number.DivBinary(this);
    }

    @Override
    public INumber DivInt(SInt number) {
        SInt Int1=this.intoSInt();
        return new SInt(number.getTipoInfo()/ Int1.getTipoInfo());
    }

    @Override
    public INumber DivFloat(SFloat number) {
        SFloat Float1=this.intoSFloat();
        return new SFloat(number.getTipoInfo()/Float1.getTipoInfo());
    }

    @Override
    public INumber DivBinary(SBinary number) {
        SInt Int1=number.intoSInt();
        SInt Int2=this.intoSInt();
        SInt Int3=new SInt(Int1.getTipoInfo()/ Int2.getTipoInfo());
        return Int3.intoSBinary();
    }


    @Override
    public ILogical and(ILogical logical) {
        return logical.andSBinary(this);
    }

    @Override
    public ILogical andSBool(SBool Sbool) {
        String binario= this.getTipoInfo();
        int largo=binario.length();
        boolean truthvalue=Sbool.getTipoInfo();
        String s="";
        int i=0;
        while(i<largo){
            if (truthvalue && binario.charAt(i)=='1'){
                s="1"+s;
            }
            else{
                s="0"+s;
            }
            i++;
        }
        return new SBinary(s);
    }

    @Override
    public ILogical andSBinary(SBinary binary) {
        String binario=binary.getTipoInfo();
        String binario2=this.getTipoInfo();
        String s="";
        int i=0;
        if(binario.length()==binario2.length()) {
            while (i < binario.length()) {
                if (binario.charAt(i) == '1' && binario2.charAt(i) == '1') {
                    s = s+"1";
                } else {
                    s = s+"0";
                }
                i++;
            }
        }
        System.out.println("s="+s);
        return new SBinary(s);
    }

    @Override
    public ILogical or(ILogical logical) {
        return logical.orSBinary(this);
    }

    @Override
    public ILogical orSBool(SBool Sbool) {
        String binario= this.getTipoInfo();
        int largo=binario.length();
        boolean truthvalue=Sbool.getTipoInfo();
        String s="";
        if (!truthvalue){
            return new SBinary(binario);
        }
        int i=0;
        while(i<largo){

                s='1'+s;
            i++;
            }


        return new SBinary(s);
    }


    @Override
    public ILogical orSBinary(SBinary binary) {
        String binario = binary.getTipoInfo();
        String binario2=this.getTipoInfo();
        int largo = binario.length();
        String s = "";
        int i = 0;
        if (binario.length()==binario2.length()) {
            while (i < largo) {
                if (binario.charAt(i) == '1' || binario2.charAt(i)=='1') {
                    s = s+"1";
                }
                else {
                    s = s+"0";
                }
                i++;
            }
        }
        return new SBinary(s);
    }


    @Override
    public ILogical negacion() {
        String binario = this.getTipoInfo();
        int largo = binario.length();
        String s = "";
        int i = 0;
        while (i < largo) {
            if (binario.charAt(i) == '1') {
                s = s+"0";
            } else {
                s = s+"1";
            }
            i++;
        }
        return new SBinary(s);
    }
}