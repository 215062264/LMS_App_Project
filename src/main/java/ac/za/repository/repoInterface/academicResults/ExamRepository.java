package ac.za.repository.repoInterface.academicResults;

import ac.za.domain.academicResults.Exam;
import ac.za.repository.IRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;
@Repository
public interface ExamRepository extends JpaRepository<Exam, Integer> {
}