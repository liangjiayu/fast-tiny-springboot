package com.me.fast.tiny.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.me.fast.tiny.admin.model.SysUsers;

import java.util.List;


public interface SysUsersMapper extends BaseMapper<SysUsers> {
    List<SysUsers> getListByPhone(long phoneNumber);
}
