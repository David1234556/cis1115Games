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
public class GamesStatistics {
      public static double lowestPrice(DAOGames data) {
        int low = 0;
        for(Games games : data.myList) {
            if(games.getPrice() < low) low = (int) games.getPrice();
        }
        return low;
    }
    
    public static double highestPrice(DAOGames data) {
        double highest = 0;
        for(Games games : data.myList) {
            if(games.getPrice() > highest) highest = games.getPrice();
        }
        return highest;
    }
    
    public static double sumPrice(DAOGames data) {
        double sum = 0;
        for(Games games : data.myList) {
            sum += games.getPrice();
        }
        return sum;
    }
    
    public static double avgPrice(DAOGames data) {
        double sum = sumPrice(data);
        double average = sum / data.myList.size();
        return average;
    }
    
    public static double standardDeviation(DAOGames data) {
        double total = 0;
        double average = avgPrice(data);
        for(Games games : data.myList) { 
            total += Math.pow((games.getPrice() - average), 2);
        }
        return Math.sqrt(total / (data.myList.size() - 1));
    }
        
}

