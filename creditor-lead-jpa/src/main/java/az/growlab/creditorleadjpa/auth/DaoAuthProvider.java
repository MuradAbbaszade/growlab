package az.growlab.creditorleadjpa.auth;

import az.growlab.creditorleadjpa.entity.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DaoAuthProvider implements AuthenticationProvider {
    private final PasswordEncoder passwordEncoder;
    private final UserDetailsService userDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        Account account = (Account) userDetailsService.loadUserByUsername(username);
        String hashPassword = account.getPassword();
        String password = authentication.getCredentials().toString();
        if (!passwordEncoder.matches(password,hashPassword)) throw new BadCredentialsException("Username or password is invalid");
        return new UsernamePasswordAuthenticationToken(account.getUsername(),account.getPassword(),account.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return false;
    }
}
