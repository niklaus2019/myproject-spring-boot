package com.example.myprojectspringboot.dto;

public class AuthorDto {
    private int id;
    private String surname;
    private String name;

    public AuthorDto(int id, String surname, String name) {
        this.id = id;
        this.surname = surname;
        this.name = name;
    }

    public AuthorDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "AuthorDto{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
