package com.example.practisewithoutsequrity.entity;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Setter
@Getter
@Table(name = "Status")
@ToString
public class Status {

    private Long id;
    private Double statusTime;
    private Double statusTask;


    public Double findPercentTime(Date dateStart, Date dateFinish) {
        Date dateNow = new Date();

        // Вычисляем общую длительность задачи
        long totalDuration = dateFinish.getTime() - dateStart.getTime();

        // Вычисляем длительность, прошедшую на данный момент
        long elapsedDuration = dateNow.getTime() - dateStart.getTime();

        // Вычисляем процент завершенности
        double percentComplete = (double) elapsedDuration / totalDuration * 100;

        // Возвращаем результат
        return percentComplete;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
