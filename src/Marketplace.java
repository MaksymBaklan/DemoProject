import java.util.ArrayList;
import java.util.List;

public class Marketplace {
    private List<Buyer> buyers;
    private List<Product> products;

    {
        buyers = new ArrayList<>();
        buyers.add(new Buyer("Jon", "Malkolm", 12000));
        buyers.add(new Buyer("Tj", "Nikolson", 8000));
        buyers.add(new Buyer("Mary", "Jain", 1100));
    }

    {
        products = new ArrayList<>();
        products.add(new Product("car", 3000));
        products.add(new Product("phone", 800));
        products.add(new Product("bicycle", 1200));

    }

    public void buyProduct(int userId, int productId) throws Exception {
        int buyerMoney, productPrice;
        Buyer buyer;
        Product product;
        if (userId > 0 && userId <= buyers.size()) {
            buyer = buyers.get(userId - 1);
            buyerMoney = buyer.getAmountOfMoney();
        } else {
            System.err.println("The list of buyers does not contain this id. Please input correct id from 1 to " + buyers.size() + ".");
            return;
        }

        if (productId > 0 && productId <= products.size()) {
            product = products.get(productId - 1);
            productPrice = product.getPrice();
        } else {
            System.err.println("The list of products does not contain this id. Please input correct id from 1 to " + products.size() + ".");
            return;
        }

        if (buyerMoney < productPrice) {
            throw new Exception("Not enough money");
        }

        buyer.setAmountOfMoney(buyerMoney - productPrice);
        buyer.getProducts().add(products.get(productId));
        System.out.printf("User %s %s bought %s.\n", buyer.getFirstName(), buyer.getLastName(), product.getName());
    }

    public List<Product> getBuyerProducts(int buyerId) {
        if (buyerId < 1 || buyerId > buyers.size()) {
            System.err.println("The list of products does not contain this id. Please input correct id from 1 to " + products.size() + ".");
            return null;
        }
        return buyers.get(buyerId - 1).getProducts();
    }

    public List<Buyer> getProductsBuyer(int productId) {
        if (productId < 1 || productId > products.size()) {
            System.err.println("The list of buyers does not contain this id. Please input correct id from 1 to " + buyers.size() + ".");
            return null;
        }
        return products.get(productId - 1).getBuyers();
    }

    public List<Buyer> getBuyers() {
        return buyers;
    }

    public List<Product> getProducts() {
        return products;
    }
}
