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

import br.com.gabriel.model.Course;
import br.com.gabriel.repository.CourseRepository;
import br.com.gabriel.repository.SubjectRepository;

@Controller
public class CourseController {

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private SubjectRepository subjectRepository;

	@GetMapping("/course")
	public String course(Model model) {
		List<Course> courses = courseRepository.findAll();

		model.addAttribute("courses", courses);

		return "course/course";
	}

	@GetMapping("/course/add_course_form")
	public String addCourseForm(Course course, Model model) {

		model.addAttribute("subjects", subjectRepository.findAll());

		return "course/add_course_form";
	}

	@PostMapping("/course/add_course")
	public String addCourse(@Valid Course course, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "course/add_course_form";
		}

		courseRepository.save(course);

		return "redirect:/course";
	}

	@RequestMapping(path = "/course/update_course/{id}", method = { RequestMethod.GET, RequestMethod.PUT })
	public String update(@PathVariable("id") long id, @Valid Course course, BindingResult result, Model model) {
		if (result.hasErrors()) {

			course.setCourseId(id);

			model.addAttribute("subjects", subjectRepository.findAll());

			return "course/update_course_form";

		}

		courseRepository.save(course);

		return "redirect:/course";
	}

	@GetMapping("/course/delete_course/{id}")
	public String delete(@PathVariable("id") long id) {
		courseRepository.deleteById(id);

		return "redirect:/course";
	}

}
