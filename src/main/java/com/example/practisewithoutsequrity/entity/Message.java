package com.example.practisewithoutsequrity.entity;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Setter
@Getter
@Table(name = "Task")
@ToString
public class Message {

    @Id
    private Long id;
    private String fromAdmin;
    private String toUser;
    private String message;
    private Integer driveId;
    private String answer;

    public void takeMessage(String adm,
                            String us,
                            String message,
                            Integer drId){
        this.fromAdmin=adm;
        this.toUser=us;
        this.message=message;
        this.driveId=drId;
    }
    public void answerMessage(String answ){
        this.answer=answ;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
