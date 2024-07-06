package com.example.practisewithoutsequrity.model;


import com.example.practisewithoutsequrity.entity.Drive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DriveForm {

    String status;
    String title;

    public Drive toDrive(){
        Drive drive = new Drive();

        drive.setTitle(title);
        drive.setStatus(status);

        return drive;
    }



}
