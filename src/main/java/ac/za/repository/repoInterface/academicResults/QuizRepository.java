package ac.za.repository.repoInterface.academicResults;


import ac.za.domain.academicResults.Quiz;
import ac.za.repository.IRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;
@Repository
public interface QuizRepository extends JpaRepository<Quiz, Integer> {
}