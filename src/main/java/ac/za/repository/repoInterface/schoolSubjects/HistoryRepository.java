package ac.za.repository.repoInterface.schoolSubjects;

import ac.za.domain.schoolSubjects.History;
import ac.za.repository.IRepository;

import java.util.Set;


public interface HistoryRepository extends IRepository<History, String> {
    Set<History> getAll();

}