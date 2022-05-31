import java.io.File;

import consolejv.*;
import pmjv.*;

public class main {
    public static void usage(String programName, int e) {
        ConsoleJV.printc("Usage: ", ConsoleJV.red, true);
        System.out.println(String.format("\t./%s <command> [args]", programName));
        ConsoleJV.printlnc("\tCommands:", ConsoleJV.blue, true);
        System.out.println("\t\tinit\t\tInitialize a project");
        System.out.println("\t\tinstall\t\tInstall a package");
        System.out.println("\t\tuninstall\t\tUninstall a package");
        System.out.println("\t\tsearch <user> <platform>\t\tSearch for a project from a specific user");
        ConsoleJV.printlnc("\tOptions:", ConsoleJV.blue, true);
        System.out.println("\t\t-h, --help\tDisplay this help");
        
        System.exit(e);
    }

    public static void main(String[] Args) {
        File f = new File("project.ini");

        StackTraceElement[] stack = Thread.currentThread().getStackTrace();
        StackTraceElement main = stack[stack.length - 1];
        String mainClass = main.getClassName();

        // TODO: Better command line arguments maybe

        if (Args.length == 0 || Args[0].equals("-h") || Args[0].equals("--help")) {
            usage(mainClass, 1);
        }

        if (Args[0].equals("init")) {pmjv.init(); System.exit(0);}
        
        if (!f.exists()) {
            ConsoleJV.printlnc("Error:", ConsoleJV.red, true);
            System.out.println("\tNo project.txt file found.");
            System.out.println(String.format("\tRun `./%s init` to initialize a project.", mainClass));
            System.exit(1);
        }

        if (Args[0].equals("install"))   {pmjv.install(); System.exit(0);} 
        if (Args[0].equals("search"))    {pmjv.search(); System.exit(0);} 
        if (Args[0].equals("uninstall")) {pmjv.uninstall(); System.exit(0);} 
        else {
            ConsoleJV.printlnc("Error:", ConsoleJV.red, true);
            System.out.println(String.format("\tUnknown command: %s", Args[0]));
            usage(mainClass, 1);
        }

    }
}