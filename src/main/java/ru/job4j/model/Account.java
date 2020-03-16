package ru.job4j.model;

import java.util.Objects;

public class Account {
    private int id;
    private String name;
    private String phone;

    public Account() {
    }

    public Account(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public Account(int id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return id == account.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Account{id=" + id
                + ", name='" + name + '\''
                + ", phone='" + phone + '\''
                + '}';
    }
}
