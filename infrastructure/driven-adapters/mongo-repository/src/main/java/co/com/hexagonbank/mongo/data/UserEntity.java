package co.com.hexagonbank.mongo.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Users")
public class UserEntity {

    @Id
    @Field(name = "id")
    private long id;

    @Field(name = "username")
    private String username;

    @Field(name = "password")
    private String password;

    @Field(name = "name")
    private String name;

    @Field(name = "last_name")
    private String lastName;

    @Field(name = "phone")
    private long phone;

    @Field(name = "email")
    private String email;
}
