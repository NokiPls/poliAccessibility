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
import org.springframework.web.bind.annotation.ResponseBody;

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
	private String type;
	private Product currentProduct;
	private Person currentUser;

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

	@RequestMapping(value = "/contactUs", method = RequestMethod.GET)
	public String contactUs(Model model) {
		return "contactUs";
	}

	@RequestMapping(value = "/userRegistration", method = RequestMethod.GET)
	public String showForm(Model model) {
		model.addAttribute("personForm", new Person());
		return "registration";
	}

	@RequestMapping(value = "/userRegistration", method = RequestMethod.POST)
	public String registrationFormEvaluation(
			@Valid @ModelAttribute Person personForm, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			model.addAttribute("personForm", new Person());
			return "registration";
		}
		if (um.getUserByUserName(personForm.getUserName()) == null) {
			um.saveUser(personForm);
			model.addAttribute("name", personForm.getName());
			model.addAttribute("surname", personForm.getSurname());
			return "registrationSuccessful";
		} else {
			System.out.println("Duplicate userName found !!!");
			model.addAttribute("personForm", new Person());
			return "registration";
		}

	}

	@RequestMapping(value = "/checkUserName", method = RequestMethod.GET)
	public @ResponseBody
	String checkUsarName(@RequestParam(value = "userName") String userName,
			Model model) {

		String state = "";
		String error = "Username already taken.";
		String fine = "Username is now ok.";
		if (state.equals(error)) {
			state = fine;
		}
		if (um.getUserByUserName(userName) != null) {
			state = error;
		}
		model.addAttribute("userName", state);
		return state;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
		model.addAttribute("personForm", new Person());
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute Person personForm,
			BindingResult result, Model model) {

		String error = "";
		currentUser = personForm;
		Person p = um.getUserByUserName(personForm.getUserName());
		if (p == null) {
			System.out.println("User not found");
			error = "Incorrect Username.";
			model.addAttribute("error", error);
			model.addAttribute("personForm", new Person());
			return "login";
		} else {
			if (p.getPassw().equals(personForm.getPassw())) {
				System.out.println("Peeeeeeeeeeeeeeeerfietto!!");
			} else {
				System.out.println("Password Errata");
				error = "Incorrect Password.";
				model.addAttribute("personForm", new Person());
				model.addAttribute("error", error);
				model.addAttribute("userName", personForm.getUserName());
				return "login";
			}
		}
		model.addAttribute("person", currentUser);
		model.addAttribute("product", currentProduct);
		return "purchaseConfirm";
	}

	@RequestMapping(value = "/checkLogin", method = RequestMethod.GET)
	public String checkLogin(Model model) {
		return "";
	}

	// Le categorie sono hard coded nel jsp.
	@RequestMapping(value = "/category", method = RequestMethod.GET)
	public String categ(Model model,
			@RequestParam(value = "category") String category) {
		products = new ArrayList<Product>();
		products = pf.findProductsByCategory(category);
		model.addAttribute("product", products);
		model.addAttribute("categ", category);
		model.addAttribute("type", this.type);
		return "category";
	}

	// Prodotti di una categoria
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public String products(Model model,
			@RequestParam(value = "type") String type) {

		products = new ArrayList<Product>();
		products = pf.findProductsByType(type);

		this.type = type;

		List<String> subcat = new ArrayList<String>();

		if (type.equals("Vision Impaired")) {
			subcat.add("Braille Displays");
			subcat.add("Braille Embossers");
			subcat.add("Screen Readers");
		}

		if (type.equals("Hearing and Speech")) {
			subcat.add("TDD and TTY");
			subcat.add("Amplifications Systems");
			subcat.add("Voice Amplifiers");
		}

		model.addAttribute("subcategories", subcat);
		model.addAttribute("type", type);
		model.addAttribute("product", products);
		return "products";
	}

	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public String product(Model model, @RequestParam(value = "i") int i) {
		currentProduct = products.get(i);
		model.addAttribute("product", currentProduct);
		return "product";
	}

	@RequestMapping(value = "/orderSuccess", method = RequestMethod.GET)
	public String buy(Model model) {
		return "orderSuccess";
	}

}
