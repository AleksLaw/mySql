import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DAO {
    private static final SessionFactory sf =
            new Configuration().configure().buildSessionFactory();
    Session session = null;
    protected DAO() {
    }

    public  Session getSession() {

        if (session == null) {
            session = sf.openSession();
           }
        return session;
    }

    protected void begin() {
        getSession().beginTransaction();
    }

    protected void commit() {

       getSession().getTransaction().commit();
    }

    protected void rollback() {
            getSession().getTransaction().rollback();
    }
//    protected void merge() {
//            getSession().merge();
//    }



    public  void close() {
        getSession().close();
       }

}
