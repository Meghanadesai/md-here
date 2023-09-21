package io.javabrains.moviecatalogservice;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable String userId) {
		
		UserRating userRatings = restTemplate.getForObject("http://localhost:8083/ratingsData/users/"+userId, UserRating.class);
		return userRatings.getUserRating().stream().map(
				rating -> {
					Movie movie = restTemplate.getForObject("http://localhost:8082/movies/"+rating.getMovieId(), Movie.class);
					return new CatalogItem(movie.getName(), "Desc", rating.getRating());
				}
				).collect(Collectors.toList());
						
	}
}
