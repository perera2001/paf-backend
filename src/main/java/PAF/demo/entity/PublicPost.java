package PAF.demo.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "post")
public class PublicPost {
    @Id
    @Column(name ="post_id",length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    @Column(name = "description", length = 255, nullable = false)
    private String description;

    @Column(name = "photo" , length = 255)
    private String photo;

    public PublicPost() {
    }

    public PublicPost(int id, String description, String photo) {
        this.id = id;
        this.description = description;
        this.photo = photo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
