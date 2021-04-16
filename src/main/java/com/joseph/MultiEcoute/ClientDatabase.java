package com.joseph.MultiEcoute;

import java.util.List;

public interface ClientDatabase {
    boolean addNewClient(Client newClient);
    Client findClientFromCurrentSession(int id);
    Client findClientFromDatabaseClientList(int id);
    boolean removeClient(Client client);
    boolean writeIntoDatabase(Client client, String filePath);
    List<Client> retrieveDatabaseClientList();
    boolean copyDatabaseToNewFile(String newfilePath);
}


