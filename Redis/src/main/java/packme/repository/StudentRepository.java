package packme.repository;

import org.springframework.stereotype.Repository;
import packme.model.Student;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface StudentRepository extends CrudRepository<Student, String> {
}
