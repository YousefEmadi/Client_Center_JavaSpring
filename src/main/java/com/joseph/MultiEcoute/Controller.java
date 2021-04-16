package com.joseph.MultiEcoute;

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
        Client newClient = myUI.getNewClientToCreate();
        if (newClient != null){
            myClientList.addNewClient(newClient);
            myClientList.writeIntoDatabase(newClient, ClientsList.DEFAULT_FILE_PATH);
            myUI.successfulMessage();
        }else
            myUI.failureMessage();
    }

    public void doFindAndShowClient(){
        int id = myUI.getClientIdToSearch();
        Client foundClient = myClientList.findClientFromDatabaseClientList(id);
        myUI.showClient(foundClient);
    }

    public void doFindAndRemoveClient(){
        int id = myUI.getClientIdToRemove();
        Client foundClient = myClientList.findClientFromDatabaseClientList(id);
        myClientList.removeClient(foundClient);
        myUI.successfulMessage();
    }

    public void doListOfAllClients(){
        myUI.showDatabaseClientList(myClientList.retrieveDatabaseClientList());
    }

    public void doCopyDatabaseIntoFile() {
        String newFilePath = myUI.getNewFilePath();
        myClientList.copyDatabaseToNewFile(newFilePath);
    }

    public void doExit(){
        myUI.exitMessage();
        System.exit(0);
    }
}

