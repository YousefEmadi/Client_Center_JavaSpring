package com.joseph.MultiEcoute;

import java.util.List;

public interface ClientDatabase {
    boolean addNewClient(Client newClient);
    Client findClient(int id);
    boolean removeClient(Client client);
    boolean writeIntoFile(Client client);
    List<Client> readFromDatabaseFile();
}


