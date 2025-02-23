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
@Tag(name = "SysUsersTag", description = "用户管理API")
public class SysUsersController {
    @Autowired
    SysUsersService sysUsersService;

    @GetMapping("/list")
    @ResponseBody
    @Operation(summary = "获取用户列表123456!!!")
    public CommonResult<IPage<SysUsers>> list(@Validated @ParameterObject SysUsersQuery sysUsersQuery) {
        IPage<SysUsers> records = this.sysUsersService.list(sysUsersQuery);
        return CommonResult.success(records);
    }


    @PostMapping("/create")
    @ResponseBody
    @Operation(summary = "创建用户，返回用户id")
    public CommonResult<Integer> create(@Validated @RequestBody SysUserCreateDto sysUserCreateDto) {
        int result = this.sysUsersService.create(sysUserCreateDto);
        return CommonResult.success(result);
    }

    @PostMapping("/update/{id}")
    @ResponseBody
    @Operation(summary = "更新用户")
    public CommonResult<Boolean> update(
            @Parameter(name = "id", description = "用户id", required = true) @PathVariable("id") int id,
            @Validated @RequestBody SysUserUpdateDto sysUserUpdateDto
    ) {
        boolean result = this.sysUsersService.update(id, sysUserUpdateDto);
        if (result) {
            return CommonResult.success(true);
        }
        return CommonResult.failed("用户不存在");
    }

    @PostMapping("/delete/{id}")
    @ResponseBody
    @Operation(summary = "删除用户")
    public CommonResult<Boolean> delete(@Parameter(name = "id", description = "用户id", required = true) @PathVariable int id) {
        boolean result = this.sysUsersService.delete(id);
        if (result) {
            return CommonResult.success(true);
        }
        return CommonResult.failed("用户不存在");
    }

    @GetMapping("/{id}")
    @ResponseBody
    @Operation(summary = "用户详情")
    public CommonResult<SysUsers> details(@Parameter(name = "id", description = "用户id", required = true) @PathVariable int id) {
        SysUsers result = this.sysUsersService.getDetails(id);
        return CommonResult.success(result);
    }

    @GetMapping("/getListByPhone")
    @ResponseBody
    @Operation(summary = "获取列表根据手机号码")
    public CommonResult<List<SysUsers>> getListByPhone(
            @Parameter(name = "phoneNumber", description = "手机号码", required = true) long phoneNumber) {
        List<SysUsers> result = this.sysUsersService.getListByPhone(phoneNumber);
        return CommonResult.success(result);
    }
}
