import java.io.*;

public class ConnectorGoods {

    private String filename;

    public ConnectorGoods(String filename) {
        this.filename = filename;
    }

    public void write(Good... list) throws IOException {
        FileOutputStream fouts = new FileOutputStream(filename);
        try(ObjectOutputStream oos = new ObjectOutputStream(fouts)) {
            oos.writeInt(list.length);
            for(int i = 0; i < list.length; ++i) {
                oos.writeObject(list[i]);
            }
            oos.flush();
        }
    }

    public Good[] read() throws IOException, ClassNotFoundException {
        FileInputStream fins = new FileInputStream(filename);
        try(ObjectInputStream ois = new ObjectInputStream(fins)) {
            int length = ois.readInt();
            Good[] result = new Good[length];
            for(int i = 0; i < length; ++i) {
                result[i] = (Good) ois.readObject();
            }
            return result;
        }
    }
}