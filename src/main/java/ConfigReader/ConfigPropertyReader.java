package ConfigReader;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigPropertyReader {

    private Properties prop;
    private FileInputStream ip;

//    If we want to run from cl, need to remove "String language"  from public Properties initLangProp()
//    and add String

    public Properties initLangProp() throws IOException {

//        mvn clean install -Dlang="english"

        String language = System.getProperty("lang");
        System.out.println("Language is: " + language);
        prop = new Properties();
        try {
            switch (language.toLowerCase()) {
                case "english":
                    ip = new FileInputStream("src/main/resources/language.english.properties");
                    break;

                case "french":
                    ip = new FileInputStream("src/main/resources/language.french.properties");
                    break;

                case "russian":
                    ip = new FileInputStream("src/main/resources/language.russian.properties");
                    break;

                default:
                    System.out.println("Language not found ..... " + language);
                    break;
            }
            prop.load(ip);

        } catch (Exception e) {
            System.out.println(language + " : Properties not found ..... ");

        }
        return prop;
    }
}