package models;

public class PostPetRequest extends Pet{

    public PostPetRequest(Category category, String name, String[] photoUrls, Tag[] tags, String status) {
        super(category, name, photoUrls, tags, status);
    }
}