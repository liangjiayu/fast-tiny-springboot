package com.me.fast.tiny.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.me.fast.tiny.admin.dto.ArticleQuery;
import com.me.fast.tiny.admin.dto.ArticleSaveRequest;
import com.me.fast.tiny.admin.mapper.SysArticlesMapper;
import com.me.fast.tiny.admin.model.SysArticles;
import com.me.fast.tiny.admin.service.ISysArticlesService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * <p>
 * 服务实现类
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
    public IPage<SysArticles> getListByPage(ArticleQuery articleQuery) {
        Page<SysArticles> page = new Page<>(articleQuery.getCurrent(), articleQuery.getPageSize());
        LambdaQueryWrapper<SysArticles> lambdaQueryWrapper = new LambdaQueryWrapper<>();

        // 查询文章标题
        if (StringUtils.isNotBlank(articleQuery.getTitle())) {
            lambdaQueryWrapper.like(SysArticles::getTitle, articleQuery.getTitle());
        }

        return this.baseMapper.selectPage(page, lambdaQueryWrapper);
    }

    @Override
    public Integer createArticle(ArticleSaveRequest articleSaveRequest) {
        SysArticles record = new SysArticles();
        BeanUtils.copyProperties(articleSaveRequest, record);
        record.setId(null);
        this.baseMapper.insert(record);

        return record.getId();
    }

    @Override
    public Boolean updateArticle(ArticleSaveRequest articleSaveRequest) {
        SysArticles record = new SysArticles();
        BeanUtils.copyProperties(articleSaveRequest, record);

        return this.baseMapper.updateById(record) > 0;
    }

    @Override
    public Boolean deleteArticle(Integer id) {
        return this.baseMapper.deleteById(id) > 0;
    }

}


