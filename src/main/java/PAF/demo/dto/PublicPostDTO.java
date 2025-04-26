package PAF.demo.dto;

public class PublicPostDTO {

    private int id;
    private String description;
    private String photo;

    public PublicPostDTO() {
    }

    public PublicPostDTO(int id, String description, String photo) {
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
