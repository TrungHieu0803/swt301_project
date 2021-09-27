package controller;

import common.DataInput;
import java.util.ArrayList;
import model.Fruit;

public class FruitManager {

    private final ArrayList<Fruit> fruitList = new ArrayList<>();

    public void addFruit() {
        //loop until user don't want to create fruit
        // Phan Đức Mạnh: Fruit nên để kiểu int để tránh gây nhầm lẫn .
        while (true) {
            int fruitId = DataInput.checkInputInt("Enter id of fruit :");
            if (DataInput.fruitExisted(fruitList, fruitId)) {
                System.err.println("Id exist");
                return;
            }
            String fruitName = DataInput.checkInputName("Enter fruit name: ");
            double price = DataInput.checkInputDouble("Enter price: ");
            int quantity = DataInput.checkInputInt("Enter quantity: ");
            String origin = DataInput.checkInputString("Enter origin: ");
            fruitList.add(new Fruit(fruitId, fruitName, price, quantity, origin));
            //check user want to continue or not
            if (!DataInput.checkInputYN()) {
                return;
            }
        }
    }

    public void updateFruit() {
        //loop until user don't want to create fruit
        while (true) {
             // Phan Đức Mạnh Fruit nên để kiểu int để tránh gây nhầm lẫn .
             int fruitId = DataInput.checkInputInt("Enter id of fruit :");
            if (!DataInput.fruitExisted(fruitList, fruitId)) {
                System.err.println("Id does not exist!");
                return;
            }
            String fruitName = DataInput.checkInputString("Enter fruit name: ");
            double price = DataInput.checkInputDouble("Enter price: ");
            int quantity = DataInput.checkInputInt("Enter quantity: ");
            String origin = DataInput.checkInputString("Enter origin: ");
            fruitList.add(new Fruit(fruitId, fruitName, price, quantity, origin));
        }
    }
 private  int findTaskExist(int id) {
     // // Phan Đức Mạnh Thêm hàm tìm index theo id để thực hiện xóa 
        for (int i = 0; i < fruitList.size(); i++) {
             if ( fruitList.get(i).getFruitId() == id) {
                return i;
            }
        }
        System.err.println("Not found.");
        return -1;
    }
    public void deleteFruit() {
        //.Phan Đức Mạnh Nếu danh sách trống thì thông báo cho admin
        if (fruitList.isEmpty()) {
            System.err.println("List empty");
            return;
        }
        //.Phan Đức Mạnh : Kiểm tra trong danh sách xem có tồn tại id không và lấy ra chỉ số của loại hoa quả đó
        // và thực hiện xóa , sau đó trong danh sách sẽ trừ đi 1
        while (true) {
            int fruitId = DataInput.checkInputInt("Enter id of fruit :");
           int findId = findTaskExist(fruitId);
        if (findId != -1) {
            fruitList.remove(findId);
            for (int i = findId; i < fruitList.size(); i++) {
                fruitList.get(i).setFruitId(fruitList.get(i).getFruitId() - 1);
            }
            System.err.println("Delete success.");
        }
        }
    }

    public ArrayList<Fruit> getFruitList() {
        return fruitList;
    }

    //get fruint user want to by
    public Fruit getFruitByItem(int item) {
        int countItem = 1;
        for (Fruit fruit : fruitList) {
            //check shop have item or not 
            if (fruit.getQuantity() != 0) {
                countItem++;
            }
            if (countItem - 1 == item) {
                return fruit;
            }
        }
        return null;
    }
}
