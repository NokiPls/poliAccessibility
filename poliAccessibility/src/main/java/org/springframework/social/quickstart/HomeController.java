package org.springframework.social.quickstart;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.access.domain.Product;
import com.access.domain.Person;
import com.access.services.ProductsFinderInterface;
import com.access.services.UserManagerInterface;

/**
 * The main controller for the application.
 * 
 */

@Controller
@ComponentScan("com.access.services")
public class HomeController {

	private List<Product> products = new ArrayList<Product>();
	private UserManagerInterface um;
	private ProductsFinderInterface pf;

	@Autowired
	public HomeController(UserManagerInterface um, ProductsFinderInterface pf) {
		this.um = um;
		this.pf = pf;
		this.pf.init();
	}

	// Home
	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String home(Model model) {
		return "home";
	}

	@RequestMapping(value = "/aboutUs", method = RequestMethod.GET)
	public String aboutUs(Model model) {
		return "aboutUs";
	}

	@RequestMapping(value = "/userRegistration", method = RequestMethod.GET)
	public String showForm(Model model) {
		model.addAttribute("personForm", new Person());
		return "registration";
	}

	@RequestMapping(value = "/addPerson", method = RequestMethod.POST)
	public String savePersonPost(@Valid @ModelAttribute Person personForm,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("personForm", new Person());
			return "registration";
		}
		if (um.getUserByUserName(personForm.getUserName()) == null) {
			um.saveUser(personForm);
		} else {
			System.out.println("Duplicate userName found !!!");
		}
		model.addAttribute("personForm", new Person());
		return "registration";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
		model.addAttribute("personForm", new Person());
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute Person personForm,
			BindingResult result, Model model) {

		Person p = um.getUserByUserName(personForm.getUserName());
		if (p == null) {
			System.out.println("User not found");
		} else {
			if (p.getPassw().equals(personForm.getPassw())) {
				System.out.println("Peeeeeeeeeeeeeeeerifetto!!");
			} else {
				System.out.println("Password Errata");
			}
		}
		model.addAttribute("personForm", new Person());
		return "login";
	}

	// Le categorie sono hard coded nel jsp.
	@RequestMapping(value = "/category", method = RequestMethod.GET)
	public String categ(Model model,
			@RequestParam(value = "category") String category) {
		products = new ArrayList<Product>();
		products = pf.findProductsByCategory(category);
		model.addAttribute("product", products);
		model.addAttribute("categ", category);
		return "category";
	}

	// Prodotti di una categoria
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public String products(Model model, @RequestParam(value = "type") String type) {

		products = new ArrayList<Product>();
		products = pf.findProductsByType(type);

		model.addAttribute("type", type);
		model.addAttribute("product", products);
		return "products";
	}

	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public String product(Model model, @RequestParam(value = "i") int i) {
		model.addAttribute("product", products.get(i));
		return "product";
	}

	@RequestMapping(value = "/buy", method = RequestMethod.GET)
	public String buy(Model model) {
		return "buy";
	}

}
