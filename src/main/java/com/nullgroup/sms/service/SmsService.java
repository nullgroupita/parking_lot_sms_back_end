package com.nullgroup.sms.service;

/**
 * @description: 腾讯云短信服务
 * @author: Deng
 * @create: 2019-08-01
 */
public interface SmsService {

    Boolean sendRegisterMessage(String[] params);

}
