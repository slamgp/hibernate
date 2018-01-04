package enttity;


import javax.persistence.*;

@Entity
@Table(name = "user_review")
public class UserReview {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "review_generator")
    @SequenceGenerator(name = "review_generator", sequenceName = "review_seq", initialValue = 1, allocationSize = 0)
    private int id;
    private String commnet;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private AppUser appUser;

    public UserReview() {
    }

    public UserReview(int id, String commnet) {
        this.id = id;
        this.commnet = commnet;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCommnet(String commnet) {
        this.commnet = commnet;
    }

    public int getId() {
        return id;
    }

    public String getCommnet() {
        return commnet;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    @Override
    public String toString() {
        return "UserReview{" +
                "id=" + id +
                ", commnet='" + commnet + '\'' +
                '}';
    }
}