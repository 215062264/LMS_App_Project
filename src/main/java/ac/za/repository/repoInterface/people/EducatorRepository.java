package ac.za.repository.repoInterface.people;

import ac.za.domain.people.Educator;
import ac.za.repository.IRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

public interface EducatorRepository extends JpaRepository<Educator, Integer> {

}
