package com.joseph.MultiEcoute;

import java.io.File;

public class List implements Database{

    public static final String DEFAULT_FILE_PATH = "src\\main\\resources\\Database.txt";

    @Override
    public void createFile(String path) {
        File file = new File(path);
    }

    @Override
    public java.util.List<Member> downloadFromFile() {
        return null;
    }

    @Override
    public void uploadToFile(java.util.List<Member> list) {

    }

    @Override
    public void deleteFile(String path) {
        File file = new File(path);
        file.delete();
    }

    @Override
    public void add(Member member) {

    }

    @Override
    public Member find(int id) {
        return null;
    }

    @Override
    public void remove(int id) {

    }
}
