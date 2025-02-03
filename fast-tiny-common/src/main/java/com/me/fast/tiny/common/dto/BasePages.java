package com.me.fast.tiny.common.dto;

import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

@Data
public class BasePages {

    @Parameter(description = "页码，从1开始", example = "1")
    @NotNull(message = "页码不能为空")
    @Min(value = 1, message = "页面必须大于1")
    private Integer pageNum = 1;

    @Parameter(description = "分页大小", example = "10")
    @NotNull(message = "分页大小不能为空")
    @Range(min = 1, max = 100, message = "分页大小范围为1-100")
    private Integer pageSize = 10;

}
