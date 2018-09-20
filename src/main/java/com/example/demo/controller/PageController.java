package com.example.demo.controller;


import java.util.Optional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class PageController {
	
	@RequestMapping("/generator")
	public String generator(@RequestParam(value = "a", required = false, defaultValue="0") String a, 
			@RequestParam(value = "b", required = false, defaultValue="0") String b, Model model) {
		
			String base = "hm";
			
			model.addAttribute("a",a);
			model.addAttribute("b",b);
			
			
			int num_a = Integer.parseInt(a);
			int num_b = Integer.parseInt(b);
			
			if((num_a == 0 && num_b == 0) || (num_a == 0 && num_b == 1) || (num_a == 1 && num_b == 0) || (num_a == 1 && num_b == 1)) {
				model.addAttribute("hasil",base);
			}
			
			else {
				
			for (int i = 1; i < num_a; i++) {
				base += "m";
			}
			
			String hasil ="";
			
			if(num_b<1) {
				num_b=1;
			}
			
			for (int i = 0; i < num_b; i++) {
				hasil += base;
				hasil += " ";
			}
			
			model.addAttribute("hasil",hasil);
			
			}
			
		return "generator";
	}
	
	@RequestMapping("/viral")
	public String index() {
		return "viral";
	}
	
	@RequestMapping("/challenge")
	public String challenge(@RequestParam(value = "name") String name, Model model) {
		model.addAttribute("name",name);
		return "challenge";
	}
	
	@RequestMapping(value= {"/challenge","challenge/{name}"})
	public String challengePath(@PathVariable Optional<String> name, Model model) {
		if (name.isPresent()) {
			model.addAttribute("name", name.get());
		}else{
			model.addAttribute("name", "KB");
		}
		return "challenge";
	}

}