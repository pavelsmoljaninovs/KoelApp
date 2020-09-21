package helpers;

import models.*;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public class RandomGenerator {
    public static String randomStringGenerator(int length){
        boolean useLetters = true;
        boolean useNumbers = false;
        return RandomStringUtils.random(length, useLetters, useNumbers);
    }
    public static PostPetRequest petRequestGenerator(){
        Random random = new Random();
        Category ct = new Category(randomStringGenerator(8),random.nextInt(100));
        Tag tag = new Tag(random.nextInt(10),randomStringGenerator(6));
        String name = randomStringGenerator(10);
        String status = "sold";
        return new PostPetRequest(ct,name,new String[]{},new Tag[]{tag},status);
    }

    public static PutPetRequest petUpdateRequestGenerator() {
        Random random = new Random();
        Category ct = new Category(randomStringGenerator(8),random.nextInt(100));
        Tag tag = new Tag(random.nextInt(10),randomStringGenerator(6));
        String name = randomStringGenerator(10);
        String status = "sold";
        return new PutPetRequest(ct,name,new String[]{},new Tag[]{tag},status);
    }
}
