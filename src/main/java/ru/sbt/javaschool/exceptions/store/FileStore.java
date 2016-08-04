package ru.sbt.javaschool.exceptions.store;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author evstafiev
 */
public class FileStore implements Store {

    private final String path;

    public FileStore(String path) {
        this.path = path;
    }

    @Override
    public void save(String t) {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(path, true));
            bw.write(t + "\n");
        } catch (IOException ex) {
            throw new FileStoreException("Exception from FileStore, caused by IOException when saving. Don't worry, be happy!", ex);
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException ex) {
                    //okaaaay, don't worry, be happy
                }
            }
        }
    }

    @Override
    public List<String> getAll() {
        List<String> listOfLinesFromFile = new ArrayList<>();
        String line = null;
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(path));
            while ((line = br.readLine()) != null) {
                listOfLinesFromFile.add(line);
            }
            return listOfLinesFromFile;
        } catch (FileNotFoundException ex) {
            throw new FileStoreException("Exception from FileStore, caused by FileNotFoundException when getting. Don't worry, be happy!", ex);
        } catch (IOException ex) {
            throw new FileStoreException("Exception from FileStore, caused by IOException when getting. Don't worry, be happy!", ex);
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException ex) {
                //okaaaay, don't worry, be happy
            }
        }
    }

}
