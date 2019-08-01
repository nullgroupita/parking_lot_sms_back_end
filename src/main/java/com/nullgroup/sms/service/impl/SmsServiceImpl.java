package com.nullgroup.sms.service.impl;

import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;
import com.nullgroup.sms.service.SmsService;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @description:
 * @author: Deng
 * @create: 2019-08-01
 */
@Service
@Slf4j
public class SmsServiceImpl implements SmsService {

    @Value("${sms.appid}")
    private int APP_ID;

    @Value("${sms.appkey}")
    private String APP_KEY;

    @Value("${sms.templateId.registered}")
    private int TEMPLATE_REGISTERED;

    @Value("${sms.sign}")
    private String SIGN;

    @Override
    public String sendRegisterMessage(String[] params) {
        SmsSingleSender sender = new SmsSingleSender(APP_ID, APP_KEY);
        try {
            SmsSingleSenderResult result = sender.sendWithParam("86", params[0], TEMPLATE_REGISTERED, params, SIGN, "", "");
            log.info(result.toString());
            return result.toString();
        } catch (HTTPException e) {
            // HTTP响应码错误
            log.error("[验证码]: HTTP响应码错误");
        } catch (JSONException e) {
            // json解析错误
            log.error("[验证码]: json解析错误");
        } catch (IOException e) {
            // 网络IO错误
            log.error("[验证码]: 网络IO错误");
        }
        return "error";
    }
}
