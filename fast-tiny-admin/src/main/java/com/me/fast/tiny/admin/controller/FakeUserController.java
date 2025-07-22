package com.me.fast.tiny.admin.controller;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.me.fast.tiny.admin.dto.CurrentUserDTO;
import com.me.fast.tiny.common.api.CommonResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.Map;

@Controller
@Tag(name = "FakeUserController")
public class FakeUserController {
    @GetMapping("/api/currentUser")
    @ResponseBody
    @Operation(summary = "获取用户信息")
    public CommonResult<CurrentUserDTO> getCurrentUser() throws IOException {
        ClassPathResource resource = new ClassPathResource("static/mock/currentUser.json");
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        CurrentUserDTO user = mapper.readValue(resource.getInputStream(), CurrentUserDTO.class);
        return CommonResult.success(user);
    }

    @PostMapping("/api/login/account")
    @ResponseBody
    @Operation(summary = "用户登录")
    public CommonResult<String> loginAccount(@RequestBody Map<String, String> params) {
        String username = params.get("username");
        String password = params.get("password");
        if ("admin".equals(username) && "123456".equals(password)) {
            return CommonResult.success("登录成功");
        }
        if ("user".equals(username) && "123456".equals(password)) {
            return CommonResult.success("登录成功");
        }

        return CommonResult.failed("登录失败");
    }

    @PostMapping("/api/login/outLogin")
    @ResponseBody
    @Operation(summary = "退出登录")
    public CommonResult<String> outLoginAccount() {
        return CommonResult.success("");
    }

    @GetMapping("/api/login/captcha")
    @ResponseBody
    public CommonResult<String> loginCaptcha() {
        return CommonResult.success("");
    }

}
