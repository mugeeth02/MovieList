package com.mugeeth.movies.controller;

import com.mugeeth.movies.model.Movie;
import com.mugeeth.movies.repo.MovieListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class MovieListController {
    @Autowired
    private MovieListRepository movieListRepository;
    @GetMapping
    @RequestMapping("/movies/{actor}") //{} inside flower bracket getting from url
    public String getMovieListByActor(@PathVariable("actor") String name, Model model){  //http://localhost:8080/movies
    //actor pathvariable assigned in this name
      /*  List<Movie> movieList = new ArrayList<Movie>();
        Movie movie = new Movie();
        movie.setActor("Tom");
        movie.setDescription("Mission Impossible 3");
        movie.setName("MI3");

        movieList.add(movie);*/

        List<Movie> movieList = movieListRepository.findMoviesByActor(name);

        model.addAttribute("movies",movieList);
        return "movieList";
    }
    @PostMapping
    @RequestMapping("/movies")
    public ResponseEntity<Object> addMovie(@RequestBody Movie movie){
        movieListRepository.save(movie);
        return ResponseEntity.ok().build();
    }
}
