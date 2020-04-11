package rs.java.textreader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import rs.java.textreader.service.TextReader;
import rs.java.textreader.service.TextWriter;

import java.io.FileWriter;
import java.io.IOException;

@SpringBootApplication
public class TextReaderApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(TextReaderApplication.class, args);


        TextReader textReader = new TextReader("grafika.jpg");
		TextWriter textWriter = new TextWriter(textReader.getText(),textReader.getTitleWithoutEnlargement());

		textWriter.writeFile();


//
//		String fileName = "grafika.jpg";
//		TextReader textReader = new TextReader();
//		String path = "C:\\Users\\Dell\\Desktop\\ImageToText\\";
//		String text = textReader.getText();
//
//		FileWriter fileWriter = null;
//		try {
//			fileWriter = new FileWriter(path + "writed.txt");
//			fileWriter.write(text);
//		} catch (IOException ex) {
//			ex.getMessage();
//		} finally {
//			fileWriter.close();
//		}
//	}
    }
}
