package com.jakubk.movielib;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieController {

  @Autowired
  MovieRepository movieRepository;

  @GetMapping("")
  public List<Movie> getAll() {
    return movieRepository.getAll();
  }

  @GetMapping("/{id}")
  public Movie getById(@PathVariable("id") int id) {
    return movieRepository.getById(id);
  }

  @PostMapping("")
  public int addMovie(@RequestBody List<Movie> movies) {
    return movieRepository.save(movies);
  }

  @PutMapping("/{id}")
  public int update(@PathVariable("id") int id, @RequestBody Movie updatedMovie) {
    Movie movie = movieRepository.getById(id);

    if (movie != null) {
      movie.setTitle(updatedMovie.getTitle());
      movie.setRating(updatedMovie.getRating());

      movieRepository.update(movie);
      return 1;
    } else {
      return -1;
    }
  }

  @PatchMapping("/{id}")
  public int partiallyUpdate(@PathVariable("id") int id, @RequestBody Movie updatedMovie) {
    Movie movie = movieRepository.getById(id);

    if (movie != null) {
      if (updatedMovie.getTitle() != null)
        movie.setTitle(updatedMovie.getTitle());
      if (updatedMovie.getRating() > 0)
        movie.setRating(updatedMovie.getRating());

      movieRepository.update(movie);

      return 1;
    } else {
      return -1;
    }
  }

  @DeleteMapping("/{id}")
  public int delete(@PathVariable("id") int id) {

    return movieRepository.delete(id);
  }
}


