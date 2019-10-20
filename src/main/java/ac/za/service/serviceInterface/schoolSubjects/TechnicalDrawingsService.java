package ac.za.service.serviceInterface.schoolSubjects;

import ac.za.domain.schoolSubjects.TechnicalDrawings;
import ac.za.service.IService;

import java.util.Set;

public interface TechnicalDrawingsService extends IService<TechnicalDrawings, String> {

    Set<TechnicalDrawings> getAllP();
    Set<TechnicalDrawings> getAll();
}
