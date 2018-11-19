package com.aaa.ssm.service;

import com.aaa.ssm.dao.EmpDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * className:EmpServiceImpl
 * discriptoin:
 * author:zz
 * createTime:2018-11-07 15:16
 */
@Service
public class EmpServiceImpl implements EmpService{

    @Autowired
    private EmpDao empDao;

    public List<Map> getPage(Map map) {
        int pageNo = map.get("pageNo")==null?1:Integer.valueOf(map.get("pageNo")+"");
        int pageSize = map.get("pageSize")==null?10:Integer.valueOf(map.get("pageSize")+"");
        /*计算分页的开始值和结束值*/
        map.put("start",(pageNo-1)*pageSize);
        map.put("end",pageNo*pageSize+1);
        return empDao.getPage(map);
    }

    public int getPageCount(Map map) {
        return empDao.getpageCount(map);
    }

    public int add(Map map) {
        return empDao.add(map);
    }

    public List<Map> getByIdPage(Map map) {
        return empDao.getByIdPage(map);
    }

    public int update(Map map) {
        return empDao.update(map);
    }

    public int delete(Map map) {
        return empDao.delete(map);
    }
}
