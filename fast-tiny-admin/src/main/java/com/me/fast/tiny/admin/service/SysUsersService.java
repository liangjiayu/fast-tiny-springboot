package com.me.fast.tiny.admin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.me.fast.tiny.admin.dto.SysUserCreateDto;
import com.me.fast.tiny.admin.dto.SysUserUpdateDto;
import com.me.fast.tiny.admin.dto.SysUsersQuery;
import com.me.fast.tiny.admin.model.SysUsers;

import java.util.List;

public interface SysUsersService {
    IPage<SysUsers> list(SysUsersQuery sysUsersQuery);

    int create(SysUserCreateDto sysUserCreateDto);

    boolean update(int id, SysUserUpdateDto sysUserUpdateDto);

    boolean deleted(int id);

    SysUsers getDetails(int id);

    List<SysUsers> getListByPhone(long phoneNumber);
}
