package com.example.demo;

public class testToken {
    public static void main(String[] args) throws Exception {
        String token = epoint.frame.encrypt.token.TokenUtil.createToken("epointjweb4.0", "96&7Qin@");
        System.out.println(token);
    }
}
