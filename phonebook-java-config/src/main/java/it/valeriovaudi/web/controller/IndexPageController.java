package it.valeriovaudi.web.controller;

import it.valeriovaudi.security.PhoneBookSecurityRole;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Valerio on 19/09/2014.
 */

@Controller
public class IndexPageController {

    @ModelAttribute("content")
    public String getFragmentContent(){
        return "index";
    }

    @ModelAttribute("navigation")
    public String getFragmentPath(){
        return "user/content";
    }

    @Secured(value = "IS_AUTHENTICATED_FULLY")
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public void getUserPage(Model model){
        final Map<String,String> role2Controller = new HashMap<>();
        role2Controller.put(PhoneBookSecurityRole.ADMIN.getRole(),"administrationController");
        role2Controller.put(PhoneBookSecurityRole.USER.getRole(), "handleFormController");

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("phoneBoockUserName", authentication.getName());
        String jsController =  authentication.getAuthorities().
                                                stream().
                                                map(grantedAuthority -> role2Controller.get(grantedAuthority.getAuthority())).
                findFirst().
                get();
        model.addAttribute("controller", jsController);
    }
}
