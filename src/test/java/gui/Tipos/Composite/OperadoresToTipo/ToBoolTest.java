package gui.Tipos.Composite.OperadoresToTipo;

import cl.uchile.dcc.scrabble.gui.Tipos.ClasesSTypes.SBool;
import cl.uchile.dcc.scrabble.gui.Tipos.ClasesSTypes.STypeFactory;
import cl.uchile.dcc.scrabble.gui.Tipos.Composite.ArbolFactory;
import cl.uchile.dcc.scrabble.gui.Tipos.Composite.InterfazOperadores.Operador;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class ToBoolTest {


    private ArbolFactory arbolfact;


    //Bool

    private SBool sBool;
    private SBool sBool2;


    @BeforeEach
    void setUp() {

        arbolfact = new ArbolFactory();


        //SBool setup
        sBool = STypeFactory.getSBool(true);
        sBool2 = STypeFactory.getSBool(false);
    }

    @RepeatedTest(20)
    void constructorTest() {

        //2do constructor
        Operador constructor2v = arbolfact.ToBool(sBool);
        Operador constructor2f = arbolfact.ToBool(sBool2);

        SBool expectedsBool2v = STypeFactory.getSBool(true);
        SBool expectedsBool2f = STypeFactory.getSBool(false);

        assertEquals(sBool, constructor2v.resultado());
        assertEquals(expectedsBool2v, constructor2v.resultado());
        assertNotEquals(constructor2v, constructor2f);

        assertEquals(sBool2, constructor2f.resultado());
        assertEquals(expectedsBool2f, constructor2f.resultado());

        //1er constructor


        Operador constructor1v = arbolfact.ToBool(constructor2v);
        Operador constructor1f = arbolfact.ToBool(constructor2f);

        assertEquals(sBool, constructor1v.resultado());
        assertEquals(expectedsBool2v, constructor1v.resultado());
        assertNotEquals(constructor1v, constructor1f);

        assertEquals(sBool2, constructor1f.resultado());
        assertEquals(expectedsBool2f, constructor1f.resultado());


    }

}