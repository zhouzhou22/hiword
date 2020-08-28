package com.itaem.crazy.shirodemo.modules.shiro.command;

import lombok.Data;

@Data
public class LoginCommand {
    private String username;
    private String password;
}