package gui.ClasesSTypesTests;

import cl.uchile.dcc.scrabble.gui.Tipos.ClasesSTypes.*;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class SBinaryTest {
    private SBinary binary1;
    private SBinary binary2;
    private SBinary binarydiff;
    private String string1;
    private int seed;
    private Random rng;

    private String binarioprueba="10000001"; //-127
    private String binarioprueba2="111111111";//-1
    private String binarioprueba3="0111011001110001";//30321
    private String binarioprueba4="0";


    @BeforeEach
    void setUp() {
        seed = new Random().nextInt(20) + 1;
        rng = new Random(seed);
        int strSize = rng.nextInt(seed) +1; //para que nunca sea 0 el strSize
        string1 = RandomStringUtils.random(strSize, "01");
        String diffpalabra = string1 + "101";
        binary1 = new SBinary(string1);
        binary2 = new SBinary(string1);
        binarydiff= new SBinary(diffpalabra);
    }

    @RepeatedTest(20)
    void constructorTest() {
        assertEquals(binary1.hashCode(), binary2.hashCode());
        assertEquals(binary1, binary2);
        assertTrue (binary1.toString().equals(binary1.toString()));
        assertNotEquals(binarydiff,binary1);

        SInt int1=new SInt(22);

        assertFalse(binary1.equals(int1));

    }

    @RepeatedTest(20)
    void intoSString() {
        SString expected = binary1.intoSString();
        SString actual = new SString(binary1.getTipoInfo());

        assertEquals(expected, actual);
    }

    @RepeatedTest(20)
    void intoSBinaryTest() {
        SBinary expected = binary1.intoSBinary();
        SBinary actual = binary1;

        assertEquals(expected, actual);
    }


    @Test()
    void intoSFloatTest() {
        SBinary binfloat = new SBinary("0011111111010000000000000000000000000000000000000000000000000000");
        SFloat actual = binfloat.intoSFloat();
        SFloat expected= new SFloat(0.25);
        assertEquals(expected,actual);

        SBinary binfloat2=new SBinary("0");
        SFloat actual2=binfloat2.intoSFloat();
        SFloat expected2=new SFloat(0);
        assertEquals(expected2,actual2);


        SBinary binfloat3=new SBinary("1100000001000101001101011100001010001111010111000010100011110110");
        SFloat actual3=binfloat3.intoSFloat();
        SFloat expected3=new SFloat(-42.42);
        assertEquals(expected3,actual3);

        SBinary binfloat4=new SBinary("0100000000010000000000000000000000000000000000000000000000000000");
        SFloat actual4=binfloat4.intoSFloat();
        SFloat expected4=new SFloat(4);
        assertEquals(expected4,actual4);

    }

    @Test
    void intoSIntTest() {

        SBinary binary5 = new SBinary(binarioprueba);
        SBinary binary6 = new SBinary(binarioprueba2);
        SBinary binary7= new SBinary(binarioprueba3);
        SBinary binary8=new SBinary(binarioprueba4);

        SInt expected = new SInt(-127);
        SInt actual = binary5.intoSInt();
        assertEquals(expected, actual);

        SInt expected2 = new SInt(-1);
        SInt actual2 = binary6.intoSInt();

        assertEquals(expected2,actual2);

        SInt expected3 = new SInt(30321);
        SInt actual3 = binary7.intoSInt();

        assertEquals(expected3,actual3);

        SInt expected4=new SInt(0);
        SInt actual4=binary8.intoSInt();

        assertEquals(expected4,actual4);
    }

    @Test()
    void Suma() {

        //Suma de Binary numeros positivos
        SBinary binarysum1 = new SBinary("0111");//7
        SBinary binarysum2 = new SBinary("0101");//5

        SBinary expected = new SBinary("01100");//12
        SBinary actual = (SBinary) binarysum1.Suma(binarysum2);//7+5
        SBinary actualconmutativo = (SBinary) binarysum2.Suma(binarysum1);//5+7

        assertEquals(expected, actual);//7+5=12
        assertEquals(expected,actualconmutativo);//5+7=12

        SBinary binarysum3= new SBinary("0");//0

        SBinary expected3=new SBinary("0111");//7
        SBinary actual3=(SBinary) binarysum1.Suma(binarysum3);//7+0
        SBinary actual3conmutativo=(SBinary) binarysum3.Suma(binarysum1);//7+0

        assertEquals(expected3,actual3);//7+0=7
        assertEquals(expected3,actual3conmutativo);//0+7=7

        SBinary expected4=binarysum3;//0
        SBinary actual4= (SBinary) binarysum3.Suma(binarysum3);//0+0


        assertEquals(expected4,actual4);//0+0=0

        //Suma de Binary numeros negativos
        SBinary binarysum4 = new SBinary("1000");//-8
        SBinary binarysum5 = new SBinary("0101");//5


        SBinary expected5= new SBinary("101");//-3
        SBinary actual5= (SBinary)binarysum4.Suma(binarysum5);//-8+5
        SBinary actual5conmutativo= (SBinary) binarysum5.Suma(binarysum4);//5+-8
        assertEquals(expected5,actual5);//-8+5=-3
        assertEquals(expected5,actual5conmutativo);//5-8=-3

        SBinary binarysum6 = new SBinary("01001");//9
        SBinary expected6=new SBinary("01");//1
        SBinary actual6=(SBinary) binarysum6.Suma(binarysum4);//9+-8
        SBinary actual6conmutativo=(SBinary) binarysum4.Suma(binarysum6);//-8+9
        assertEquals(expected6,actual6);//9+-8=1
        assertEquals(expected6,actual6conmutativo);//-8+9=1

        SBinary expected7=new SBinary("110000");//-16
        SBinary actual7=(SBinary) binarysum4.Suma(binarysum4);//-8+-8
        assertEquals(expected7,actual7);//-8+-8=-16


        //Suma de Binary con SInt

        SInt int1 = new SInt(5);
        SInt int2= new SInt(-8);

        SBinary actual8 = (SBinary) binarysum1.Suma(int1);
        assertEquals(expected, actual8);

        SBinary actual9=(SBinary) binarysum5.Suma(int2);
        assertEquals(expected5,actual9);

        SBinary actual10=(SBinary) binarysum4.Suma(int2);
        assertEquals(expected7,actual10);



    }

    @Test
    void Resta() {
        //Resta de SBinary positivos

        SBinary binaryresta1 = new SBinary("0101");//5
        SBinary binaryresta2 = new SBinary("001");//1


        SBinary actual = (SBinary) binaryresta1.Resta(binaryresta2);
        SBinary expected = new SBinary("0100");
        assertEquals(expected, actual);

        SBinary actual2=(SBinary) binaryresta2.Resta(binaryresta1);
        SBinary expected2= new SBinary("1100");
        assertEquals(expected2,actual2);//1-5=-4

        SBinary actual3=(SBinary) binaryresta1.Resta(binaryresta1);
        SBinary expected3=new SBinary("0");
        assertEquals(expected3,actual3);

        //Resta de SBinary negativos

        SBinary binaryresta3=new SBinary("1100");//-4
        SBinary binaryresta4 = new SBinary("11101");//-3

        SBinary actual4=(SBinary) binaryresta4.Resta(binaryresta3);
        SBinary expected4= new SBinary("01");//1
        assertEquals(expected4,actual4);

        SBinary actual5=(SBinary) binaryresta3.Resta(binaryresta4);
        SBinary expected5= new SBinary("11");//-1
        assertEquals(expected5,actual5);//

        SBinary actual6=(SBinary) binaryresta3.Resta(binaryresta3);
        assertEquals(expected3,actual6);//3-3=0

        //Resta SBinary con SInt

        SInt int1 = new SInt(1);
        SBinary actual7 = (SBinary) binaryresta1.Resta(int1);
        assertEquals(expected, actual7);//5-1=4

        SInt int2=new SInt(5);
        SBinary actual8=(SBinary) binaryresta2.Resta(int2);
        assertEquals(expected2,actual8);//1-5=-4

        SBinary actual10=(SBinary) binaryresta1.Resta(int2);
        assertEquals(expected3,actual10);//5-5=0

        SInt int3=new SInt(-3);
        SBinary actual11=(SBinary) binaryresta3.Resta(int3);
        assertEquals(expected5,actual11);//-4-(-3)=-1

    }


    @Test
    void MultTest() {

        //SBinary con SBinary positivos

        SBinary binarymult1 = new SBinary("0111");//7
        SBinary binarymult2 = new SBinary("011");//3


        SBinary actualmult = (SBinary) binarymult1.Mult(binarymult2);//7*3
        SBinary actualmultconmu = (SBinary) binarymult2.Mult(binarymult1);//3*7
        SBinary expected = new SBinary("010101");//21

        assertEquals(expected, actualmult);//7*3=21
        assertEquals(expected, actualmultconmu);//3*7=21

        //SBinary con SBinary negativos

        SBinary binarymultneg = new SBinary("1001");//-7
        SBinary binarymultneg2 = new SBinary("1101");//-3

        SBinary actualmult2=(SBinary) binarymultneg.Mult(binarymultneg2);//-7*-3
        SBinary actualmult2conm=(SBinary) binarymultneg2.Mult(binarymultneg);//-3*-7

        assertEquals(expected,actualmult2);//-7*-3=21
        assertEquals(expected,actualmult2conm);//-3*-7=21

        //SBinary con SBinary positivo y negativo

        SBinary actualmult3=(SBinary)binarymult1.Mult(binarymultneg);//7*-7
        SBinary actualmult3conmu=(SBinary)binarymultneg.Mult(binarymult1);//-7*7
        SBinary expected3=new SBinary("1001111");//-49

        assertEquals(expected3,actualmult3);//7 * -7= -49
        assertEquals(expected3,actualmult3conmu);//7 * -7= -49


        //SBinary con SInt
        SInt int1 = new SInt(3);
        SBinary actualmultint = (SBinary) binarymult1.Mult(int1);//7*3

        assertEquals(expected, actualmultint);//7*3=21

        SInt int2= new SInt(-7);
        SBinary actualmultint2= (SBinary) binarymult1.Mult(int2);//7*-7
        assertEquals(expected3,actualmultint2);//7*7=-49

        SInt int3=new SInt(0);
        SBinary actualmultint3= (SBinary) binarymult2.Mult(int3);//3*0
        SBinary expected0=new SBinary("0");//0
        assertEquals(expected0,actualmultint3);//3*0=0



    }

    @Test
    void DivTest() {
        //Div de SBinary con SBinary
        SBinary binarydiv1 = new SBinary("01110");//14
        SBinary binarydiv2 = new SBinary("0111");//7

        SBinary actual = (SBinary) binarydiv1.Div(binarydiv2);//14:7
        SBinary expected = new SBinary("010");//2

        assertEquals(expected, actual);//14:7=2

        SBinary binarydiv3 = new SBinary("1001");//-7

        SBinary actual2=(SBinary) binarydiv1.Div(binarydiv3);//14:-7
        SBinary expected2=new SBinary("110");//-2 (tambien se puede escribir como 10)
        assertEquals(expected2,actual2);//14:-7=-2

        SBinary binarydiv4=new SBinary("10010");//-14
        SBinary  actual3=(SBinary) binarydiv4.Div(binarydiv3);//-14:-7
        assertEquals(expected,actual3);//-14:-7=2


        //Div de SBinary con SInt
        SInt int1 = new SInt(7);//7
        SBinary actual4 = (SBinary) binarydiv1.Div(int1);//14:7
        assertEquals(expected, actual4);//14:7=2

        SInt int2=new SInt(-7);//-7
        SBinary actual5=(SBinary) binarydiv1.Div(int2);//14:-7
        assertEquals(expected2,actual5);//14:-7=-2

        SBinary actual6=(SBinary) binarydiv4.Div(int2);// -14:-7
        assertEquals(expected,actual6);





    }
    @Test
    void andTest(){
        //and de SBinary con SBinary
        SBinary binary1 = new SBinary("1111010");
        SBinary binary2 = new SBinary("1010010");
        SBinary actual=(SBinary) binary1.and(binary2);
        SBinary expected=new SBinary("1010010");

        assertEquals(expected,actual);

        //and de SBinary con SBool

        SBool boolv=new SBool(true);
        SBool boolf=new SBool(false);

        SBinary actual2=(SBinary) binary1.and(boolv);
        SBinary expected2=new SBinary("1111010");
        assertEquals(expected2,actual2);

        SBinary actual3=(SBinary) binary2.and(boolf);
        SBinary expected3=new SBinary("0000000");
        assertEquals(expected3,actual3);
    }

    @Test
    void orTest(){
        //or de SBinary con SBinary
        SBinary binary1 = new SBinary("1111010");
        SBinary binary2 = new SBinary("1010010");
        SBinary actual=(SBinary) binary1.or(binary2);
        SBinary expected=new SBinary("1111010");

        assertEquals(expected,actual);

        //or de SBinary con SBool

        SBool boolv=new SBool(true);
        SBool boolf=new SBool(false);

        SBinary actual2=(SBinary) binary1.or(boolv);
        SBinary expected2=new SBinary("1111111");
        assertEquals(expected2,actual2);

        SBinary actual3=(SBinary) binary2.or(boolf);
        SBinary expected3=new SBinary("1010010");
        assertEquals(expected3,actual3);

    }

    @Test()
    void negacionTest(){
        SBinary binary1 = new SBinary("1111010");
        SBinary binary2 = new SBinary("1010010");

        SBinary actual=binary1.negacion();
        SBinary expected=new SBinary("0000101");
        assertEquals(expected,actual);

        SBinary actual2=binary2.negacion();
        SBinary expected2=new SBinary("0101101");
        assertEquals(expected2,actual2);

    }


}