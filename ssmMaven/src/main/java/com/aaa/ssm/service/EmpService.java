package com.aaa.ssm.service;

import java.util.List;
import java.util.Map;

/**
 * className:EmpService
 * discriptoin:
 * author:zz
 * createTime:2018-11-07 15:10
 */
public interface EmpService {

    /**
     * 获取员工列表分页
     * @return
     */
    List<Map> getPage(Map map);
    /**'
     * 分页获取总条数
     * @param map
     * @return
     */
    int getPageCount(Map map);

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
