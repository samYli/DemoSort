package sample;

import java.io.File;
import java.nio.file.Paths;
import java.util.Scanner;

public class ReturnMap {

    private String path;


    public static void mapReader() {
        File file = new File("cp_orange.dem");
        Scanner scanner = new Scanner(extensionChange(file, "txt").getAbsolutePath());

    }


    public static File extensionChange(File file, String newExtension) {
        int i = file.getName().lastIndexOf(".");
        String filename = file.getName().substring(0, i);
        return new File(file.getParent(), filename + newExtension);
    }


}






