package com.example.Studentmanagment.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Studentmanagment.entity.Groupe;
import com.example.Studentmanagment.entity.Student;
import com.example.Studentmanagment.entity.Teacher;
import com.example.Studentmanagment.entity.TypeGroupes;
import com.example.Studentmanagment.repository.GroupeRepository;
import com.example.Studentmanagment.repository.StudentRepository;
import com.example.Studentmanagment.repository.TeacherRepository;

@Controller
public class TeacherController {
	
	@Autowired
	TeacherRepository teacherRepository;
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	GroupeRepository groupRepository;
	
	
	@GetMapping("/login")
	String login(){
		
		return "login";
	}
	
	
	@GetMapping("/")
	String connect(){
		
		return "index";
	}
	
	@GetMapping("/about")
	String about(){
		
		return "about";
	}
	
	@GetMapping("/post")
	String post(){
		
		return "post";
	}
	
	@GetMapping("/contact")
	String contact(){
		
		return "contact";
	}
	
	 @GetMapping("/logout")
	    public String logout() {
	        // Logique de déconnexion
	        return "/index";
	    }

	@RequestMapping("/connexion")
	 public String connexion(String username,String password,Model model) {
	 String error="error";
		if(username.equals("admin")) {
			if(password.equals("1234")) {
				model.addAttribute("students",studentRepository.findAll()); 
				model.addAttribute("isAdmin","yes"); 
				return "students2";}
			else {
				model.addAttribute("error",error); 
				return "login";
			}
		}
		else {
			
			  List<Teacher> teachers=teacherRepository.findAll();
			  for(Teacher t:teachers) {
				  if(t.getFirstName().equals(username)){
					  if(password.equals("1234")) {
						  model.addAttribute("students",studentRepository.findAll()); 
						  return "students";
							}
					  else {
							model.addAttribute("error",error); 
							return "login";
						}
					  }
				  }
			  }
		model.addAttribute("error",error); 
		return "login";
		
	 }
	
	@GetMapping("/teachers")
	String listOfTeacherss(Model model){
		model.addAttribute("teachers", teacherRepository.findAll());
		return "teachers";
	}
	
	@GetMapping("/teachers2")
	String listOfTeachers(Model model){
		model.addAttribute("teachers", teacherRepository.findAll());
		return "teachers2";
	}
	
	@GetMapping("/teachers/new")
	String createTeacherform(Model model) {
		Teacher teacher=new Teacher();
	model.addAttribute("teacher",teacher); 
	List<String> types=new ArrayList<String>();
	
	types.add("php");
	types.add("java");
	types.add("compilation");
	types.add("reseaux");
	types.add("uml");
	types.add("xml");
	types.add("algo");
	types.add("jee");
	model.addAttribute("types",types);
	return "create_teacher";
	}
	
	@PostMapping("/teachers")
	String createTeacher(@ModelAttribute("teacher") Teacher teacher) {
		teacherRepository.save(teacher);
		return "redirect:/teachers";
	}
	
	 @GetMapping("teachers/edit/{id}")
		String updateTeacher(@PathVariable Long id,Model model) {
			
		model.addAttribute("teacher",teacherRepository.findById(id).get());  	
		return "edit_teacher";
		} 
	 
	 @PostMapping("/teachers/{id}")
	 public String update(@PathVariable Long id,Model model, @ModelAttribute("teacher")Teacher teacher) {
		 Teacher exestingTeacher=teacherRepository.findById(id).get();
		        exestingTeacher.setId(id);
		        exestingTeacher.setFirstName(teacher.getFirstName()); 
		        exestingTeacher.setLastName(teacher.getLastName()); 
				exestingTeacher.setEmail(teacher.getEmail()); 
				exestingTeacher.setModule(teacher.getModule()); 
				
				teacherRepository.save(exestingTeacher);
	  return "redirect:/teachers";
	 }
	 
	 @GetMapping("/teachers/{id}")
	 String deleteTeacher(@PathVariable Long id) {
		 teacherRepository.deleteById(id);
		 return "redirect:/teachers";
	 }
	 
	 
	

		
		
		@GetMapping("/students")
		String listStudents(Model model) {
		model.addAttribute("students",studentRepository.findAll());  	
		return "students";
		}
		
		@GetMapping("/students2")
		String listStudents2(Model model) {
		model.addAttribute("students",studentRepository.findAll());  	
		return "students2";
		}
		
		@GetMapping("/students/new")
		String createStudentform(Model model) {
			Student student=new Student();
		model.addAttribute("student",student);  	
		return "create_student";
		}
		
		 @PostMapping("/students")
		 public String saveStudent(@ModelAttribute("student") Student student) {
			 studentRepository.save(student);
		  return "redirect:/students";
		 }
		 
		 
		 @GetMapping("students/edit/{id}")
			String updateStudent(@PathVariable Long id,Model model) {
				
			model.addAttribute("student",studentRepository.findById(id).get());  	
			return "edit_student";
			} 
		 
		 @PostMapping("/students/{id}")
		 public String update(@PathVariable Long id,Model model, @ModelAttribute("student")Student student) {
			 Student exestingStudent=studentRepository.findById(id).get();
			        exestingStudent.setId(id);
			        exestingStudent.setFirstName(student.getFirstName()); 
			        exestingStudent.setLastName(student.getLastName()); 
					exestingStudent.setEmail(student.getEmail()); 
					
					studentRepository.save(exestingStudent);
		  return "redirect:/students";
		 }
		 
		 @GetMapping("/students/{id}")
		 String deleteStudent(@PathVariable Long id) {
			 studentRepository.deleteById(id);
			 return "redirect:/students";
		 }
		 
		 
		 
		
			 
			@GetMapping("/groupes")
			String listGroupes(Model model){
				model.addAttribute("groupes",groupRepository.findAll());
				return "groupes";
			}
			
			@GetMapping("/groupes2")
			String listGroupes2(Model model){
				model.addAttribute("groupes",groupRepository.findAll());
				return "groupes2";
			}
			
			
			@GetMapping("/groupes/new")
			String createGroupeForm(Model model,Groupe groupe) {
				
				List<String> types=new ArrayList<String>();
				
				types.add("A01");
				types.add("A02");
				types.add("A03");
				types.add("A04");
				types.add("B01");
				types.add("B02");
				types.add("B03");
				types.add("B04");
				model.addAttribute("teachAvailable",teacherRepository.findAll());
				model.addAttribute("types",types);
				return "create_groupe";
			}
			
			
			@PostMapping("/groupes")
			String create_group(@ModelAttribute("groupe") Groupe groupe) {
				groupRepository.save(groupe);
				return "redirect:/groupes";
			}
			
			 @GetMapping("groupes/edit/{id}")
				String updateStudent(@PathVariable TypeGroupes id,Model model) {
					
				model.addAttribute("groupe",groupRepository.findById(id).get()); 
				model.addAttribute("teachAvailable",teacherRepository.findAll());
				return "edit_groupe";
				} 
			 
			 @PostMapping("/groupes/{id}")
			 public String update(@PathVariable TypeGroupes id,Model model, @ModelAttribute("groupe")Groupe groupe) {
				 Groupe exestingGroupe=groupRepository.findById(id).get();
				        exestingGroupe.setName(id);
				        exestingGroupe.setCapacity(groupe.getCapacity()); 
				        exestingGroupe.setTeacher(groupe.getTeacher()); 
				        groupRepository.save(exestingGroupe);
			  return "redirect:/groupes";
			 }
			 
			 @GetMapping("/groupes/{id}")
			 String deleteStudent(@PathVariable TypeGroupes id) {
				 groupRepository.deleteById(id);
				 return "redirect:/groupes";
			 }
			 
			 
			 
			
			
			
}
