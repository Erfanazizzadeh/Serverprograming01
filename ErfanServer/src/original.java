import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class original {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

            try {
                ServerSocket serverSocket = new ServerSocket(1380);
                System.out.println("person Typing ....");
                Socket socket = serverSocket.accept();


                // client write something
                InputStream inputStream = socket.getInputStream();
                DataInputStream dataInputStream = new DataInputStream(inputStream);
                System.out.println("person Say :  " + dataInputStream.readUTF());


                OutputStream outputStream = socket.getOutputStream();
                DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
                String say = scanner.nextLine();
                dataOutputStream.writeUTF(say);
                dataOutputStream.flush();

                serverSocket.close();
                System.out.println("Server is Closed");


            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //master now update

}
