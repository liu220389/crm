package com.ttc.crms.entity;

import lombok.Getter;

@Getter
public enum ResultCode {
    /**
     * SUCCESS表达一个积极的正向的一个结果
     */
    SUCCESS(200,"成功"),
    FINDSUCCESS(201,"获得资源成功"),
    ADDSUCCESS(202,"添加资源成功"),
    MDDSUCCESS(203,"修改资源成功"),
    DELSUCCESS(204,"删除资源成功"),
    //  用户提交的数据
    /**
     * 登录名不存在
     */
    LOGIDNOTEXIST(301,"登录名不存在"),
    /**
     * 登录名与密码不匹配
     */
    LOGIDNOTMATCHPWD(301,"登录名与密码不匹配"),
    //  用户的动作错误
    ACCESSBEDENIED(351,"没有足够的访问权限"),

    URLERROR(400,"使用的URL错误"),
    /**
     * 访问的资源不存在
     */
    NOTFOUND(404,"访问的资源不存在"),
    EMPTYLIST(405, "资源列表为空"),
    //  服务器错误
    SERVLETERROR(500, "服务器端代码异常"),
    DATABASECONNECTERROR(501, "数据库连接异常")
    //  数据库错误
    //  硬件设备错误
    ; //所有的枚举值都定义在此分号之前，多个枚举值之间使用,分割

    private Integer code ;
    private String message;

    ResultCode(int code , String message) {
        this.code = code;
        this.message =  message;
    }
}
