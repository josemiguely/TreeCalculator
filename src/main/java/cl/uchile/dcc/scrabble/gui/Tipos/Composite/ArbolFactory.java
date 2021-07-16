package cl.uchile.dcc.scrabble.gui.Tipos.Composite;

import cl.uchile.dcc.scrabble.gui.Tipos.Composite.Element.Element;
import cl.uchile.dcc.scrabble.gui.Tipos.Composite.InterfazOperadores.Operador;
import cl.uchile.dcc.scrabble.gui.Tipos.Composite.OperadoresBinarios.*;
import cl.uchile.dcc.scrabble.gui.Tipos.Composite.OperadoresToTipo.*;
import cl.uchile.dcc.scrabble.gui.Tipos.Composite.OperadoresUnarios.Negacion;
import cl.uchile.dcc.scrabble.gui.Tipos.InterfacesOperaciones.IUnion;

/**
 * Fabrica de ArbolAST. Usa el patron Composite de Operador para definir los nodos internos y hojas.
 * Se asumio que el usuario debe crear correctamente el arbol.
 */

public class ArbolFactory {


    //SECCION ADD

    /**
     * Suma Operador con cualquier Operador
     *
     * @param operador  operando de la izquierda (en forma de operacion)
     * @param operador2 operando de la derecha (en forma de operacion)
     * @return Operador
     */

    public Operador Add(Operador operador, Operador operador2) {
        return new Add(operador, operador2);
    }

    /**
     * Suma de un SType(SInt,SFloat,SBool,SString,SBinary,) con cualquier Operador
     *
     * @param SType
     * @param operador (en forma de operacion)
     * @return Operador
     */
    public Operador Add(IUnion SType, Operador operador) {
        return new Add(new Element(SType), operador);
    }

    /**
     * Suma de un Operador con un SType(SInt,SFloat,SBool,SString,SBinary)
     *
     * @param operador operando de la izquierda (en forma de operacion)
     * @param SType    operando de la derecha
     * @return Operador
     */
    public Operador Add(Operador operador, IUnion SType) {
        return new Add(operador, new Element(SType));
    }

    /**
     * Suma entre un SType(SInt,SFloat,SBool,SString,SBinary) con otro SType
     *
     * @param operador  operando de la izquierda
     * @param operador2 operando de la derecha
     * @return Operador
     */

    public Operador Add(IUnion operador, IUnion operador2) {
        return new Add(new Element(operador), new Element(operador2));
    }


    //SECCION SUB

    /**
     * Resta Operador con cualquier Operador
     *
     * @param operador  operando de la izquierda (en forma de operacion)
     * @param operador2 operando de la derecha (en forma de operacion)
     * @return Operador
     */

    public Operador Sub(Operador operador, Operador operador2) {
        return new Sub(operador, operador2);
    }

    /**
     * Resta de un SType(SInt,SFloat,SBool,SString,SBinary,) con cualquier Operador
     *
     * @param SType
     * @param operador (en forma de operacion)
     * @return Operador
     */
    public Operador Sub(IUnion SType, Operador operador) {
        return new Sub(new Element(SType), operador);
    }

    /**
     * Resta de un Operador con un SType(SInt,SFloat,SBool,SString,SBinary)
     *
     * @param operador operando de la izquierda (en forma de operacion)
     * @param SType    operando de la derecha
     * @return Operador
     */
    public Operador Sub(Operador operador, IUnion SType) {
        return new Sub(operador, new Element(SType));
    }

    /**
     * Resta entre un SType(SInt,SFloat,SBool,SString,SBinary) con otro SType
     *
     * @param operador  operando de la izquierda
     * @param operador2 operando de la derecha
     * @return Operador
     */

    public Operador Sub(IUnion operador, IUnion operador2) {
        return new Sub(new Element(operador), new Element(operador2));
    }


    //SECCION MULT

    /**
     * Multiplicacion Operador con cualquier Operador
     *
     * @param operador  operando de la izquierda (en forma de operacion)
     * @param operador2 operando de la derecha (en forma de operacion)
     * @return Operador
     */

    public Operador Mult(Operador operador, Operador operador2) {
        return new Mult(operador, operador2);
    }

    /**
     * Multiplicacion de un SType(SInt,SFloat,SBool,SString,SBinary,) con cualquier Operador
     *
     * @param SType
     * @param operador (en forma de operacion)
     * @return Operador
     */
    public Operador Mult(IUnion SType, Operador operador) {
        return new Mult(new Element(SType), operador);
    }

    /**
     * Multiplicacion de un Operador con un SType(SInt,SFloat,SBool,SString,SBinary)
     *
     * @param operador operando de la izquierda (en forma de operacion)
     * @param SType    operando de la derecha
     * @return Operador
     */
    public Operador Mult(Operador operador, IUnion SType) {
        return new Mult(operador, new Element(SType));
    }

    /**
     * Multiplicacion entre un SType(SInt,SFloat,SBool,SString,SBinary) con otro SType
     *
     * @param operador  operando de la izquierda
     * @param operador2 operando de la derecha
     * @return Operador
     */

    public Operador Mult(IUnion operador, IUnion operador2) {
        return new Mult(new Element(operador), new Element(operador2));
    }


    //SECCION DIV

    /**
     * Division Operador con cualquier Operador
     *
     * @param operador  operando de la izquierda (en forma de operacion)
     * @param operador2 operando de la derecha (en forma de operacion)
     * @return Operador
     */

    public Operador Div(Operador operador, Operador operador2) {
        return new Div(operador, operador2);
    }

    /**
     * Division de un SType(SInt,SFloat,SBool,SString,SBinary,) con cualquier Operador
     *
     * @param SType
     * @param operador (en forma de operacion)
     * @return Operador
     */
    public Operador Div(IUnion SType, Operador operador) {
        return new Div(new Element(SType), operador);
    }

    /**
     * Division de un Operador con un SType(SInt,SFloat,SBool,SString,SBinary)
     *
     * @param operador operando de la izquierda (en forma de operacion)
     * @param SType    operando de la derecha
     * @return Operador
     */
    public Operador Div(Operador operador, IUnion SType) {
        return new Div(operador, new Element(SType));
    }

    /**
     * Division entre un SType(SInt,SFloat,SBool,SString,SBinary) con otro SType
     *
     * @param SType     operando de la izquierda
     * @param operador2 operando de la derecha
     * @return Operador
     */

    public Operador Div(IUnion SType, IUnion operador2) {
        return new Div(new Element(SType), new Element(operador2));
    }


    //SECCION TO BINARY

    /**
     * Transforma un Operador a un Operador Binary
     *
     * @param operador (en forma de operacion)
     * @return operador transformado a uno que contiene un SBinary
     */

    public Operador ToBinary(Operador operador) {
        return new ToBinary(operador);
    }

    /**
     * Transforma un SType a un Operador Binary
     *
     * @param SType
     * @return SType transformado a un operador que contiene un SBinary
     */

    public Operador ToBinary(IUnion SType) {
        return new ToBinary(new Element(SType));
    }

    //SECCION TO Float

    /**
     * Transforma un Operador a un Operador Float
     *
     * @param operador (en forma de operacion)
     * @return operador transformado a uno que contiene un SFloat
     */

    public Operador ToFloat(Operador operador) {
        return new ToFloat(operador);
    }

    /**
     * Transforma un SType a un Operador Float
     *
     * @param SType
     * @return SType transformado a un operador que contiene un SFloat
     */

    public Operador ToFloat(IUnion SType) {
        return new ToFloat(new Element(SType));
    }

    //SECCION TO Int

    /**
     * Transforma un Operador a un Operador Int
     *
     * @param operador (en forma de operacion)
     * @return operador transformado a uno que contiene un SInt
     */

    public Operador ToInt(Operador operador) {
        return new ToInt(operador);
    }

    /**
     * Transforma un SType a un Operador Int
     *
     * @param SType
     * @return SType transformado a un operador que contiene un SInt
     */

    public Operador ToInt(IUnion SType) {
        return new ToInt(new Element(SType));
    }

    //SECCION TO Bool

    /**
     * Transforma un Operador a un Operador Booleano
     *
     * @param operador (en forma de operacion)
     * @return operador transformado a uno que contiene un SBool
     */

    public Operador ToBool(Operador operador) {
        return new ToBool(operador);
    }

    /**
     * Transforma un SType a un Operador Booleano
     *
     * @param SType
     * @return SType transformado a un operador que contiene un SBool
     */

    public Operador ToBool(IUnion SType) {
        return new ToBool(new Element(SType));
    }


    //SECCION TO String

    /**
     * Transforma un Operador a un Operador String
     *
     * @param operador (en forma de operacion)
     * @return operador transformado a uno que contiene un SString
     */

    public Operador ToString(Operador operador) {
        return new ToString(operador);
    }

    /**
     * Transforma un SType a un Operador String
     *
     * @param SType
     * @return SType transformado a un operador que contiene un SString
     */

    public Operador ToString(IUnion SType) {
        return new ToString(new Element(SType));
    }


    //SECCION Negacion

    /**
     * Niega un Operador
     *
     * @param operador (en forma de operacion)
     * @return operador transformado a uno que contiene la misma informacion pero negada
     */

    public Operador Negacion(Operador operador) {
        return new Negacion(operador);
    }

    /**
     * Niega un SType y lo convierte a un Operador
     *
     * @param SType
     * @return SType transformado a un operador que contiene el SType negado
     */

    public Operador Negacion(IUnion SType) {
        return new Negacion(new Element(SType));
    }


    //SECCION AND

    /**
     * Y logico Operador con cualquier Operador
     *
     * @param operador  operando de la izquierda (en forma de operacion)
     * @param operador2 operando de la derecha (en forma de operacion)
     * @return Operador
     */

    public Operador And(Operador operador, Operador operador2) {
        return new And(operador, operador2);
    }

    /**
     * Y logico de un SType(SInt,SFloat,SBool,SString,SBinary,) con cualquier Operador
     *
     * @param SType
     * @param operador (en forma de operacion)
     * @return Operador
     */
    public Operador And(IUnion SType, Operador operador) {
        return new And(new Element(SType), operador);
    }

    /**
     * Y logico de un Operador con un SType(SInt,SFloat,SBool,SString,SBinary)
     *
     * @param operador operando de la izquierda (en forma de operacion)
     * @param SType    operando de la derecha
     * @return Operador
     */
    public Operador And(Operador operador, IUnion SType) {
        return new And(operador, new Element(SType));
    }

    /**
     * Y logico entre un SType(SInt,SFloat,SBool,SString,SBinary) con otro SType
     *
     * @param SType     operando de la izquierda
     * @param operador2 operando de la derecha
     * @return Operador
     */

    public Operador And(IUnion SType, IUnion operador2) {
        return new And(new Element(SType), new Element(operador2));
    }


    //SECCION OR

    /**
     * O logico Operador con cualquier Operador
     *
     * @param operador  operando de la izquierda (en forma de operacion)
     * @param operador2 operando de la derecha (en forma de operacion)
     * @return Operador
     */

    public Operador Or(Operador operador, Operador operador2) {
        return new Or(operador, operador2);
    }

    /**
     * O logico de un SType(SInt,SFloat,SBool,SString,SBinary,) con cualquier Operador
     *
     * @param SType
     * @param operador (en forma de operacion)
     * @return Operador
     */
    public Operador Or(IUnion SType, Operador operador) {
        return new Or(new Element(SType), operador);
    }

    /**
     * O logico de un Operador con un SType(SInt,SFloat,SBool,SString,SBinary)
     *
     * @param operador operando de la izquierda (en forma de operacion)
     * @param SType    operando de la derecha
     * @return Operador
     */
    public Operador Or(Operador operador, IUnion SType) {
        return new Or(operador, new Element(SType));
    }

    /**
     * O logico entre un SType(SInt,SFloat,SBool,SString,SBinary) con otro SType
     *
     * @param SType     operando de la izquierda
     * @param operador2 operando de la derecha
     * @return Operador
     */

    public Operador Or(IUnion SType, IUnion operador2) {
        return new Or(new Element(SType), new Element(operador2));
    }


}
