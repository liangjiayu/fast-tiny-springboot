package com.me.fast.tiny.admin.service.impl;

import com.me.fast.tiny.admin.model.SysArticles;
import com.me.fast.tiny.admin.mapper.SysArticlesMapper;
import com.me.fast.tiny.admin.service.ISysArticlesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author system_generator
 * @since 2025-06-17
 */
@Service
public class SysArticlesServiceImpl extends ServiceImpl<SysArticlesMapper, SysArticles> implements ISysArticlesService {

    @Autowired
    SysArticlesMapper baseMapper;

    @Override
    public IPage<SysArticles> getPage() {
        Page<SysArticles> page = new Page<>(1, 10);
        LambdaQueryWrapper<SysArticles> lambdaQueryWrapper = new LambdaQueryWrapper<>();

        return this.baseMapper.selectPage(page, lambdaQueryWrapper);
    }

    @Override
    public int create() {
        SysArticles record = new SysArticles();
        record.setId(null);
        this.baseMapper.insert(record);

        return record.getId();
    }

    @Override
    public boolean update(int id) {
        SysArticles record  = new SysArticles();
        record.setId(id);

        return this.baseMapper.updateById(record) > 0;
    }

    @Override
    public boolean delete(int id) {
        return this.baseMapper.deleteById(id) > 0;
    }

}


