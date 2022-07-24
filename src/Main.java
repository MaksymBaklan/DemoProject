import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Marketplace marketplace = new Marketplace();
        while (true) {
            showMainMenu();
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    List<Buyer> buyers = marketplace.getBuyers();
                    for (int i = 0, n = buyers.size(); i < n; i++) {
                        System.out.println(buyers.get(i));
                    }
                    break;
                case 2:
                    List<Product> products = marketplace.getProducts();
                    for (int i = 0, n = products.size(); i < n; i++) {
                        System.out.println(products.get(i));
                    }
                    break;
                case 3:
                    try {
                        purchase(marketplace, scanner);
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case 4:
                    showBuyersPurchase(marketplace, scanner);
                    break;
                case 5:
                    showProductsBuyer(marketplace, scanner);
                    break;
            }
            System.out.println();
        }
    }

    public static void showMainMenu() {
        System.out.println("Choose the number and press Enter. What do you want to do?");
        System.out.println("1  Show buyers");
        System.out.println("2  Show product");
        System.out.println("3  Buy something");
        System.out.println("4  Show buyers products");
        System.out.println("5  Show products buyers");
    }

    public static void purchase(Marketplace marketplace, Scanner scanner) throws Exception {
        System.out.println("Input the buyer id");
        int buyerId = scanner.nextInt();
        System.out.println("Input the product id");
        int productId = scanner.nextInt();
        marketplace.buyProduct(buyerId, productId);
    }

    public static void showBuyersPurchase(Marketplace marketplace, Scanner scanner) {
        System.out.println("Input the buyer id");
        int buyerId = scanner.nextInt();

        List<Product> products = marketplace.getBuyerProducts(buyerId);
        for (int i = 0, n = products.size(); i < n; i++) {
            System.out.println(i + 1 +  ". " + products.get(i).getName());
        }
    }

    public static void showProductsBuyer(Marketplace marketplace, Scanner scanner) {
        System.out.println("Input the product id");
        int productId = scanner.nextInt();

        List<Buyer> buyers = marketplace.getProductsBuyer(productId);
        for (int i = 0, n = buyers.size(); i < n; i++) {
            System.out.println(i + 1 + ". " + buyers.get(i).getFirstName() + " " + buyers.get(i).getLastName());
        }
    }

}
