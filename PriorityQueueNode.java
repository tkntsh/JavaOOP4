/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;

/**
 * Ntshangase
 * Ntokozo
 * 4123601
 * CSC211 2022 Practical 4
 * PriorityQueueNode.java
 * @author Ntokozo
 */

public class PriorityQueueNode 
{
    private String type;
    private String title;
    private int releaseYear;
    private int rating;

     public PriorityQueueNode()
     {
         this.type = "";
         this.title = "";
         this.releaseYear = 0;
         this.rating = 0;
     }
    
    public PriorityQueueNode(String type, String title, int releaseYear, int rating) 
    {
        this.type = type;
        this.title = title;
        this.releaseYear = releaseYear;
        this.rating = rating;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
