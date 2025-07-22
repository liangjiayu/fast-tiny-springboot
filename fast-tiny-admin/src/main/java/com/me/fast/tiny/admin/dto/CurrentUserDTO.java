package com.me.fast.tiny.admin.dto;

import lombok.Data;

@Data
public class CurrentUserDTO {
    private String name;
    private String avatar;
    private String userid;
    private String email;
    private String signature;
    private String title;
    private String group;
    private Integer notifyCount;
    private Integer unreadCount;
    private String country;
    private String access;
    private String address;
    private String phone;
}
