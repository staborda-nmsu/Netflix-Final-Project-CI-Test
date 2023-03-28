package com.company.gameStore.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name="game")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="book_id")
    private Integer id;
    @Column(name="title")
    String title;
    @Column(name="esrb_rating")
    String esrbRating;
    @Column(name="description")
    String description;
    @Column(name="price")
    Double price;
    @Column(name="studio")
    String studio;
    @Column(name="quantity")
    int quantity;

    public Game() {

    }

    public Game(String title, String esrb_rating, String description, Double price, String studio) {
        this.title = title;
        this.esrbRating = esrb_rating;
        this.description = description;
        this.price = price;
        this.studio = studio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEsrbRating() {
        return esrbRating;
    }

    public void setEsrb_rating(String esrb_rating) {
        this.esrbRating = esrb_rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return quantity == game.quantity && id.equals(game.id) && title.equals(game.title) && esrbRating.equals(game.esrbRating) && description.equals(game.description) && price.equals(game.price) && studio.equals(game.studio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, esrbRating, description, price, studio, quantity);
    }
}
