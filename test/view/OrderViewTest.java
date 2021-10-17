/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;
import java.util.Hashtable;
import org.junit.Test;
import static org.junit.Assert.*;
import model.Order;
import view.OrderView;

/**
 *
 * @author This PC
 */
public class OrderViewTest {
    
    public OrderViewTest() {
    }

     @Test
    public void testDisplayListOrder() {
        System.out.println("displayListOrder");
        ArrayList<Order> lo = null;
        OrderView.displayListOrder(lo);
        fail("The test case is a prototype.");
    }

    @Test
    public void testViewOrder() {
        System.out.println("viewOrder");
        Hashtable<String, ArrayList<Order>> ht = null;
        OrderView.viewOrder(ht);
        fail("The test case is a prototype.");
    }
    
}
