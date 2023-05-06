import javax.xml.crypto.Data;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class orginal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
        Socket socket = new Socket("localhost",1380);
            System.out.println("402 : Hi ,How can I help you?");
            OutputStream outputStream = socket.getOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            String write = scanner.nextLine();
            dataOutputStream.writeUTF(write);
            dataOutputStream.flush();
                // server want say someting to me .

            InputStream inputStream =socket.getInputStream();
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            System.out.println("support Server: "+ dataInputStream.readUTF()+".");

            System.out.println("\n Client closed ...");
            socket.close();



        }catch (Exception ex){ex.printStackTrace();}
    }
}
