package ru.borisov.objects;

import javax.validation.constraints.Size;

public class User {

    @Size(min=6, message = "Имя должно быть человеческой длины")
    public String name;

    @Size(min=6, max = 10 , message = "Пароль в диапазоне от 6 до 10 символов")
    public String password;


    public Boolean admin;

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
