package ac.za.service.serviceInterface.schoolSubjects;

import ac.za.domain.schoolSubjects.History;
import ac.za.service.IService;

import java.util.Set;

public interface HistoryService extends IService<History, String> {
    Set<History> getAllHis();
    Set<History> getAll();
}
