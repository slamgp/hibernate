import bl.HibernateUtil;
import enttity.AppUser;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.Set;
import java.util.TreeSet;

public class EntryHibernate {
    public static void main (String[] args){
        final Logger loger = Logger.getLogger(EntryHibernate.class.getName());
        Session session = HibernateUtil.getSessionFactory().openSession();
      /* session.beginTransaction();

        AppUser user = new AppUser();
        user.setFirst_name("Misha");
        user.setSecond_name("Mishuta");
        user.setEmail("tmish@gmail.com");

        session.save(user);
        session.getTransaction().commit();


        session.beginTransaction();
        UserReview review1 = new UserReview();
        review1.setCommnet("krasava");

        UserReview review2 = new UserReview();
        review2.setCommnet("olen");

        review1.setAppUser(user);
        review2.setAppUser(user);

        session.save(review1);
        session.save(review2);


        AppUser user2 = new AppUser();
        user2.setFirst_name("Kolya");
        user2.setSecond_name("Koluk");
        user2.setEmail("koluk@gmail.com");

        session.save(user2);
        session.getTransaction().commit();


        session.beginTransaction();
        UserReview review3 = new UserReview();
        review3.setCommnet("dodik");

        UserReview review4= new UserReview();
        review4.setCommnet("alosha");

        review3.setAppUser(user2);
        review4.setAppUser(user2);

        session.save(review3);
        session.save(review4);
        session.getTransaction().commit();

        session.refresh(user);
        session.refresh(user2);*/
        Query query = session.createQuery(" from AppUser as users Left  JOIN FETCH users.reviews");
        Set<AppUser> users = new TreeSet<>(query.list());
        loger.info("RESULTTTTTTTTTTTTTT  1");
        users.stream().forEach(s->loger.info(s));




        HibernateUtil.shutDown();
    }
}