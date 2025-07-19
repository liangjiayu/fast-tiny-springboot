package com.me.fast.tiny.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.me.fast.tiny.admin.dto.SysUserCreateDto;
import com.me.fast.tiny.admin.dto.SysUserUpdateDto;
import com.me.fast.tiny.admin.dto.SysUsersQuery;
import com.me.fast.tiny.admin.model.SysUsers;
import com.me.fast.tiny.admin.service.SysUsersService;
import com.me.fast.tiny.common.api.CommonResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/sys_users")
@Tag(name = "SysUsersController", description = "用户管理")
public class SysUsersController {
    @Autowired
    SysUsersService sysUsersService;

    @GetMapping("/list")
    @ResponseBody
    @Operation(summary = "获取用户列表")
    public CommonResult<IPage<SysUsers>> getSysUserByPage(@Validated @ParameterObject SysUsersQuery sysUsersQuery) {
        IPage<SysUsers> records = this.sysUsersService.list(sysUsersQuery);
        return CommonResult.success(records);
    }


    @PostMapping("/create")
    @ResponseBody
    @Operation(summary = "创建用户，返回用户id")
    public CommonResult<Integer> createSysUser(@Validated @RequestBody SysUserCreateDto sysUserCreateDto) {
        int result = this.sysUsersService.create(sysUserCreateDto);
        return CommonResult.success(result);
    }

    @PostMapping("/update/{id}")
    @ResponseBody
    @Operation(summary = "更新用户")
    public CommonResult<Boolean> updateSysUser(
            @Parameter(name = "id", description = "用户id", required = true) @PathVariable("id") int id,
            @Validated @RequestBody SysUserUpdateDto sysUserUpdateDto
    ) {
        boolean result = this.sysUsersService.update(id, sysUserUpdateDto);
        if (result) {
            return CommonResult.success(true);
        }
        return CommonResult.failed("用户不存在");
    }

    @PostMapping("/deleted/{id}")
    @ResponseBody
    @Operation(summary = "删除用户")
    public CommonResult<Boolean> deletedSysUser(@Parameter(name = "id", description = "用户id", required = true) @PathVariable int id) {
        boolean result = this.sysUsersService.deleted(id);
        if (result) {
            return CommonResult.success(true);
        }
        return CommonResult.failed("用户不存在");
    }

    @GetMapping("/{id}")
    @ResponseBody
    @Operation(summary = "用户详情")
    public CommonResult<SysUsers> getUserDetail(@Parameter(name = "id", description = "用户id", required = true) @PathVariable int id) {
        SysUsers result = this.sysUsersService.getDetails(id);
        return CommonResult.success(result);
    }
}
