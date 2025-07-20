package com.me.fast.tiny.admin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.me.fast.tiny.admin.dto.SysArticleQuery;
import com.me.fast.tiny.admin.dto.SysArticleSaveRequest;
import com.me.fast.tiny.admin.model.SysArticle;

/**
 * @author system_generator
 * @since 2025-07-20
 */
public interface ISysArticleService extends IService<SysArticle> {
    IPage<SysArticle> getListByPage(SysArticleQuery sysArticleQuery);

    Integer createSysArticle(SysArticleSaveRequest sysArticleSaveRequest);

    Boolean updateSysArticle(SysArticleSaveRequest sysArticleSaveRequest);

    Boolean deleteSysArticle(Integer id);
}
