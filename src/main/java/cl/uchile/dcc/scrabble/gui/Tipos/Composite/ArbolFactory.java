package cl.uchile.dcc.scrabble.gui.Tipos.Composite;

import cl.uchile.dcc.scrabble.gui.Tipos.ClasesSTypes.*;
import cl.uchile.dcc.scrabble.gui.Tipos.Composite.Element.*;
import cl.uchile.dcc.scrabble.gui.Tipos.Composite.InterfazOperadores.*;
import cl.uchile.dcc.scrabble.gui.Tipos.Composite.OperadoresBinarios.*;
import cl.uchile.dcc.scrabble.gui.Tipos.Composite.OperadoresToTipo.ToBinary;
import cl.uchile.dcc.scrabble.gui.Tipos.Composite.OperadoresToTipo.ToBool;
import cl.uchile.dcc.scrabble.gui.Tipos.Composite.OperadoresToTipo.ToFloat;
import cl.uchile.dcc.scrabble.gui.Tipos.Composite.OperadoresToTipo.ToInt;
import cl.uchile.dcc.scrabble.gui.Tipos.Composite.OperadoresUnarios.Negacion;
import cl.uchile.dcc.scrabble.gui.Tipos.Composite.InterfazOperadores.OperadorInt;
import cl.uchile.dcc.scrabble.gui.Tipos.InterfacesOperaciones.ILogical;
import cl.uchile.dcc.scrabble.gui.Tipos.InterfacesOperaciones.INumber;
import cl.uchile.dcc.scrabble.gui.Tipos.InterfacesOperaciones.IRealNumbers;
import cl.uchile.dcc.scrabble.gui.Tipos.InterfacesOperaciones.IUnion;

public class ArbolFactory {

    //SECCION ADD





    /**
     * Suma SString con cualquier SType
     * @param String1 operando de la izquierda
     * @param SType operando de la derecha
     * @return OperadorString (Operacion que resulta en un String)
     */

    public OperadorString Add(SString String1, IUnion SType){
        return new Add(new Element(String1),new Element(SType));
    }

    /**
     * Suma SString con cualquier Operador
     * @param String1 operando de la izquierda
     * @param operador operando de la derecha (en forma de operacion)
     * @return OperadorString (Operacion que resulta en un String)
     */
    public OperadorString Add(SString String1, Operador operador){
        return new Add(new Element(String1),operador);
    }

    /**
     * Suma OperadorString(Operador que resulta en String) con cualquier Operador
     * @param operador1 operando de la izquierda (en forma de operacion)
     * @param operador2 operando de la derecha (en forma de operacion)
     * @return OperadorString (Operacion que resulta en un String)
     */
    public OperadorString Add(OperadorString operador1,Operador operador2){
        return new Add(operador1,operador2);
    }


    /**
     * Suma entre un SFloat y cualquier SType del tipo IRealNumbers(SInt,SFloat,SBinary)
     * @param Float1     operando a la izquierda
     * @param RealNumber operando a la derecha (SInt,SFloat,SBinary)
     * @return OperadorFloat (Operacion que resulta ser un Float)
     */
    public OperadorFloat Add(SFloat Float1, IRealNumbers RealNumber) {
        return new Add(new Element(Float1),new Element(RealNumber));
    }



    /**
     * Suma entre un SFloat y un OperadorFloatIntBinario(operacion que al ser evaluada resulte Float,Int,Binario)
     * @param Float1   operando a la izquierda
     * @param operador operando a la derecha (en forma de operacion)
     * @return OperadorFloat (Operacion que resulta ser un Float)
     */

    public OperadorFloat Add(SFloat Float1, OperadoresFloatIntBinario operador) {
        return new Add(new Element(Float1),operador);
    }

    

    /**
     * Suma entre un OperadorFloat y un OperadorFloatIntBinario(operacion que al ser evaluada resulte Float,Int,Binario)
     * @param operador1  operando a la izquierda (en forma de operacion)
     * @param operador2 operando a la derecha (en forma de operacion)
     * @return OperadorFloat (Operacion que resulta ser un Float)
     */

    public OperadorFloat Add(OperadorFloat operador1, OperadoresFloatIntBinario operador2) {
        return new Add(operador1,operador2);


    }
    /**
     * Suma SInt con SFloat
     * @param Int1 operando de la izquierda
     * @param Float1 operando de la derecha
     * @return OperadorFloat (Operacion que resulta ser un Float)
     */

    public OperadorFloat Add(SInt Int1, SFloat Float1){
        return new Add(new Element(Int1),new Element(Float1));
    }


    /**
     * Suma SInt y cualquier SType del tipo INumbers(SInt,SBinary)
     * @param Int1 operando de la izquierda
     * @param Number operando de la derecha
     * @return OperadorInt (Operacion que resulta ser un Int)
     */

    public OperadorInt Add(SInt Int1, INumber Number){
        return new Add(new Element(Int1),new Element(Number));
    }

    /**
     * Suma SInt y un OperadorFloat
     * @param Int1 operando de la izquierda
     * @param operador operando de la derecha (en forma de operacion)
     * @return OperadorFloat (Operacion que resulta ser un Float)
     */

    public OperadorFloat Add(SInt Int1, OperadorFloat operador){
        return new Add(new Element(Int1),operador);
    }

    /**
     * Suma SInt y un OperadorIntBinario(operacion que al ser evaluada result en Int o Binario)
     * @param Int1 operando de la izquierda
     * @param operador operando de la derecha (en forma de operacion)
     * @return OperadorInt (Operacion que resulta ser un Int)
     */

    public OperadorInt Add(SInt Int1, OperadorIntBinario operador){
        return new Add(new Element(Int1),operador);
    }



    /**
     * Suma SBinary y cualquier SType del tipo INumbers(SInt,SBinary)
     * @param Binary1 operando de la izquierda
     * @param Number operando de la derecha
     * @return OperadorBinary (Operacion que resulta ser un Binary)
     */

    public OperadorBinary Add(SBinary Binary1, INumber Number){
        return new Add(new Element(Binary1),new Element(Number));
    }


    /**
     * Suma SBinary y un OperadorIntBinario(operacion que al ser evaluada result en Int o Binario)
     * @param Binary1 operando de la izquierda
     * @param operador operando de la derecha (en forma de operacion)
     * @return OperadorBinary (Operacion que resulta ser un Binary)
     */

    public OperadorBinary Add(SBinary Binary1, OperadorIntBinario operador){
        return new Add(new Element(Binary1),operador);
    }


    /**
     * Suma entre OperadorBinary y un OperadorIntBinario(operacion que al ser evaluada result en Int o Binario)
     * @param operador1 operando de la izquierda
     * @param operador2 operando de la derecha (en forma de operacion)
     * @return OperadorBinary (Operacion que resulta ser un Binary)
     */

    public OperadorInt Add(OperadorBinary operador1, OperadorIntBinario operador2){
        return new Add(operador1,operador2);
    }


















    //SECCION SUB



    /**
     * Resta entre un SFloat y cualquier SType del tipo IRealNumbers(SInt,SFloat,SBinary)
     * @param Float1     operando a la izquierda
     * @param RealNumber operando a la derecha (SInt,SFloat,SBinary)
     * @return OperadorFloat (Operacion que resulta ser un Float)
     */
    public OperadorFloat Sub(SFloat Float1, IRealNumbers RealNumber) {
        return new Sub(new Element(Float1),new Element(RealNumber));
    }

    /**
     * Resta entre un SFloat y un OperadorFloatIntBinario(operacion que al ser evaluada resulte Float,Int,Binario)
     * @param Float1   operando a la izquierda
     * @param operador operando a la derecha (en forma de operacion)
     * @return OperadorFloat (Operacion que resulta ser un Float)
     */

    public OperadorFloat Sub(SFloat Float1, OperadoresFloatIntBinario operador) {
        return new Sub(new Element(Float1),operador);
    }

    /**
     * Resta entre un OperadorFloat y un OperadorFloatIntBinario(operacion que al ser evaluada resulte Float,Int,Binario)
     * @param operador1  operando a la izquierda (en forma de operacion)
     * @param operador2 operando a la derecha (en forma de operacion)
     * @return OperadorFloat (Operacion que resulta ser un Float)
     */

    public OperadorFloat Sub(OperadorFloat operador1, OperadoresFloatIntBinario operador2) {
        return new Sub(operador1,operador2);


    }
    /**
     * Resta SInt con SFloat
     * @param Int1 operando de la izquierda
     * @param Float1 operando de la derecha
     * @return OperadorFloat (Operacion que resulta ser un Float)
     */

    public OperadorFloat Sub(SInt Int1, SFloat Float1){
        return new Sub(new Element(Int1),new Element(Float1));
    }


    /**
     * Resta SInt y cualquier SType del tipo INumbers(SInt,SBinary)
     * @param Int1 operando de la izquierda
     * @param Number operando de la derecha
     * @return OperadorInt (Operacion que resulta ser un Int)
     */

    public OperadorInt Sub(SInt Int1, INumber Number){
        return new Sub(new Element(Int1),new Element(Number));
    }

    /**
     * Resta SInt y un OperadorFloat
     * @param Int1 operando de la izquierda
     * @param operador operando de la derecha (en forma de operacion)
     * @return OperadorFloat (Operacion que resulta ser un Float)
     */

    public OperadorFloat Sub(SInt Int1, OperadorFloat operador){
        return new Sub(new Element(Int1),operador);
    }

    /**
     * Resta SInt y un OperadorIntBinario(operacion que al ser evaluada result en Int o Binario)
     * @param Int1 operando de la izquierda
     * @param operador operando de la derecha (en forma de operacion)
     * @return OperadorInt que contiene la Suma en Int
     */

    public OperadorInt Sub(SInt Int1, OperadorIntBinario operador){
        return new Sub(new Element(Int1),operador);
    }

    /**
     * Resta SBinary y cualquier SType del tipo INumbers(SInt,SBinary)
     * @param Binary1 operando de la izquierda
     * @param Number operando de la derecha
     * @return OperadorBinary (Operacion que resulta ser un Binary)
     */

    public OperadorBinary Sub(SBinary Binary1, INumber Number){
        return new Sub(new Element(Binary1),new Element(Number));
    }


    /**
     * Resta SBinary y un OperadorIntBinario(operacion que al ser evaluada result en Int o Binario)
     * @param Binary1 operando de la izquierda
     * @param operador operando de la derecha (en forma de operacion)
     * @return OperadorBinary (Operacion que resulta ser un Binary)
     */

    public OperadorBinary Sub(SBinary Binary1, OperadorIntBinario operador){
        return new Sub(new Element(Binary1),operador);
    }


    /**
     * Resta entre OperadorBinary y un OperadorIntBinario(operacion que al ser evaluada result en Int o Binario)
     * @param operador1 operando de la izquierda
     * @param operador2 operando de la derecha (en forma de operacion)
     * @return OperadorBinary (Operacion que resulta ser un Binary)
     */

    public OperadorInt Sub(OperadorBinary operador1, OperadorIntBinario operador2){
        return new Sub(operador1,operador2);
    }






    //SECCION MULT




    /**
     * Multiplicacion entre un SFloat y cualquier SType del tipo IRealNumbers(SInt,SFloat,SBinary)
     * @param Float1     operando a la izquierda
     * @param RealNumber operando a la derecha (SInt,SFloat,SBinary)
     * @return OperadorFloat (Operacion que resulta ser un Float)
     */
    public OperadorFloat Mult(SFloat Float1, IRealNumbers RealNumber) {
        return new Mult(new Element(Float1),new Element(RealNumber));
    }

    /**
     * Multiplicacion entre un SFloat y un OperadorFloatIntBinario(operacion que al ser evaluada resulte Float,Int,Binario)
     * @param Float1   operando a la izquierda
     * @param operador operando a la derecha (en forma de operacion)
     * @return OperadorFloat (Operacion que resulta ser un Float)
     */

    public OperadorFloat Mult(SFloat Float1, OperadoresFloatIntBinario operador) {
        return new Mult(new Element(Float1),operador);
    }

    /**
     * Multiplicacion entre un OperadorFloat y un OperadorFloatIntBinario(operacion que al ser evaluada resulte Float,Int,Binario)
     * @param operador1  operando a la izquierda (en forma de operacion)
     * @param operador2 operando a la derecha (en forma de operacion)
     * @return OperadorFloat (Operacion que resulta ser un Float)
     */

    public OperadorFloat Mult(OperadorFloat operador1, OperadoresFloatIntBinario operador2) {
        return new Mult(operador1,operador2);


    }
    /**
     * Multiplicacion SInt con SFloat
     * @param Int1 operando de la izquierda
     * @param Float1 operando de la derecha
     * @return OperadorFloat (Operacion que resulta ser un Float)
     */

    public OperadorFloat Mult(SInt Int1, SFloat Float1){
        return new Mult(new Element(Int1),new Element(Float1));
    }


    /**
     * Multiplicacion SInt y cualquier SType del tipo INumbers(SInt,SBinary)
     * @param Int1 operando de la izquierda
     * @param Number operando de la derecha
     * @return OperadorInt (Operacion que resulta ser un Int)
     */

    public OperadorInt Mult(SInt Int1, INumber Number){
        return new Mult(new Element(Int1),new Element(Number));
    }

    /**
     * Multiplicacion SInt y un OperadorFloat
     * @param Int1 operando de la izquierda
     * @param operador operando de la derecha (en forma de operacion)
     * @return OperadorFloat (Operacion que resulta ser un Float)
     */

    public OperadorFloat Mult(SInt Int1, OperadorFloat operador){
        return new Mult(new Element(Int1),operador);
    }

    /**
     * Multiplicacion SInt y un OperadorIntBinario(operacion que al ser evaluada result en Int o Binario)
     * @param Int1 operando de la izquierda
     * @param operador operando de la derecha (en forma de operacion)
     * @return OperadorInt que contiene la Suma en Int
     */

    public OperadorInt Mult(SInt Int1, OperadorIntBinario operador){
        return new Mult(new Element(Int1),operador);
    }

    /**
     * Multiplicacion SBinary y cualquier SType del tipo INumbers(SInt,SBinary)
     * @param Binary1 operando de la izquierda
     * @param Number operando de la derecha
     * @return OperadorBinary (Operacion que resulta ser un Binary)
     */

    public OperadorBinary Mult(SBinary Binary1, INumber Number){
        return new Mult(new Element(Binary1),new Element(Number));
    }


    /**
     * Multiplicacion SBinary y un OperadorIntBinario(operacion que al ser evaluada result en Int o Binario)
     * @param Binary1 operando de la izquierda
     * @param operador operando de la derecha (en forma de operacion)
     * @return OperadorBinary (Operacion que resulta ser un Binary)
     */

    public OperadorBinary Mult(SBinary Binary1, OperadorIntBinario operador){
        return new Mult(new Element(Binary1),operador);
    }


    /**
     * Multiplicacion entre OperadorBinary y un OperadorIntBinario(operacion que al ser evaluada result en Int o Binario)
     * @param operador1 operando de la izquierda
     * @param operador2 operando de la derecha (en forma de operacion)
     * @return OperadorBinary (Operacion que resulta ser un Binary)
     */

    public OperadorInt Mult(OperadorBinary operador1, OperadorIntBinario operador2){
        return new Mult(operador1,operador2);
    }


















    //SECCION DIV




    /**
     * Division entre un SFloat y cualquier SType del tipo IRealNumbers(SInt,SFloat,SBinary)
     * @param Float1     operando a la izquierda
     * @param RealNumber operando a la derecha (SInt,SFloat,SBinary)
     * @return OperadorFloat (Operacion que resulta ser un Float)
     */
    public OperadorFloat Div(SFloat Float1, IRealNumbers RealNumber) {
        return new Div(new Element(Float1),new Element(RealNumber));
    }

    /**
     * Division entre un SFloat y un OperadorFloatIntBinario(operacion que al ser evaluada resulte Float,Int,Binario)
     * @param Float1   operando a la izquierda
     * @param operador operando a la derecha (en forma de operacion)
     * @return OperadorFloat (Operacion que resulta ser un Float)
     */

    public OperadorFloat Div(SFloat Float1, OperadoresFloatIntBinario operador) {
        return new Div(new Element(Float1),operador);
    }

    /**
     * Division entre un OperadorFloat y un OperadorFloatIntBinario(operacion que al ser evaluada resulte Float,Int,Binario)
     * @param operador1  operando a la izquierda (en forma de operacion)
     * @param operador2 operando a la derecha (en forma de operacion)
     * @return OperadorFloat (Operacion que resulta ser un Float)
     */

    public OperadorFloat Div(OperadorFloat operador1, OperadoresFloatIntBinario operador2) {
        return new Div(operador1,operador2);


    }
    /**
     * Division SInt con SFloat
     * @param Int1 operando de la izquierda
     * @param Float1 operando de la derecha
     * @return OperadorFloat (Operacion que resulta ser un Float)
     */

    public OperadorFloat Div(SInt Int1, SFloat Float1){
        return new Div(new Element(Int1),new Element(Float1));
    }


    /**
     * Division SInt y cualquier SType del tipo INumbers(SInt,SBinary)
     * @param Int1 operando de la izquierda
     * @param Number operando de la derecha
     * @return OperadorInt (Operacion que resulta ser un Int)
     */

    public OperadorInt Div(SInt Int1, INumber Number){
        return new Div(new Element(Int1),new Element(Number));
    }

    /**
     * Division SInt y un OperadorFloat
     * @param Int1 operando de la izquierda
     * @param operador operando de la derecha (en forma de operacion)
     * @return OperadorFloat (Operacion que resulta ser un Float)
     */

    public OperadorFloat Div(SInt Int1, OperadorFloat operador){
        return new Div(new Element(Int1),operador);
    }

    /**
     * Division SInt y un OperadorIntBinario(operacion que al ser evaluada result en Int o Binario)
     * @param Int1 operando de la izquierda
     * @param operador operando de la derecha (en forma de operacion)
     * @return OperadorInt que contiene la Suma en Int
     */

    public OperadorInt Div(SInt Int1, OperadorIntBinario operador){
        return new Div(new Element(Int1),operador);
    }

    /**
     * Division SBinary y cualquier SType del tipo INumbers(SInt,SBinary)
     * @param Binary1 operando de la izquierda
     * @param Number operando de la derecha
     * @return OperadorBinary (Operacion que resulta ser un Binary)
     */

    public OperadorBinary Div(SBinary Binary1, INumber Number){
        return new Div(new Element(Binary1),new Element(Number));
    }


    /**
     * Division SBinary y un OperadorIntBinario(operacion que al ser evaluada result en Int o Binario)
     * @param Binary1 operando de la izquierda
     * @param operador operando de la derecha (en forma de operacion)
     * @return OperadorBinary (Operacion que resulta ser un Binary)
     */

    public OperadorBinary Div(SBinary Binary1, OperadorIntBinario operador){
        return new Div(new Element(Binary1),operador);
    }


    /**
     * Division entre OperadorBinary y un OperadorIntBinario(operacion que al ser evaluada result en Int o Binario)
     * @param operador1 operando de la izquierda
     * @param operador2 operando de la derecha (en forma de operacion)
     * @return OperadorBinary (Operacion que resulta ser un Binary)
     */

    public OperadorInt Div(OperadorBinary operador1, OperadorIntBinario operador2){
        return new Div(operador1,operador2);
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    //SECCION TO BINARY

    public OperadorBinary ToBinary(Operador operador){
        return new ToBinary(operador);
    }

    //SECCION TO Float

    public OperadorFloat ToFloat(Operador operador){
        return new ToFloat(operador);
    }

    //SECCION TO Int

    public OperadorInt ToInt(Operador operador){
        return new ToInt(operador);
    }

    //SECCION TO Bool

    public OperadorBool ToBool(Operador operador){
        return new ToBool(operador);
    }





    //SECCION Negacion

    public OperadorBool Negacion(OperadorBool operador){
        return new Negacion(operador);
    }

    public OperadorBinary Negacion(OperadorBinary operador){
        return new Negacion(operador);
    }

    public OperadorBinary Negacion(SBinary binario){
        return new Negacion(new Element(binario));
    }

    public OperadorBinary Negacion(SBool bool){
        return new Negacion(new Element(bool));
    }





    //SECCION AND




    /**
     * Y logico entre SBinary y cualquier SType del tipo ILogical(Binary,Bool)
     * @param Binary1 operando de la izquierda
     * @param Bool operando de la derecha
     * @return OperadorBinary (Operacion que resulta ser un Int)
     */

    public OperadorBinary And(SBinary Binary1, ILogical Bool){
        return new And(new Element(Binary1),new Element(Bool));
    }

    /**
     * Y logico entre SBinary y un OperadorLogical(operacion que al ser evaluada result en Binary,Bool)
     * @param Binary1 operando de la izquierda
     * @param operador operando de la derecha (en forma de operacion)
     * @return OperadorBinary (Operacion que resulta ser un Binary)
     */

    public OperadorBinary And(SBinary Binary1, OperadorLogical operador){
        return new And(new Element(Binary1),operador);
    }

    /**
     * Y logico entre OperadorBinary y un OperadorLogical(operacion que al ser evaluada result en Bool o Binario)
     * @param operador1 operando de la izquierda
     * @param operador2 operando de la derecha (en forma de operacion)
     * @return OperadorBinary (Operacion que resulta ser un Binary)
     */


    public OperadorBinary And(OperadorBinary operador1,OperadorLogical operador2){
        return new And(operador1,operador2);
    }

    /**
     * Y logico entre OperadorBinary y cualquier SType del tipo ILogical (Bool,Binario)
     * @param operador1 operando de la izquierda (en forma de operacion)
     * @param Logical operando de la derecha
     * @return OperadorBinary (Operacion que resulta ser un Binary)
     */


    public OperadorBinary And(OperadorBinary operador1,ILogical Logical){
        return new And(operador1,new Element(Logical));
    }

    
    /**
     * Y logico entre SBool y cualquier SType del tipo ILogical(Binary,Bool)
     * @param Binary1 operando de la izquierda
     * @param Bool operando de la derecha
     * @return OperadorBool (Operacion que resulta ser un Int)
     */

    public OperadorBool And(SBool Binary1, ILogical Bool){
        return new And(new Element(Binary1),new Element(Bool));
    }

    /**
     * Y logico entre SBool y un OperadorLogical(operacion que al ser evaluada result en Binary,Bool)
     * @param Binary1 operando de la izquierda
     * @param operador operando de la derecha (en forma de operacion)
     * @return OperadorBool (Operacion que resulta ser un Binary)
     */

    public OperadorBool And(SBool Binary1, OperadorLogical operador){
        return new And(new Element(Binary1),operador);
    }

    /**
     * Y logico entre OperadorBool y un OperadorLogical(operacion que al ser evaluada result en Bool o Binario)
     * @param operador1 operando de la izquierda
     * @param operador2 operando de la derecha (en forma de operacion)
     * @return OperadorBool (Operacion que resulta ser un Binary)
     */


    public OperadorBool And(OperadorBool operador1,OperadorLogical operador2){
        return new And(operador1,operador2);
    }

    /**
     * Y logico entre OperadorBool y cualquier SType del tipo ILogical (Bool,Binario)
     * @param operador1 operando de la izquierda (en forma de operacion)
     * @param Logical operando de la derecha
     * @return OperadorBool (Operacion que resulta ser un Binary)
     */


    public OperadorBool And(OperadorBool operador1,ILogical Logical){
        return new And(operador1,new Element(Logical));
    }
    
    









    //SECCION OR


    /**
     * Y logico entre SBinary y cualquier SType del tipo ILogical(Binary,Bool)
     * @param Binary1 operando de la izquierda
     * @param Bool operando de la derecha
     * @return OperadorBinary (Operacion que resulta ser un Int)
     */

    public OperadorBinary Or(SBinary Binary1, ILogical Bool){
        return new Or(new Element(Binary1),new Element(Bool));
    }

    /**
     * Y logico entre SBinary y un OperadorLogical(operacion que al ser evaluada result en Binary,Bool)
     * @param Binary1 operando de la izquierda
     * @param operador operando de la derecha (en forma de operacion)
     * @return OperadorBinary (Operacion que resulta ser un Binary)
     */

    public OperadorBinary Or(SBinary Binary1, OperadorLogical operador){
        return new Or(new Element(Binary1),operador);
    }

    /**
     * Y logico entre OperadorBinary y un OperadorLogical(operacion que al ser evaluada result en Bool o Binario)
     * @param operador1 operando de la izquierda
     * @param operador2 operando de la derecha (en forma de operacion)
     * @return OperadorBinary (Operacion que resulta ser un Binary)
     */


    public OperadorBinary Or(OperadorBinary operador1,OperadorLogical operador2){
        return new Or(operador1,operador2);
    }

    /**
     * Y logico entre OperadorBinary y cualquier SType del tipo ILogical (Bool,Binario)
     * @param operador1 operando de la izquierda (en forma de operacion)
     * @param Logical operando de la derecha
     * @return OperadorBinary (Operacion que resulta ser un Binary)
     */


    public OperadorBinary Or(OperadorBinary operador1,ILogical Logical){
        return new Or(operador1,new Element(Logical));
    }


    /**
     * Y logico entre SBool y cualquier SType del tipo ILogical(Binary,Bool)
     * @param Binary1 operando de la izquierda
     * @param Bool operando de la derecha
     * @return OperadorBool (Operacion que resulta ser un Int)
     */

    public OperadorBool Or(SBool Binary1, ILogical Bool){
        return new Or(new Element(Binary1),new Element(Bool));
    }

    /**
     * Y logico entre SBool y un OperadorLogical(operacion que al ser evaluada result en Binary,Bool)
     * @param Binary1 operando de la izquierda
     * @param operador operando de la derecha (en forma de operacion)
     * @return OperadorBool (Operacion que resulta ser un Binary)
     */

    public OperadorBool Or(SBool Binary1, OperadorLogical operador){
        return new Or(new Element(Binary1),operador);
    }

    /**
     * Y logico entre OperadorBool y un OperadorLogical(operacion que al ser evaluada result en Bool o Binario)
     * @param operador1 operando de la izquierda
     * @param operador2 operando de la derecha (en forma de operacion)
     * @return OperadorBool (Operacion que resulta ser un Binary)
     */


    public OperadorBool Or(OperadorBool operador1,OperadorLogical operador2){
        return new Or(operador1,operador2);
    }

    /**
     * Y logico entre OperadorBool y cualquier SType del tipo ILogical (Bool,Binario)
     * @param operador1 operando de la izquierda (en forma de operacion)
     * @param Logical operando de la derecha
     * @return OperadorBool (Operacion que resulta ser un Binary)
     */


    public OperadorBool Or(OperadorBool operador1,ILogical Logical){
        return new Or(operador1,new Element(Logical));
    }



   





}
