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

import br.com.gabriel.model.Teacher;
import br.com.gabriel.repository.TeacherRepository;

@Controller
public class TeacherController {

	@Autowired
	private TeacherRepository teacherRepository;
	
	
	@GetMapping("/teacher")
	public String teacher(Model model) {
		List<Teacher> teachers = teacherRepository.findAll();

		model.addAttribute("teachers", teachers);

		return "teacher/teacher";
	}
	
	@GetMapping("/teacher/add_teacher_form")
	public String addTeacherForm(Teacher teacher) {
		return "teacher/add_teacher_form";
	}

	@PostMapping("/teacher/add_teacher")
	public String addTeacher(@Valid Teacher teacher, BindingResult result) {
		if (result.hasErrors()) {
			return "teacher/add_teacher_form";
		}

		teacherRepository.save(teacher);

		return "redirect:/teacher";
	}
	
	@RequestMapping(path = "/teacher/update_teacher/{id}", method = {RequestMethod.GET, RequestMethod.PUT})
	public String update(@PathVariable("id") long id, @Valid Teacher teacher, BindingResult result, Model model) {
		if (result.hasErrors()) {

			teacher.setTeacherId(id);
			
			model.addAttribute("teacher", teacher);
						
			return "teacher/update_teacher_form";

		}

		teacherRepository.save(teacher);

		return "redirect:/teacher";
	}

	@GetMapping("/teacher/delete_teacher/{id}")
	public String delete(@PathVariable("id") long id) {
		teacherRepository.deleteById(id);

		return "redirect:/teacher";
	}
	
}
