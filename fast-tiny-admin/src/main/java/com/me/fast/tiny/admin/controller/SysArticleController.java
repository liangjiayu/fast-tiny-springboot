package com.me.fast.tiny.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.me.fast.tiny.admin.dto.SysArticleQuery;
import com.me.fast.tiny.admin.dto.SysArticleSaveRequest;
import com.me.fast.tiny.admin.model.SysArticle;
import com.me.fast.tiny.admin.service.ISysArticleService;
import com.me.fast.tiny.common.api.CommonResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 * @author system_generator
 * @since 2025-07-20
 */

@Controller
@RequestMapping("/api/sysArticle")
@Tag(name = "SysArticleController")
public class SysArticleController {
    @Autowired
    ISysArticleService baseService;

    @GetMapping("/pageList")
    @ResponseBody
    @Operation(summary = "获取文章列表")
    public CommonResult<IPage<SysArticle>> getSysArticleByPage(@ParameterObject SysArticleQuery sysArticleQuery) {
        IPage<SysArticle> records = this.baseService.getListByPage(sysArticleQuery);
        return CommonResult.success(records);
    }


    @PostMapping("/create")
    @ResponseBody
    @Operation(summary = "创建文章数据")
    public CommonResult<Integer> createSysArticle(@RequestBody SysArticleSaveRequest sysArticleSaveRequest) {
        Integer result = this.baseService.createSysArticle(sysArticleSaveRequest);
        return CommonResult.success(result);
    }

    @PostMapping("/update")
    @ResponseBody
    @Operation(summary = "更新文章数据")
    public CommonResult<Boolean> updateSysArticle(@RequestBody SysArticleSaveRequest sysArticleSaveRequest) {
        Boolean result = this.baseService.updateSysArticle(sysArticleSaveRequest);
        if (result) {
            return CommonResult.success(true);
        }
        return CommonResult.failed("数据不存在");
    }

    @PostMapping("/delete")
    @ResponseBody
    @Operation(summary = "删除文章数据")
    public CommonResult<Boolean> deleteSysArticle(@Parameter() Integer id) {
        Boolean result = this.baseService.deleteSysArticle(id);
        if (result) {
            return CommonResult.success(true);
        }
        return CommonResult.failed("数据不存在");
    }

}
