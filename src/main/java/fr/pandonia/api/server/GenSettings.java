package fr.pandonia.api.server;

import org.apache.commons.io.FileUtils;
import org.bson.Document;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GenSettings implements IGenSettings {

    private String genName;
    private int size;

    public GenSettings(String genName){
        this.genName = genName;
        this.size = 200;
    }

    public GenSettings(String genName, int size) {
        this.genName = genName;
        this.size = size;
    }

    @Override
    public String getGenName() {
        return genName;
    }

    @Override
    public int getSize() {
        return size;
    }

    public Document toDocument(){
        return new Document("genName", genName).append("size", size);
    }

    public static GenSettings fromDocument(Document document){
        return new GenSettings(document.getString("genName"), document.getInteger("size"));
    }

    public void pasteInFile(File file) throws IOException {
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(toDocument().toJson());
        fileWriter.close();
    }

    public static GenSettings fromFile(File file) throws IOException {
        return fromDocument(Document.parse(FileUtils.readFileToString(file, "UTF-8")));
    }
}
