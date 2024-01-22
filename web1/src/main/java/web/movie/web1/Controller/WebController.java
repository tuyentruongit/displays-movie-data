package web.movie.web1.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import web.movie.web1.entity.Movie;
import web.movie.web1.service.MovieService;

import java.util.Objects;

@Controller
public class WebController {
    @Autowired
    private MovieService movieService;

    @GetMapping("/")
    public String getHome(Model model){
        model.addAttribute("posterBackground",movieService.getMoviViewHight());
        model.addAttribute("printSingleMovie",movieService.getSingleMovie());
        model.addAttribute("seriesMovie",movieService.getSeriesMovie());
        model.addAttribute("theatricalMovies",movieService.getTheatricalMovies());

        return "web/index";
    }

    @GetMapping("/phim-le")
    public String getSingleMovie(Model model){
        model.addAttribute("singleMovieTop" , movieService.getTopSingleMovie());
        model.addAttribute("listSingleMovie",movieService.getAllSingleMovie());
        model.addAttribute("movieSuggestions",movieService.movieSuggestionsPageSingleMovie());
        return "web/phim-le";
    }


    @GetMapping("/series-movie")
    public String getSeriesMovie(Model model){
        model.addAttribute("seriesMovieTop" , movieService.getTopSeriesMovie());
        model.addAttribute("listSeriesMovie",movieService.getAllSeriesMovie());
        model.addAttribute("movieSuggestions",movieService.movieSuggestionsPageSeriesMovie());
        return "web/series-movie";
    }


    @GetMapping("/phim-chieu-rap")
    public String getTheatricalMovies(Model model){
        model.addAttribute("theatricalMoviesTop" , movieService.getTheatricalMoviesTop());
        model.addAttribute("listTheatricalMovies",movieService.getAllTheatricalMovies());
        model.addAttribute("movieSuggestions",movieService.movieSuggestionsPageTheatricalMovie());
        return "web/phim-chieu-rap";
    }

    @GetMapping("/phim/{id}/{slug}")
    public String moviesDetail(@PathVariable Integer id,@PathVariable String slug,Model model){
        Movie movie = movieService.getAllMovie().stream()
                .filter(s-> Objects.equals(s.getId(), id))
                .findFirst()
                .orElse(null);

        model.addAttribute("movieDetail",movie);
        model.addAttribute("featuredMovie" ,movieService.getFeaturedMovie());
        model.addAttribute("top3RatingMovie" , movieService.top3RatingMovie());

        return "web/movies-detail";
    }


}
