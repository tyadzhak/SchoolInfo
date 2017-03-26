package com.tiad.SchoolInfo.controller;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tiad.SchoolInfo.common.loggin.Logging;
import com.tiad.SchoolInfo.model.Subject;
import com.tiad.SchoolInfo.service.SubjectService;
import com.tiad.SchoolInfo.validation.SubjectValidator;

@Controller
@RequestMapping("/subject")
public class SubjectController {
	@Logging(SubjectController.class)
	Logger logger;

	@Autowired
	private SubjectService subjectService;

	@Autowired
	//@Qualifier("subjectValidator")
	private SubjectValidator subjectValidator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(subjectValidator);
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String subjectListPage(Model model) {
		try {
			Subject[] subjectList = subjectService.findAllByOrderByName();
			model.addAttribute("subjectList", subjectList);
			return "subject-list";
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String newSubjectPage(Model model) {
		model.addAttribute("subject", new Subject());
		return "subject-new";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String createNewSubject(@ModelAttribute @Valid Subject subject,
			BindingResult result, Model model) {

		try {
			if (result.hasErrors())
				return "subject-new";

			subjectService.create(subject);
		
			Subject[] subjectList = subjectService.findAllByOrderByName();
			model.addAttribute("subjectList", subjectList);		
			return "redirect:/subject/list";
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}

	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editSubjectPage(@PathVariable ObjectId id, Model model) {
		Subject subject = subjectService.findById(id);
		model.addAttribute("subject", subject);
		return "subject-edit";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public String editSubject(@ModelAttribute @Valid Subject subject,
			BindingResult result, @PathVariable ObjectId id,
			Model model) {

		if (result.hasErrors())
			return "subject-edit";
	
		subjectService.update(id, subject);
		Subject[] subjectList = subjectService.findAllByOrderByName();
		model.addAttribute("subjectList", subjectList);
		return "redirect:/subject/list";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteSubject(@PathVariable ObjectId id, Model model) {

		subjectService.delete(id);
	
		Subject[] subjectList = subjectService.findAllByOrderByName();
		model.addAttribute("subjectList", subjectList);
		return "redirect:/subject/list";
	}
}
