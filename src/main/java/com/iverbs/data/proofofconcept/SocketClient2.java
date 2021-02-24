package com.iverbs.data.proofofconcept;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class SocketClient2 {
    public static void main(String [] args) throws IOException, InterruptedException, ClassNotFoundException {
        System.out.println("---------------------------------------------------------------------------------------- 0");
        Socket socket = new Socket("localhost",3000);
        
        InputStream inputStream = socket.getInputStream();
        ObjectInputStream ois = new ObjectInputStream(inputStream);
        
        System.out.println("---------------------------------------------------------------------------------------- 1");
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        
        System.out.println("---------------------------------------------------------------------------------------- 2");
        oos.writeObject(new SerializablePerson("a"));
        Thread.sleep(10000);
        System.out.println(ois.readUTF());
        System.out.println("---------------------------------------------------------------------------------------- 3");
        oos.writeObject(new SerializablePerson("b"));
        Thread.sleep(10000);
        System.out.println(ois.readUTF());
        System.out.println("---------------------------------------------------------------------------------------- 4");
        oos.writeObject(new SerializablePerson("c"));
        System.out.println(ois.readUTF());
        System.out.println("before close");
        oos.close();
        System.out.println("after close");
        
    }
}
