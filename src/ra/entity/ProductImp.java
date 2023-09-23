package ra.entity;

import java.util.Scanner;

public class ProductImp {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Product[] arrProduct = new Product[100];
        int index = 0;//số lượng sản phẩm hiện tại

        do {
            System.out.println("***********************MENU**************************");
            System.out.println("1. Nhập thông tin n sản phẩm (n nhập từ bàn phím)");
            System.out.println("2. Hiển thị thông tin các sản phẩm");
            System.out.println("3. Tính lợi nhuận các sản phẩm");
            System.out.println("4. Sắp xếp các sản phẩm theo lợi nhuận giảm dần");
            System.out.println("5. Thống kê các sản phẩm theo giá");
            System.out.println("6. Tìm các sản phẩm theo tên sản phẩm");
            System.out.println("7. Nhập sản phẩm");
            System.out.println("8. Bán sản phẩm");
            System.out.println("9. Cập nhật trạng thái sản phẩm");
            System.out.println("10. Thoát");
            System.out.println("hãy chọn chức năng: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    //"1. Nhập thông tin n sản phẩm (n nhập từ bàn phím)");
                    System.out.println("Nhập số lượng sản phẩm: ");
                    int n = scanner.nextInt();
                    scanner.nextLine();
                    for (int i = 0; i < n; i++) {
                        arrProduct[index] = new Product();
                        arrProduct[index].inputData(scanner);
                        System.out.println();
                        index++;
                    }
                    break;
                case 2:
                    //"2. Hiển thị thông tin các sản phẩm");
                    for (int i = 0; i < index; i++) {
                        System.out.println("Sản phẩm thứ: " + (i + 1));
                        arrProduct[i].displayData();
                        System.out.println();
                    }
                    break;
                case 3:
                    //"3. Tính lợi nhuận các sản phẩm");
                    for (int i = 0; i < index; i++) {
                        arrProduct[i].calProfit();
                    }
                    System.out.println("Đã tính lợi nhận của sản phẩm.");
                    break;
                case 4:
                    //("4. Sắp xếp các sản phẩm theo lợi nhuận giảm dần");
                    for (int i = 0; i < index - 1; i++) {
                        for (int j = i + 1; j < index; j++) {
                            if (arrProduct[i].getProfit() < arrProduct[j].getProfit()) {
                                Product temp = arrProduct[i];
                                arrProduct[i] = arrProduct[j];
                                arrProduct[j] = temp;
                            }
                        }
                    }
                    System.out.println("Đã sắp xếp lợi nhuận giẩm dần");
                    break;
                case 5:
                    //("5. Thống kê các sản phẩm theo giá");
                    for (int i = 0; i < index - 1; i++) {
                        for (int j = i + 1; j < index; j++) {
                            if (arrProduct[i].getExportPrice() > arrProduct[j].getExportPrice()) {
                                Product temp = arrProduct[i];
                                arrProduct[i] = arrProduct[j];
                                arrProduct[j] = temp;
                            }
                        }
                    }
                    System.out.println("Đã sắp xếp sản phẩm theo giá tăng dần");
                    break;
                case 6:
                    //("6. Tìm các sản phẩm theo tên sản phẩm");
                    System.out.println("Nhập tên sản phẩm: ");
                    String searchName = scanner.nextLine();
                    boolean found = false;

                    for (int i = 0; i < index; i++) {
                        if (arrProduct[i].getProductName().equals(searchName)) {
                            arrProduct[i].displayData();
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("Không tìm thấy sản phẩm có tên " + searchName);
                    }
                    break;
                case 7:
                    //"7. Nhập sản phẩm");
                    arrProduct[index] = new Product();
                    arrProduct[index].inputData(scanner);
                    index++;
                    break;
                case 8:
                    //("8. Bán sản phẩm");
                    System.out.println("Nhập mã sản phẩm cần bán: ");
                    String sellProductId = scanner.nextLine();
                    System.out.println("nhập số lượng mua: ");
                    int sellquantity = Integer.parseInt(scanner.nextLine());
                    boolean sold = false;

                    for (int i = 0; i < index; i++) {
                        if (arrProduct[i].getProductId().equals(sellProductId)) {
                            if (arrProduct[i].getQuantity() > sellquantity) {
                                arrProduct[i].setQuantity(arrProduct[i].getQuantity() - sellquantity);
                                System.out.println("Đã bán sản phẩm" + arrProduct[i].getProductName());
                                sold = true;
                            } else {
                                System.out.println("Sản phẩm " + arrProduct[i].getProductName() + " đã hết hàng");
                            }
                        }
                    }
                    if (!sold) {
                        System.out.println("không tìm thấy sản phẩm có mã" + sellProductId);
                    }
                    break;
                case 9:
                    //("9. Cập nhật trạng thái sản phẩm");
                    System.out.println("Nhập mã sản phẩm cần cập nhật trạng thái: ");
                    String updateProductId = scanner.nextLine();
                    boolean updated = false;

                    for (int i = 0; i < index; i++) {
                        if (arrProduct[i].getProductId().equals(updateProductId)) {
                            boolean newStatus = !arrProduct[i].isStatus();
                            arrProduct[i].setStatus(newStatus);
                            System.out.println("Đã cập nhật trạng thái sản phẩm" + updateProductId);
                            updated = true;
                            break;
                        }
                    }
                    if (!updated) {
                        System.out.println("Không tìm thấy sản phẩm có mã" + updateProductId);
                    }
                    break;
                case 10:
                    System.exit(0);
                default:
                    System.out.println("Lựa cho không hợp lệ vui lòng chọn lại");

            }

        } while (true);
    }
}
