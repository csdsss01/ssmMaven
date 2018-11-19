package com.aaa.ssm.dao;

import java.util.List;
import java.util.Map;

/**
 * className:EmpDao
 * discriptoin:
 * author:zz
 * createTime:2018-11-07 14:59
 */
public interface EmpDao {
    /**
     * 获取员工列表
     * @return
     */
    List<Map> getPage(Map map);

    /**'
     * 获取总条数
     * @param map
     * @return
     */
    int getpageCount(Map map);

    /**
     * 新增用户
     * @param map
     * @return
     */
    int add(Map map);

    /**
     * 根据ID获取员工列表
     * @return
     */
    List<Map> getByIdPage(Map map);

    /**
     * 修改
     * @param map
     * @return
     */
    int update(Map map);

    /**
     * 删除
     * @param map
     * @return
     */
    int delete(Map map);

}
