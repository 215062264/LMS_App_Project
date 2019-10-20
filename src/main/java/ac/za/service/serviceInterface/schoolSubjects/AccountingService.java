package ac.za.service.serviceInterface.schoolSubjects;

import ac.za.domain.schoolSubjects.Accounting;
import ac.za.service.IService;

import java.util.Set;

public interface AccountingService extends IService<Accounting, String> {

    Set<Accounting> getAllAccounting();
    Set<Accounting> getAll();

}
