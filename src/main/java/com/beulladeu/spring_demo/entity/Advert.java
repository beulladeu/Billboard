package com.beulladeu.spring_demo.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "adverts_t")
public class Advert {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String username;
    @Column
    private String content;
    @Column
    private Date date;

    /*private int likes;
    private int dislikes;*/

    public Advert(String username, Date date, String content) {
        this.username = username;
        this.date = date;
        this.content = content;
    }

    public Advert() {

    }

    public void setUsername(String personName) {
        this.username = personName;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /*public void like() {
        likes++;
    }

    public void removeLike() {
        likes--;
    }

    public void dislike() {
        dislikes++;
    }

    public void removeDislike() {
        dislikes--;
    }

    public int getLikes() {
        return likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    public int getDif() {
        return likes - dislikes;
    }*/

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public Date getDate() {
        return date;
    }

    public String getContent() {
        return content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Advert advert = (Advert) o;
        return Objects.equals(username, advert.username) &&
                Objects.equals(date, advert.date) &&
                Objects.equals(content, advert.content);
    }
}
