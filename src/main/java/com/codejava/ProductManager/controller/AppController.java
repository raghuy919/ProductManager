
package com.codejava.ProductManager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.codejava.ProductManager.model.domain.Product;
import com.codejava.ProductManager.service.ProductService;

@Controller
public class AppController {
	
	@Autowired
	private ProductService service;
		
	@RequestMapping("/")
	public String viewHomepage(Model model) {
		List<Product>lisProducts=service.listAll();
		model.addAttribute("ListProduct", lisProducts);
		return "index";
	}
	@RequestMapping("/new")
	public String showNewProductForm(Model model) {
		Product product=new Product();
		model.addAttribute("product", product);
		return "new_product";
	}
	//@RequestMapping(value="/save",method=RequestMethod.POST)
	@PostMapping(value ="/save")
	public String saveProduct(@ModelAttribute("product")Product product) {
		service.save(product);
		return "redirect:/";
	}
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditProductForm(@PathVariable(name="id")Long id) {
		ModelAndView mav=new ModelAndView("edit_product");
		Product product=service.get(id);
		mav.addObject("product", product); 
		System.out.println("hello");
		return mav;
	}
	
	@GetMapping(value ="/delete/{id}")
	public String deleteProduct(@PathVariable(name="id")Long id) {
		service.delete(id);
		System.out.println("deleted");
		return "redirect:/";
	}
}
