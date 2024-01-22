package web.movie.web1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import web.movie.web1.Repository.MovieRepository;
import web.movie.web1.entity.Movie;
import web.movie.web1.model.MovieType;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService  {
    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> getAllMovie(){
        return movieRepository.findMovieByStatus(true);
    }




    public List<Movie> getSingleMovie (){
        List<Movie> movieList = movieRepository.findByMovieTypeAndStatusOrderByRelishYearDesc(MovieType.PHIM_LE,true).stream()
                .limit(4)
                .toList();
        return movieList;
    }


    public List<Movie> getSeriesMovie() {
        List<Movie> movieList = movieRepository.findByMovieTypeAndStatusOrderByRelishYearDesc(MovieType.PHIM_BO,true).stream()
                .limit(4)
                .toList();
        return movieList;
    }

    public List<Movie> getTheatricalMovies() {
        List<Movie> movieList = movieRepository.findByMovieTypeAndStatusOrderByRelishYearDesc(MovieType.PHIM_CHIEU_RAP,true).stream()
                .limit(4)
                .toList();
        return movieList;
    }
    public Movie getMoviViewHight(){
        Movie movie =movieRepository.findMovieByStatusOrderByViewDesc(true).get(0);
        return movie;
    }



    public List<Movie> getAllSingleMovie() {

        List<Movie> movieList = movieRepository.findByMovieTypeAndStatusOrderByRelishYearDesc(MovieType.PHIM_LE,true).stream()
                .skip(3)
                .limit(8)
                .toList();
        return movieList;

    }
    public List<Movie> getTopSingleMovie(){
        List<Movie> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Movie movie = movieRepository.findByMovieTypeAndStatusOrderByRelishYearDesc(MovieType.PHIM_LE,true).get(i);
            list.add(movie);
        }
        return list;
    }

    public List<Movie>  movieSuggestionsPageSingleMovie() {
        List<Movie> movieList = movieRepository.findByMovieTypeAndStatusOrderByRelishYearDesc(MovieType.PHIM_BO,true).stream()
                .limit(4)
                .toList();
        return movieList;
    }
    public List<Movie>  movieSuggestionsPageSeriesMovie() {
        List<Movie> movieList = movieRepository.findByMovieTypeAndStatusOrderByRelishYearDesc(MovieType.PHIM_CHIEU_RAP,true).stream()
                .limit(4)
                .toList();
        return movieList;
    }
    public List<Movie>  movieSuggestionsPageTheatricalMovie() {
        List<Movie> movieList = movieRepository.findByMovieTypeAndStatusOrderByRelishYearDesc(MovieType.PHIM_LE,true).stream()
                .limit(4)
                .toList();
        return movieList;
    }

    public List<Movie> getTopSeriesMovie() {
        List<Movie> list = movieRepository.findByMovieTypeAndStatusOrderByRelishYearDesc(MovieType.PHIM_BO,true).stream()
                .limit(3)
                .toList();
        return list;
    }

    public List<Movie> getAllSeriesMovie() {
        List<Movie> list = movieRepository.findByMovieTypeAndStatusOrderByRelishYearDesc(MovieType.PHIM_BO,true).stream()
                .skip(3)
                .limit(8)
                .toList();
        return list;
    }


    public List<Movie> getTheatricalMoviesTop() {
        List<Movie> list = movieRepository.findByMovieTypeAndStatusOrderByRelishYearDesc(MovieType.PHIM_CHIEU_RAP,true).stream()
                .limit(3)
                .toList();

        return list;
    }

    public List<Movie> getAllTheatricalMovies() {
        List<Movie> list = movieRepository.findByMovieTypeAndStatusOrderByRelishYearDesc(MovieType.PHIM_CHIEU_RAP,true).stream()
                .skip(3)
                .limit(8)
                .toList();
        return list;
    }

    public List<Movie> getFeaturedMovie() {
        List<Movie> movieList = movieRepository.findMovieByStatusOrderByViewDesc(true).stream()
                .limit(4)
                .toList();
        return movieList;
    }

    public List<Movie> top3RatingMovie() {
        List<Movie> list = movieRepository.findByStatusOrderByRatingDesc(true).stream()
                .limit(3)
                .toList();
        return list;
    }
}
