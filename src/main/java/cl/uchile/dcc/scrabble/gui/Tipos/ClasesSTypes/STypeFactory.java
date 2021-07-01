package cl.uchile.dcc.scrabble.gui.Tipos.ClasesSTypes;

import cl.uchile.dcc.scrabble.gui.Tipos.InterfacesOperaciones.IUnion;

import java.util.HashMap;


public class STypeFactory {
    private static HashMap<Integer, SInt> SIntcache=new HashMap<>();
    private static HashMap<Double, SFloat> SFloatcache=new HashMap<>();
    private static HashMap<String, SString> SStringcache=new HashMap<>();
    private static HashMap<String, SBinary> SBinarycache=new HashMap<>();
    private static HashMap<Boolean, SBool> SBoolcache=new HashMap<>();

    public static SInt getSInt(int number){
        int key=number;
        if(getSIntcache().containsKey(key)){
            return getSIntcache().get(key);
        }
        else{
         SInt sint=new SInt(number);
         getSIntcache().put(number,sint);
         return sint;
        }
    }

    public static SFloat getSFloat(double number){
        double key=number;
        if(getSFloatcache().containsKey(key)){
            return getSFloatcache().get(key);
        }
        else{
            SFloat sfloat=new SFloat(number);
            getSFloatcache().put(number,sfloat);
            return sfloat;
        }

    }

    public static SString getSString(String string){
        String key=string;
        if(getSStringcache().containsKey(key)){
            return getSStringcache().get(key);
        }
        else{
            SString sstring=new SString(string);
            getSStringcache().put(key,sstring);
            return sstring;
        }

    }

    public static SBinary getSBinary(String binary){
        String key=binary;
        if(getSBinarycache().containsKey(key)){
            return getSBinarycache().get(key);
        }
        else{
            SBinary sbinary=new SBinary(binary);
            getSBinarycache().put(key,sbinary);
            return sbinary;
        }

    }
    public static SBool getSBool(boolean bool){
        boolean key=bool;
        if(getSBoolcache().containsKey(key)){
            return getSBoolcache().get(key);
        }
        else{
            SBool sbool=new SBool(key);
            getSBoolcache().put(key,sbool);
            return sbool;
        }

    }

    public static HashMap<Integer, SInt> getSIntcache() {
        return SIntcache;
    }

    public static HashMap<Double, SFloat> getSFloatcache() {
        return SFloatcache;
    }

    public static HashMap<String, SString> getSStringcache() {
        return SStringcache;
    }

    public static HashMap<String, SBinary> getSBinarycache() {
        return SBinarycache;
    }

    public static HashMap<Boolean, SBool> getSBoolcache() {
        return SBoolcache;
    }
}
