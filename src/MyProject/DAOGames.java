/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyProject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The data access object to a collection of Games.
 *
 * @author David Gordon Plouse
 */
public class DAOGames {

    List<Games> myList;
    String fileName = "games.txt";

    public DAOGames() {
        myList = new ArrayList();
        try {
            Files.createFile(Paths.get(fileName));
        } catch (FileAlreadyExistsException fae) {
            ;
        } catch (IOException ex) {
            Logger.getLogger(DAOGames.class.getName()).log(Level.SEVERE, null, ex);
        }
        readList();
    }

    public void create(Games games) {
        // add a game to the list
        myList.add(games);
        writeList();
    }

    public Games retrieve(int id) {
        // return a single game record from the list or null if it does not exist
        for (Games g : myList) {
            if (g.getId() == id) {
                return g;
            }
        }
        return null;
    }

    public void update(Games games) {
        for (Games g : myList) {
            if (g.getId() == games.getId()) {
                g.setName(games.getName());
                //do this for all fields
                break;
            }
        }
        writeList();
    }

    public void delete(int id) {
        Games myGames = null;
        for (Games g : myList) {
            if (g.getId() == id) {
                myGames = g;
                break;
            }
        }
        writeList();
    }

    /**
     *
     * @return
     */
    public String orderById() {
        myList.sort(Comparator.comparing(Games::getId));
        return this.toString();
    }

    public String orderByName() {
        myList.sort(Comparator.comparing(Games::getName));//.thencomparing(Pet::getPrice).reversed);
        return this.toString();
    }

    public String orderByPrice() {
        myList.sort((Games g1, Games g2) -> {
            if (g1.getName().equals(g2.getName())) {
                return Double.compare(g2.getPrice(), g1.getPrice());
            } else {
                return g1.getName().compareTo(g2.getName());
            }
        });
        return this.toString();
    }

    public String orderByNumber() {
        myList.sort(Comparator.comparing(Games::getNumber));
        return this.toString();
    }

    public String orderByDate() {
        myList.sort(Comparator.comparing(Games::getDate));
        return this.toString();
    }

    public String orderByNamePrice() {
        myList.sort(Comparator.comparing(Games::getName).thenComparing(Games::getPrice).reversed());
        return this.toString();
    }

    private void readList() {
        Path path = Paths.get(fileName);
        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String name = data[1];
                double price = Double.parseDouble(data[2]);
                int number = Integer.parseInt(data[3]);
                int date = Integer.parseInt(data[4]);
                Games mygames = new Games(id, name, price, number, date);
                myList.add(mygames);
            }
        } catch (IOException ex) {
            Logger.getLogger(DAOGames.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void writeList() {
        Path path = Paths.get(fileName);
        try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
            for (Games games : myList) {
                writer.write(String.format("%d,%s,%.2f,%d,%d\n",
                        games.getId(),
                        games.getName(),
                        games.getPrice(),
                        games.getNumber(),
                        games.getDate()));
            }
        } catch (IOException ex) {
            Logger.getLogger(DAOGames.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");
        for (Games games : myList) {
            StringBuilder append = sb.append(games).append("\n");
            //  sb.append(games).append("\n")
        }
        return sb.toString();
    }

}
