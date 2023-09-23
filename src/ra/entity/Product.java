package ra.entity;

import java.util.Scanner;

public class Product {
    //a. Các thuộc tính
    private String productId;
    private  String productName;
    private float importPrice;
    private float exportPrice;
    private float profit;
    private int quantity;
    private String descriptions;
    private boolean status;

    //Các constructor
    public Product() {
    }

    public Product(String productId, String productName, float importPrice, float exportPrice, float profit, int quantity, String descriptions, boolean status) {
        this.productId = productId;
        this.productName = productName;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.profit = profit;
        this.quantity = quantity;
        this.descriptions = descriptions;
        this.status = status;
    }
    //c. Các phương thức get/set

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public float getProfit() {
        return profit;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public boolean isStatus() {
        return status;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public void setProfit(float profit) {
        this.profit = profit;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    //d. Các phương thức
    public void inputData(Scanner scanner){
        System.out.println("Nhập mã sản phẩm: ");
        this.productId=scanner.nextLine();
        System.out.println("Nhập tên sản phẩm: ");
        this.productName=scanner.nextLine();
        System.out.println("Nhập giá nhập: ");
        this.importPrice= Float.parseFloat(scanner.nextLine());
        System.out.println("Nhập giá xuất: ");
        this.exportPrice= Float.parseFloat(scanner.nextLine());
        System.out.println("Nhập số lượng sản phẩm: ");
        this.quantity= Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập mô tả sản phẩm: ");
        this.descriptions= scanner.nextLine();
        System.out.println("Nhập trạng thái sản phẩm:");
        this.status=Boolean.parseBoolean(scanner.nextLine());



    }
    public void displayData(){
        System.out.println("Mã sản phẩm: "+this.productId);
        System.out.println("Tên sản phẩm: "+this.productName);
        System.out.println("Giá nhập: "+this.importPrice);
        System.out.println("Giá xuất: "+this.exportPrice);
        System.out.println("Số lương: "+this.quantity);
        System.out.println("Mô tả: "+this.descriptions);
        System.out.println("Trạng thái: "+this.status);
        System.out.println("lơi nhuận: "+this.profit);
    }

    public void calProfit() {
        this.profit=this.exportPrice-this.importPrice;
    }
}
