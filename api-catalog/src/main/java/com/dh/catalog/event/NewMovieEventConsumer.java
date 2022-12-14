package com.dh.catalog.event;
import com.dh.catalog.configurations.RabbitMQ;
import com.dh.catalog.model.MovieEntity;
import com.dh.catalog.model.dto.MovieEntityDto;
import com.dh.catalog.repository.MovieRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class NewMovieEventConsumer {
    private final MovieRepository movieRepository;

    public NewMovieEventConsumer(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @RabbitListener(queues = RabbitMQ.QUEUE_NEW_MOVIE)
    public void execute(NewMovieEventConsumer.Data data) {
        MovieEntity movieNew= new MovieEntity();
        BeanUtils.copyProperties(data.getMovie(),movieNew);
        movieRepository.save(movieNew);
    }
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Data implements Serializable {
        private MovieEntityDto movie = new MovieEntityDto();
    }

}

