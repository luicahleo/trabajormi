package server;

import rmiinterface.RMIInterface;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServerOperation extends UnicastRemoteObject implements RMIInterface {

    protected ServerOperation() throws RemoteException {
        super();
    }

    @Override
    public String helloTo(String name) throws RemoteException {
        System.err.println(name + " is trying to contact!");
        return "Server says hello to " + name;
    }

    public static void main(String[] args) {
        try {
            Naming.rebind("//localhost/MyServer", new ServerOperation()); //agregamos nuevo objeto de tippo ServerOperation, vamos a estar unidos al registry
            System.err.println("Server ready");

        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }

}
