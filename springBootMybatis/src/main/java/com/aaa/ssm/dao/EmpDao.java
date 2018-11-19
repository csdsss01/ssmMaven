package com.aaa.ssm.dao;

import com.aaa.ssm.entitys.Emp;

import java.util.List;
import java.util.Map;

public interface EmpDao {

    /**
     * 员工列表方法
     *
     * @param map
     * @return
     */
    List<Emp> getList(Map map);

    /**
     * 新增
     */
    int addEmp(Emp emp);

    /**
     * 删除
     */
    int deleteEmp(Integer empno);

    /**
     * id查询
     * @param newsid
     * @return
     */
    List<Emp> byIdgetList(Integer newsid);

    /**
     * 修改
     * @param emp
     * @return
     */
    int empUpdate(Emp emp);

    /**
     * 登录
     * @param map
     * @return
     */
    List<Map> userLogin(Map map);

    /**
     * 调用存储过程，根据部门编号获取人员
     * @param map
     * @return
     */
    List<Emp> getProListByDeptNo(Map map);

    int addId(Map map);

}
