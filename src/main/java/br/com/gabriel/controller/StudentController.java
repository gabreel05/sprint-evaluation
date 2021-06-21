package br.com.gabriel.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.gabriel.model.Student;
import br.com.gabriel.repository.StudentRepository;
import br.com.gabriel.repository.TeacherRepository;
import br.com.gabriel.repository.TeamRepository;

@Controller
public class StudentController {

	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private TeacherRepository teacherRepository;
	
	@Autowired
	private TeamRepository teamRepository;


	@GetMapping("/student")
	public String student(Model model) {
		List<Student> students = studentRepository.findAll();

		model.addAttribute("students", students);

		return "student/student";
	}

	@GetMapping("/student/add_student_form")
	public String addStudentForm(Student student, Model model) {
		
		model.addAttribute("teachers", teacherRepository.findAll());
		
		model.addAttribute("teams", teamRepository.findAll());

		
		return "student/add_student_form";
	}

	@PostMapping("/student/add_student")
	public String addStudent(@Valid Student student, BindingResult result) {
		if (result.hasErrors()) {
			return "student/add_student_form";
		}

		studentRepository.save(student);

		return "redirect:/student";
	}

	@RequestMapping(path = "/student/update_student/{id}", method = { RequestMethod.GET, RequestMethod.PUT })
	public String update(@PathVariable("id") long id, @Valid Student student, BindingResult result, Model model) {
		if (result.hasErrors()) {

			student.setStudentId(id);
			
			model.addAttribute("teachers", teacherRepository.findAll());
			
			model.addAttribute("teams", teamRepository.findAll());


			return "student/update_student_form";

		}

		studentRepository.save(student);

		return "redirect:/student";
	}

	@GetMapping("/student/delete_student/{id}")
	public String delete(@PathVariable("id") long id) {
		studentRepository.deleteById(id);

		return "redirect:/student";
	}

}
