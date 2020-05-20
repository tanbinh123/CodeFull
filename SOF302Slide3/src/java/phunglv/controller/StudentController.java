package phunglv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import phunglv.bean.Student;

@Controller
@RequestMapping("/student/")
public class StudentController {	
	@RequestMapping("edit")
	public String edit(ModelMap model) {
		Student sv = new Student("Ng Thi Gai", 9.5, "APP");
		model.addAttribute("student", sv);
		return "student";
	}
	
	@RequestMapping("update")
	public String update(@ModelAttribute("student") Student student) {
                System.out.println("Hoten: "+student.getName());
                System.out.println("Diem: "+student.getMark());
                System.out.println("Chuyen nganh: "+student.getMajor());
		return "student";
	}
}
