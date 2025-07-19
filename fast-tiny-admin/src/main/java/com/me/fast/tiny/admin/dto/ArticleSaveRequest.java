package com.me.fast.tiny.admin.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class ArticleSaveRequest {
    @Schema(description = "文章id")
    private Integer id;

    @Schema(description = "文章标题")
    private String title;

    @Schema(description = "文章内容")
    private String content;

    @Schema(description = "作者ID")
    private Integer authorId;

    @Schema(description = "分类ID")
    private Integer categoryId;

    @Schema(description = "文章状态")
    private String status;

    @Schema(description = "阅读量")
    private Integer viewCount;
}
