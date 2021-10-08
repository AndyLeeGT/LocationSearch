package main;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import okhttp3.ResponseBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


@RestController
public class InterestingPlacesController {

    @GetMapping("/")
    public String TestScreen() {
        return "Welcome to this app!";
    }

    @GetMapping("/places")
    public List<InterestingPlace> findPlaces(@RequestParam(value = "lat") String lat, @RequestParam(value = "lon") String lon) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://maps.googleapis.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        GooglePlacesService service = retrofit.create(GooglePlacesService.class);
        String location = lat + "," + lon;
        Call<GPResponse> res = service.listPlaces(location, 1500, "AIzaSyDi-6IpTsT-uQn85CCDJ_cYvNwkmiZ_f3Y");
        System.out.println(res.request().url());
        List<Place> places = null;
        try {
            Response<GPResponse> body = res.execute();
            places = body.body().getResults();
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }

        List<InterestingPlace> interestingPlaces = places.stream().map(place -> {
            return new InterestingPlace(place.getName(), place.getRating());
        }).collect(Collectors.toList());

        return interestingPlaces;
    }


}