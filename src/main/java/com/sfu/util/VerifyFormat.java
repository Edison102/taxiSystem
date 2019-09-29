package com.sfu.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VerifyFormat {

    public static boolean verifyPhoneFormat(String phone){
        Pattern p=Pattern.compile("^[1][3,4,5,7,8][0-9]{9}$");
        Matcher m=p.matcher(phone);
        if(m.find()) return true;
        return false;
    }
}
