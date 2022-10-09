package edu.sdccd.cisc191;

import java.io.*;
import java.net.MalformedURLException;
import java.util.Scanner;
import java.net.URL;

/**
 *
 * References:
 * Morelli, R., & Walde, R. (2016). Java, Java, Java: Object-Oriented Problem Solving.
 * Retrieved from https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 *
 */
public class IOLab
{

    public static String readTestResults(String s) {

       String finla ="";

       try {
            File testResult = new File("src/main/resources/"+s);

            Scanner scanner = new Scanner(testResult);

           while (scanner.hasNextLine()) {

               finla+=scanner.nextLine();
            }
            return finla;
        }
        catch (FileNotFoundException e) {
            return "";
        }
    }

    public static void appendTestResult(String s, String s1) {

        File newFile = new File("src/main/resources/" + s);

        if (!newFile.exists()) {
            try {
                newFile.createNewFile();
            }
            catch (IOException e) {
                System.out.println("error");
                return;
            }
        }

        try {
            PrintWriter out = new PrintWriter(new FileWriter(newFile, true), true);
            out.println(s1);
        }
        catch (IOException e) {
            System.out.println("error");
        }
    }

    public static String readDateTime(String s) {

        try {

            URL online = new URL(s);

            Scanner download = new Scanner(online.openStream());
            String getInput = download.nextLine();

            int dateTime = getInput.indexOf("datetime");

            return getInput.substring(dateTime+11 , dateTime+43);

        }

        catch (FileNotFoundException e) {
            System.out.println("error");
        }
        catch (MalformedURLException e) {
            System.out.println("error");
        }
        catch (IOException e) {

            throw new RuntimeException(e);
        }

        return "";
    }
}