package cl.uchile.dcc.scrabble.gui;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


class SBoolTest {
    private SBool truthvalue1;
    private SBool truthvalue2;


    @BeforeEach
    void setUp(){
        truthvalue1=new SBool(true);
        truthvalue2=new SBool(true);
    }

    @Test
    void constructorTest(){
        assertEquals(truthvalue1.hashCode(),truthvalue2.hashCode());
        assertEquals(truthvalue1,truthvalue2);
        assert(truthvalue1.toString().equals(truthvalue2.toString()));

        SBool differenttruthvalue=new SBool(false);
        assertNotEquals(truthvalue1,differenttruthvalue);
    }

    @Test
    void IntoSStringTest(){
        String bolstring=truthvalue1.intoSString();
        SString expectedSString=new SString(bolstring);
        SString string=new SString("true");
        assertEquals(expectedSString,string);
    }
    @Test
    void IntoSBoolTest(){
        boolean bool= truthvalue1.intoSSbool();
        SBool expectedSBool= new SBool(bool);
        assertEquals(expectedSBool,truthvalue2);
    }


}