/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyProject;

/**
 *
 * @author David Gordon Plouse
 */
public class Games {

    private int id;
    private String name;
    private double price;
    private int number;
    private int date;
    String getName;

    public Games(int id, String name, double price, int number, int date) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.number = number;
        this.date = date;
    }

    Games() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    Games(int id, String name, double price) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * returns the name
     * @return
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
       // return "Games{" + "id=" + id + ", name=" + name + ", price=" + price + ", number=" + number + ", date=" + date + '}';
        // return String.format("%5d %-20s %8.2f", id, name, price, number, date);
         return String.format("%5d %-27s %8.2f %5d %5d", id, name, price, number, date);
    }

}
