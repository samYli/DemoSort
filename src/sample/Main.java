package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();

    }

    public static File mapReader(String path) {
        File file = new File(path);
        File newfile = extensionChange(file, "txt");
        return newfile;
    }


    public static File extensionChange(File file, String newExtension) {
        int i = file.getName().lastIndexOf(".");
        String filename = file.getName().substring(0, i);
        return new File(file.getParent(), filename + "." + newExtension);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Please enter the filename with extension to be changed: ");
        String oldfileExtension = in.readLine();
        File oldfile = new File(oldfileExtension);
        if(!oldfile.exists())
        {
            System.out.println("File does not exist.");
            System.exit(0);
        }
        int dotPos = oldfileExtension.lastIndexOf(".");
        String strExtension = oldfileExtension.substring(dotPos + 1);
        String strFilename = oldfileExtension.substring(0, dotPos);
        System.out.println("Please enter the file extension");
        String newfileExtension = in.readLine();
        String strNewFileName = strFilename + "." + newfileExtension;
        File newfile = new File(strNewFileName);
        boolean Rename = oldfile.renameTo(newfile);
        if(!Rename)  {
            System.out.println("FileExtension hasn't been changed successfully.");
        }
        else {
            System.out.println("FileExtension has been changed successfully.");
        }
        // System.out.println(mapReader("cp_orange_jump_tutorial.dem"));

        // launch(args);
    }
}
