package az.growlab.transactionisolation.repository;

import az.growlab.transactionisolation.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
