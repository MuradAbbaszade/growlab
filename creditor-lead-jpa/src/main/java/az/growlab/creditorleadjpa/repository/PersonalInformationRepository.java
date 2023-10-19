package az.growlab.creditorleadjpa.repository;

import az.growlab.creditorleadjpa.entity.PersonalInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonalInformationRepository extends JpaRepository<PersonalInformation,Long> {
}
