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
import com.tiad.SchoolInfo.model.SchoolClass;
import com.tiad.SchoolInfo.service.SchoolClassService;
import com.tiad.SchoolInfo.validation.SchoolClassValidator;

@Controller
@RequestMapping("/schoolClass")
public class SchoolClassController {
	@Logging(SchoolClassController.class)
	Logger logger;

	@Autowired
	private SchoolClassService schoolClassService;

	@Autowired
	//@Qualifier("schoolClassValidator")
	private SchoolClassValidator schoolClassValidator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(schoolClassValidator);
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String schoolClassListPage(Model model) {
		try {
			SchoolClass[] schoolClassList = schoolClassService.findAllByOrderByName();
			model.addAttribute("schoolClassList", schoolClassList);
			return "schoolClass-list";
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String newSchoolClassPage(Model model) {
		model.addAttribute("schoolClass", new SchoolClass());
		return "schoolClass-new";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String createNewSchoolClass(@ModelAttribute @Valid SchoolClass schoolClass,
			BindingResult result, Model model) {

		try {
			if (result.hasErrors())
				return "schoolClass-new";

			schoolClassService.create(schoolClass);
		
			SchoolClass[] schoolClassList = schoolClassService.findAllByOrderByName();
			model.addAttribute("schoolClassList", schoolClassList);		
			return "redirect:/schoolClass/list";
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}

	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editSchoolClassPage(@PathVariable ObjectId id, Model model) {
		SchoolClass schoolClass = schoolClassService.findById(id);
		model.addAttribute("schoolClass", schoolClass);
		return "schoolClass-edit";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public String editSchoolClass(@ModelAttribute @Valid SchoolClass schoolClass,
			BindingResult result, @PathVariable ObjectId id,
			Model model) {

		if (result.hasErrors())
			return "schoolClass-edit";
	
		schoolClassService.update(id, schoolClass);
		SchoolClass[] schoolClassList = schoolClassService.findAllByOrderByName();
		model.addAttribute("schoolClassList", schoolClassList);
		return "redirect:/schoolClass/list";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteSchoolClass(@PathVariable ObjectId id, Model model) {

		schoolClassService.delete(id);
	
		SchoolClass[] schoolClassList = schoolClassService.findAllByOrderByName();
		model.addAttribute("schoolClassList", schoolClassList);
		return "redirect:/schoolClass/list";
	}
}
