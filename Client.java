import java.io.Serializable;
import java.io.IOException;

public class Client implements Serializable {

    private static final long serialVersionUID = 2L;

    String nick;
    transient private ConnectorGoods conShop;
    transient private ConnectorGoods conBasket;

    Client(String nick, String filenameShop) {
        this.nick = nick;
        conShop = new ConnectorGoods(filenameShop);
        conBasket = new ConnectorGoods(nick + "Basket.dat");
    }

    public ConnectorGoods getBasket() {
        return conBasket;
    }

    public String getNick() {
        return nick;
    }

    public void order() throws IOException, ClassNotFoundException {
        int goodAmount = conShop.read().length;
        Good[] goods = conShop.read();

        Good[] orderedGoods = new Good[2];

        int r = (int)(Math.random() * (goodAmount - 1));
        goods[r].setOrdered();
        orderedGoods[0] = goods[r];
        int t = (int)(Math.random() * (goodAmount - 1));
        goods[t].setOrdered();
        orderedGoods[1] = goods[t];

        conBasket.write(orderedGoods);
    }

    public void pay(int number) throws IllegalArgumentException, IOException, ClassNotFoundException {
        Good[] orderedGoods = conBasket.read();
        int orderedGoodAmount = orderedGoods.length;
        if(number < 0 || number > orderedGoodAmount) {
            throw new IllegalArgumentException("THERE IS NO SUCH AN ORDER IN BASKET");
        } else orderedGoods[number].setPaid();
        conBasket.write(orderedGoods);
    }

    @Override
    public String toString() {
        return new String("Nick: " + nick);
    }
}