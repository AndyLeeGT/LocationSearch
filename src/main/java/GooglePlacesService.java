package main.java;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GooglePlacesService {
    @GET("maps/api/place/nearbysearch/json")
    Call<GPResponse> listPlaces(@Query("location") String location, @Query("radius") int radius, @Query("key") String apiKey);
}
