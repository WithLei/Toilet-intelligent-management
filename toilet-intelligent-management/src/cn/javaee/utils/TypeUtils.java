package cn.javaee.utils;
public class TypeUtils {
    public TypeUtils() {
    } // change the string type to the int type

    public static int stringToInt(String intstr) {
        Integer integer;
        integer = Integer.valueOf(intstr);
        return integer.intValue();
    }

    // change int type to the string type
    public static String intToString(int value) {
        Integer integer = new Integer(value);
        return integer.toString();
    }

    // change the string type to the float type
    public static float stringToFloat(String floatstr) {
        Float floatee;
        floatee = Float.valueOf(floatstr);
        return floatee.floatValue();
    }

    // change the float type to the string type
    public static String floatToString(float value) {
        Float floatee = new Float(value);
        return floatee.toString();
    }

    // change the string type to the sqlDate type
    public static java.sql.Date stringToDate(String dateStr) {
        return java.sql.Date.valueOf(dateStr);
    }

    // change the sqlDate type to the string type
    public static String dateToString(java.sql.Date datee) {
        return datee.toString();
    }


}