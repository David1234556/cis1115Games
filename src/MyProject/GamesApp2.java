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
public class GamesApp2 {
    public static void main(String[] args) {
        DAOGames data = new DAOGames();
        data.create(new Games(1, "RPG", 60, 8665, 2012));
        data.create(new Games(2, "RPG", 40, 5574, 2007));
        System.out.println(data);
        
        System.out.println(data.retrieve(2));
        
       // data.update(new Games(2, "Skyrim", 50, 5574, 2012));
        
        Games g1;
        g1 = new Games(1, "Skyrim", 60, 8665, 2012);
        data.update(g1);
        System.out.println(data.retrieve(2));
        
        data.delete(3);
        System.out.println(data);
    }
}
