/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.Viet;


import controller.*;
import com.sun.prism.impl.PrismSettings;
import java.util.ArrayList;
import java.util.List;
import model.User;
import org.junit.AfterClass;

import common.AppConstant;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.User;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *

 * @author Viet
 */
public class UserManagerTest {

    public UserManagerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        System.out.println("* UserManagerTest: @BeforeClass method");
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("* UserManagerTest: @AfterClass method");
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {

    }

    /**
     * Test of getListAccounts method, of class UserManager.
     */

    public void testGetListAccounts() {
        System.out.println("getListAccounts");
        List<String> expResult = new ArrayList<>();
        expResult.add("1 | hieu  | 123 | 1, 2 | viet | 321 | 2");
//        expResult.add("2 | viet | 321 | 2");
        List<String> result = UserManager.getListAccounts();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        System.out.println("* UserManagerTest: testGetListAccounts");
    }
    /**
     * Test of checkLogin method, of class UserManager.
     */
    @Test
    public void testCheckLoginViet() {
        System.out.println("checkLogin");
        String filename = "user.dat";
        User user = new User(1, "hieu", "123", 1);
        boolean expResult = true;
        boolean result = UserManager.checkLogin(filename, user);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        System.out.println("* UserManagerTest: testCheckLogin");
    }

    /**
     * Test of changePassword method, of class UserManager.
     */
    @Test
    public void testChangePassword() {
        System.out.println("changePassword");
        User user = null;
        String newPassword = "";
        UserManager.changePassword(user, newPassword);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveAccount method, of class UserManager.
     */


    /**
     * Test of getUserList method, of class UserManager.
     */


    /**
     * Test of addUser method, of class UserManager.
     */


    @Test
    public void testMain() {
    }
    

}