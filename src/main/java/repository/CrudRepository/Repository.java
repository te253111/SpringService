package repository.CrudRepository;

import java.util.List;

/**
 * Created by Zlink on 11/3/2560.
 */
public interface Repository<T> {
    void save(T t);
    void update(T t,int id);
    void delete(int id);
    List<T> findAll();
    T findone(int id);
}
