package com.me.fast.tiny.admin.service;

import com.me.fast.tiny.admin.model.SysArticles;
import com.baomidou.mybatisplus.extension.service.IService;

import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author system_generator
 * @since 2025-06-17
 */
public interface ISysArticlesService extends IService<SysArticles> {
    IPage<SysArticles> getPage();

    int create();

    boolean update(int id);

    boolean delete(int id);
}
