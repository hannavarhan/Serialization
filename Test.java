
public class Test {

    public static Good[] createList() {
        Good[] list = new Good[5];

        list[0] = new Good("Ring", "gold cubic zirconia, standart 585", 11090);
        list[1] = new Good("Earrings", "gold with 0.263K topazes and 0.0022K diamonds, standart 585", 6090);
        list[2] = new Good("Bracelet", "rolex, gold, standart 585", 8850);
        list[3] = new Good("Wristwatch", "Talant, bijouterie alloy, quartz", 3290);
        list[4] = new Good("Pendant", "silver owl with enamel and cubic zirconia, standart 925", 1320);

        return list;
    }

    public static void main(String[] args) {
        try {
            Administrator admin1 = new Administrator("YuriyVladimirovich",
                    "shop.dat", "blacklist.dat");

            admin1.addGood(createList());

            Client client1 = new Client("Vasya_1975", "shop.dat");
            client1.order();
            client1.pay(0);
            //client1.pay(1);
            admin1.register(client1);

            //shop
            System.out.println("Shop");
            ConnectorGoods con2 = admin1.getShop();
            Good[] mas2 = con2.read();
            for(Good e : mas2) {
                System.out.println(e);
            }
            System.out.println();

            //basket
            System.out.println("Basket of client");
            ConnectorGoods con1 = client1.getBasket();
            Good[] mas1 = con1.read();
            for(Good e : mas1) {
                System.out.println(e);
            }
            System.out.println();

            //black_list
            System.out.println("Black list");
            ConnectorClients con3 = admin1.getBlackList();
            Client[] mas3 = con3.read();
            for(Client e : mas3) {
                System.out.println(e);
            }
            System.out.println();
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}