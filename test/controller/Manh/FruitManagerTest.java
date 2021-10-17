/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import common.DataInput;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
import controller.FruitManager;
import model.Fruit;

/**
 *
 * @author This PC
 */
public class FruitManagerTest {
    

    @Test
    public void testTempFruit() {
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
        
        //TC1 :Kiểm tra số lượng của list 
           int expected=6;
           assertEquals(expected, fruitList.size());
        //TC2 : Kiem tra fruit cuoi cung 
            String expected2="apple";
            String real=fruitList.get(fruitList.size()-1).getFruitName();
            assertEquals(expected2, real);
        //TC3 
            String expected3="Vietnam";
            String real3=fruitList.get(fruitList.size()-1).getOrigin();
            assertEquals(expected3, real3);
            

        
        
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
        
        // TC1: Check if Id not found
        boolean flag = false;
        int testId = 7;
        if (!DataInput.fruitExisted(fruitList, testId)) {
                flag=true;
                System.out.println("FruitID does not exist ");
                return;
            }
        assertEquals(true, flag);
        
        //TC2: Delete 1 element on arraylist
        testId = 1; 
        for(int i = 0; i < fruitList.size(); i++){
            if(testId == fruitList.get(i).getFruitId()){
                fruitList.remove(i);
                break;
            }
        
        }
        int expectedResult = 1; 
        int sizeNow = fruitList.size();
        assertEquals(expectedResult, sizeNow);
        //TC3 :
         int expectedResult2 = 5; 
        
        assertEquals(expectedResult, sizeNow);
    }
     

    @Test
    public void testGetFruitByItem() {
        
    }
    
     
    
    @Test
    public void testGetFruitList() {
        
    }
    
}
