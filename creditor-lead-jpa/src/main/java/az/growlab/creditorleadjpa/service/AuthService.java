package az.growlab.creditorleadjpa.service;

import az.growlab.creditorleadjpa.dto.SignInRequest;
import az.growlab.creditorleadjpa.dto.SignUpRequest;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {
    void signUp(SignUpRequest signUpRequest);
}
