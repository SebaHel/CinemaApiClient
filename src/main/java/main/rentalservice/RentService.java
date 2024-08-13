package main.rentalservice;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class RentService {
    private RestTemplate restTemplate;

    public RentService(RestTemplate restTemplate) throws HttpClientErrorException {
        this.restTemplate = restTemplate;
    }

    public Film getMovie(Long id) throws HttpClientErrorException{
        return restTemplate.getForObject("http://localhost:8080/movies/" + id, Film.class);
    }

    public void returnMovie(Long id) throws HttpClientErrorException{
        restTemplate.put("http://localhost:8080/movies/" + id + "/unavailable", null);
    }

    public void rentMovie(Long id) throws HttpClientErrorException{
        restTemplate.put("http://localhost:8080/movies/" + id + "/available", null);
    }

}

