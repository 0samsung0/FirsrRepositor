package com.example.practisewithoutsequrity.model;

import com.example.practisewithoutsequrity.entity.Automobile;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AutomobileForm {

    private String brand;
    private String color;
    private Integer count_place;

    public Automobile toAuto(){

        Automobile a = new Automobile();

        a.setBrand(brand);
        a.setColor(color);
        a.setCountPlace(count_place);

        System.out.println("\n AUTOMOBILE FORM =========== " + brand + " " + color + " " + count_place + "\n" );

        return a;

    }

}