package com.dh.catalog.event;


import com.dh.catalog.configurations.RabbitMQ;
import com.dh.catalog.model.MovieEntity;
import com.dh.catalog.model.SerieEntity;
import com.dh.catalog.model.dto.MovieEntityDto;
import com.dh.catalog.model.dto.SerieEntityDto;
import com.dh.catalog.repository.MovieRepository;
import com.dh.catalog.repository.SeriesRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class NewSerieEventConsumer {
    private final SeriesRepository seriesRepository;

    public NewSerieEventConsumer(SeriesRepository seriesRepository) {
        this.seriesRepository = seriesRepository;
    }

    @RabbitListener(queues = RabbitMQ.QUEUE_NEW_SERIE)
    public void execute(NewSerieEventConsumer.Data data) {
        SerieEntity serieNew= new SerieEntity();
        BeanUtils.copyProperties(data.getSerie(),serieNew);
        seriesRepository.save(serieNew);
    }
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Data implements Serializable {
        private SerieEntityDto serie = new SerieEntityDto();
    }




}
