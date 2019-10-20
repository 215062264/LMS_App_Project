package ac.za.repository.repoInterface.academicResults;


import ac.za.domain.academicResults.Results;
import ac.za.repository.IRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;
@Repository
public interface ResultRepository extends JpaRepository<Results, Integer> {
}