package supsi.cloud.assignment.demo.persistence;

import org.springframework.data.repository.CrudRepository;
import supsi.cloud.assignment.demo.model.Exam;

import java.util.Optional;

public interface ExamRepository extends CrudRepository<Exam, Long> {
    Optional<Exam> findBySubject(String subject);
}