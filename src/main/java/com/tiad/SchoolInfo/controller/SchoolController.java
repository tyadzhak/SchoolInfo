package com.tiad.SchoolInfo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tiad.SchoolInfo.model.School;
import com.tiad.SchoolInfo.service.SchoolService;

@Controller
@RequestMapping("/school")
public class SchoolController {
	
	@Autowired
	private SchoolService schoolService;
	

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String newSchoolPage(Model model) {
		model.addAttribute("newSchool", new School());
		return "school-new";
	}
/*
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createNewSchool(
			@ModelAttribute @Valid SchoolEntity school, BindingResult result,
			final RedirectAttributes redirectAttributes) {

		if (result.hasErrors())
			return new ModelAndView("school-new");

		ModelAndView mav = new ModelAndView();
		String message = "New school " + school.getName()
				+ " was successfully created.";

		schoolService.create(school);
		mav.setViewName("redirect:/index.html");

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView schoolListPage() {
		ModelAndView mav = new ModelAndView("school-list");
		SchoolEntity[] schoolList = schoolService.findAll();
		mav.addObject("schoolList", schoolList);
		return mav;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editSchoolPage(@PathVariable Long id) {
		ModelAndView mav = new ModelAndView("school-edit");
		SchoolEntity school = schoolService.findById(id);
		mav.addObject("school", school);
		return mav;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public ModelAndView editSchool(@ModelAttribute @Valid SchoolEntity school,
			BindingResult result, @PathVariable Integer id,
			final RedirectAttributes redirectAttributes) {

		if (result.hasErrors())
			return new ModelAndView("school-edit");

		ModelAndView mav = new ModelAndView("redirect:/index.html");
		String message = "School was successfully updated.";

		schoolService.update(school);

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteSchool(@PathVariable Long id,
			final RedirectAttributes redirectAttributes) {

		ModelAndView mav = new ModelAndView("redirect:/index.html");

		SchoolEntity school = schoolService.delete(id);
		String message = "The school " + school.getName()
				+ " was successfully deleted.";

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}
	 */
}
