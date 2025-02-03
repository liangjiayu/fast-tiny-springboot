package com.me.fast.tiny.admin.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class SysUserCreateDto {

    @Schema(description = "用户名，唯一")
    @NotBlank(message = "用户名不能为空")
    @Pattern(regexp = "^[A-Za-z0-9]{6,20}$", message = "用户名必须是6-20位的英文或数字")
    private String username;

    @Schema(description = "用户密码")
    @NotBlank(message = "密码不能为空")
    @Pattern(regexp = "^[A-Za-z0-9]{6,20}$", message = "密码必须是6-20位的英文或数字")
    private String password;
}
