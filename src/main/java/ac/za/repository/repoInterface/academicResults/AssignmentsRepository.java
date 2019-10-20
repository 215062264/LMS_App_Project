package ac.za.repository.repoInterface.academicResults;

import ac.za.domain.academicResults.Assignments;
import ac.za.repository.IRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;
@Repository("assignmentRepository")
public interface AssignmentsRepository extends JpaRepository<Assignments, Integer> {
}