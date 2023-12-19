package pizzeria.resource;

import java.util.List;

public interface CrudeRepository<T, ID> {
    T save(T entity);
    T findById(ID id);
    void deleteById(ID id);

    List<Pizza> findAll();

}
