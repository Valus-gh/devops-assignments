package supsi.cloud.assignment.demo.persistence;

import org.springframework.data.repository.CrudRepository;
import supsi.cloud.assignment.demo.model.Course;

import java.util.Optional;

public interface CourseRepository extends CrudRepository<Course, Long> {
    Optional<Course> findByTitle(String title);
}