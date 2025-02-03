package com.me.fast.tiny.admin.dto;

import com.me.fast.tiny.admin.enums.GenderEnum;
import com.me.fast.tiny.admin.model.SysUsersMetaData;
import com.me.fast.tiny.common.validator.ValidEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.URL;


@Data
public class SysUserUpdateDto {
    @Schema(description = "用户手机号")
    @Pattern(regexp = "^1[3-9]\\d{9}$", message = "手机号格式不合法")
    private String phoneNumber;

    @Schema(description = "用户性别，枚举类型：男(1)、女(2)、其他(3)", example = "1")
    @ValidEnum(enumClass = GenderEnum.class, message = "性别编码不合法")
    private Integer gender;

    @Schema(description = "用户称呼", example = "小明")
    @Size(min = 2, max = 16, message = "用户称呼长度为2-16位")
    private String nickname;

    @Schema(description = "用户头像的URL", example = "https://www.picture.com/")
    @URL(message = "头像地址格式错误")
    private String profilePictureUrl;

    @Schema(description = "用户简介", example = "个性签名")
    private String profileDescription;

    @Schema(description = "用户元数据，存储额外的自定义信息")
    @Valid
    private SysUsersMetaData metadata;
}
