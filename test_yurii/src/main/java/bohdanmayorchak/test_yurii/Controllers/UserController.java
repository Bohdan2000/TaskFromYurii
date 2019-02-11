package bohdanmayorchak.test_yurii.Controllers;

import bohdanmayorchak.test_yurii.Models.User;
import bohdanmayorchak.test_yurii.ServiceImpl.UserService;
import bohdanmayorchak.test_yurii.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public UserDto saveUser(@RequestBody UserDto user){
        return userService.save(user);
    }
}
