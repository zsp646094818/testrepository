package com.example.demo;

import java.security.SecureRandom;
import java.util.Base64;



import javax.crypto.KeyGenerator;

import java.security.NoSuchAlgorithmException;



public class randomkey
{

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        try {
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            //使用128位的key，
            keyGen.init(128, new SecureRandom());
            //keyGen.init(256, new SecureRandom());

            String key = Base64.getEncoder().encodeToString(keyGen.generateKey().getEncoded());
            System.out.println(key); 
        }
        catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        

    }

}
