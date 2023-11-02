package az.growlab.creditorleadjpa.repository;

import az.growlab.creditorleadjpa.entity.ContactInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactInformationRepository extends JpaRepository<ContactInformation,Long> {
}
