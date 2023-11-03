package az.growlab.creditorleadjpa.service.impl;

import az.growlab.creditorleadjpa.dto.SignInRequest;
import az.growlab.creditorleadjpa.dto.SignUpRequest;
import az.growlab.creditorleadjpa.entity.Account;
import az.growlab.creditorleadjpa.entity.Authority;
import az.growlab.creditorleadjpa.repository.AccountRepository;
import az.growlab.creditorleadjpa.repository.AuthorityRepository;
import az.growlab.creditorleadjpa.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthorityRepository authorityRepository;

    @Override
    public void signUp(SignUpRequest signUpRequest){
        Account account = new Account();
        accountRepository.findAccountByUsername(signUpRequest.getUsername()).ifPresent(user -> {
            throw new IllegalArgumentException("Email used");
        });
        account.setUsername(signUpRequest.getUsername());
        account.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
        Authority authority = authorityRepository.findByAuthority("USER").get();
        account.setAuthorities(Set.of(authority));
        accountRepository.save(account);
    }
}
