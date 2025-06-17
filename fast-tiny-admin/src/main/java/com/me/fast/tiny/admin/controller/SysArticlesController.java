package com.me.fast.tiny.admin.controller;

import com.me.fast.tiny.admin.model.SysArticles;
import com.me.fast.tiny.admin.service.ISysArticlesService;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.me.fast.tiny.common.api.CommonResult;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;


/**
 * <p>
 *  前端控制器
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
    @Operation(summary = "获取列表")
    public CommonResult<IPage<SysArticles>> list() {
        IPage<SysArticles> records = this.baseService.getPage();
        return CommonResult.success(records);
    }


    @PostMapping("/create")
    @ResponseBody
    @Operation(summary = "创建数据")
    public CommonResult<Integer> create() {
        int result = this.baseService.create();
        return CommonResult.success(result);
    }

    @PostMapping("/update/{id}")
    @ResponseBody
    @Operation(summary = "更新数据")
    public CommonResult<Boolean> update(@PathVariable("id") int id) {
        boolean result = this.baseService.update(id);
        if (result) {
            return CommonResult.success(true);
        }
        return CommonResult.failed("数据不存在");
    }

    @PostMapping("/delete/{id}")
    @ResponseBody
    @Operation(summary = "删除数据")
    public CommonResult<Boolean> delete(@PathVariable int id) {
        boolean result = this.baseService.delete(id);
        if (result) {
            return CommonResult.success(true);
        }
        return CommonResult.failed("数据不存在");
    }

}
