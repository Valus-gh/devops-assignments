package supsi.cloud.assignment.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import supsi.cloud.assignment.demo.model.Student;
import supsi.cloud.assignment.demo.persistence.StudentRepository;

import java.util.Collection;
import java.util.Optional;

@Service
public class StudentService implements CrudServiceBase<Student>{

    private final StudentRepository repository;

    @Autowired
    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Student read(String name) {

        Optional<Student> instance = repository.findByName(name);

        if(instance.isEmpty())
            return null;

        return instance.get();
    }

    @Override
    public Collection<Student> read() {
        return (Collection<Student>) repository.findAll();
    }

    @Override
    public Student create(Student body) {

        Optional<Student> instance = repository.findByName(body.getName());

        if (instance.isPresent())
            return null;

        return repository.save(body);
    }

    @Override
    public void delete(String name) {
        Optional<Student> instance = repository.findByName(name);

        if (instance.isEmpty())
            return;

        repository.delete(instance.get());
    }
}
