package com.dh.series.events;

import com.dh.series.config.RabbitMQConfig;
import com.dh.series.model.SeasonEntity;
import com.dh.series.model.SerieEntity;
import com.dh.series.model.dto.SeasonDto;
import com.dh.series.model.dto.SerieDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Component
public class NewSerieEventProducer {

    private final RabbitTemplate rabbitTemplate;

    public NewSerieEventProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }
    public void execute(SerieEntity serieEntity) {
        NewSerieEventProducer.Data data = new NewSerieEventProducer.Data();
        BeanUtils.copyProperties(serieEntity, data.getSerie());
        if (data.getSerie() != null ) {
            BeanUtils.copyProperties(data.getSerie();
        }
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME, RabbitMQConfig.TOPIC_NEW_SERIES, data);
    }


    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Data implements Serializable {

        @Serial
        private static final long serialVersionUID = 1L;
        private SerieDto serie = new SerieDto();

        @Getter
        @Setter
        @NoArgsConstructor
        @AllArgsConstructor
        public static class SerieDto implements Serializable {
            @Serial
            private Integer serieId;

            private String name;

            private String genre;

            private List<SeasonEntity> seasonsEntities = new ArrayList<>();


        }

    }



}