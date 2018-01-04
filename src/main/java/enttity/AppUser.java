package enttity;


import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "app_usser")
public class AppUser implements Comparable{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_generator")
    @SequenceGenerator(name = "user_generator", sequenceName = "user_seq", initialValue = 1, allocationSize = 0)
    private int id;
    String first_name;
    String second_name;
    String email;
    @OneToMany(mappedBy = "appUser", fetch = FetchType.EAGER)
    //@Fetch(FetchMode.JOIN)
    List<UserReview> reviews;

    public AppUser() {
    }

    public AppUser(int id, String first_name, String second_name, String email) {
        this.id = id;
        this.first_name = first_name;
        this.second_name = second_name;
        this.email = email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setSecond_name(String second_name) {
        this.second_name = second_name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {

        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getSecond_name() {
        return second_name;
    }

    public String getEmail() {
        return email;
    }

    public List<UserReview> getReviews() {
        return reviews;
    }

    public void setReviews(List<UserReview> reviews) {
        this.reviews = reviews;
    }

    @Override
    public String toString() {
        StringBuffer result = new StringBuffer().append(id).append(" ").append(first_name)
                .append(" ").append(second_name).append(" ").append(email);
        if (reviews != null) {
            reviews.stream().forEach(s -> {
                result.append(" ");
                result.append(s);
            });
        }
        return  result.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AppUser)) return false;

        AppUser appUser = (AppUser) o;

       if (id == appUser.id)
        {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (first_name != null ? first_name.hashCode() : 0);
        result = 31 * result + (second_name != null ? second_name.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }

    @Override
    public int compareTo(Object o) {
        if (this == o) return 0;
        if (!(o instanceof AppUser)) return -1;
        AppUser appUser = (AppUser) o;

        if (id > appUser.id) {
            return 1;
        } else if (id < appUser.id){
            return -1;
        }else {
            return 0;
        }
    }
}