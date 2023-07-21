package com.supershop.pos.util;


//single responsibility


import org.mindrot.BCrypt;

public class PasswordManager {

    public static String encriptPassword(String plainText){

       return BCrypt.hashpw(plainText, BCrypt.gensalt(10));

    }

    public static Boolean checkPassword(String hash,String plainText){

        return BCrypt.checkpw(plainText,hash);

    }

}
