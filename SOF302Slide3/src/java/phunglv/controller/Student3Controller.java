/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phunglv.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import phunglv.bean.Student;
import phunglv.model.Student3Model;

/**
 *
 * @author Administrator
 */
@Controller
@RequestMapping("/student3")
public class Student3Controller {
    @RequestMapping("showall")
    public String showAll(ModelMap model){
        Student3Model st = new Student3Model();
        List<Student> list = new ArrayList<Student>();
        list = st.showStudent("");
        model.addAttribute("listStudent", list);
        
        Student sv = new Student();
        sv = list.get(0);
        model.addAttribute("student", sv);
        return "student3";
    }
    
    @RequestMapping("edit")
    public String edit(HttpServletRequest request, ModelMap model){
        int masv = Integer.parseInt(request.getParameter("txtMasv"));
        String name = request.getParameter("txtName");
        double mark = Double.parseDouble(request.getParameter("txtMark"));
        String major = request.getParameter("txtMajor");
        Student sv = new Student(masv, name, mark, major);
        model.addAttribute("student", sv);
        
        List<Student> list = new ArrayList<Student>();
        list = Student3Model.showStudent("");
        model.addAttribute("listStudent", list);
        return "student3";
    }       
    
    @RequestMapping("delete")
    public String delete(HttpServletRequest request, ModelMap model, 
            @ModelAttribute("student") Student student){
        int masv = Integer.parseInt(request.getParameter("txtMasv"));
        Student3Model.delete(masv);
        
        List<Student> list = new ArrayList<Student>();
        list = Student3Model.showStudent("");
        model.addAttribute("listStudent", list);
        return "student3";
    }
    @RequestMapping(params="btnUpdate")
    public String update(@ModelAttribute("student") Student student, ModelMap model) {       
        Student3Model.update(student);
        
        List<Student> list = new ArrayList<Student>();
        list = Student3Model.showStudent("");
        model.addAttribute("listStudent", list);
        return "student3";
    }   
    @RequestMapping(params="btnInsert")
    public String insert(@ModelAttribute("student") Student student, ModelMap model){
        Student3Model.insert(student);
        
        List<Student> list = new ArrayList<Student>();
        list = Student3Model.showStudent("");
        model.addAttribute("listStudent", list);
        return "student3";
    }
}
