package com.aaa.ssm.controller;

import com.aaa.ssm.service.EmpService;
import com.aaa.ssm.uilt.PageUilt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * className:EmpController
 * discriptoin:
 * author:zz
 * createTime:2018-11-07 15:51
 */
@Controller

public class EmpController {

    @Autowired
    private EmpService empService;

    @RequestMapping("list")
    public String empList(@RequestParam Map map, Model model, HttpServletRequest request){
        map.put("pageSize",5);
        int pageNo = map.get("pageNo")==null?1:Integer.valueOf(map.get("pageNo")+"");
        String stringPage = new PageUilt(pageNo,5,empService.getPageCount(map),request).getStringPage();
        model.addAttribute("stringPage",stringPage);model.addAttribute("pageNo",pageNo);
        model.addAttribute("empList",empService.getPage(map));
        return "emp/list";
    }

    @RequestMapping("tzAdd")
    public String tzAdd(){
        return "emp/add";
    }


    @RequestMapping("add")
    public String addEmp(@RequestParam Map map){
        System.out.println(map.get("ename"));
        System.out.println(map.get("job"));
        System.out.println(map.get("sal"));
        if (map!=null){
        int add = empService.add(map);

            return "redirect:list";
        }else {
            return "redirect:add";
        }


    }

    @RequestMapping("ByidList")
    public String ByidList(@RequestParam Map map,Model model){
        System.out.println(map.get("empno"));
        int pageNo=Integer.valueOf(map.get("pageNo")+"");
        if (map != null) {
            List<Map> mapList = empService.getByIdPage(map);
            for (Map map2:mapList) {
                System.out.println(map2.get("JOB"));
                model.addAttribute("pageNo",pageNo);
            }
            model.addAttribute("mapList",mapList);
            return "emp/update";
        }
        return "redirect:list";
    }

    @RequestMapping("update")
    public String update(@RequestParam Map map,Model model){
        int update = empService.update(map);
        return "redirect:list"+"?pageNo="+map.get("pageNo");
    }

    @RequestMapping("deleteFF")
    public String deleteFF(@RequestParam Map map){
        System.out.println(map.get("empno"));
        empService.delete(map);
        return "redirect:list"+"?pageNo="+map.get("pageNo");

    }
}
