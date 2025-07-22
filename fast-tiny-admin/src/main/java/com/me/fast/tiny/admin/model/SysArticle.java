package com.me.fast.tiny.admin.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
/**
 * <p>
 * 
 * </p>
 *
 * @author system_generator
 * @since 2025-07-20
 */
@Getter
@Setter
@ToString
@TableName("sys_article")
@Schema(name = "SysArticle", description = "")
public class SysArticle implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(description = "文章ID")
    @TableId(value = "id", type = IdType.AUTO)
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
    private Integer status;

    @Schema(description = "阅读量")
    private Integer viewCount;

    @Schema(description = "创建时间")
    private LocalDateTime createdAt;

    @Schema(description = "更新时间")
    private LocalDateTime updatedAt;

    @Schema(description = "逻辑删除时间")
    private LocalDateTime deletedAt;
}
