package com.example.demo.entity;

import lombok.*;
import org.hibernate.annotations.ColumnTransformer;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "application_user")
public class User {

    @Id
    @Column(name = "application_user_id")
    private UUID applicationUserId;

    private String ccId;

    @Column(name="client_id")
    @ColumnTransformer(
            read = "decrypt_client(client_id, application_user_id)",
            write = "encrypt_client(?, application_user_id)"
    )
    private String clientId;

   @Column(name="client_secret")
   @ColumnTransformer(
           read = "decrypt_client(client_secret, application_user_id)",
           write = "encrypt_client(?,application_user_id)"
    )
    private String clientSecret;
    private String geoLocation;
}
