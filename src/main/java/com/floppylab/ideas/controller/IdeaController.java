package com.floppylab.ideas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.floppylab.ideas.dto.IdeaDto;
import com.floppylab.ideas.entity.Idea;
import com.floppylab.ideas.helper.IdeaType;
import com.floppylab.ideas.service.IdeaService;

@Controller
public class IdeaController {

	@Autowired
	private IdeaService ideaService;
	
	/*--------------------------- GET ---------------------------*/

	@GetMapping("/")
	public String listIdeas(Model model, @RequestParam(name="page", required=false) Integer page) {
		Page<Idea> ideas = ideaService.getIdeas(page);
	    model.addAttribute("ideas", ideas);
        return "view-ideas";
	}
	
	@GetMapping("/{id}")
	public String viewIdea(Model model, @PathVariable("id") Long id) {
		Idea idea = ideaService.getIdea(id);
	    model.addAttribute("idea", idea);
        return "view-idea"; 
	}
	
	@GetMapping("/add")
    public String addIdea(Model model) {
		model.addAttribute("types", IdeaType.values());
		return "add";
	}
	
	@GetMapping("/edit/{id}")
	public String editIdea(Model model, @PathVariable("id") Long id) {
		Idea idea = ideaService.getIdea(id);
	    model.addAttribute("idea", idea);
	    model.addAttribute("types", IdeaType.values());
        return "form-idea";
	}
	
	/*--------------------------- POST ---------------------------*/
	
	@PostMapping("/")
    public String addIdea(Model model, @RequestParam IdeaDto idea) {
		ideaService.saveIdea(idea);		
		return "redirect:/" + idea.getId();
	}
	
	/*--------------------------- PUT ---------------------------*/
	
	@PutMapping("/")
	public String editIdea(Model model, @RequestParam IdeaDto idea) {
		ideaService.modifyIdea(idea);		
		return "redirect:/" + idea.getId();
	}	
	
	/*-------------------------- DELETE ---------------------------*/
	
	@DeleteMapping("/")
	public String deleteAll() {
		ideaService.deleteAll();
		return "redirect:/";
	}
	
	@DeleteMapping("/{id}")
	public String deleteIdea(@PathVariable("id") Long id) {
		ideaService.delete(id);
		return "redirect:/";
	}
	
}
