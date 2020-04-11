package rs.java.textreader.service;

import org.springframework.stereotype.Component;

@Component
public class FileName {

    private String name;

    public FileName() {
    }

    public FileName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
