package az.growlab.transactionisolation.controller;

import az.growlab.transactionisolation.bean.User;
import az.growlab.transactionisolation.dto.UserRequest;
import az.growlab.transactionisolation.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class UserController {
    private final UserService userService;

    @PostMapping("/add")
    public void add(@RequestBody UserRequest userRequest) throws InterruptedException {
        userService.add(userRequest);
    }

    @GetMapping("/get")
    public User get(Long id){
        return userService.get(id);
    }

}
