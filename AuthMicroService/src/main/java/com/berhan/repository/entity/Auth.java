package com.berhan.repository.entity;

import com.berhan.utility.enums.State;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tbl_auth")
public class Auth {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true,length = 64,nullable = false)
    String userName;
    @Column(nullable = false,length = 128)
    String password;
    Long createAt;
    Long updateAt;
    @Enumerated(EnumType.STRING)
    State state;
}
