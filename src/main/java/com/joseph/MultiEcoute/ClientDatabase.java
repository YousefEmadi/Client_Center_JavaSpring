package com.joseph.MultiEcoute;

public interface ClientDatabase {
    boolean addNewClient(Client newClient);
    Client findClient(int id);
    boolean removeClient(Client client);
    boolean writeIntoFile(Client client);
//    void readFromFile();
}


