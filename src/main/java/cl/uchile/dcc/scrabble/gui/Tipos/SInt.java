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



    public SString intoSString(){

        return new SString(String.valueOf(this.getTipoInfo()));
    }

    @Override
    public SBool intoSBool() {
        return null;
    }


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
            s = ( (numero % 2 ) == 0 ? "0" : "1")+s;
            numero = numero / 2;
        }
        return "0"+s;
    }


    public String TwosComplement(String str){
        StringBuffer string=new StringBuffer(str);
        int n = string.length();

        int i;
        for (i = n-1 ; i >= 0 ; i--)
            if (string.charAt(i) == '1')
                break;

        if (i == -1)
            return str+"1";

        for (int k = i-1 ; k >= 0; k--)
        {
            //Just flip the values
            if (str.charAt(k) == '1')
                string.replace(k, k+1, "0");
            else
                string.replace(k, k+1, "1");
        }

        return string.toString();
    }

    @Override
    public INumberandStrings Suma(INumberandStrings number) {
        return ((IRealNumbers) number).SumaSInt(this);
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
        SInt Int1= binarystr.intoSInt();
        SInt Int2=Int1.SumaSInt(this);
        return Int2.intoSBinary();
    }



    @Override
    public IRealNumbers Resta(IRealNumbers number) {
        return number.RestaSInt(this);
    }

    public SInt RestaSInt(SInt numero){
        int number=numero.getTipoInfo()-this.getTipoInfo();
        return new SInt(number);
    }

    @Override
    public SFloat RestaSFloat(SFloat number) {
        return new SFloat(number.getTipoInfo()-this.getTipoInfo());
    }

    @Override
    public INumber RestaSBinary(SBinary number) {
        SInt Int1=number.intoSInt();
        SInt result= new SInt(Int1.getTipoInfo()-this.getTipoInfo());
        return result.intoSBinary();
    }

    @Override
    public IRealNumbers Mult(IRealNumbers number) {
        return number.MultInt(this);
    }

    @Override
    public INumber MultInt(SInt number) {
        return new SInt(this.getTipoInfo()* number.getTipoInfo());
    }

    @Override
    public IRealNumbers MultFloat(SFloat number) {
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
    public IRealNumbers Div(IRealNumbers number) {
        return number.DivInt(this);
    }

    @Override
    public IRealNumbers DivInt(SInt number) {
        return new SInt(number.getTipoInfo()/this.getTipoInfo());
    }

    @Override
    public IRealNumbers DivFloat(SFloat number) {
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
