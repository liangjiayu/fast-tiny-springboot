package com.me.fast.tiny.admin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.me.fast.tiny.admin.dto.ArticleQuery;
import com.me.fast.tiny.admin.dto.ArticleSaveRequest;
import com.me.fast.tiny.admin.model.SysArticles;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author system_generator
 * @since 2025-06-17
 */
public interface ISysArticlesService extends IService<SysArticles> {
    IPage<SysArticles> getListByPage(ArticleQuery articleQuery);

    Integer createArticle(ArticleSaveRequest articleSaveRequest);

    Boolean updateArticle(ArticleSaveRequest articleSaveRequest);

    Boolean deleteArticle(Integer id);
}
