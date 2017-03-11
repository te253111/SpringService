package repository.CrudRepository;

import model.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Zlink on 11/3/2560.
 */
public class PersonRepository implements Repository<Person> {
    @Override
    public void save(Person person) {
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "test" );
        EntityManager entitymanager = emfactory.createEntityManager( );
        entitymanager.getTransaction( ).begin( );

        entitymanager.persist( person );
        entitymanager.getTransaction( ).commit( );

        entitymanager.close( );
        emfactory.close( );
    }

    @Override
    public void update(Person person ,int id) {
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "test" );
        EntityManager entitymanager = emfactory.createEntityManager( );

        entitymanager.getTransaction( ).begin( );
        Person uperson = entitymanager.find(Person.class,id);
        uperson.setName(person.getName());
        uperson.setLastname(person.getLastname());
        entitymanager.getTransaction( ).commit( );

        entitymanager.close( );
        emfactory.close( );
    }

    @Override
    public void delete(int id) {
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "test" );
        EntityManager entitymanager = emfactory.createEntityManager( );

        entitymanager.getTransaction( ).begin( );
        Person person = entitymanager.find(Person.class, id);
        entitymanager.remove(person);
        entitymanager.getTransaction( ).commit( );

        entitymanager.close( );
        emfactory.close( );
    }

    @Override
    public List<Person> findAll() {
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "test" );
        EntityManager entitymanager = emfactory.createEntityManager( );
        entitymanager.getTransaction( ).begin( );


        Query query = entitymanager.
                createQuery("Select p from Person p");
        List<Person> list=query.getResultList();

        entitymanager.getTransaction( ).commit( );

        entitymanager.close( );
        emfactory.close( );
        return list;
    }

    @Override
    public Person findone(int id) {
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "test" );
        EntityManager entitymanager = emfactory.createEntityManager( );
        entitymanager.getTransaction( ).begin( );
        Person person = entitymanager.find(Person.class, id);
        entitymanager.getTransaction( ).commit( );
        entitymanager.close( );
        emfactory.close( );
        return person;
    }
}
