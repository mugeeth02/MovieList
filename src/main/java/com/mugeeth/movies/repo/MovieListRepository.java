package com.mugeeth.movies.repo;

import com.mugeeth.movies.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieListRepository extends JpaRepository<Movie,Long>{
    List<Movie> findMoviesByActor(String name);
}
