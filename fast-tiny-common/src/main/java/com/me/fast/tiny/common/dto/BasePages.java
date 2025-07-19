package com.me.fast.tiny.common.dto;

import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.constraints.Min;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

@Data
public class BasePages {

    @Parameter(description = "页码，默认为1", example = "1")
    @Min(value = 1, message = "页码最小为1")
    private Integer current = 1;

    @Parameter(description = "分页大小，默认为10", example = "10")
    @Range(min = 1, max = 100, message = "分页大小最小为1")
    private Integer pageSize = 10;

}
