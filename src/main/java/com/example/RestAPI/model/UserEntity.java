package com.example.RestAPI.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "bdnoticia")
public class UserEntity {

    @Id
    private String notrelease;
    private String noticia;
    private String release;

    // Método construtor da classe
    public UserEntity(String notrelease, String noticia, String release) {
        this.notrelease = notrelease;
        this.noticia = noticia;
        this.release = release;
    }

    public String getNotrelease() {
        return notrelease;
    }

    public String getNoticia() {
        return noticia;
    }

    public String getRelease() {
        return release;
    }
}
