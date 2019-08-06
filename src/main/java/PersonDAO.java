import org.hibernate.HibernateException;

public class PersonDAO extends DAO {


    public void addPerson(Person person)
            throws Exception {
        try {

            begin();
            getSession().save(person);
            commit();

        } catch (HibernateException e) {
            rollback();
            throw new Exception("Could not add person " + person.getName(), e);
        }
    }

    public Person getPerson(int id) throws Exception {
        Person person=null;
        try {
        begin();
         person = getSession().get(Person.class, id);
        commit();
    } catch (HibernateException e) {
        rollback();
        throw new Exception("Could not get person " , e);

        }
        return person;
    }
    public Person updatePerson( Person person) throws Exception {
        try {
        begin();

     getSession().update(person);
        commit();
    } catch (HibernateException e) {
        rollback();
        throw new Exception("Could not update person " + person.getName(), e);
        }
        return person;
    }


    public void deletePerson(Person person) throws Exception {
        try {
            begin();
            getSession().delete(person);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new Exception("Could not delete person " + person.getName(), e);
        }
    }
}
