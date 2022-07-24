import java.util.ArrayList;
import java.util.List;

public class Buyer {
    private int id;
    private String firstName;
    private String lastName;
    private int amountOfMoney;
    private List<Product> products;
    private static int idCounter = 1;

    public Buyer(String firstName, String lastName, int amountOfMoney) {
        this.id = idCounter++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.amountOfMoney = amountOfMoney;
        this.products = new ArrayList<>();
    }

    public List<Product> getProducts() {
        return products;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAmountOfMoney() {
        return amountOfMoney;
    }

    public void setAmountOfMoney(int amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }

    @Override
    public String toString() {
        return this.id + ". " + firstName + " " + lastName;
    }
}
