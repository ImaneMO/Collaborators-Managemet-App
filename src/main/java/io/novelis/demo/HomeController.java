package io.novelis.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import io.novelis.demo.service.CollaboratorService;


@Controller
public class HomeController {
	
	@Autowired
	CollaboratorService collaboratorService;
	
	
	
	public HomeController(CollaboratorService collaboratorService) {
		this.collaboratorService = collaboratorService;
	}

	@RequestMapping("/list")
	public String showCollabs() {
		return "collaboratorsList";
	}
	
	@RequestMapping("/details/{id}")
	public ModelAndView showSpecificCollab(@PathVariable int id) {
		
		 ModelAndView modelAndView = new ModelAndView("informations");
		    modelAndView.addObject("id", id);
		
		return modelAndView;
	}
	
	@GetMapping("/add")
    public String showAddForm() {
        return "add";
    }
	
//	//Form
//	@RequestMapping("/Collaborators/Add")
//	public String addCollab() {
//		return "add";
//	}
//	
	//Home
	@RequestMapping("/home")
	public String homeRedirect() {
		return "home";
	}
	
//	@GetMapping("/edit/{id}")
//	public String showUpdateForm(@PathVariable("id") long id, Model model) {
//	    Controller controller = controllerRepository.findByID(id)
//	      .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
//	     
//	    model.addAttribute("collab", collaborator);
//	    return "update-user";
//	}
	
//	@PostMapping("/update/{id}")
//	public String updateCollaborator(@PathVariable("id") long id, @Valid Collaborator collaborator, 
//	  BindingResult result, Model model) {
//	    if (result.hasErrors()) {
//	        user.setId(id);
//	        return "update-user";
//	    }
//	         
//	    userRepository.save(collaborator);
//	    model.addAttribute("users", collaboratorRepository.findAll());
//	    return "index";
//	}

}
