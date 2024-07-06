package com.example.practisewithoutsequrity.model;


import com.example.practisewithoutsequrity.entity.Location;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Data
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LocationForm {

    String start_location;
    String finish_location;
    LocalDate start_time;
    LocalDate finish_time;

    public Location toLocation(){

        Location location = new Location();

        location.setStartLocation(start_location);
        location.setFinishLocation(finish_location);
        location.setStartTime(start_time);
        location.setFinishTime(finish_time);


        System.out.println("\n\n location form is ======== " + location.toString() + "\n\n");

        return location;
    }
}
