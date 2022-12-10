package fr.pandonia.api.server;

import org.apache.commons.io.FileUtils;
import org.bson.Document;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ServerSettings {

    private int frameID;

    private GenSettings genSettings;

    public ServerSettings(int frameID) {
        this.frameID = frameID;
    }

    public void setGenSettings(GenSettings genSettings) {
        this.genSettings = genSettings;
    }

    public int getFrameID() {
        return frameID;
    }

    public GenSettings getGenSettings() {
        return genSettings;
    }

    public Document toDocument(){
        Document document = new Document("frameID", frameID);
        if(genSettings != null){
            document.append("genSettings", genSettings.toDocument());
        }
        return document;
    }

    public static ServerSettings fromDocument(Document document){
        ServerSettings serverSettings = new ServerSettings(document.getInteger("frameID"));
        if(document.get("genSettings", Document.class) != null){
            serverSettings.setGenSettings(GenSettings.fromDocument(document.get("genSettings", Document.class)));
        }
        return serverSettings;
    }

    public void pasteInFile(File file) throws IOException {
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(toDocument().toJson());
        fileWriter.close();
    }

    public static ServerSettings fromFile(File file) throws IOException {
        return fromDocument(Document.parse(FileUtils.readFileToString(file, "UTF-8")));
    }
}
