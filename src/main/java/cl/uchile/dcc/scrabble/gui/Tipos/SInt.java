package cl.uchile.dcc.scrabble.gui.Tipos;

import java.util.Objects;

public class SInt implements ITypes,INumber{

    private int numero;

    public SInt(int numero){
        this.numero=numero;
    }

    public int getTipoInfo() {
        return numero;
    }

    /**
     * Metodo que transforma  SInt a  SString
     *
     * @return SString
     */

    public SString intoSString(){

        return new SString(String.valueOf(this.getTipoInfo()));
    }

    @Override
    public SBool intoSBool() {
        return null;
    }

    /**
     * Metodo que transforma SInt a  SFloat
     *
     * @return Sfloat
     */
    @Override
    public SFloat intoSFloat(){

        return new SFloat((double)getTipoInfo());
    }

    @Override
    public SInt intoSInt() {
        return new SInt(getTipoInfo());
    }

    @Override
    public SBinary intoSBinary() {
        int absolute = Math.abs(this.numero);
        String b=positiveIntToBinary(absolute);
        if (this.numero<0){
            b=TwosComplement(b);
        }
        return new SBinary(b);
    }


    public String positiveIntToBinary(int numero){
        String s = "";
        while (numero > 0)
        {
            s = s+( (numero % 2 ) == 0 ? "0" : "1");
            numero = numero / 2;
        }
        return s;
    }

    public String TwosComplement(String str){
        StringBuffer string=new StringBuffer(str);
        int n = string.length();

        // Traverse the string to get first '1' from
        // the last of string
        int i;
        for (i = n-1 ; i >= 0 ; i--)
            if (string.charAt(i) == '1')
                break;

        // If there exists no '1' concat 1 at the
        // starting of string
        if (i == -1)
            return str+"1";

        // Continue traversal after the position of
        // first '1'
        for (int k = i-1 ; k >= 0; k--)
        {
            //Just flip the values
            if (str.charAt(k) == '1')
                string.replace(k, k+1, "0");
            else
                string.replace(k, k+1, "1");
        }

        // return the modified string
        return string.toString();
    }

    @Override
    public INumber Suma(INumber number){
        return number.SumaSInt(this);
    }


    @Override
    public SInt SumaSInt(SInt numero){
        int number=this.getTipoInfo()+ numero.getTipoInfo();
        SInt ResultSuma= new SInt(number);
        return ResultSuma;
    }

    @Override
    public SFloat SumaSFloat(SFloat numero){
        double number=this.getTipoInfo()+ numero.getTipoInfo();
        return new SFloat(number);
    }

    @Override
    public SBinary SumaSBinary(SBinary binarystr){
        SBinary intotobinary = this.intoSBinary();
        String result=addBinary(intotobinary.getTipoInfo(),binarystr.getTipoInfo());

        return new SBinary(result);
    }


    static String addBinary(String a, String b)
    {

        // Initialize result
        String result = "";

        // Initialize digit sum
        int s = 0;

        // Traverse both strings starting
        // from last characters
        int i = a.length() - 1, j = b.length() - 1;
        while (i >= 0 || j >= 0 || s == 1)
        {

            // Comput sum of last
            // digits and carry
            s += ((i >= 0)? a.charAt(i) - '0': 0);
            s += ((j >= 0)? b.charAt(j) - '0': 0);

            // If current digit sum is
            // 1 or 3, add 1 to result
            result = (char)(s % 2 + '0') + result;

            // Compute carry
            s /= 2;

            // Move to next digits
            i--; j--;
        }

        return result;
    }
    @Override
    public INumber Resta(INumber number) {
        return number.RestaSInt(this);
    }

    public SInt RestaSInt(SInt numero){
        int number=this.getTipoInfo()-numero.getTipoInfo();
        return new SInt(number);
    }

    @Override
    public SFloat RestaSFloat(SFloat number) {
        return new SFloat(number.getTipoInfo()-this.getTipoInfo());
    }

    @Override
    public INumber RestaSBinary(SBinary number) {
        SInt Int1=number.intoSInt();

        return null;
    }

    @Override
    public INumber Mult(INumber number) {
        return number.MultInt(this);
    }

    @Override
    public INumber MultInt(SInt number) {
        return new SInt(this.getTipoInfo()* number.getTipoInfo());
    }

    @Override
    public INumber MultFloat(SFloat number) {
        return new SFloat(number.getTipoInfo()*this.getTipoInfo());
    }

    @Override
    public INumber MultBinary(SBinary number) {
        SInt Int1= number.intoSInt();
        SInt Res=new SInt(Int1.getTipoInfo()*this.getTipoInfo());
        SBinary ResToBin=Res.intoSBinary();
        return ResToBin;
    }

    @Override
    public INumber Div(INumber number) {
        return number.DivInt(this);
    }

    @Override
    public INumber DivInt(SInt number) {
        return new SInt(number.getTipoInfo()/this.getTipoInfo());
    }

    @Override
    public INumber DivFloat(SFloat number) {
        return new SFloat(number.getTipoInfo()/this.getTipoInfo());
    }

    @Override
    public INumber DivBinary(SBinary number) {
        SInt Int1=number.intoSInt();
        SInt Result=(SInt) Int1.Div(this);
        SBinary ResultBinary=Result.intoSBinary();
        return ResultBinary;
    }

    @Override
    public String toString() {
        return "Int{" +
                "numero=" + getTipoInfo() +
                '}';
    }

    /**
     *Revisa si dos objetos representan el mismo SInt
     *
     * @param o Objeto que se quiere comparar
     * @return Verdadero si representan el mismo SInt, Falso cualquier otro caso
     */


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SInt sInt = (SInt) o;
        return getTipoInfo() == sInt.getTipoInfo();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTipoInfo());
    }

}
