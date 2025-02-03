package com.me.fast.tiny.admin.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SysUsersMetaData {

    @Data
    public static class Contact {
        @NotBlank(message = "联系人姓名不能为空")
        @Schema(description = "联系人姓名", example = "家长")
        private String name;

        @Pattern(regexp = "^1[3-9]\\d{9}$", message = "手机号格式不正确")
        @Schema(description = "联系人手机号码")
        private String phone;

        @Schema(description = "是否主要联系人")
        private boolean isPrimary;
    }

    @URL(message = "博客链接格式不正确")
    @Schema(description = "博客地址", example = "https://www.blog.com/")
    private String blogUrl;

    @URL(message = "Facebook链接格式不正确")
    @Schema(description = "Facebook地址", example = "https://www.facebook.com/")
    private String facebookUrl;

    @Valid
    @Schema(description = "联系人信息")
    private List<Contact> contacts;

    @Schema(description = "手机号码是否已验证", example = "false")
    private boolean phoneVerified = false;

    @Schema(description = "是否订阅通知", example = "false")
    private boolean subscribed = false;
}
