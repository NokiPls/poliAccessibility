package org.springframework.social.quickstart;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.access.domain.Product;

/**
 * The main controller for the application.
 * 
 */

@Controller
@ComponentScan("com.access.services")
public class HomeController {

	// @Autowired
	public HomeController() {
	}

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String home(Model model) {
		return "home";
	}

	@RequestMapping(value = "aboutUs", method = RequestMethod.GET)
	public String aboutUs(Model model) {
		return "aboutUs";
	}

	@RequestMapping(value = "/userRegistration", method = RequestMethod.POST)
	public String commonFriendsList(
			@RequestParam(value = "id[]", required = true) String[] idSelected,
			Model model) {

		return "commonFriendsList";
	}

	@RequestMapping(value = "/categ", method = RequestMethod.GET)
	public String categ(Model model) {
		List<Product> products = new ArrayList<Product>();
		
		model.addAttribute("products", products);
		return "categ";
	}
	
	@RequestMapping(value = "/graphNode", method = RequestMethod.GET)
	public String graphNode(Model model, @RequestParam(value = "id") String id) {

		return "nodePopUp";
	}

}
