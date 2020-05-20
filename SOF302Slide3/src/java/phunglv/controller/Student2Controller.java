package phunglv.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import phunglv.bean.Major;
import phunglv.bean.Student;

@Controller
@RequestMapping("/student2/")
public class Student2Controller {
	
	@RequestMapping("edit")
	public String edit(ModelMap model) {
		Student sv = new Student("Nguyễn Thị Tám", 8.3, "WEB");
		model.addAttribute("student", sv);
		return "student2";
	}
	
	@RequestMapping("update")
	public String update(@ModelAttribute("student") Student student) {
		return "student2";
	}
	
	@ModelAttribute("majors")
	public List<Major> getMajors() {
		List<Major> majors = new ArrayList<>();
		majors.add(new Major("APP", "Ứng dụng phần mềm"));
		majors.add(new Major("WEB", "Thiết kế trang web"));
                majors.add(new Major("DH", "Do hoa"));
                majors.add(new Major("KS", "Nha hang khach san"));
                majors.add(new Major("AR", "Android"));
		return majors;
	}

	/*
	 * Xử dụng mảng
	 *	
	*/
//	@ModelAttribute("majors")
//	public String[] getMajors() {
//		String[] majors = {
//				"Ứng dụng phần mềm",
//				"Thiết kế trang web",
//                                "Thiet Ke Do Hoa",
//                                "Ke Toan"
//                                                         
//		};
//		return majors;
//	}
	/*
	 * Xử dụng List<String>
	 **/
//	@ModelAttribute("majors")
//	public List<String> getMajors() {
//		List<String> majors = new ArrayList<>();
//		majors.add("Ứng dụng phần mềm");
//		majors.add("Thiết kế trang web");
//		return majors;
//	}
//	
	
	/*
	 * Xử dụng Map<String, String>
	 *
	*/
//        @ModelAttribute("majors")
//	public Map<String, String> getMajors() {
//		Map<String, String> majors = new HashMap<>();
//		majors.put("APP", "Ứng dụng phần mềm");
//		majors.put("WEB", "Thiết kế trang web");
//                majors.put("ANDROID", "laptrinh di dong");
//		return majors;
//	}
}
