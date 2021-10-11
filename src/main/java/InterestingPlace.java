package main.java;

public class InterestingPlace {
    public InterestingPlace(Geometry geometry, String url, String name, float rating) {
        this.geometry = geometry;
        this.url = url;
        this.name = name;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }
    public Geometry geometry;
    public String url;

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
