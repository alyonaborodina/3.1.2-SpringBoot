package alenagupanova31.__Spring.Boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import alenagupanova31.__Spring.Boot.models.User;
import alenagupanova31.__Spring.Boot.service.UserService;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String index(Model model) {
        model.addAttribute("users", userService.findAll());
        return "users";
    }

    @GetMapping(value ="/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping("/users")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/users";
    }

    @GetMapping("edit/{id}")
    public String showEditUserForm(@PathVariable Integer id, Model model) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "edit";
    }

    @PostMapping("edit/{id}")
    public String saveEditedUser(@ModelAttribute("user") User user, @PathVariable Integer id) {
        user.setId(id);
        userService.update(user);
        return "redirect:/users";
    }

    @PostMapping("delete/{id}")
    public String deleteUser(@ModelAttribute("user") User user, @PathVariable Integer id) {
        user.setId(id);
        userService.delete(user);
        return "redirect:/users";
    }









}
