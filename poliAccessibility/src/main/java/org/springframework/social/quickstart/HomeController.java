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
	private String css;
	private String js;
	private String contrast;
	private String font;
	private String category;
	private List<String> subcatV = new ArrayList<String>();
	private List<String> subcatH = new ArrayList<String>();
	private List<String> types = new ArrayList<String>();

	@Autowired
	public HomeController(UserManagerInterface um, ProductsFinderInterface pf) {
		this.um = um;
		this.pf = pf;
		this.pf.init();
		this.css = "stylenn";
		this.js = "initnn";
		this.contrast = "high";
		this.font = "high";
	}

	// Home
	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("font", this.font);
		model.addAttribute("contrast", this.contrast);
		model.addAttribute("css", css);
		model.addAttribute("js", js);
		return "home";
	}

	@RequestMapping(value = "/contactUs", method = RequestMethod.GET)
	public String contactUs(Model model) {
		model.addAttribute("css", css);
		model.addAttribute("js", js);
		return "contactUs";
	}

	@RequestMapping(value = "/userRegistration", method = RequestMethod.GET)
	public String showForm(Model model) {
		model.addAttribute("css", css);
		model.addAttribute("js", js);
		model.addAttribute("personForm", new Person());
		return "registration";
	}

	@RequestMapping(value = "/userRegistration", method = RequestMethod.POST)
	public String registrationFormEvaluation(
			@Valid @ModelAttribute Person personForm, BindingResult result,
			Model model) {
		model.addAttribute("js", js);
		model.addAttribute("css", css);
		String userNameError = "Username already taken.";
		String nameError = "It is mandatory to insert your name.";
		String surnameError = "It is mandatory to insert your surname.";
		String addressError = "It is mandatory to insert an address.";
		String ccnError = "It is mandatory to insert a credit card number.";
		String ccexpError = "It is mandatory to insert the expiration date in MM/YY format.";
		String userNameError2 = "It is mandatory to choose a username.";
		String passwordError = "It is mandatory to choose a password.";

		// String passwordError = "The two passwords are not matching.";

		if (result.hasErrors()) {
			model.addAttribute("personForm", new Person());
			return "registration";
		}

		if (personForm.getName() == null || personForm.getName().equals("")) {
			model.addAttribute("nameError", nameError);
		} else {
			nameError = "";
			model.addAttribute("nameError", nameError);
		}

		if (personForm.getSurname() == null
				|| personForm.getSurname().equals("")) {
			model.addAttribute("surnameError", surnameError);
		} else {
			surnameError = "";
			model.addAttribute("surnameError", surnameError);
		}

		if (personForm.getAddress() == null
				|| personForm.getAddress().equals("")) {
			model.addAttribute("addressError", addressError);
		} else {
			addressError = "";
			model.addAttribute("addressError", addressError);
		}

		if (personForm.getCcn() == 0) {
			model.addAttribute("ccnError", ccnError);
		} else {
			ccnError = "";
			model.addAttribute("ccnError", ccnError);
		}

		if (personForm.getCcexp() == null || personForm.getCcexp().equals("")) {
			model.addAttribute("ccexpError", ccexpError);
		} else {
			ccexpError = "";
			model.addAttribute("ccexpError", ccexpError);
		}

		if (personForm.getPassw() == null || personForm.getPassw().equals("")) {
			model.addAttribute("passwordError", passwordError);
		} else {
			passwordError = "";
			model.addAttribute("passwordError", passwordError);
		}

		if (personForm.getUserName() == null
				|| personForm.getUserName().equals("")) {
			model.addAttribute("userNameError2", userNameError2);
		} else {
			userNameError2 = "";
			model.addAttribute("userNameError2", userNameError2);
			if (um.getUserByUserName(personForm.getUserName()) != null) {
				model.addAttribute("userNameError", userNameError);
			} else {
				System.out.println("Duplicate userName found !!!");
				userNameError = "";
				model.addAttribute("userNameError", userNameError);
			}
		}

		if (userNameError.equals("") && userNameError2.equals("")
				&& nameError.equals("") && surnameError.equals("")
				&& addressError.equals("") && ccnError.equals("")
				&& ccexpError.equals("") && passwordError.equals("")) {
			um.saveUser(personForm);
			model.addAttribute("name", personForm.getName());
			model.addAttribute("surname", personForm.getSurname());
			return "registrationSuccessful";
		} else {
			model.addAttribute("personForm", new Person());
			model.addAttribute("person", personForm);
			return "registration";
		}

		// if (um.getUserByUserName(personForm.getUserName()) == null) {
		// um.saveUser(personForm);
		// model.addAttribute("name", personForm.getName());
		// model.addAttribute("surname", personForm.getSurname());
		// return "registrationSuccessful";
		// } else {
		// System.out.println("Duplicate userName found !!!");
		// model.addAttribute("personForm", new Person());
		// model.addAttribute("person", personForm);
		// model.addAttribute("userNameError", userNameError);
		// return "registration";
		// }

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

		model.addAttribute("css", css);
		model.addAttribute("js", js);
		model.addAttribute("userName", state);
		return state;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
		model.addAttribute("css", css);
		model.addAttribute("js", js);
		model.addAttribute("personForm", new Person());
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute Person personForm,
			BindingResult result, Model model) {
		model.addAttribute("js", js);
		model.addAttribute("css", css);
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
		model.addAttribute("css", css);
		model.addAttribute("js", js);
		return "";
	}

	@RequestMapping(value = "/allProducts", method = RequestMethod.GET)
	public String allProducts(Model model) {
		products = new ArrayList<Product>();
		products = pf.findAllProducts();
		types = new ArrayList<String>();
		types.add("Vision Impaired");
		types.add("Hearing and Speech");

		model.addAttribute("css", css);
		model.addAttribute("js", js);
		model.addAttribute("products", products);
		model.addAttribute("types", types);
		return "allProducts";
	}

	// Le categorie sono hard coded nel jsp.
	@RequestMapping(value = "/category", method = RequestMethod.GET)
	public String categ(Model model,
			@RequestParam(value = "category") String category) {
		products = new ArrayList<Product>();
		subcatV = new ArrayList<String>();
		subcatH = new ArrayList<String>();
		this.category = category;

		products = pf.findProductsByCategory(category);

		if (type.equals("Vision Impaired")) {
			subcatV.add("Braille Displays");
			subcatV.add("Braille Embossers");
			subcatV.add("Screen Readers");
		}

		if (type.equals("Hearing and Speech")) {
			subcatH.add("TDD and TTY");
			subcatH.add("Amplifications Systems");
			subcatH.add("Voice Amplifiers");
		}

		model.addAttribute("css", css);
		model.addAttribute("js", js);
		model.addAttribute("subcategoriesV", subcatV);
		model.addAttribute("subcategoriesH", subcatH);
		model.addAttribute("v", "Vision Impaired");
		model.addAttribute("h", "Hearing and Speech");
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

		subcatV = new ArrayList<String>();
		subcatH = new ArrayList<String>();

		if (type.equals("Vision Impaired")) {
			subcatV.add("Braille Displays");
			subcatV.add("Braille Embossers");
			subcatV.add("Screen Readers");
		}

		if (type.equals("Hearing and Speech")) {
			subcatH.add("TDD and TTY");
			subcatH.add("Amplifications Systems");
			subcatH.add("Voice Amplifiers");
		}

		model.addAttribute("css", css);
		model.addAttribute("js", js);
		model.addAttribute("subcategoriesV", subcatV);
		model.addAttribute("subcategoriesH", subcatH);
		model.addAttribute("v", "Vision Impaired");
		model.addAttribute("h", "Hearing and Speech");
		model.addAttribute("type", type);
		model.addAttribute("products", products);
		return "products";
	}

	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public String product(Model model, @RequestParam(value = "i") int i) {
		model.addAttribute("css", css);
		model.addAttribute("js", js);
		currentProduct = products.get(i);
		model.addAttribute("product", currentProduct);
		return "product";
	}

	@RequestMapping(value = "/orderSuccess", method = RequestMethod.GET)
	public String buy(Model model) {
		model.addAttribute("css", css);
		model.addAttribute("js", js);
		return "orderSuccess";
	}

	@RequestMapping(value = "/switchFont", method = RequestMethod.GET)
	public String switchFont(Model model,
			@RequestParam(value = "font") String font,
			@RequestParam(value = "page") String page) {
		if (font.equals("Switch to normal font.")) {
			this.font = "high";
			if (contrast.equals("normal")) {
				this.css = "stylenh";
				this.js = "initnh";
			} else {
				this.css = "stylenn";
				this.js = "initnn";
			}
		} else {
			this.font = "normal";
			if (contrast.equals("normal")) {
				this.css = "stylehh";
				this.js = "inithh";
			} else {
				this.css = "stylehn";
				this.js = "inithn";
			}

		}
		model.addAttribute("font", this.font);
		model.addAttribute("contrast", this.contrast);
		model.addAttribute("types", types);
		model.addAttribute("categ", category);
		model.addAttribute("css", css);
		model.addAttribute("js", js);
		model.addAttribute("product", currentProduct);
		model.addAttribute("subcategoriesV", subcatV);
		model.addAttribute("subcategoriesH", subcatH);
		model.addAttribute("v", "Vision Impaired");
		model.addAttribute("h", "Hearing and Speech");
		model.addAttribute("type", type);
		model.addAttribute("products", products);
		model.addAttribute("personForm", new Person());
		return page;
	}

	@RequestMapping(value = "/switchContrast", method = RequestMethod.GET)
	public String switchContrast(Model model,
			@RequestParam(value = "contrast") String contrast,
			@RequestParam(value = "page") String page) {
		if (contrast.equals("Switch to normal contrast.")) {
			this.contrast = "high";
			if (font.equals("normal")) {
				this.css = "stylehn";
				this.js = "inithn";
			} else {
				this.css = "stylenn";
				this.js = "initnn";
			}
		} else {
			this.contrast = "normal";
			if (font.equals("normal")) {
				this.css = "stylehh";
				this.js = "inithh";
			} else {
				this.css = "stylenh";
				this.js = "initnh";

			}
		}
		model.addAttribute("font", this.font);
		model.addAttribute("contrast", this.contrast);
		model.addAttribute("types", types);
		model.addAttribute("categ", category);
		model.addAttribute("css", css);
		model.addAttribute("js", js);
		model.addAttribute("product", currentProduct);
		model.addAttribute("subcategoriesV", subcatV);
		model.addAttribute("subcategoriesH", subcatH);
		model.addAttribute("v", "Vision Impaired");
		model.addAttribute("h", "Hearing and Speech");
		model.addAttribute("type", type);
		model.addAttribute("products", products);
		model.addAttribute("personForm", new Person());
		return page;
	}
}
