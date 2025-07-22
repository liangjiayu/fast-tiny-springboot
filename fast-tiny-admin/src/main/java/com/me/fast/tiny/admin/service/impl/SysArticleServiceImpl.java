package com.me.fast.tiny.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.me.fast.tiny.admin.dto.SysArticleQuery;
import com.me.fast.tiny.admin.dto.SysArticleSaveRequest;
import com.me.fast.tiny.admin.mapper.SysArticleMapper;
import com.me.fast.tiny.admin.model.SysArticle;
import com.me.fast.tiny.admin.service.ISysArticleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author system_generator
 * @since 2025-07-20
 */
@Service
public class SysArticleServiceImpl extends ServiceImpl<SysArticleMapper, SysArticle> implements ISysArticleService {

    @Autowired
    SysArticleMapper baseMapper;

    @Override
    public IPage<SysArticle> getListByPage(SysArticleQuery sysArticleQuery) {
        Page<SysArticle> page = new Page<>(sysArticleQuery.getCurrent(), sysArticleQuery.getPageSize());
        LambdaQueryWrapper<SysArticle> lambdaQueryWrapper = new LambdaQueryWrapper<>();

        // 查询文章标题
        if (StringUtils.isNotBlank(sysArticleQuery.getTitle())) {
            lambdaQueryWrapper.like(SysArticle::getTitle, sysArticleQuery.getTitle());
        }
        // 状态筛选（如果状态不为空）
        if (sysArticleQuery.getStatus() != null) {
            lambdaQueryWrapper.eq(SysArticle::getStatus, sysArticleQuery.getStatus());
        }

        lambdaQueryWrapper.orderByDesc(SysArticle::getCreatedAt);
        return this.baseMapper.selectPage(page, lambdaQueryWrapper);
    }

    @Override
    public Integer createSysArticle(SysArticleSaveRequest sysArticleSaveRequest) {
        SysArticle record = new SysArticle();
        BeanUtils.copyProperties(sysArticleSaveRequest, record);

        record.setId(null);
        this.baseMapper.insert(record);
        return record.getId();
    }

    @Override
    public Boolean updateSysArticle(SysArticleSaveRequest sysArticleSaveRequest) {
        SysArticle record = new SysArticle();
        BeanUtils.copyProperties(sysArticleSaveRequest, record);

        return this.baseMapper.updateById(record) > 0;
    }

    @Override
    public Boolean deleteSysArticle(Integer id) {
        return this.baseMapper.deleteById(id) > 0;
    }

}


