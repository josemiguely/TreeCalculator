package cl.uchile.dcc.scrabble.gui.Tipos.ClasesSTypes;

import java.util.HashMap;

/**
 * Fabrica de Flyweight
 */

public class STypeFactory {
    private static HashMap<Integer, SInt> SIntcache = new HashMap<>();
    private static HashMap<Double, SFloat> SFloatcache = new HashMap<>();
    private static HashMap<String, SString> SStringcache = new HashMap<>();
    private static HashMap<String, SBinary> SBinarycache = new HashMap<>();
    private static HashMap<Boolean, SBool> SBoolcache = new HashMap<>();

    /**
     * Crea un SInt que se guarda en SIntcache para poder ser reutilizado
     *
     * @param number entero que tendra el SInt que se quiere crear
     * @return SInt con informacion de number
     */

    public static SInt getSInt(int number) {
        int key = number;
        if (getSIntcache().containsKey(key)) {
            return getSIntcache().get(key);
        } else {
            SInt sint = new SInt(number);
            getSIntcache().put(number, sint);
            return sint;
        }
    }

    /**
     * Crea un SFloat que se guarda en SFloatcache para poder ser reutilizado
     *
     * @param number entero que tendra el SInt que se quiere crear
     * @return SFloat con informacion de number
     */

    public static SFloat getSFloat(double number) {
        double key = number;
        if (getSFloatcache().containsKey(key)) {
            return getSFloatcache().get(key);
        } else {
            SFloat sfloat = new SFloat(number);
            getSFloatcache().put(number, sfloat);
            return sfloat;
        }

    }

    /**
     * Crea un SString que se guarda en SStringcache para poder ser reutilizado
     *
     * @param string string que tendra el SString que se quiere crear
     * @return SString con informacion de string
     */

    public static SString getSString(String string) {
        String key = string;
        if (getSStringcache().containsKey(key)) {
            return getSStringcache().get(key);
        } else {
            SString sstring = new SString(string);
            getSStringcache().put(key, sstring);
            return sstring;
        }

    }

    /**
     * Crea un SBinary que se guarda en SBinarycache para poder ser reutilizado
     *
     * @param binary binario en forma de string que tendra el SBinary que se quiere crear
     * @return SBinary con informacion de binary
     */

    public static SBinary getSBinary(String binary) {
        String key = binary;
        if (getSBinarycache().containsKey(key)) {
            return getSBinarycache().get(key);
        } else {
            SBinary sbinary = new SBinary(binary);
            getSBinarycache().put(key, sbinary);
            return sbinary;
        }

    }

    /**
     * Crea un SBool que se guarda en SBoolcache para poder ser reutilizado
     *
     * @param bool booleano que tendra el SBool que se quiere crear
     * @return SBool con informacion de bool
     */

    public static SBool getSBool(boolean bool) {
        boolean key = bool;
        if (getSBoolcache().containsKey(key)) {
            return getSBoolcache().get(key);
        } else {
            SBool sbool = new SBool(key);
            getSBoolcache().put(key, sbool);
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
