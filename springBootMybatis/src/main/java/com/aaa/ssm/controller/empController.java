package com.aaa.ssm.controller;

import com.aaa.ssm.entitys.Emp;
import com.aaa.ssm.service.EmpService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
public class empController {



    @Autowired
    private EmpService empService;

    @Value("${upload.path}")
    private String filePath;

    private ResourceLoader resourceLoader;

    @Autowired
    public empController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    /**
     * 跳转emplist
     * @return
     */
    @RequestMapping("gotoEmpList.do")
    public String gotoEmpList(){
        return "empList";
    }

    /**
     * 跳转登录页面
     * @return
     */
    @RequestMapping("toLogin")
    public String toLogin(){
        return "userLogin";
    }




    @RequestMapping("Login")
    public String Login(@RequestParam Map map,HttpServletRequest request){
        List<Map> con = empService.userLogin(map);

        HttpSession session = request.getSession();
        if (con!=null&&con.size()>0) {
            session.setAttribute("user", map.get("username"));
            return "empList";
        }else{
            session.setAttribute("ts", "用户名密码不正确");
            return "userLogin";
        }
    }

    @ResponseBody
    @RequestMapping("getlist")
    public Object getList(@RequestParam Map map){
        return  empService.getList(map);
    }

    @ResponseBody
    @RequestMapping("empAddSS")
    public Object empAdd(@RequestBody Emp emp){
        return empService.addEmp(emp);
    }

    @ResponseBody
    @RequestMapping("empDeleteSS")
    public Object empDelete(@RequestBody int empNo){

        System.out.println(empNo);
        return empService.deleteEmp(empNo);
    }

    @ResponseBody
    @RequestMapping("ByidgetListSS")
    public Object ByidgetList(@RequestBody int newsid){

        List<Emp> emps = empService.byIdgetList(newsid);

       return emps;
    }

    @ResponseBody
    @RequestMapping("RequestBodySS")
    public Object update(@RequestBody Emp emp){
        return empService.empUpdate(emp);
    }


    /**
     * 跳转上转页面
     * @return
     */
    @RequestMapping("toUpload.do")
    public String toUpload(){
        return "upload";
    }



    /**
     * 上传方法
     * @param filePic
     * @return
     */
    @RequestMapping("picUpload")
    public String picUpload(Emp emp, @RequestParam MultipartFile filePic){
        String originalFilename = filePic.getOriginalFilename();
        String substring = originalFilename.substring(originalFilename.lastIndexOf("."));
        String newFileName = UUID.randomUUID() + substring;
        File file = new File(filePath,newFileName);
        try {
            filePic.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "empList";
    }

    @RequestMapping("show")
    public ResponseEntity show(String fileName){
        try {
            // 由于是读取本机的文件，file是一定要加上的， path是在application配置文件中的路径
            return ResponseEntity.ok(resourceLoader.getResource("file:" + filePath + fileName));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }

    }


    @ResponseBody
    @RequestMapping("listTS")
    public Object listTS(HttpServletRequest request){

        Map map = new  HashMap();
        HttpSession session = request.getSession();
        String user=(String) request.getSession().getAttribute("user");
        map.put("user",user);
        return map;
    }

    @ResponseBody
    @RequestMapping("listTS2")
    public Object listTS2(HttpServletRequest request){
        System.out.println("进入方法");
        Map map = new  HashMap();
        HttpSession session = request.getSession();
        String ts=(String) request.getSession().getAttribute("ts");
        String user=(String) request.getSession().getAttribute("user");
        System.out.println(user);
        if (user==null) {
            map.put("ts", ts);
        }
        return map;
    }


    /**
     * 调用存储过程返回列表，根据部门编号返回列表
     * @param deptNo
     * @return
     */
    @ResponseBody
    @RequestMapping("proList")
    public Object getProListByDeptNo(Integer deptNo){
        return empService.getProListByDeptNo(deptNo);
    }

    @ResponseBody
    @RequestMapping("addId")
    public Object addId(@RequestBody Map map){
        int add=empService.addId(map);

        return add;
    }
}
