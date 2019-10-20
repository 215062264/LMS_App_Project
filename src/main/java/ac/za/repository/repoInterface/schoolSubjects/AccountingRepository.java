package ac.za.repository.repoInterface.schoolSubjects;

import ac.za.domain.schoolSubjects.Accounting;
import ac.za.repository.IRepository;

import java.util.Set;


public interface AccountingRepository extends IRepository<Accounting, String> {
    Set<Accounting> getAll();

}