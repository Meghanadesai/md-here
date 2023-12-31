package io.javabrains.movieinfoservice;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieInfoResource {
	
	@RequestMapping("/{movieId}")
	public Movie getMovieInfo(@PathVariable String movieId) {
		return new Movie(movieId, "Kushi");
	}
}
