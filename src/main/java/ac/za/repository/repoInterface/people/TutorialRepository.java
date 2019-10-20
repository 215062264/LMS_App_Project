package ac.za.repository.repoInterface.people;


import ac.za.domain.people.Tutorial;
import ac.za.repository.IRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

public interface TutorialRepository extends JpaRepository<Tutorial, Integer> {
}