package dao;

import enttity.AppUser;

import java.util.List;

public interface AppUserDAO {
    //CRUD operation
    //create block
    void create(AppUser user);
    //read block
    List<AppUser> allAppUser();
    AppUser getById (int id);
    //update block
    void update(AppUser user);
    //delete block
    void delete(AppUser user);

}