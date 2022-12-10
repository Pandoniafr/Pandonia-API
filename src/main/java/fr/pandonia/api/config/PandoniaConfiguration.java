package fr.pandonia.api.config;

import org.apache.commons.io.FileUtils;
import org.bson.Document;

import java.io.File;
import java.io.IOException;

public class PandoniaConfiguration {

    private File file;

    public PandoniaConfiguration(File file) {
        this.file = file;
    }

    public String getFileContent(){
        String result = "";
        try {
            result = FileUtils.readFileToString(file, "UTF-8");

        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public Document getParsedFileContent(){
        return Document.parse(getFileContent());
    }
}
