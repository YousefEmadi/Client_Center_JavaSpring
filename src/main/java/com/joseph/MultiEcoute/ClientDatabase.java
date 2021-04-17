package com.joseph.MultiEcoute;

import java.util.List;

public interface ClientDatabase {
    boolean addNewClient(Client newClient);
//    Client findClientFromCurrentSession(int id);
    Client findClientFromDatabaseClientList(int id);
    boolean removeClientFromList(Client client);
    boolean writeIntoDatabase(Client client, String filePath);
    List<Client> retrieveDatabaseClientList();
    boolean writeListToDatabaseFile(String newfilePath, List<Client> clientList);
    void deleteDatabaseFile();
}


