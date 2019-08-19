import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PersonDAOTest {
    static Person createTestData(int index) {

        Person person = new Person();
        person.setName("Name" + index);
        person.setAge(12);
        person.setLastname("Last");
        List<Car> carList = new ArrayList<>();
        Car car = new Car();
        car.setPerson(person);
        car.setColor("asdasdasd");
        car.setModel("mazda");
        carList.add(car);
        person.setAutos(carList);

        return person;
    }

    @Test
    public void addPerson() {
        Transaction tx = null;
        DAO dao = new DAO();

        try (Session session = dao.getSession()) {
            tx = session.beginTransaction();

            Person testPerson = createTestData(1);

            session.saveOrUpdate(testPerson);

            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (tx != null) tx.rollback();
            fail();
        }

    }

    @Test
    public void getPerson() {
        Transaction tx = null;
        DAO dao = new DAO();
        Person person = null;

        try (Session session = dao.getSession()) {
            tx = session.beginTransaction();

            Person testPerson = createTestData(1);

            session.saveOrUpdate(testPerson);

            tx.commit();

            tx = session.beginTransaction();

            person = session.get(Person.class, testPerson.getId());
            tx.commit();
            assertEquals(person, testPerson);


        } catch (Exception e) {
            e.printStackTrace();
            if (tx != null) tx.rollback();
            fail();
        }
    }

    @Test
    public void updatePerson() {
        Transaction tx = null;
        DAO dao = new DAO();
        Person person = null;

        try (Session session = dao.getSession()) {
            tx = session.beginTransaction();

            Person testPerson = createTestData(1);

            session.saveOrUpdate(testPerson);
            System.out.println(testPerson + " testPerson");
            System.out.println(testPerson.getId() + " id " + testPerson.getName() + " name " + testPerson.getAge());
            tx.commit();

            tx = session.beginTransaction();
            person = session.get(Person.class, testPerson.getId());
            person.setAge(1);
            session.update(testPerson);

            tx.commit();

            tx = session.beginTransaction();

            tx.commit();

            assert (testPerson.getAge() == 1);


        } catch (Exception e) {
            e.printStackTrace();
            if (tx != null) tx.rollback();
            fail();
        }
    }

    @Test
    public void deletePerson() {
        Transaction tx = null;
        DAO dao = new DAO();


        try (Session session = dao.getSession()) {
            tx = session.beginTransaction();

            Person testPerson = createTestData(1);

            session.saveOrUpdate(testPerson);

            tx.commit();

            tx = session.beginTransaction();
            session.delete(testPerson);

            tx.commit();





        } catch (Exception e) {
            e.printStackTrace();
            if (tx != null) tx.rollback();
            fail();
        }
    }
}