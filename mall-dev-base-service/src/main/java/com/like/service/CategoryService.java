package com.like.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.like.pojo.Category;
import com.like.pojo.vo.CategoryVo;
import com.like.pojo.vo.NewItemsVo;

import java.util.List;

/**
 * @author like
 * @email 980650920@qq.com
 * @Description: 首页分类展示
 * @since 2021-02-09 17:37
 */
public interface CategoryService extends IService<Category> {

    /**
     * 查询所有一级分类
     *
     * @return {@link List<Category>}
     */
    public List<Category> queryAllRootLevelCat();

    /**
     * 获取对应一级分类id下的子分类
     *
     * @param rootCatId 一级分类id
     * @return {@link List<CategoryVo>}
     */
    public List<CategoryVo> getSubCatList(Integer rootCatId);


    /**
     * 查询每个分类下的6个商品数据作为推荐项
     *
     * @param rootCatId 主分类id
     * @return {@link List<Object>}
     */
    public List<NewItemsVo> getSixNewItemsLazy(Integer rootCatId);
}
