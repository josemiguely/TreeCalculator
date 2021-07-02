package cl.uchile.dcc.scrabble.gui.Tipos.ClasesSTypes;

import cl.uchile.dcc.scrabble.gui.Tipos.InterfacesOperaciones.*;

import java.math.BigInteger;
import java.util.Objects;

public class SBinary implements INumber, ILogical {

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
     * Metodo que transforma  SBinary a  Float
     *
     * @return SBinary
     */


    @Override
    public SFloat intoSFloat() {
        String s = this.getTipoInfo();
        double doubleVal = Double.longBitsToDouble(new BigInteger(s, 2).longValue());
        return new SFloat(doubleVal);
    }

    /**
     * Metodo que transforma SBinary a SInt
     *
     * @return SInt
     */

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

    /**
     * Metodo que transforma SBinary a SBinary
     *
     * @return SInt
     */

    @Override
    public SBinary intoSBinary() {
        return new SBinary(getTipoInfo());
    }

    //Algoritmo para pasar binario positivo a entero
    private SInt positiveBinToInt(String logical) {
        int w = 0;
        for (int i = logical.length() - 1, j = 0; i > 0; i--, j++) {
            w += (int) Math.pow(2, j) * bitToInt(logical.charAt(i));
        }
        return new SInt(w);
    }

    //Algoritmo para pasar binario negativo a entero
    private SInt negativeBinaryToInt(String logical) {
        int n = logical.length() - 1;
        int w = -bitToInt(logical.charAt(0)) * (int) Math.pow(2, n);
        for (int i = n, j = 0; i > 0; i--, j++) {
            w += (int) Math.pow(2, j) * (logical.charAt(i) == '1' ? 1 : 0);
        }
        return new SInt(w);
    }


    /**
     * Dos binarios son iguales si su conversion a entero es igual
     */
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof SBinary) {
            SBinary sBinary = (SBinary) o;
            if ((this.intoSInt().getTipoInfo()) == sBinary.intoSInt().getTipoInfo()) {
                return true;
            }
        }

        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(SBinary.class);
    }

    @Override
    public String toString() {
        return "Binary{" +
                "numero='" + getTipoInfo() + '\'' +
                '}';
    }


    @Override
    public INumberandStrings Suma(IUnion number) {
        return ((INumber) number).SumaSBinary(this);
    }


    @Override
    public SString SumaSString(SString number) {
        return new SString(number.getTipoInfo() + this.getTipoInfo());
    }


    /**
     * @param number SInt a ser sumado con un SBinary
     * @return SInt que representa la suma entre number y SBinary
     */

    @Override
    public SInt SumaSInt(SInt number) {
        SInt int1 = (this.intoSInt());
        int result = int1.getTipoInfo();
        return new SInt(result + number.getTipoInfo());
    }

    /**
     * @param number SFloat a ser sumado con un SBinary
     * @return SFloat que representa la suma entre number y Sfloat
     */

    @Override
    public SFloat SumaSFloat(SFloat number) {
        int result = (this.intoSInt().getTipoInfo());
        return new SFloat(result + number.getTipoInfo());
    }

    /**
     * @param number SFloat a ser sumado con un SBinary
     * @return SFloat que representa la suma entre number y Sfloat
     */

    @Override
    public SBinary SumaSBinary(SBinary number) {
        SInt Int1 = number.intoSInt();
        SInt Int2 = this.intoSInt();
        SInt Int3 = (SInt) Int1.Suma(Int2);
        SBinary Binary = Int3.intoSBinary();
        return Binary;
    }


    @Override
    public IRealNumbers Resta(IRealNumbers number) {

        return ((INumber) number).RestaSBinary(this);
    }

    /**
     * @param number SInt a ser restado con un SBinary
     * @return SInt que representa la resta entre number y SBinary
     */
    @Override
    public SInt RestaSInt(SInt number) {
        SInt logicaltoint = this.intoSInt();
        return new SInt(number.getTipoInfo() - logicaltoint.getTipoInfo());
    }

    @Override
    public SFloat RestaSFloat(SFloat number) {
        SInt logicaltofloat = this.intoSInt();
        return new SFloat(number.getTipoInfo() - logicaltofloat.getTipoInfo());
    }

    /**
     * @param number SBinary a ser restado con un SBinary
     * @return SBinary que representa la resta entre number con un SBinary
     */

    @Override
    public SBinary RestaSBinary(SBinary number) {
        SInt Int1 = number.intoSInt();
        SInt Int2 = this.intoSInt();
        SInt Int3 = new SInt(Int1.getTipoInfo() - Int2.getTipoInfo());
        SBinary result = Int3.intoSBinary();
        return result;
    }

    @Override
    public IRealNumbers Mult(IRealNumbers number) {
        return ((INumber) number).MultBinary(this);
    }

    /**
     * @param number SInt a ser multiplicado con un SBinary
     * @return SInt que representa la multiplicacion entre number con un SBinary
     */

    @Override
    public SInt MultInt(SInt number) {
        SInt Int1 = this.intoSInt();
        return new SInt(number.getTipoInfo() * Int1.getTipoInfo());
    }

    /**
     * @param number SFloat a ser multiplicado con un SBinary
     * @return SFloat que representa la multiplicacion entre number con un SBinary
     */

    @Override
    public SFloat MultFloat(SFloat number) {
        SInt Int1 = this.intoSInt();
        return new SFloat(number.getTipoInfo() * Int1.getTipoInfo());
    }

    /**
     * @param number SBinary a ser multiplicado con un SBinary
     * @return SBinary que representa la multiplicado entre number con un SBinary
     */

    @Override
    public SBinary MultBinary(SBinary number) {
        SInt Int1 = number.intoSInt();
        SInt Int2 = this.intoSInt();
        SInt Int3 = new SInt(Int1.getTipoInfo() * Int2.getTipoInfo());
        return Int3.intoSBinary();
    }

    @Override
    public IRealNumbers Div(IRealNumbers number) {
        return ((INumber) number).DivBinary(this);
    }

    /**
     * @param number SInt a ser dividido con un SBinary
     * @return SInt que representa la division entre number con un SBinary
     */

    @Override
    public SInt DivInt(SInt number) {
        SInt Int1 = this.intoSInt();
        return new SInt(number.getTipoInfo() / Int1.getTipoInfo());
    }

    /**
     * @param number SFloat a ser dividido con un SBinary
     * @return SFloat que representa la division entre number con un SBinary
     */

    @Override
    public SFloat DivFloat(SFloat number) {
        SInt Int1 = this.intoSInt();
        return new SFloat(number.getTipoInfo() / Int1.getTipoInfo());
    }

    /**
     * @param number SBinary a ser dividido con un SBinary
     * @return SBinary que representa la division entre number con SBinary
     */
    @Override
    public SBinary DivBinary(SBinary number) {
        SInt Int1 = number.intoSInt();
        SInt Int2 = this.intoSInt();
        SInt Int3 = new SInt(Int1.getTipoInfo() / Int2.getTipoInfo());
        return Int3.intoSBinary();
    }


    @Override
    public ILogical and(ILogical logical) {
        return logical.andSBinary(this);
    }

    /**
     * @param logical que va a hacer la operacion AND con un SBinary
     * @return SBinary que representa la conjuncion entre logical y SBinary
     */
    @Override
    public SBinary andSBool(SBool logical) {
        String binario = this.getTipoInfo();
        int largo = binario.length();
        boolean truthvalue = logical.getTipoInfo();
        String s = "";
        int i = 0;
        if (truthvalue) {
            return new SBinary(binario);
        } else
            while (i < largo) {
                s = "0" + s;
                i++;
            }
        return new SBinary(s);

    }

    /**
     * @param logical que va a hacer la operacion AND con un SBinary (ambos strings deben ser del mismo tamaño)
     * @return SBinary que representa la conjuncion entre logical y SBinary
     */

    @Override
    public SBinary andSBinary(SBinary logical) {
        String binario = logical.getTipoInfo();
        String binario2 = this.getTipoInfo();


        String s = "";
        int i = 0;

        if (binario.length() > binario2.length()) {
            int contador = binario2.length();
            if (binario2.charAt(0) == '0') {
                while (binario.length() != contador) {
                    binario2 = "0" + binario2;
                    contador++;
                }
            } else {
                while (binario.length() != contador) {
                    binario2 = "1" + binario2;
                    contador++;
                }
            }
        } else if (binario.length() < binario2.length()) {
            int contador = binario.length();
            if (binario.charAt(0) == '0') {
                while (binario2.length() != contador) {
                    binario = "0" + binario;
                    contador++;
                }
            } else {
                while (binario2.length() != contador) {
                    binario = "1" + binario;
                    contador++;
                }
            }
        }
        if (binario.length() == binario2.length()) {
            while (i < binario.length()) {
                if (binario.charAt(i) == '1' && binario2.charAt(i) == '1') {
                    s = s + "1";
                } else {
                    s = s + "0";
                }
                i++;
            }
        }

        return new SBinary(s);
    }

    @Override
    public ILogical or(ILogical logical) {
        return logical.orSBinary(this);
    }

    /**
     * @param logical SBool que va a hacer la operacion OR con un SBool
     * @return SBinary que representa OR entre logical y SBool
     */
    @Override
    public SBinary orSBool(SBool logical) {
        String binario = this.getTipoInfo();
        int largo = binario.length();
        boolean truthvalue = logical.getTipoInfo();
        String s = "";
        if (!truthvalue) {
            return new SBinary(binario);
        }
        int i = 0;
        while (i < largo) {

            s = '1' + s;
            i++;
        }


        return new SBinary(s);
    }

    /**
     * @param logical SBinary que va a hacer la operacion OR con un SBinary (ambos strings deben ser del mismo tamaño)
     * @return ILogical que representa la operacion OR entre logical y SBinary
     */

    @Override
    public SBinary orSBinary(SBinary logical) {
        String binario = logical.getTipoInfo();
        String binario2 = this.getTipoInfo();
        int largo = Math.max(binario.length(), binario2.length());
        String s = "";
        int i = 0;

        if (binario.length() > binario2.length()) {
            int contador = binario2.length();
            if (binario2.charAt(0) == '0') {
                while (binario.length() != contador) {
                    binario2 = "0" + binario2;
                    contador++;
                }
            } else {
                while (binario.length() != contador) {
                    binario2 = "1" + binario2;
                    contador++;
                }
            }
        } else if (binario.length() < binario2.length()) {
            int contador = binario.length();
            if (binario.charAt(0) == '0') {
                while (binario2.length() != contador) {
                    binario = "0" + binario;
                    contador++;
                }
            } else {
                while (binario2.length() != contador) {
                    binario = "1" + binario;
                    contador++;
                }
            }
        }

        if (binario.length() == binario2.length()) {
            while (i < largo) {
                if (binario.charAt(i) == '1' || binario2.charAt(i) == '1') {
                    s = s + "1";
                } else {
                    s = s + "0";
                }
                i++;
            }
        }
        return new SBinary(s);
    }

    /**
     * @return SBinary que representa la negacion de un SBinary(this)
     */

    @Override
    public SBinary negacion() {
        String binario = this.getTipoInfo();
        int largo = binario.length();
        String s = "";
        int i = 0;
        while (i < largo) {
            if (binario.charAt(i) == '1') {
                s = s + "0";
            } else {
                s = s + "1";
            }
            i++;
        }
        return new SBinary(s);
    }


}
