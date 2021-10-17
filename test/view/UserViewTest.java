/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import org.junit.Test;
import static org.junit.Assert.*;
import common.DataInput;
import controller.UserManager;
import model.User;

/**
 *
 * @author This PC
 */
public class UserViewTest {
    
    public UserViewTest() {
    }

    @Test
    public void testManageUsers() {
    }

    @Test
    public void testLogin() {
    }

    @Test
    public void testGetUserInfo() {
        User user = new User();
        user.setUserName("quoc");
        user.setPassword("VietNam");
       
        String expected="quoc";
        String result=user.getUserName();
       assertEquals(expected, result);
        fail("The test case is a prototype.");
    }

    

    @Test
    public void testDisplayUserList() {
    }
    
}
