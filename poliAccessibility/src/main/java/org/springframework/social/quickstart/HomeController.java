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
		// Person user = new Person(/*Dati estratti dalla form*/);
		// um.saveUser(user);
		// Person user2 = um.getUser("lol");
		// System.out.println("LOL"+ user2.getUserName());
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
			System.out.println("LOL!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		}
		return "home";
	}

	// Le categorie sono hard coded.
	@RequestMapping(value = "/category", method = RequestMethod.GET)
	public String categ(Model model,
			@RequestParam(value = "category") String category) {
		model.addAttribute("product", pf.findProducts(category));
		return "category";
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

	@RequestMapping(value = "/loginForm", method = RequestMethod.GET)
	public String loginForm(Model model) {
		return "loginForm";
	}

	/**
	 * Questa è la risposta a una form, di cui van presi UserID e psw
	 * 
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(Model model,
			@RequestParam(value = "userName") String userName,
			@RequestParam(value = "psw") String psw) {

		Person user = um.getUserByUserName(userName);
		if (user.equals(null)) {
			return "userNotFound";
		} else {
			if (!user.getPassw().equals(psw)) {
				return "incorrect";
			} else {
				return "login";
			}
		}
	}

	@RequestMapping(value = "/buy", method = RequestMethod.GET)
	public String buy(Model model) {
		return "buy";
	}

}
