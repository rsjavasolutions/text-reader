package rs.java.textreader.service;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@Service
public class TextReader {

    private String title;

    public TextReader() {
    }

    public TextReader(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText(){
        String path = "C:\\Reader\\";
        File fileImage = new File(path + title);

        ITesseract instance = new Tesseract();
        instance.setDatapath("N:\\Bykowski\\ocr-system");
        instance.setLanguage("pol");

        BufferedImage bufferedImage;

        String result = null;
        try {
            bufferedImage = ImageIO.read(fileImage);
            result = instance.doOCR(bufferedImage);
        } catch (TesseractException e) {
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public String getTitleWithoutEnlargement(){
        return title.substring(0,title.indexOf("."));
    }
}
