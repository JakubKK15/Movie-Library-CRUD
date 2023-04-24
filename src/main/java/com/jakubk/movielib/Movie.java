package com.jakubk.movielib;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
  private int id;
  private String title;
  private int rating;

  /*
   Uncomment the code below if lombok is throwing any errors about missing getters and setters,
   and the code will work fine.
   ----------------------------------
    public int getId() {
      return id;
    }

    public void setId(int id) {
      this.id = id;
    }

    public String getTitle() {
      return title;
    }

    public void setTitle(String title) {
      this.title = title;
    }

    public int getRating() {
      return rating;
    }

    public void setRating(int rating) {
      this.rating = rating;
    }
  */


}
