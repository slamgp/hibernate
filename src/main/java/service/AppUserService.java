package service;

import bl.HibernateUtil;
import bl.Util;
import com.sun.org.apache.regexp.internal.RE;
import dao.AppUserDAO;
import enttity.AppUser;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AppUserService implements AppUserDAO {
    public void create(AppUser user) {

    }


    public Set<AppUser> allAppUser() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query  = session.createQuery("from AppUser as users fetch left join users.reviews");
        Set<AppUser> result = new HashSet(query.getResultList());
        session.close();
        return result;
    }

    public AppUser getById(int id) {
        AppUser result = null;

        return result;
    }

    public void update(AppUser user) {

    }

    public void delete(AppUser user) {

    }



}