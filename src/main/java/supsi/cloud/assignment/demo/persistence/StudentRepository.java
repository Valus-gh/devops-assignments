package supsi.cloud.assignment.demo.persistence;

import org.springframework.data.repository.CrudRepository;
import supsi.cloud.assignment.demo.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends CrudRepository<Student, Long> {

    Optional<Student> findByName(String name);

    Optional<Student> findByEmail(String email);

}