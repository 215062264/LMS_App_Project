package ac.za.repository.Impl.schoolSubjectsRepositoryImpl;

import ac.za.domain.schoolSubjects.Physics;
import ac.za.repository.repoInterface.schoolSubjects.PhysicsRepository;
import java.util.HashSet;
import java.util.Set;

public class PhysicsRepositoryImpl implements PhysicsRepository {

    private static PhysicsRepositoryImpl repository = null;
    private Set<Physics> physics;

    private PhysicsRepositoryImpl() {
        this.physics = new HashSet<>();
    }

    private Physics findP(String subjectCode) {
        return this.physics.stream()
                .filter(mathematics -> mathematics.getSubjectCode().trim().equals(subjectCode))
                .findAny()
                .orElse(null);
    }

    public static PhysicsRepository getRepository(){
        if(repository == null) repository = new PhysicsRepositoryImpl();
        return repository;
    }

    public Physics create(Physics physics){
        this.physics.add(physics);
        return physics;
    }

    public Physics read(String subjectCode){
        Physics physics = findP(subjectCode);
        return physics;
    }

    public Physics update(Physics physics) {
        Physics toDelete = findP(physics.getSubjectCode());
        if(toDelete != null) {
            this.physics.remove(toDelete);
            return create(physics);
        }
        return null;
    }

    public void delete(String subjectCode) {
        Physics physics = findP(subjectCode);
        if (physics != null) this.physics.remove(physics);
    }

    public Set<Physics> getAll(){
        return this.physics;
    }


}
