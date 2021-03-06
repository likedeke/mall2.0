package com.like.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by Mybatis Generator 2021/02/16
 */
@ApiModel(value = "com.like.pojo.Category")
@Data
@TableName(value = "category")
public class Category implements Serializable {
    /**
     * 主键 分类id主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "主键 分类id主键")
    private Integer id;

    /**
     * 分类名称 分类名称
     */
    @TableField(value = "name")
    @ApiModelProperty(value = "分类名称 分类名称")
    private String name;

    private static final long serialVersionUID = 1L;
    public static final String COL_NAME = "name";
    public static final String COL_TYPE = "type";
    public static final String COL_FATHER_ID = "father_id";
    public static final String COL_LOGO = "logo";
    public static final String COL_SLOGAN = "slogan";
    public static final String COL_CAT_IMAGE = "cat_image";
    public static final String COL_BG_COLOR = "bg_color";
    /**
     * 分类类型 分类得类型，
     * 1:一级大分类
     * 2:二级分类
     * 3:三级小分类
     */
    @TableField(value = "type")
    @ApiModelProperty(value = "分类类型 分类得类型， 1:一级大分类 2:二级分类 3:三级小分类")
    private Integer type;
    /**
     * 父id 父id 上一级依赖的id，1级分类则为0，二级三级分别依赖上一级
     */
    @TableField(value = "father_id")
    @ApiModelProperty(value = "父id 父id 上一级依赖的id，1级分类则为0，二级三级分别依赖上一级")
    private Integer fatherId;
    /**
     * 图标 logo
     */
    @TableField(value = "logo")
    @ApiModelProperty(value = "图标 logo")
    private String logo;
    /**
     * 口号
     */
    @TableField(value = "slogan")
    @ApiModelProperty(value = "口号")
    private String slogan;
    /**
     * 分类图
     */
    @TableField(value = "cat_image")
    @ApiModelProperty(value = "分类图")
    private String catImage;
    /**
     * 背景颜色
     */
    @TableField(value = "bg_color")
    @ApiModelProperty(value = "背景颜色")
    private String bgColor;
}