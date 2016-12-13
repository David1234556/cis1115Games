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
public class GamesApp {

    public static void main(String[] args) {
        Games g1 = new Games(1, "RPG", 60, 2833, 2002);
        Games g2 = new Games(2, "RPG", 40, 3766, 2012);
        Games g3 = new Games(3, "RPG", 30, 1182, 2013);
        Games g4 = new Games(4, "RPG", 29, 2998, 2008);
        System.out.println(g1);
        System.out.println(g2);
        System.out.println(g3);
        System.out.println(g4);

    }
}
