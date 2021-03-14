package com.like.mq.common.mabatis;

import cn.hutool.json.JSONUtil;
import com.like.mq.base.Message;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * <B>系统名称：</B><BR>
 * <B>模块名称：</B><BR>
 * <B>中文类名：</B><BR>
 * <B>概要说明：</B><BR>
 * @author BuFanxueyuan
 * @since 2018年5月15日 下午2:35:54
 */
public class MessageJsonTypeHandler extends BaseTypeHandler<Message> {

    @Override
    public void setNonNullParameter(
            PreparedStatement ps, int i, Message parameter,
            JdbcType jdbcType) throws SQLException {

        ps.setString(i, JSONUtil.toJsonStr(parameter));
    }

    @Override
    public Message getNullableResult(ResultSet rs, String columnName)
            throws SQLException {
        String value = rs.getString(columnName);
        if (null != value && !StringUtils.isBlank(value)) {
            return JSONUtil.toBean(rs.getString(columnName), Message.class);
        }
        return null;
    }

    @Override
    public Message getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String value = rs.getString(columnIndex);
        if (null != value && !StringUtils.isBlank(value)) {
            return JSONUtil.toBean(rs.getString(columnIndex), Message.class);
        }
        return null;
    }

    @Override
    public Message getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String value = cs.getString(columnIndex);
        if (null != value && !StringUtils.isBlank(value)) {
            return JSONUtil.toBean(cs.getString(columnIndex), Message.class);
        }
        return null;
    }

}