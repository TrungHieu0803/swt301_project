/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import common.AppConstant;
import common.DataInput;
import static controller.UserManager.userList;
import java.io.FileOutputStream;
import java.util.List;
import model.User;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

/**
 *
 * @author Kien
 */
public class UserManagerTest {
    
    public UserManagerTest() {
    }
    private static UserManager testUserManager;

        @Before
    public void setUp() throws Exception {
//        // sau khi setup thì chạy đến teardown
//        System.out.println("Before Test");
//        User user1 = new User(1, "kiennt", "Vietnam", 1);
//        User user2 = new User(2, "tuanta", "Tuan134", 2);  
//        User user3 = new User(3, "thuypx", "14France", 2); 
//        User user4 = new User(4, "ducndt", "Vietnam", 1);
//        testUserManager.getUser(user1);
//        testUserManager.getUser(user2);
//        testUserManager.getUser(user3);
//        testUserManager.getUser(user4);

    }

    @After
    public void tearDown() throws Exception {
        // giải phóng connection
    }
    /**
     * Test of getListAccounts method, of class UserManager.
     */
    
    @Test
    public void testCheckAccounts(){
        System.out.println("testDeleteUser");
        ArrayList<User> listUsers = new ArrayList<>();
        User user1 = new User(1,"kiennt","Vietnam",1);
        User user2 = new User(2,"tuanta1", "Tuan134", 2);
        User user3 = new User(3,"thuypx","14France",2);
        User user4 = new User(4,"ducndt", "Vietnam1", 1);
        listUsers.add(0,user1);
        listUsers.add(1,user2);
        listUsers.add(2,user3);
        listUsers.add(3,user4);

        testUserManager = new UserManager();
        
        //TC1 (user name true, pass true)
        boolean result = testUserManager.checkLogin(user1);
        boolean expectedResult = true;
        assertEquals("TC1",expectedResult, result);
        
        //TC2 (user name false, pass true)
        boolean result2 = testUserManager.checkLogin(user2);
        boolean expectedResult2 = false;
        assertEquals("TC2",expectedResult2, result2);
        
        //TC3 (user name true, pass false)
        boolean result3 = testUserManager.checkLogin(user4);
        boolean expectedResult3 = false;
        assertEquals("TC2",expectedResult3, result3);
    }
    
    @Test
    public void testGetListAccount(){
        System.out.println("testDeleteUser");
        ArrayList<User> listUsers = new ArrayList<>();
        User user1 = new User(1,"kiennt","Vietnam",1);
        User user2 = new User(2,"tuanta1", "Tuan134", 2);
        User user3 = new User(3,"thuypx8","France",2);
        User user4 = new User(4,"ducndt", "Vietnam1", 3);
        listUsers.add(0,user1);
        listUsers.add(1,user2);
        listUsers.add(2,user3);
        listUsers.add(3,user4);
        
        testUserManager = new UserManager();
        // TC1 (type input invalid, can't add user to file)
        String result = testUserManager.addUserToFile(user4);
        String expectedResult1 = "invalidtype";
        assertEquals("TC1",expectedResult1, result);
        
        // TC2 (username is already in file, can't add user to file)
        String result2 = testUserManager.addUserToFile(user1);
        String expectedResult2 =  "username exist";
        assertEquals("TC2",expectedResult2, result2);
        
        // TC3 (Password is not valid, can't add user to file)
        String result3 = testUserManager.addUserToFile(user3);
        String expectedResult3 = "password invalid";
        assertEquals("TC3",expectedResult3, result3);
        
        // TC4 (All valid, add to file)
        String result4 = testUserManager.addUserToFile(user2);
        String expectedResult4 ="success";
        assertEquals("TC4",expectedResult4, result4);
       
    }
    
    
   @Test
    public void testGetListAccounts() {
        System.out.println("testGetListAccounts");
        int count = 0;
        ArrayList<User> userList = new ArrayList<>();
        File f = new File(AppConstant.USER_DATA);
        try (BufferedReader reader = new BufferedReader(new FileReader(f))) {
            String line = null;
            while((line = reader.readLine())!=null){
                count++;
                User user = new User();
                String[] userInfo = line.split("\\|");
                user.setUserId(Integer.parseInt(userInfo[0].trim()));
                user.setUserName(userInfo[1].trim());
                user.setPassword(userInfo[2].trim());
                if(userInfo[3].trim().equals("Admin")){ // sửa
                    user.setType(1);
                } else {
                    user.setType(2);
                }
                userList.add(user); // đã add được các object từ file sang array list
            }
            reader.close();
        } catch (Exception ignored) {
        }
        int expectedResult = 4;

        ArrayList<User> userListExpected = new ArrayList<>();
        User user1 = new User(1,"kiennt","Vietnam",1);
        User user2 = new User(2,"tuanta", "Tuan134", 2);
        User user3 = new User(3,"thuypx", "14France", 2);
        User user4 = new User(4,"ducndt", "Vietnam", 1);

        userListExpected.add(0,user1);
        userListExpected.add(1,user2);
        userListExpected.add(2,user3);
        userListExpected.add(3,user4);

        // testcase1: Number of list
        assertEquals(expectedResult,count);
        
        // testcase2: test data of list
        assertEquals(userListExpected.get(0).getUserName(), userList.get(0).getUserName());
        assertEquals(userListExpected.get(1).getUserName(), userList.get(1).getUserName());
        assertEquals(userListExpected.get(2).getUserName(), userList.get(2).getUserName());
        assertEquals(userListExpected.get(3).getUserName(), userList.get(3).getUserName());
    }

    @Test(timeout = 100)
    public void testCheckLogin() {
        System.out.println("testCheckLogin");
        String userNameTest = "kiennt";
        String passWordTest = "Vietnam";
        int check = 0;
        User user = new User();
        File f = new File(AppConstant.USER_DATA);
        try (BufferedReader reader = new BufferedReader(new FileReader(f))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                String[] userInfo = line.split("\\|");
                if (userNameTest.equals(userInfo[1].trim()) && passWordTest.equals((userInfo[2].trim()))) {
                    check=1;
                }
            }
        } catch (IOException ex) {
            System.out.println("Loi o buffer reader");
            System.out.println(ex);
        }

        // test case check login of 1 account
        Assert.assertEquals(1,check);
    }


    /**
     * Test of saveAccount method, of class UserManager.
     */
     @Test(timeout = 100)
     public void testSaveAccount(){
        System.out.println("testSaveAccount");
        List<String> listUsers = new ArrayList<>();
        listUsers.add(0,"1|kiennt|Vietnam|Admin|");
        listUsers.add(1,"2|tuanta|Tuan134|Sale|");
        listUsers.add(2,"3|thuypx|14France|Sale|");
        listUsers.add(3,"4|ducndt|Vietnam|Admin");
        int count = 0;
         try (FileOutputStream fos = new FileOutputStream(new File(AppConstant.USER_DATA))) {
            for (String user : listUsers) {
                count++;
                fos.write(user.getBytes());
                fos.write("\n".getBytes());
            }
            fos.close();
        } catch (IOException ex) {
        }
         int expectedResult = 4;
         // test case check file is save account in.
         assertEquals(expectedResult, count);
     }
   
    /**
     * Test of addUser method, of class UserManager.
     */
     @Test(timeout = 100)
    public void testAddUser() {
        System.out.println("testAddUser");
        ArrayList<User> listUsers = new ArrayList<>();
        User user1 = new User(1,"kiennt","Vietnam",1);
        User user2 = new User(2,"tuanta", "Tuan134", 2);
        User user3 = new User(3,"thuypx", "14France", 2);
        User user4 = new User(4,"ducndt", "Vietnam", 1);

        listUsers.add(0,user1);
        listUsers.add(1,user2);
        listUsers.add(2,user3);
        listUsers.add(3,user4);
        boolean flag = true;
        String userName = "ducndt2"; // thêm hàm check username
        if(DataInput.checkName(listUsers,userName)){
            flag = false;
            System.err.println("Username existed!");
            return;
        }
        String password = "Duc1234"; // thêm hàm check password
        int userType = 1;
        User user = new User(5, userName, password, userType);
        listUsers.add(user);
        // TC1: Xem tài khoản có trùng không 
         assertEquals(true, flag);
         
        // TC2 Xem đã add được vào chưa
        int expectedResult = 5;
        assertEquals(expectedResult, listUsers.size());
        
        // TC3 Xem user mới nhất có phải là ducndt2 không
        assertEquals(userName,listUsers.get(4).getUserName());
        
    }

    /**
     * Test of updateUser method, of class UserManager.
     */
    @Test(timeout = 100)
    public void testUpdateUser() {
        System.out.println("testUpdateUser");
        ArrayList<User> listUsers = new ArrayList<>();
        User user1 = new User(1,"kiennt","Vietnam",1);
        User user2 = new User(2,"tuanta", "Tuan134", 2);
        listUsers.add(0,user1);
        listUsers.add(1,user2);
        
        // TC1: Check if Id not found
        boolean flag = false;
        int testId = 3;
        if (!DataInput.userExisted(listUsers, testId)) {
                flag=true;
                System.out.println("User code does not exist is true");
                return;
            }
        assertEquals(true, flag);
        
        // TC2: Id exist, update user;
        testId = 1;
        String userName = "kiennt2";
        String passWord = "Vietnam1";
        int type = 1;
        listUsers.get(0).setUserName(userName);
        listUsers.get(0).setPassword(passWord);
        listUsers.get(0).setType(type);
        
        assertEquals(userName, listUsers.get(0).getUserName());
    }

    /**
     * Test of deleteUserById method, of class UserManager.
     */
    @Test(timeout = 100)
    public void testDeleteUserById() {
        System.out.println("testDeleteUserById");
        ArrayList<User> listUsers = new ArrayList<>();
        User user1 = new User(1,"kiennt","Vietnam",1);
        User user2 = new User(2,"tuanta", "Tuan134", 2);
        listUsers.add(0,user1);
        listUsers.add(1,user2);
        
        // TC1: Check if Id not found
        boolean flag = false;
        int testId = 3;
        if (!DataInput.userExisted(listUsers, testId)) {
                flag=true;
                System.out.println("User code does not exist is true");
                return;
            }
        assertEquals(true, flag);
        
        //TC2: Delete 1 element on arraylist
        testId = 1; 
        for(int i = 0; i < listUsers.size(); i++){
            if(testId == listUsers.get(i).getUserId()){
                listUsers.remove(i);
                break;
            }
        
        }
        int expectedResult = 1; 
        int sizeNow = listUsers.size();
        assertEquals(expectedResult, sizeNow);
    
    }
    
    
}
