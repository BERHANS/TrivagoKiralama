package com.berhan.repository.entity;


import com.berhan.utility.enums.State;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document //data tipleri döküman olduğu için MongoDB dökümental olduğu içindir.
public class UserProfile {
    @Id
    String id;//burda sekans oluşturma olmadığı için burda @Id üzerinden gerçekleştiği için long tutmadık.
    Long authId;
    String userName;
    String email;
    String name;
    String photo;
    String phone;
    State state;

}
