package com.iverbs.data.proofofconcept;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SocketServer {

    public static void main(String[] args) throws IOException, InterruptedException {

        ServerSocket server = new ServerSocket(3000);

        ExecutorService tp = Executors.newFixedThreadPool(2);
        
        Map m = new HashMap();

        Semaphore sm = new Semaphore(2);
        
        while (true) {

            sm.acquire();
            System.out.println("beffore accept");
            Socket accept = server.accept();
            System.out.println("after accept");
            
            tp.execute(
                    new Thread(() -> {
                        try {
                            serve(accept);
                        } catch (IOException e) {
                            // TODO Auto-generated catch block
                            System.out.println("Sockewt is closed");
                            e.printStackTrace();
                            
                        } finally {
                            sm.release();
                        }
                    }));
                    

            /*
            try {
            serve(accept);
            } catch(Exception e) {
                
            }
            */

        }

    }

    public static void serve(Socket accept) throws IOException {
        System.out.println("connection is established");

         OutputStream outputStream = accept.getOutputStream();
         ObjectOutputStream oos = new ObjectOutputStream(outputStream);
        InputStream inputStream = accept.getInputStream();
        ObjectInputStream ois = new ObjectInputStream(inputStream);

        while (true) {
            SerializablePerson sp = null;
            try {
                System.out.println("wait for person");
                sp = (SerializablePerson) ois.readObject();
                System.out.println("Person is deserialized");
                oos.writeUTF("Ok");
                oos.flush();
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            System.out.println(sp);
        }
        /*
         * BufferedReader bufferedReader = new BufferedReader( new
         * InputStreamReader(inputStream, "utf8"));
         * 
         * for(int i=0; i<10; i++) { String line = bufferedReader.readLine();
         * System.out.println(line); oos.writeUTF("Ok"); oos.flush(); }
         */
    }

}
