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




    public Double findPercentTime(Date dateStart, Date dateFinish){
        Date dateNow = new Date();
        return (dateFinish.getSeconds()-dateStart.getSeconds())/(dateNow.getSeconds() - dateStart.getSeconds());
    }
    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
