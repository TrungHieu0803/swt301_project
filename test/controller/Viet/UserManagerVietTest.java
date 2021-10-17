/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Viet;

import controller.UserManager;
import java.util.ArrayList;
import model.User;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Viet
 */
public class UserManagerVietTest {
    private static UserManager testUserManager;
    public UserManagerVietTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
        @Test
    public void testCheckAccounts(){
        System.out.println("testDeleteUser");
        ArrayList<User> listUsers = new ArrayList<>();
        User user1 = new User(1,"viethme","viet",1);
        User user2 = new User(2,"phungh", "phu", 2);
        User user3 = new User(3,"manhpd","manh",2);
        User user4 = new User(4,"hieunt", "hieu", 1);
        listUsers.add(0,user1);
        listUsers.add(1,user2);
        listUsers.add(2,user3);
        listUsers.add(3,user4);

        testUserManager = new UserManager();
        
        //TC1 (user name true, pass true)
        boolean result = testUserManager.checkLogin2(user1);
        boolean expectedResult = true;
        assertEquals("TC1",expectedResult, result);
        
        //TC2 (user name false, pass true)
        boolean result2 = testUserManager.checkLogin2(user2);
        boolean expectedResult2 = false;
        assertEquals("TC2",expectedResult2, result2);
        
        //TC3 (user name true, pass false)
        boolean result3 = testUserManager.checkLogin2(user4);
        boolean expectedResult3 = false;
        assertEquals("TC2",expectedResult3, result3);
    }
    
    @Test
    public void testGetListAccount(){
        System.out.println("testDeleteUser");
        ArrayList<User> listUsers = new ArrayList<>();
        User user1 = new User(1,"viethme","viet",1);
        User user2 = new User(2,"phungh", "phu", 2);
        User user3 = new User(3,"manhpd","manh",2);
        User user4 = new User(4,"hieunt", "hieu", 1);
        listUsers.add(0,user1);
        listUsers.add(1,user2);
        listUsers.add(2,user3);
        listUsers.add(3,user4);
        
        testUserManager = new UserManager();
        
        String result = testUserManager.addUserToFile(user4);
        String expectedResult1 = "invalid ";
        assertEquals("TC1",expectedResult1, result);
        
        
        String result2 = testUserManager.addUserToFile(user1);
        String expectedResult2 =  "username is exist";
        assertEquals("TC2",expectedResult2, result2);
        
        
        String result3 = testUserManager.addUserToFile(user3);
        String expectedResult3 = "wrong password";
        assertEquals("TC3",expectedResult3, result3);
        
        
        String result4 = testUserManager.addUserToFile(user2);
        String expectedResult4 ="login success";
        assertEquals("TC4",expectedResult4, result4);
       
    }

    
}
