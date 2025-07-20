package com.me.fast.tiny.admin.dto;

import com.me.fast.tiny.common.dto.BasePages;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class SysArticleQuery extends BasePages {
    @Schema(description = "文章标题")
    private String title;
}