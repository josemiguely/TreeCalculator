package gui.Tipos.ClasesSTypes;

import cl.uchile.dcc.scrabble.gui.Tipos.ClasesSTypes.*;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class STypeFactoryTest {

    //SSInt
    private int numero = new Random().nextInt();
    private int numerodiff = numero + 1;
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

    //SString
    private String palabra;
    private SString sString;
    private SString sStringcopia;
    private SString sString2;

    //Float
    private double seeddouble;
    private SFloat sFloat;
    private SFloat sFloatcopia;
    private SFloat sFloat2;

    //Bool

    private SBool sBool;
    private SBool sBool2;
    private SBool sBoolcopia;


    @BeforeEach
    void setUp() {
        STypeFactory.getSIntcache().clear();
        STypeFactory.getSBinarycache().clear();
        STypeFactory.getSFloatcache().clear();
        STypeFactory.getSBoolcache().clear();
        STypeFactory.getSStringcache().clear();


        //SInt setup
        sInt = STypeFactory.getSInt(numero);
        sIntcopia = STypeFactory.getSInt(numero);
        sInt2 = STypeFactory.getSInt(numerodiff);


        //SBinary setup
        seed = new Random().nextInt(20) + 1;
        rng = new Random(seed);
        int strSize = rng.nextInt(seed) + 1; //+1 para que nunca sea 0 el strSize
        string1 = RandomStringUtils.random(strSize, "01");
        String diffstring = string1 + "101";
        sBinary = STypeFactory.getSBinary(string1);
        sBinarycopia = STypeFactory.getSBinary(string1);
        sBinary2 = STypeFactory.getSBinary(diffstring);

        //SString setup
        palabra = RandomStringUtils.random(strSize, 0, 0, true, true, null, rng);
        String diffpalabra = palabra + "101";
        sString = STypeFactory.getSString(palabra);
        sStringcopia = STypeFactory.getSString(palabra);
        sString2 = STypeFactory.getSString(diffpalabra);


        //SFloat setup
        seeddouble = new Random().nextDouble();
        double diffdouble = seeddouble + 1;
        sFloat = STypeFactory.getSFloat(seeddouble);
        sFloatcopia = STypeFactory.getSFloat(seeddouble);
        sFloat2 = STypeFactory.getSFloat(diffdouble);

        //SBool setup

        boolean seedboolean = new Random().nextBoolean();
        boolean diifbolean = !seedboolean;
        sBool = STypeFactory.getSBool(seedboolean);
        sBoolcopia = STypeFactory.getSBool(seedboolean);
        sBool2 = STypeFactory.getSBool(diifbolean);
    }

    @RepeatedTest(20)
    void constructorTest() {

        //SIntcache test


        assertEquals(sInt, sIntcopia);//Contienen la misma informacion
        assertTrue(sInt == sIntcopia);//verificamos que son realmente el mismo objeto
        assertTrue(STypeFactory.getSIntcache().size() == 2);
        assertNotEquals(sInt, sInt2);


        //SBinarycache test


        assertEquals(sBinary, sBinarycopia);//Contienen la misma informacion
        assertTrue(sBinary == sBinarycopia);//verificamos que son realmente el mismo objeto
        assertTrue(STypeFactory.getSBinarycache().size() == 2);
        assertNotEquals(sBinary, sBinary2);

        //SStringcache test


        assertEquals(sString, sStringcopia);//Contienen la misma informacion
        assertTrue(sString == sStringcopia);//verificamos que son realmente el mismo objeto
        assertTrue(STypeFactory.getSStringcache().size() == 2);
        assertNotEquals(sString, sString2);

        //SFloatcache test


        assertEquals(sFloat, sFloatcopia); //Contienen la misma informacion
        assertTrue(sFloat == sFloatcopia); //verificamos que son realmente el mismo objeto
        assertTrue(STypeFactory.getSFloatcache().size() == 2);
        assertNotEquals(sFloat, sFloat2);

        //SBoolcache test


        assertEquals(sBool, sBoolcopia);//Contienen la misma informacion
        assertTrue(sBool == sBoolcopia);//verificamos que son realmente el mismo objeto
        assertTrue(STypeFactory.getSBoolcache().size() == 2);
        assertNotEquals(sBool, sBool2);


        STypeFactory.getSIntcache().clear();
        STypeFactory.getSBinarycache().clear();
        STypeFactory.getSFloatcache().clear();
        STypeFactory.getSBoolcache().clear();
        STypeFactory.getSStringcache().clear();


        //Chekear que se vacian correctamente
        assertTrue(STypeFactory.getSIntcache().size() == 0);
        assertTrue(STypeFactory.getSFloatcache().size() == 0);
        assertTrue(STypeFactory.getSStringcache().size() == 0);
        assertTrue(STypeFactory.getSBoolcache().size() == 0);
        assertTrue(STypeFactory.getSBinarycache().size() == 0);

        //Chekear que se guardan 20 SInt en el cache (los demas tienen la misma implementacion por lo que es analogo)
        for (int i = 0; i < 20; i++) {
            STypeFactory.getSInt(i);
            assertTrue(STypeFactory.getSIntcache().size() == i + 1);
        }

        //Chekear que se reutilizan los mismo 20 SInt en el cache (los demas tienen la misma implementacion por lo que es analogo)
        for (int i = 0; i < 20; i++) {
            STypeFactory.getSInt(i);
            assertTrue(STypeFactory.getSIntcache().size() == 20);
        }

    }


}