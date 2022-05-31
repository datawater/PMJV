package pmjv;

import java.io.*;

import utils.*;
import consolejv.*;

public class pmjv {

    private static class Data {
        private String Name;
        private String Description;
        private String Version;
        private String Author;
        private String License;
        private String GitURL;

        public Data(String name, String description, String version, String author, String license, String giturl) {
            this.Name = name;
            this.Description = description;
            this.Version = version;
            this.Author = author;
            this.License = license;
            this.GitURL = giturl;
        }

        public String getName()         {return Name;}
        public String getDescription()  {return Description;}
        public String getVersion()      {return Version;}
        public String getAuthor()       {return Author;}
        public String getLicense()      {return License;}
        public String getGitURL()       {return GitURL;}

        public void setName        (String name)           {this.Name = name;}
        public void setDescription (String description)    {this.Description = description;}
        public void setVersion     (String version)        {this.Version = version;}
        public void setAuthor      (String author)         {this.Author = author;}
        public void setLicense     (String license)        {this.License = license;}
        public void setGitURL      (String giturl)         {this.GitURL = giturl;}
    }

    private static void initIni(FileWriter fileWriter, Data data) {
        try {
            fileWriter.write("# Package Manager JV\n\n");
            fileWriter.write("[Package]\n");
            fileWriter.write(String.format("Name = %s\n",data.getName()));
            fileWriter.write(String.format("Description = %s\n",data.getDescription()));
            fileWriter.write(String.format("Version = %s\n",data.getVersion()));
            fileWriter.write(String.format("Author = %s\n",data.getAuthor()));
            fileWriter.write(String.format("License = %s\n",data.getLicense()));
            fileWriter.write(String.format("GitURL = %s\n",data.getGitURL()));
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void init() {
        Data data = new Data("", "", "", "", "", "");

        try {

            // TODO: Maybe make this all colourful and fancy
            FileWriter fileWriter = new FileWriter("project.ini", false);
            System.out.print("Name of the project? :: ");                 data.setName(ConsoleJV.userInput());
            System.out.print("Description of the project? :: ");          data.setDescription(ConsoleJV.userInput());
            System.out.print("Version of the project? :: ");              data.setVersion(ConsoleJV.userInput());
            System.out.print("Author of the project? :: ");               data.setAuthor(ConsoleJV.userInput());
            System.out.print("License of the project? :: ");              data.setLicense(ConsoleJV.userInput());
            System.out.print("GitURL of the project? :: ");               data.setGitURL(ConsoleJV.userInput());

            if (!Utils.isMatchRegex(data.getGitURL(),"^(http|https|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]")) {
                // Error out
                ConsoleJV.printc("[ERROR] ", ConsoleJV.red, true);
                System.out.println("Invalid GitURL");
                System.exit(1);
            }

            initIni(fileWriter, data);
        
        } catch(IOException exception) {
            ConsoleJV.printlnc("Error:", ConsoleJV.red, true);
            System.out.println("\tCould not write to project.ini file.");
            System.exit(1);
        }

        ConsoleJV.printlnc("Success:", ConsoleJV.green, true);
        System.out.println("\tCreated project.txt file.");
    }

    public static void install() {
        Utils.TODO("Implement install()");
    }

    public static void search() {
        Utils.TODO("Implement search()");
    }

    public static void uninstall() {
        Utils.TODO("Implement uninstall()");
    }
}