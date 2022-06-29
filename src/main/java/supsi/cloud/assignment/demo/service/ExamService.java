package supsi.cloud.assignment.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import supsi.cloud.assignment.demo.model.Exam;
import supsi.cloud.assignment.demo.persistence.ExamRepository;

import java.util.Collection;
import java.util.Optional;

@Service
public class ExamService implements CrudServiceBase<Exam>{

    private final ExamRepository repository;

    @Autowired
    public ExamService(ExamRepository repository) {
        this.repository = repository;
    }

    @Override
    public Exam read(String name) {

        Optional<Exam> instance = repository.findBySubject(name);

        if(instance.isEmpty())
            return null;

        return instance.get();
    }

    @Override
    public Collection<Exam> read() {
        return (Collection<Exam>) repository.findAll();
    }

    @Override
    public Exam create(Exam body) {

        Optional<Exam> instance = repository.findBySubject(body.getSubject());

        if (instance.isPresent())
            return null;

        return repository.save(body);
    }

    @Override
    public void delete(String name) {
        Optional<Exam> instance = repository.findBySubject(name);

        if (instance.isEmpty())
            return;

        repository.delete(instance.get());
    }
}
