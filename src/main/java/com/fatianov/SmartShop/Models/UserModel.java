package com.fatianov.SmartShop.Models;

import com.fatianov.SmartShop.Entities.User;
import lombok.*;

import java.util.Date;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {

    private Long id;

    private String name;

    private String surname;

    private Date birthday;

    private String phone;

    private String email;

    private String passwordHash;

    public static UserModel toModel(User user){
        UserModel model = new UserModel();
        model.id = user.getId();
        model.name = user.getName();
        model.surname = user.getSurname();
        model.birthday = user.getBirthday();
        model.phone = user.getPhone();
        model.email = user.getEmail();
        model.passwordHash = user.getPasswordHash();
        return model;
    }

}
