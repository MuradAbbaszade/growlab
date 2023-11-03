package az.growlab.creditorleadjpa.controller;

import az.growlab.creditorleadjpa.dto.SignInRequest;
import az.growlab.creditorleadjpa.dto.SignUpRequest;
import az.growlab.creditorleadjpa.service.AuthService;
import az.growlab.creditorleadjpa.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AccountController {
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final AuthService authService;
    @PostMapping("/sign-up")
    public String signUp(@RequestBody SignUpRequest signUpRequest){
        authService.signUp(signUpRequest);
        Authentication authentication = new UsernamePasswordAuthenticationToken(
                signUpRequest.getUsername(),
                signUpRequest.getPassword()
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtUtil.generateToken(authentication);
        return token;
    }
    @PostMapping("/sign-in")
    public String signIn(@RequestBody SignInRequest signInRequest){
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        signInRequest.getUsername(),
                        signInRequest.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final String token = jwtUtil.generateToken(authentication);
        return token;
    }
}
