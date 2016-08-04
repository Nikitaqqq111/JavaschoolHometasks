package ru.sbt.javaschool.exceptions.store;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Никита on 04.08.2016.
 */
public class Main {
    public static void main(String[] args) {
        Store fileStoreWithoutException = new FileStore("./fileOne.txt"); //ok
        fileStoreWithoutException.save("Jake"); //ok
        fileStoreWithoutException.save("Maria"); //ok
        fileStoreWithoutException.save("Sandra"); //ok
        List<String> linesFromFile = fileStoreWithoutException.getAll(); //ok
//        FileStore fileStoreWithCustomExceptionWhenSave = new FileStore("./fileTwo.txt"); //такого файла не существует
//        fileStoreWithCustomExceptionWhenSave.getAll(); //вылетает FileStoreException с соответствующим message
        List<String> dbInfo = new LinkedList<>(); //list c информацией, которая изначально содержится в базе
        dbInfo.add("John");
        Store dbStoreWithoutException = new DataBaseStore(new DbImpl(dbInfo, false, false)); //создаем базу, где SQLException никогда не бросается
        dbStoreWithoutException.save("Sarra");
        List<String> linesFromDb = dbStoreWithoutException.getAll(); //ok
        Store dbStoreWithCustomException = new DataBaseStore(new DbImpl(dbInfo, true, false)); //создаем базу, где SQLException бросается при save
        dbStoreWithCustomException.getAll(); //ok
//        dbStoreWithCustomException.save("Lost line"); //вылетает DbException с соответствующим message
        Store dbStoreWithCustomException2 = new DataBaseStore(new DbImpl(dbInfo, false, true)); //создаем базу, где SQLException бросается при getAll
        dbStoreWithCustomException2.save("Mike"); //ok
//        dbStoreWithCustomException2.getAll(); //вылетает DbException с соответствующим message

        //создаем базу, где SQLException бросается при getAll и save, а также вылетает RuntimeException в close
        //соответственно появляется Suppressed: java.lang.RuntimeException
        //Store dbStoreWithCustomException3 = new DataBaseStore(new DbImpl(dbInfo, true, true));
        //dbStoreWithCustomException3.save("Lost message");
    }
}
