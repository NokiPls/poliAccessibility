package org.springframework.social.quickstart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * The main controller for the application.
 * 
 */

@Controller
@ComponentScan("com.access.services")
public class HomeController {


//	@Autowired
	public HomeController() {
	}

	@RequestMapping(value = {"/","/openGraph","/commonFriends"}, method = RequestMethod.GET)
	public String home(Model model) {
		return "home";
	}
	
	@RequestMapping(value = "aboutUs", method = RequestMethod.GET)
	public String aboutUs(Model model) {
		return "aboutUs";
	}

//	@RequestMapping(value = "/commonFriends", method = RequestMethod.POST)
//	public String commonFriendsList(
//			@RequestParam(value = "id[]", required = false) String[] idSelected,
//			Model model) {
//
//		if (idSelected == null)
//			return "redirect:/friendsList";
//
//		return "commonFriendsList";
//	}

	@RequestMapping(value = "/graphNode", method = RequestMethod.GET)
	public String graphNode(Model model, @RequestParam(value = "id") String id) {

		return "nodePopUp";
	}

}
