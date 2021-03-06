package it.valeriovaudi.web.controller;

import it.valeriovaudi.service.SignUpService;
import it.valeriovaudi.web.model.PhoneBookUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class SignupController {
    private static final String SIGNUP_VIEW_NAME = "signup/signup";

    private SignUpService signUpService;

	@RequestMapping(value = "signup")
	public String signup(Model model) {
		model.addAttribute("signupForm",new PhoneBookUser());
        return SIGNUP_VIEW_NAME;
	}

    @RequestMapping(value = "/signup",method = RequestMethod.POST)
    public String signup(@ModelAttribute("signupForm") PhoneBookUser phoneBookUser, Errors errors, RedirectAttributes ra) {
        if (errors.hasErrors()) {
            return SIGNUP_VIEW_NAME;
        }

        signUpService.phoneBookUserSingIn(phoneBookUser);

        return "redirect:/index";
    }

    @Autowired
    public void setSignUpService(SignUpService signUpService) {
        this.signUpService = signUpService;
    }
}
