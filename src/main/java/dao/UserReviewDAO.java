package dao;

import enttity.AppUser;
import enttity.UserReview;

import java.util.List;

public interface UserReviewDAO {
    //CRUD operation
    //create block
    void create(UserReview userReview);
    //read block
    List<UserReview> alluserReview(int userId);
    //update block
    void update(UserReview userReview);
    //delete block
    void delete(UserReview userReview);

}