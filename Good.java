import java.io.Serializable;

public class Good implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name = "";
    private String description;
    private double price;
    private boolean isPaid = false;
    private boolean isOrdered = false;
    private boolean isSoldOut = false;

    protected Good(String name, String about, double price) {
        this.name = name;
        description = about;
        this.price = price;
    }
    public Good() {}

    //get-methods
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public boolean isOrdered() {
        return isOrdered;
    }

    public boolean isSoldOut() {
        return isSoldOut;
    }

    //set-methods
    public void setOrdered() {
        isOrdered = true;
    }

    public void setPaid() {
        isPaid = true;
    }

    public void setSoldOut() {
        isSoldOut = true;
    }

    @Override
    public String toString() {
        return new String("Name: " + name + "\n" +
                "About: " + description + "\n" +
                "Price: " + price + "\n" +
                "Is ordered: " + isOrdered + "\n" +
                "Is paid: " + isPaid + "\n");
    }
}
