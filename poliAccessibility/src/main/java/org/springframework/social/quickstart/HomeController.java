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
		Person user = new Person(/*Dati estratti dalla form*/);
		um.saveUser(user);
		return "home";
	}

	@RequestMapping(value = "/aboutUs", method = RequestMethod.GET)
	public String aboutUs(Model model) {
		return "aboutUs";
	}

	@RequestMapping(value = "/userRegistration", method = RequestMethod.POST)
	public String userRegistration(Model model) {
		Person user = new Person(/*Dati estratti dalla form*/);
		um.saveUser(user);
		return "userRegistration";
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

		Person user = um.getUser(userName);
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
