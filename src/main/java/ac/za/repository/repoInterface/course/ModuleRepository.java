package ac.za.repository.repoInterface.course;

import ac.za.domain.course.Module;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModuleRepository extends JpaRepository<Module, Integer> {
}
