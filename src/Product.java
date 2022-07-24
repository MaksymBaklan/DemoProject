import java.util.ArrayList;
import java.util.List;

public class Product {
    private int id;
    private String name;
    private int price;
    List<Buyer> buyers;
    private static int idCounter = 1;

    public Product(String name, int price) {
        this.id = idCounter++;
        this.name = name;
        this.price = price;
        this.buyers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public List<Buyer> getBuyers() {
        return buyers;
    }

    @Override
    public String toString() {
        return id + ". " + name;
    }
}
