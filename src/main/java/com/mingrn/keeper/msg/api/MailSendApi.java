package com.mingrn.keeper.msg.api;

import com.mingrn.keeper.global.result.Result;
import com.mingrn.keeper.msg.api.enums.MailTemplateEnums;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 邮件发送Api
 *
 * @author MinGRn <br > MinGRn97@gmail.com
 * @date 2019-02-23 14:56
 */
@FeignClient(
        name = "${keeper.app.msg:msg-v1}",
        path = "/mailSendApi"
)
public interface MailSendApi {

    /**
     * 发送简单文本邮件
     *
     * @param subject  邮件标题
     * @param msg      邮件文本信息
     * @param receiver 接收者,支持数组
     * @return {@link com.mingrn.keeper.global.result.Result}
     */
    @PostMapping("/sendTextMessage")
    Result sendTextMessage(@RequestParam(name = "subject") String subject,
                           @RequestParam(name = "msg") String msg, @RequestParam(name = "receiver") String... receiver);

    /**
     * 发送 HTML 邮件
     *
     * @param subject     邮件标题
     * @param htmlContent 邮件HTML 信息
     * @param receiver    接收者,支持数组
     * @return {@link com.mingrn.keeper.global.result.Result}
     */
    @PostMapping("/sendHtmlMessage")
    Result sendHtmlMessage(@RequestParam(name = "subject") String subject,
                           @RequestParam(name = "htmlContent") String htmlContent, @RequestParam(name = "receiver") String... receiver);


    /**
     * 发送 HTML 模板邮件
     *
     * @param subject       邮件标题
     * @param templateEnums 邮件HTML模板 信息
     * @param receiver      接收者,支持数组
     * @return {@link com.mingrn.keeper.global.result.Result}
     */
    @PostMapping("/sendHtmlMessageWithFtl")
    Result sendHtmlMessageWithFtl(@RequestParam(name = "subject") String subject,
                                  @RequestParam(name = "templateEnums") MailTemplateEnums templateEnums,
                                  @RequestParam(name = "receiver") String... receiver);
}
