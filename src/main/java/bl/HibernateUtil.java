package bl;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static  final SessionFactory sessionFactory = buildSessionFactory();

    private HibernateUtil() {

    }

    private static SessionFactory buildSessionFactory() {
        return new Configuration().configure().buildSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static  void shutDown() {
        sessionFactory.close();
    }
}