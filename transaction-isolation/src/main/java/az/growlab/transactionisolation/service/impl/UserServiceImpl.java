package az.growlab.transactionisolation.service.impl;

import az.growlab.transactionisolation.bean.User;
import az.growlab.transactionisolation.dto.UserRequest;
import az.growlab.transactionisolation.repository.UserRepository;
import az.growlab.transactionisolation.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public int add(UserRequest userRequest) throws InterruptedException {
        User user = modelMapper.map(userRequest,User.class);
        userRepository.save(user);
        Thread.sleep(1000000);
        return 1;
    }

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public User get(Long id) {
        return userRepository.findById(id).orElseThrow(()->new RuntimeException("Not found"));
    }
}
