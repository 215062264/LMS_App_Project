package ac.za.repository.repoInterface.people;

import ac.za.domain.people.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LectureRepository extends JpaRepository<Lecture, Integer> {

}