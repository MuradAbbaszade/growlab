package az.growlab.transactionisolation.service;

import az.growlab.transactionisolation.bean.User;
import az.growlab.transactionisolation.dto.UserRequest;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    int add(UserRequest userRequest) throws InterruptedException;
    User get(Long id);
}
