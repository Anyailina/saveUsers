package org.example;


import lombok.Getter;
import lombok.Setter;
import java.util.UUID;

@Setter
@Getter
public class User {
    private UUID id;
    private String firstName;
    private String lastName;
    private String patronymic;

    public User(String firstName, String lastName, String patronymic) {
        this.id = UUID.randomUUID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
    }
    public User(UUID id, String firstName,String lastName, String patronymic) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
    }

    @Override
    public String toString() {
        return  id + " " +
                firstName + " " +
                 lastName + " " + patronymic;
    }
}
