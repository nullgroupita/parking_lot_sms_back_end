package com.nullgroup.sms.form;

import lombok.Data;

/**
 * @description: 注册成功短信内容
 * @author: Deng
 * @create: 2019-08-01
 */
@Data
public class RegisterForm {

    String phone;

    String password;

    String job;

    public RegisterForm(String phone, String password, String job) {
        this.phone = phone;
        this.password = password;
        this.job = job;
    }

    public RegisterForm() {
    }
}
