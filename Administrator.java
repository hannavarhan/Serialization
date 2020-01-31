import java.io.IOException;
import java.util.ArrayList;

public class Administrator {

    private String name;
    private ConnectorGoods conShop;
    private ConnectorClients conBlackList;

    Administrator(String name, String filenameShop, String blackList) {
        this.name = name;
        conShop = new ConnectorGoods(filenameShop);
        conBlackList = new ConnectorClients(blackList);
    }

    public void addGood(Good... good) throws IOException {
        conShop.write(good);
    }

    public ConnectorGoods getShop() {
        return conShop;
    }

    public ConnectorClients getBlackList() {
        return conBlackList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setConShop(ConnectorGoods c) {
        conShop = c;
    }

    public void setConBlackList(ConnectorClients c) {
        conBlackList = c;
    }

    public void register(Client c) throws IOException, ClassNotFoundException {
        Good[] orderedGoods = c.getBasket().read();
        ArrayList<Client> blackl = new ArrayList<>();
        for(int i = 0; i < orderedGoods.length; ++i) {
            if(orderedGoods[i].isPaid()) {
                orderedGoods[i].setSoldOut();
            } else  {
                conBlackList.write(c);
                break;
            }
        }
    }
}