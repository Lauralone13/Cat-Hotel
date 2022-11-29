package com.lauralone.cathotel.controller;

import com.lauralone.cathotel.entity.Cat;
import com.lauralone.cathotel.repository.CatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/cat")
public class CatController {

	@Autowired
	private CatRepository catRepository;

	@RequestMapping("/home")
	public String home(Model model) {
		model.addAttribute("appName", "A great place for cats to find love and safety.");
		return "home";
	}

	@RequestMapping("/display")
	public String displayCatInfo(Model model) {
		List<Cat> cats = getAllCats();

		model.addAttribute("cats", cats);
		model.addAttribute("msg", "Here is an overview of our lovely guests and family members.");

		return "displayCatInfo";
	}

	@RequestMapping("/edit")
	public String editCatInfo(@ModelAttribute Cat cat, Model model) {
		catRepository.save(cat);

		List<Cat> cats = getAllCats();

		model.addAttribute("cats", cats);
		model.addAttribute("msg", "Cat has been edited successfully.");

		return "displayCatInfo";
	}

	@PostMapping("/add")
	public String addNewCat(@ModelAttribute Cat cat, Model model) {

		catRepository.save(cat);
		List<Cat> cats = getAllCats();
		model.addAttribute("cats", cats);
		model.addAttribute("msg", "Cat has been added successfully.");

		return "displayCatInfo";
	}

	@GetMapping("/editForm/{id}")
	public String editForm(@PathVariable String id, Model model) {

		Optional<Cat> oCat = catRepository.findById(Integer.parseInt(id));
		if (oCat.isEmpty()) {
			return "Id not found, please check again.";
		}

		Cat cat = oCat.get();
		model.addAttribute("cat", cat);

		return "editCat";
	}

	@GetMapping("/addForm")
	public String addForm() {
		return "addCat";
	}

	private List<Cat> getAllCats() {
		return (List<Cat>) catRepository.findAll();
	}
}
