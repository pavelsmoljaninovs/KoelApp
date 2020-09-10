package models;

public class PetResponse extends Pet{
    private long id;

    public long getId() {
        return id;
    }

    public PetResponse(Category category, String name, String[] photoUrls, Tag[] tags, String status) {
        super(category, name, photoUrls, tags, status);
    }
}
