package com.tiad.SchoolInfo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tiad.SchoolInfo.common.loggin.Logging;
import com.tiad.SchoolInfo.model.School;
import com.tiad.SchoolInfo.model.SchoolClass;
import com.tiad.SchoolInfo.service.SchoolService;
import com.tiad.SchoolInfo.validation.SchoolValidator;

@Controller()
@RequestMapping("/school")
public class SchoolController {
	@Logging(SchoolController.class)
	Logger logger;

	@Autowired
	private SchoolService schoolService;

	@Autowired
	//@Qualifier("schoolValidator")
	private SchoolValidator schoolValidator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(schoolValidator);
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String schoolListPage(Model model) {
		try {
			School[] schoolList = schoolService.findAllByOrderByName();
			model.addAttribute("schoolList", schoolList);
			return "school-list";
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String newSchoolPage(Model model) {
		model.addAttribute("school", new School());
		return "school-new";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String createNewSchool(@ModelAttribute @Valid School school,
			BindingResult result, Model model) {

		try {
			if (result.hasErrors())
				return "school-new";

			schoolService.create(school);
		
			School[] schoolList = schoolService.findAllByOrderByName();
			model.addAttribute("schoolList", schoolList);		
			return "redirect:/school/list";
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editSchoolPage(@PathVariable ObjectId id, Model model) {
		School school = schoolService.findById(id);
		model.addAttribute("school", school);
		return "school-edit";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public String editSchool(@ModelAttribute @Valid School school,
			BindingResult result, @PathVariable ObjectId id,
			Model model) {

		if (result.hasErrors())
			return "school-edit";
	
		schoolService.update(id, school);
		School[] schoolList = schoolService.findAllByOrderByName();
		model.addAttribute("schoolList", schoolList);
		return "redirect:/school/list";
	}
	
	@RequestMapping(value = "/edit/{id}/schoolClass", method = RequestMethod.GET)
	public String editSchoolClassPage(@PathVariable ObjectId id, Model model, HttpServletRequest request) {
		System.out.println("debug");
		List<SchoolClass> schoolClass = schoolService.findSchoolClassById(id);
		request.setAttribute("schoolClass", schoolClass);
		request.setAttribute("schoolId", id);
		return "redirect:/schoolClass/list";
		//return "schoolClass-list";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteSchool(@PathVariable ObjectId id, Model model) {

		schoolService.delete(id);
	
		School[] schoolList = schoolService.findAllByOrderByName();
		model.addAttribute("schoolList", schoolList);
		return "redirect:/school/list";
	}

}
