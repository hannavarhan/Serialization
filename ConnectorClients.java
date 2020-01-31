import java.io.*;

public class ConnectorClients {

    private String filename;

    public ConnectorClients(String filename) {
        this.filename = filename;
    }

    public void write(Client... list) throws IOException {
        FileOutputStream fouts = new FileOutputStream(filename);
        try(ObjectOutputStream oos = new ObjectOutputStream(fouts)) {
            oos.writeInt(list.length);
            for(int i = 0; i < list.length; ++i) {
                oos.writeObject(list[i]);
            }
            oos.flush();
        }
    }

    public Client[] read() throws IOException, ClassNotFoundException {
        FileInputStream fins = new FileInputStream(filename);
        try(ObjectInputStream ois = new ObjectInputStream(fins)) {
            int length = ois.readInt();
            Client[] result = new Client[length];
            for(int i = 0; i < length; ++i) {
                result[i] = (Client) ois.readObject();
            }
            return result;
        }
    }
}