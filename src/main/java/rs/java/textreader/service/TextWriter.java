package rs.java.textreader.service;

import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;

@Service
public class TextWriter {

    private String text;
    private String title;

    public TextWriter() {
    }

    public TextWriter(String text, String title) {
        this.text = text;
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String writeFile() throws IOException {
        String path = "C:\\Reader\\";
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(path + title + ".txt");
            fileWriter.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            fileWriter.close();
        }
        return title + ".txt";
    }
}
