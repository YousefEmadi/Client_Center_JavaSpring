package com.joseph.MultiEcoute;

import java.util.List;

public class Controller {

    //new objects
    UserPanel myUI = new UserPanel();
    ClientsList myClientList = new ClientsList();

    public void mainController(){
        userChoice myUserChoice = myUI.requestUserOption();
        switch (myUserChoice) {
            case CREATE -> {doCreate();}
            case FIND -> {doFindAndShowClient();}
            case REMOVE -> {doFindAndRemoveClient();}
            case LIST -> {doListOfAllClients();}
            case COPY -> {doCopyDatabaseIntoFile();}
            case EXIT -> {doExit();}
        }
    }

    // Process and Do
    public void doCreate(){
        Member newClient = myUI.getNewClientToCreate();
        if (newClient != null){
            myClientList.addNewClient(newClient);
            myClientList.writeIntoDatabase(newClient, ClientsList.DEFAULT_FILE_PATH);
            myUI.successfulMessage();
        }else
            myUI.failureMessage();
    }

    public void doFindAndShowClient(){
        int id = myUI.getClientIdToSearch();
        Member foundClient = myClientList.findClientFromDatabaseClientList(id);
        myUI.showClient(foundClient);
    }

    public void doFindAndRemoveClient(){
        int id = myUI.getClientIdToRemove();
        Member foundClient = myClientList.findClientFromDatabaseClientList(id);
        myClientList.removeClientFromList(foundClient);


    }

    public void doListOfAllClients(){
        myUI.showDatabaseClientList(myClientList.retrieveDatabaseClientList());
    }

    public void doCopyDatabaseIntoFile() {
        String newFilePath = myUI.getNewFilePath();
        List<Member> copyOfClientList = myClientList.retrieveDatabaseClientList();
        myClientList.writeListToDatabaseFile(newFilePath, copyOfClientList);
    }

    public void doExit(){
        myUI.exitMessage();
        System.exit(0);
    }
}

