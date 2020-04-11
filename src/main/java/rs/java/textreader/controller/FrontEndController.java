package rs.java.textreader.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import rs.java.textreader.service.FileName;
import rs.java.textreader.service.TextReader;
import rs.java.textreader.service.TextWriter;

import java.io.IOException;

@Controller
public class FrontEndController {

    private FileName fileName;

    @Autowired
    public FrontEndController(FileName fileName) {
        this.fileName = fileName;
    }

    @GetMapping("/")
    public String geWriterService(ModelMap map) {
        map.put("newFileName", fileName);
        return "index";
    }

    @GetMapping("service")
    String getWriter(ModelMap map) throws IOException {

        TextReader textReader = new TextReader(fileName.getName());
        TextWriter textWriter = new TextWriter(
                textReader.getText(),textReader.getTitleWithoutEnlargement());

        map.put("saveFile", textWriter.writeFile());
        return "service";
    }

    @PostMapping("/add-service")
    public String addOperation(@ModelAttribute FileName fileName) {
        this.fileName = fileName;
        return "redirect:/service";
    }
}
