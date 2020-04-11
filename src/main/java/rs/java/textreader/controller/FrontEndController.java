package rs.java.textreader.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import rs.java.textreader.service.TextReader;

@Controller
public class FrontEndController {

    private TextReader textReader;

    @Autowired
    public FrontEndController(TextReader textReader) {
        this.textReader = textReader;
    }

    @GetMapping("/")
    public String geWriterService(ModelMap map) {
        map.put("newWriter", textReader);
        return "index";
    }

    @GetMapping("service")
    String getCalc(ModelMap map) {



        LinkService linkService = new LinkService(flat.getCity(), flat.getArea());
        CityService cityService = new CityService(linkService.getLink());

        map.put("showPrice", cityService.getAverage());
        return "service";
    }

    @PostMapping("/add-service")
    public String addOperation(@ModelAttribute Flat flat) {
        this.flat = flat;
        return "redirect:/service";
    }

}
