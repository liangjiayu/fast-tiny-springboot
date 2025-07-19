package com.me.fast.tiny.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.me.fast.tiny.admin.dto.ArticleQuery;
import com.me.fast.tiny.admin.dto.ArticleSaveRequest;
import com.me.fast.tiny.admin.model.SysArticles;
import com.me.fast.tiny.admin.service.ISysArticlesService;
import com.me.fast.tiny.common.api.CommonResult;
import io.swagger.v3.oas.annotations.Operation;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author system_generator
 * @since 2025-06-17
 */

@Controller
@RequestMapping("/sysArticles")
public class SysArticlesController {
    @Autowired
    ISysArticlesService baseService;

    @GetMapping("/list")
    @ResponseBody
    @Operation(summary = "获取文章列表")
    public CommonResult<IPage<SysArticles>> list(@ParameterObject ArticleQuery articleQuery) {
        IPage<SysArticles> records = this.baseService.getPage(articleQuery);
        return CommonResult.success(records);
    }


    @PostMapping("/create")
    @ResponseBody
    @Operation(summary = "创建文章数据")
    public CommonResult<Integer> create(@RequestBody ArticleSaveRequest articleSaveRequest) {
        Integer result = this.baseService.create(articleSaveRequest);
        return CommonResult.success(result);
    }

    @PostMapping("/update/{id}")
    @ResponseBody
    @Operation(summary = "更新文章数据")
    public CommonResult<Boolean> update(@PathVariable("id") Integer id, @RequestBody ArticleSaveRequest articleSaveRequest) {
        Boolean result = this.baseService.update(id, articleSaveRequest);
        if (result) {
            return CommonResult.success(true);
        }
        return CommonResult.failed("数据不存在");
    }

    @PostMapping("/delete/{id}")
    @ResponseBody
    @Operation(summary = "删除文章数据")
    public CommonResult<Boolean> delete(@PathVariable Integer id) {
        Boolean result = this.baseService.deleted(id);
        if (result) {
            return CommonResult.success(true);
        }
        return CommonResult.failed("数据不存在");
    }

}
