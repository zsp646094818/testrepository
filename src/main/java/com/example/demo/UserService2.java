package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class UserService2  implements IUserService {
    public String GetUserInfo() {
        return "用户信息222";
    }
}
