package main;

public class InterestingPlace {
    public String getName() {
        return name;
    }

    public InterestingPlace(String name, float rating) {
        this.name = name;
        this.rating = rating;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
    private float rating;

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}
