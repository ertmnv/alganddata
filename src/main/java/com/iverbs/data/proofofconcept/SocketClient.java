package com.iverbs.data.proofofconcept;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class SocketClient {
    
    public static void main(String [] args) throws IOException, InterruptedException, ClassNotFoundException {
        Socket socket = new Socket("localhost",3000);
        
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        
        InputStream inputStream = socket.getInputStream();
        ObjectInputStream ois = new ObjectInputStream(inputStream);
        
        oos.writeObject(new SerializablePerson("a"));
        Thread.sleep(10000);
        System.out.println(ois.readUTF());
        oos.writeObject(new SerializablePerson("b"));
        Thread.sleep(10000);
        System.out.println(ois.readUTF());
        oos.writeObject(new SerializablePerson("c"));
        System.out.println(ois.readUTF());
        
        oos.close();
        
    }

}
