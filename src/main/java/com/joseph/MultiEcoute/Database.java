package com.joseph.MultiEcoute;

import java.util.ArrayList;
import java.util.List;

public interface Database {

    //File handling
    void createFile(String path);
    List<Member> downloadFromFile();
    void uploadToFile(List<Member> list);
    void deleteFile(String path);

    //member handling
    void add(Member member);
    Member find(int id);
    void remove(int id);
}


