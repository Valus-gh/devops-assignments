package supsi.cloud.assignment.demo.service;

import java.util.Collection;

public interface CrudServiceBase<T> {

    T read(String name);

    Collection<T> read();

    T create(T body);

    void delete(String name);

}
