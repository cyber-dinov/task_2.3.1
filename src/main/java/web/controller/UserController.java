package web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;



@Controller
public class UserController {


    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/users")
    public String usersPage(Model model){
        model.addAttribute("users", userService.getUserList());
        return "users";
    }

    @GetMapping("/user-save")
    public String saveUserForm(User user, Model model){
        model.addAttribute(user);
        return "userSave";
    }

    @PostMapping("/user-save")
    public String saveUser(User user){
        userService.add(user);
        return "redirect:/users";
    }

    @GetMapping("/user-edit/{id}")
    public String userEditForm(@PathVariable("id") Long id, Model model){
        model.addAttribute("user", userService.getById(id));
        return "userEdit";
    }

    @PatchMapping("/user-edit/{id}")
    public String userEdit(@PathVariable("id") String id, User user){
        userService.update(user, Long.valueOf(id));
        return "redirect:/users";
    }

    @DeleteMapping("/user-delete/{id}")
    public String userDelete(@PathVariable("id") Long id){
        userService.delete(id);
        return "redirect:/users";
    }
}
