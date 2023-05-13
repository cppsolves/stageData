package com.geekster.Doctor.Util;

import org.json.JSONObject;
import java.util.regex.Pattern;
public class DoctorValidator {
    public static boolean validateEmail(JSONObject doctor){
        return Pattern.compile("^[a-z_0-9]+@+[a-z]+\\.+com$").matcher(doctor.getString("email")).find();
    }
    public static boolean validatePhone(JSONObject doctor){
        return Pattern.compile("^[0-9]{10}$").matcher(doctor.getString("phone")).find();
    }
    public static boolean validateName(JSONObject doctor){
        return Pattern.compile("^[a-z]{3,}$").matcher(doctor.getString("phone")).find();
    }
    public static boolean validateCity(JSONObject doctor){
        return Pattern.compile("^[a-z]{1,20}$").matcher(doctor.getString("phone")).find();
    }
}
