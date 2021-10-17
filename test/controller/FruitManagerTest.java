/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import model.Fruit;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Viet
 */
public class FruitManagerTest {

    FruitManager fm;

    public FruitManagerTest() {
        fm = new FruitManager();
    }

    @Test
    public void testAddFruit() {
        ArrayList<Fruit> fruitList = new ArrayList<>();
        fruitList.add(new Fruit(1, "lemon", 2, 100, "Vietnam"));
        fruitList.add(new Fruit(2, "Avocado", 5, 100, "Vietnam"));
        fruitList.add(new Fruit(3, "Banana", 4, 100, "Vietnam"));
        fruitList.add(new Fruit(4, "Grape", 9, 100, "Vietnam"));
        fruitList.add(new Fruit(5, "Papaya", 9, 100, "Vietnam"));
        fruitList.add(new Fruit(6, "apple", 3, 100, "Vietnam"));

        ArrayList<Fruit> expectedList = new ArrayList<>();
        fruitList.add(new Fruit(1, "lemon", 2, 100, "Vietnam"));
        fruitList.add(new Fruit(2, "Avocado", 5, 100, "Vietnam"));
        fruitList.add(new Fruit(3, "Banana", 4, 100, "Vietnam"));
        fruitList.add(new Fruit(4, "Grape", 9, 100, "Vietnam"));
        fruitList.add(new Fruit(5, "Papaya", 9, 100, "Vietnam"));
        fruitList.add(new Fruit(6, "apple", 3, 100, "Vietnam"));
        fruitList.add(new Fruit(7, "mango", 20, 100, "Vietnam"));
        fruitList.add(new Fruit(8, "orange", 5, 100, "Vietnam"));
        for (int i = 0; i < fruitList.size(); i++) {
            assertEquals(fruitList.get(i).getFruitId(), expectedList.get(i).getFruitId());
        }
        fail("The test case is a prototype.");
    }

    @Test
    public void testUpdateFruit() {
    }

    @Test
    public void testDeleteFruit() {
        ArrayList<Fruit> fruitList = new ArrayList<>();
        fruitList.add(new Fruit(1, "lemon", 2, 100, "Vietnam"));
        fruitList.add(new Fruit(2, "Avocado", 5, 100, "Vietnam"));
        fruitList.add(new Fruit(3, "Banana", 4, 100, "Vietnam"));
        fruitList.add(new Fruit(4, "Grape", 9, 100, "Vietnam"));
        fruitList.add(new Fruit(5, "Papaya", 9, 100, "Vietnam"));
        fruitList.add(new Fruit(6, "apple", 3, 100, "Vietnam"));

        for (int i = 0; i < fruitList.size(); i++) {
            fruitList.remove(fruitList.get(i).getFruitId());
            assertEquals("Removing 1 fruit from list", 2, fruitList.size());
        }
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetFruitList() {
    }

    @Test
    public void testGetFruitByItem() {
    }
 
}
