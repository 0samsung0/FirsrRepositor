package com.example.practisewithoutsequrity.model;


import com.example.practisewithoutsequrity.entity.Task;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskForm {

    String bio;
    Integer lvl_important;
    Integer cost;

    public Task toTask(){

        Task task = new Task();

        task.setBio(bio);
        task.setCost(cost);
        task.setLvl_important(lvl_important);

        return task;
    }


}
