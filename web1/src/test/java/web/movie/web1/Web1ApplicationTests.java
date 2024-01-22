package web.movie.web1;

import com.github.javafaker.Faker;
import com.github.slugify.Slugify;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import web.movie.web1.Repository.MovieRepository;
import web.movie.web1.entity.Movie;
import web.movie.web1.model.MovieType;

import java.util.Date;
import java.util.Random;

@SpringBootTest
class Web1ApplicationTests {
    @Autowired
    private MovieRepository movieRepository;

    @Test
    void contextLoads() {
        Faker faker = new Faker();
        Slugify slugify = Slugify.builder().build();
        Random random = new Random();


        for (int i = 0; i < 100; i++) {
            String title = faker.book().title();
            Boolean status = faker.bool().bool();
            Date createAt = faker.date().birthday();
            Date publishAt = null;
            if (status){
                publishAt = createAt;
            }


            Movie movie = Movie.builder()
                    .title(title)
                    .slug(slugify.slugify(title))
                    .description(faker.lorem().paragraph())
                    .poster(faker.company().logo())
                    .relishYear(faker.number().numberBetween(2020,2024))
                    .view(faker.number().numberBetween(1000,10000))
                    .rating(faker.number().randomDouble(1,6,10))
                    .movieType(MovieType.values()[random.nextInt(MovieType.values().length)])
                    .status(faker.bool().bool())
                    .createAt(createAt)
                    .updateAt(createAt)
                    .publishedAt(publishAt)



                    .build();
            movieRepository.save(movie);
        }


    }

}
