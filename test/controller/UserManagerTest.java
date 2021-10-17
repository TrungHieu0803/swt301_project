/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.sun.prism.impl.PrismSettings;
import java.util.ArrayList;
import java.util.List;
import model.User;
import org.junit.AfterClass;
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

    /**
     * Test of getListAccounts method, of class UserManager.
     */
    @Test
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
    public void testCheckLogin() {
        System.out.println("checkLogin");
        String filename = "user.dat";
        User user = new User(1, "hieu", "123", 1);
        boolean expResult = true;
        boolean result = UserManager.checkLogin(filename, user);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        System.out.println("* UserManagerTest: testCheckLogin");
    }
//    /**
//     * Test of changePassword method, of class UserManager.
//     */
//    @Test
//    public void testChangePassword() {
//        System.out.println("changePassword");
//        User user = null;
//        String newPassword = "";
//        UserManager.changePassword(user, newPassword);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of saveAccount method, of class UserManager.
//     */
//    @Test
//    public void testSaveAccount() {
//        System.out.println("saveAccount");
//        List<String> listUsers = null;
//        UserManager.saveAccount(listUsers);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getUserList method, of class UserManager.
//     */
//    @Test
//    public void testGetUserList() {
//        System.out.println("getUserList");
//        UserManager instance = new UserManager();
//       
//        List<String> result = UserManager.getListAccounts();
//        List<String> expResult = new ArrayList<>();
//        
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        System.out.println("* UserManagerTest: testGetUserList");
}
//
//    /**
//     * Test of addUser method, of class UserManager.
//     */
//    @Test
//    public void testAddUser() {
//        System.out.println("addUser");
//        UserManager instance = new UserManager();
//        instance.addUser();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of updateUser method, of class UserManager.
//     */
//    @Test
//    public void testUpdateUser() {
//        System.out.println("updateUser");
//        UserManager instance = new UserManager();
//        instance.updateUser();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of deleteUser method, of class UserManager.
//     */
//    @Test
//    public void testDeleteUser() {
//        System.out.println("deleteUser");
//        UserManager instance = new UserManager();
//        instance.deleteUser();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

