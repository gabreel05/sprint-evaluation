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

import br.com.gabriel.model.Subject;
import br.com.gabriel.repository.SubjectRepository;

@Controller
public class SubjectController {

	@Autowired
	private SubjectRepository subjectRepository;
	
	@GetMapping("/subject")
	public String subject(Model model) {
		List<Subject> subjects = subjectRepository.findAll();
		
		model.addAttribute("subjects", subjects);
		model.addAttribute("message", "Hello World");
		
		return "subject/subject";
	}
	
	@GetMapping("/subject/add_subject_form")
	public String addSubjectForm(Subject subject) {
		return "subject/add_subject_form";
	}

	@PostMapping("/subject/add_subject")
	public String addSubject(@Valid Subject subject, BindingResult result) {
		if (result.hasErrors()) {
			return "subject/add_subject_form";
		}

		subjectRepository.save(subject);

		return "redirect:/subject";
	}

	@RequestMapping(path = "/subject/update_subject/{id}", method = {RequestMethod.GET, RequestMethod.PUT})
	public String update(@PathVariable("id") long id, @Valid Subject subject, BindingResult result, Model model) {
		if (result.hasErrors()) {

			subject.setSubjectId(id);
			
			model.addAttribute("subject", subject);
						
			return "subject/update_subject_form";

		}

		subjectRepository.save(subject);

		return "redirect:/subject";
	}

	@GetMapping("/subject/delete_subject/{id}")
	public String delete(@PathVariable("id") long id) {
		subjectRepository.deleteById(id);

		return "redirect:/subject";
	}
	
}
