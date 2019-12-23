package org.launchcode.spaday.controllers;


import org.launchcode.spaday.data.UserData;
import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping()
    public String displayAddUserForm() {


        return "user/add";

    }

    @PostMapping("added")
    public String processAddUserForm(Model model, @ModelAttribute User user, String verify, String password, String name, String email) {
        //System.out.println("stop");
        if(verify.equals(password)) {
            UserData.add(user);
            model.addAttribute("name", user.getName());
            //System.out.println(UserData.getAll());
            return "user/index";
            } else {
            model.addAttribute("name", name);
            model.addAttribute("email", email);

            return "user/add_wrong_password";
        }

    }


}
