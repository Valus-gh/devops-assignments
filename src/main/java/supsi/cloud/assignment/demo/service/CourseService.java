package supsi.cloud.assignment.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import supsi.cloud.assignment.demo.model.Course;
import supsi.cloud.assignment.demo.persistence.CourseRepository;

import java.util.Collection;
import java.util.Optional;

@Service
public class CourseService implements CrudServiceBase<Course>{

    private final CourseRepository repository;

    @Autowired
    public CourseService(CourseRepository repository) {
        this.repository = repository;
    }

    @Override
    public Course read(String name) {

        Optional<Course> instance = repository.findByTitle(name);

        if(instance.isEmpty())
            return null;

        return instance.get();
    }

    @Override
    public Collection<Course> read() {
        return (Collection<Course>) repository.findAll();
    }

    @Override
    public Course create(Course body) {

        Optional<Course> instance = repository.findByTitle(body.getTitle());

        if (instance.isPresent())
            return null;

        return repository.save(body);
    }

    @Override
    public void delete(String name) {
        Optional<Course> instance = repository.findByTitle(name);

        if (instance.isEmpty())
            return;

        repository.delete(instance.get());
    }
}
