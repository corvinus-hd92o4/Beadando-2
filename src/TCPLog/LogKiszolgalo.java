package TCPLog;

import java.io.*;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LogKiszolgalo implements Runnable {

    private Socket s;

    public LogKiszolgalo(Socket s){
        this.s=s;
    }

    private void Logol(String input) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(new FileOutputStream("log.txt", true));

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        pw.println("A szerver a kovetkezo uzenetet kapta: " + input+ " | Ebben az idopontban: " + formatter.format(date));
        pw.flush();
        pw.close();

    }


    @Override
    public void run(){
        BufferedReader bf = null;
        try {
            bf=new BufferedReader(new InputStreamReader(s.getInputStream()));
            String input = bf.readLine();

            Logol(input);
            System.out.println(input);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
