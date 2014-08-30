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

	List<Product> products = new ArrayList<Product>();

	// @Autowired
	public HomeController() {
	}

	// Home
	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String home(Model model) {
		return "home";
	}

	@RequestMapping(value = "aboutUs", method = RequestMethod.GET)
	public String aboutUs(Model model) {
		return "aboutUs";
	}

	@RequestMapping(value = "/userRegistration", method = RequestMethod.POST)
	public String userRegistration(
			@RequestParam(value = "id[]", required = true) String[] idSelected,
			Model model) {

		return "userRegistration";
	}

	// Le categorie sono hard coded.
	@RequestMapping(value = "/category", method = RequestMethod.GET)
	public String categ(Model model) {
		return "category";
	}

	// Le sottocategorie sono hard coded.
	@RequestMapping(value = "/subcategory", method = RequestMethod.GET)
	public String subcateg(Model model) {
		return "subcategory";
	}

	// Prodotti di una categoria
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public String products(Model model) {

		products = new ArrayList<Product>();

		// Tirar fuori products dal db

		// Su quante pagine disponiamo n prodotti?

		model.addAttribute("products", products);
		return "products";
	}

	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public String product(Model model, @RequestParam(value = "i") int i) {

		// ...
		model.addAttribute("product", products.get(i));
		return "product";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
		return "login";
	}
	
	@RequestMapping(value = "/buy", method = RequestMethod.GET)
	public String buy(Model model) {
		return "buy";
	}

}
