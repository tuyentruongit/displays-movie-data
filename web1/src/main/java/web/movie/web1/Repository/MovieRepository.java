package web.movie.web1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.movie.web1.entity.Movie;
import web.movie.web1.model.MovieType;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie , Integer>  {
    List<Movie> findByMovieTypeAndStatusOrderByRelishYearDesc(MovieType movitype,Boolean status);
    List<Movie> findByMovieTypeAndStatusOrderByViewDesc(MovieType movitype,Boolean status);

    List<Movie> findMovieByStatusOrderByViewDesc(Boolean status);
    List<Movie> findMovieByStatus(Boolean status);
    List<Movie> findByStatusOrderByRatingDesc(Boolean status);

}
