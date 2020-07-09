package net.delafer.tests;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class MainClass {

    private static String readFile(String filePath)
    {
        StringBuilder contentBuilder = new StringBuilder();
        try (Stream<String> stream = Files.lines( Paths.get(filePath), StandardCharsets.UTF_8))
        {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return contentBuilder.toString();
    }

    public static void main(String[] args) {

        String html = readFile("C:\\tmp\\toparse\\toparse1.html");

        Pattern p = Pattern.compile("href=\"(.*?)\"");
        Matcher m = p.matcher(html);
        String url = null;
        while (m.find()) {
            url = m.group(1); // this variable should contain the link URL
            System.out.println(')'+url);
        }




    }

}
