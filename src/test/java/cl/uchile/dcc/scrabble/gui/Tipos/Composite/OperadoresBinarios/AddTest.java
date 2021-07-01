package cl.uchile.dcc.scrabble.gui.Tipos.Composite.OperadoresBinarios;

import cl.uchile.dcc.scrabble.gui.Tipos.ClasesSTypes.*;
import cl.uchile.dcc.scrabble.gui.Tipos.Composite.ArbolFactory;
import cl.uchile.dcc.scrabble.gui.Tipos.Composite.InterfazOperadores.*;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class AddTest {
    public ArbolFactory arbolfact;

    //SSInt
    private int numero = new Random().nextInt();
    private int numerodiff = numero+1;
    private int seed;
    private Random rng;
    private SInt sInt;
    private SInt sIntcopia;
    private SInt sInt2;

    //SBinary
    private SBinary sBinary;
    private SBinary sBinarycopia;
    private SBinary sBinary2;
    private String string1;
    private String diffstring;
    private int sBinaryInt;
    private int sBinary2Int;

    //SString
    private String palabra;
    private String diffpalabra;
    private SString sString;
    private SString sStringcopia;
    private SString sString2;

    //Float
    private double seeddouble;
    private double diffdouble;
    private SFloat sFloat;
    private SFloat sFloatcopia;
    private SFloat sFloat2;

    //Bool

    private SBool sBool;
    private SBool sBool2;
    private SBool sBoolcopia;

    @BeforeEach
    void setUp() {
        arbolfact=new ArbolFactory();

        //SInt setup
        sInt=STypeFactory.getSInt(numero);
        sIntcopia=STypeFactory.getSInt(numero);
        sInt2=STypeFactory.getSInt(numerodiff);


        //SBinary setup
        seed = new Random().nextInt(20) + 1;
        rng = new Random(seed);
        int strSize = rng.nextInt(seed) +1; //+1 para que nunca sea 0 el strSize
        string1 = RandomStringUtils.random(strSize, "01");
        diffstring = string1 + "101";
        sBinary = STypeFactory.getSBinary(string1);
        sBinarycopia = STypeFactory.getSBinary(string1);
        sBinary2= STypeFactory.getSBinary(diffstring);

        //tranformando la info aleatoria de los Sbinary a enteros
        //sBinaryInt=new SBinary(new SInt(sBinary.intoSInt().getTipoInfo())).getTipoInfo();
        //sBinary2Int=new SBinary(new SInt(sBinary2.intoSInt().getTipoInfo())).getTipoInfo();

        //SString setup
        palabra= RandomStringUtils.random(strSize,0,0,true,true,null,rng);
        diffpalabra = palabra + "101";
        sString=STypeFactory.getSString(palabra);
        sStringcopia=STypeFactory.getSString(palabra);
        sString2=STypeFactory.getSString(diffpalabra);


        //SFloat setup
        seeddouble=new Random().nextDouble();
        diffdouble=seeddouble+1;
        sFloat=STypeFactory.getSFloat(seeddouble);
        sFloatcopia=STypeFactory.getSFloat(seeddouble);
        sFloat2=STypeFactory.getSFloat(diffdouble);

        //SBool setup

        boolean seedboolean = new Random().nextBoolean();
        boolean diifbolean = !seedboolean;
        sBool=STypeFactory.getSBool(seedboolean);
        sBoolcopia=STypeFactory.getSBool(seedboolean);
        sBool2=STypeFactory.getSBool(diifbolean);

    }

    /*
    Se testean todas las combinaciones del constructor Add(,)
     */
    @RepeatedTest(10)
    void constructorTest(){
        arbolfact=new ArbolFactory();


        OperadorInt operadorInt=arbolfact.Add(sInt,sInt2);
        OperadorInt operadorIntcopia=arbolfact.Add(sInt2,sInt);
        SInt expectedInt=new SInt(numero+numerodiff);


        assertEquals(operadorInt,operadorIntcopia);
        assertEquals(expectedInt,operadorInt.resultado());

        OperadorFloat operadorIntMasFloat=arbolfact.Add(sInt,sFloat);
        OperadorFloat operadorIntMasFloatcopia=arbolfact.Add(sFloat,sInt);
        SFloat expectedintmasfloat=new SFloat(numero+seeddouble);


        assertEquals(operadorIntMasFloat,operadorIntMasFloatcopia);
        assertEquals(expectedintmasfloat,operadorIntMasFloat.resultado());

        OperadorFloat operadorIntMasOpFloat=arbolfact.Add(sInt,operadorIntMasFloat);
        SFloat expectedoperadorIntMasOpFloat=new SFloat(numero+(numero+seeddouble));

        assertEquals(expectedoperadorIntMasOpFloat,operadorIntMasOpFloat.resultado());

        OperadorBinary operadorBinary=arbolfact.Add(sBinary,sBinary2);
        OperadorBinary operadorBinarycopia=arbolfact.Add(sBinary2,sBinary);
        assertEquals(operadorBinary,operadorBinarycopia);

        OperadorInt operadorIntmasBinario=arbolfact.Add(operadorInt,operadorBinary);
        SInt expectedintmasbinario=new SInt(numero+numerodiff+sBinary.intoSInt().getTipoInfo()+sBinary2.intoSInt().getTipoInfo());

        assertEquals(operadorIntmasBinario.resultado(),expectedintmasbinario);

        OperadorInt operadorintbin=arbolfact.Add(sInt,operadorBinary);  //AQUI ESTABA
        
        //arbolfact.ToBinary()
        //SInt expectedopintbin=new SInt(numero+operadorBinary.To)




        OperadorFloat operadorFloat=arbolfact.Add(operadorInt,sFloat);
        OperadorFloat operadorFloatcopia=arbolfact.Add(sFloatcopia,operadorIntcopia);

        int n=numero+numerodiff;
        SFloat expectedFloat=new SFloat(n+seeddouble);

        assertEquals(operadorFloat,operadorFloatcopia);
        assertEquals(expectedFloat,operadorFloatcopia.resultado());
        assertNotEquals(operadorFloat,operadorInt);

        OperadorFloat operadorFloat4=arbolfact.Add(operadorFloat,operadorInt);


        SFloat expec5=new SFloat(n+seeddouble+n);
        assertEquals(expec5,operadorFloat4.resultado());





        OperadorString operadorString=arbolfact.Add(sString,sFloat);
        SString expected=new SString(palabra+seeddouble);
        assertEquals(operadorString.resultado(),expected);

        OperadorString operadorString2=arbolfact.Add(operadorString,sString);
        SString expected2=new SString(palabra+seeddouble+palabra);

        assertEquals(expected2,operadorString2.resultado());

        OperadorString operadorString3=arbolfact.Add(sString2,operadorString2);
        String exp=diffpalabra+palabra+seeddouble+palabra;
        SString expected3=new SString(exp);
        assertEquals(expected3,operadorString3.resultado());

        OperadorString operadorString4=arbolfact.Add(operadorString3,operadorString3);
        SString expected4=new SString(exp+exp);
        assertEquals(expected4,operadorString4.resultado());

        OperadorFloat operadorFloat3=arbolfact.Add(sFloat2,sBinary);
        SFloat expectedfloat=new SFloat(diffdouble+sBinary.intoSInt().getTipoInfo());
        assertEquals(expectedfloat,operadorFloat3.resultado());











    }



    @Test
    void eval(){
        arbolfact=new ArbolFactory();
        //Ejemplo de las instrucciones

        OperadorInt sub1=arbolfact.Sub(STypeFactory.getSInt(25), STypeFactory.getSBinary("0101"));

        OperadorBinary binary=arbolfact.ToBinary(sub1);

        OperadorBinary or1=arbolfact.Or(STypeFactory.getSBinary("1000"),binary);

        OperadorFloat addfinal=arbolfact.Add(STypeFactory.getSFloat(6.9),or1);

        SFloat floatexpected=STypeFactory.getSFloat(2.9000000000000004);
        assertEquals(floatexpected,addfinal.resultado());


    }


}