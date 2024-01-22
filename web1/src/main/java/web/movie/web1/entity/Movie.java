package web.movie.web1.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;
import web.movie.web1.model.MovieType;

import java.util.Date;

@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
@ToString
@Table(name ="movie")
@Entity
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String title;
    String slug;
    @Column(columnDefinition = "TEXT" )
    String description;
    String poster;

    Integer relishYear;
    Integer view;

    Double rating;

    @Enumerated(EnumType.STRING)
    MovieType movieType;
    Boolean status;
    Date createAt;
    Date updateAt;
    Date publishedAt;
}
