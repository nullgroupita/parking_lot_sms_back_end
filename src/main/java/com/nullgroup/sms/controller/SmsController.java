package com.nullgroup.sms.controller;

import com.nullgroup.sms.form.RegisterForm;
import com.nullgroup.sms.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @description: 腾讯云短信服务对外接口
 * @author: Deng
 * @create: 2019-08-01
 */
@RestController
@RequestMapping("/sms")
public class SmsController {

    @Autowired
    private SmsService service;

    @PostMapping("/register")
    public String sendRegisterMessage(@RequestBody RegisterForm form) {
        String[] params = {form.getPhone(), form.getPassword(), form.getJob()};
        return service.sendRegisterMessage(params);
    }
}
