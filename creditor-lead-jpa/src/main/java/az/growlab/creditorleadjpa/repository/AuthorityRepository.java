package az.growlab.creditorleadjpa.repository;

import az.growlab.creditorleadjpa.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority,Long> {
    Optional<Authority> findByAuthority(String authority);
}
