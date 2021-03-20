package TCPLog;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class Kliens2 {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("localhost", 1234);
        String message = "Analóg műszerekkel Gagarin is fika";

        PrintWriter pw = new PrintWriter(s.getOutputStream());
        pw.println(message);
        pw.flush();
        pw.close();
        s.close();
    }
}
