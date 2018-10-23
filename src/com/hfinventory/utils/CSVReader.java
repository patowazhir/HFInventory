package com.hfinventory.utils;

import static com.hfinventory.utils.HFInventory.Servers;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSVReader {
    
    private static final char DEFAULT_SEPARATOR = ',';
    private static final char DEFAULT_QUOTE = '"';
    private static final String[] hosts = {"CARSON","CAVETT","COLBERT","FALLON","GRIFFIN","IRV-HVHOSTSA01","KIMMEL","ROSE"};
    
    public List<Server> scan (String csvFile) throws FileNotFoundException{
        Scanner scanner = new Scanner(new File(csvFile));
        List<Server> result = new ArrayList<>();
        
        System.out.println("Scanning " + csvFile);
        
        scanner.nextLine(); //Skips column name
        
        while (scanner.hasNext()) {
            List<String> line = parseLine(scanner.nextLine());
            int counter =0;
            String serverName = line.get(0), serverHost = line.get(2), serverState = line.get(1);
            
            /*
            try{
                serverHost = line.get(71);
            } catch (Exception e) {
                serverHost = line.get(32);
            }*/
            
            serverName = serverName.replace("\"", "");
            serverHost = serverHost.replace("\"", "");
            serverState = serverState.replace("\"", "");
            
            Server x = new Server(serverName,serverHost,serverState);
            result.add(x);
        }
        scanner.close();
        
        return result;
    }
    
    protected void generateCSV (String outputPath) throws IOException, InterruptedException{
        String basePath = new File("").getAbsolutePath();
        System.out.println(basePath);
        String path = new File("WebContent/WEB-INF/lib/scripts/scanner.ps1").getAbsolutePath();
        
        for (String host: hosts){
            String cmd = "cmd /C start /wait powershell.exe -WindowStyle Hidden " + path + " -computer " + host + " -path " + outputPath;
            System.out.println("Executing: " + cmd + " \nPlease wait.");
            Process proc = Runtime.getRuntime().exec(cmd);
            int exitVal = proc.waitFor();
        } 
    }
    
    private static List<String> parseLine(String cvsLine) {
        return parseLine(cvsLine, DEFAULT_SEPARATOR, DEFAULT_QUOTE);
    }

    private static List<String> parseLine(String cvsLine, char separators) {
        return parseLine(cvsLine, separators, DEFAULT_QUOTE);
    }

    private static List<String> parseLine(String cvsLine, char separators, char customQuote) {

        List<String> result = new ArrayList<>();

        //if empty, return!
        if (cvsLine == null && cvsLine.isEmpty()) {
            return result;
        }

        if (customQuote == ' ') {
            customQuote = DEFAULT_QUOTE;
        }

        if (separators == ' ') {
            separators = DEFAULT_SEPARATOR;
        }

        StringBuffer curVal = new StringBuffer();
        boolean inQuotes = false;
        boolean startCollectChar = false;
        boolean doubleQuotesInColumn = false;

        char[] chars = cvsLine.toCharArray();

        for (char ch : chars) {

            if (inQuotes) {
                startCollectChar = true;
                if (ch == customQuote) {
                    inQuotes = false;
                    doubleQuotesInColumn = false;
                } else {

                    //Fixed : allow "" in custom quote enclosed
                    if (ch == '\"') {
                        if (!doubleQuotesInColumn) {
                            curVal.append(ch);
                            doubleQuotesInColumn = true;
                        }
                    } else {
                        curVal.append(ch);
                    }

                }
            } else {
                if (ch == customQuote) {

                    inQuotes = true;

                    //Fixed : allow "" in empty quote enclosed
                    if (chars[0] != '"' && customQuote == '\"') {
                        curVal.append('"');
                    }

                    //double quotes in column will hit this!
                    if (startCollectChar) {
                        curVal.append('"');
                    }

                } else if (ch == separators) {

                    result.add(curVal.toString());

                    curVal = new StringBuffer();
                    startCollectChar = false;

                } else if (ch == '\r') {
                    //ignore LF characters
                    continue;
                } else if (ch == '\n') {
                    //the end, break!
                    break;
                } else {
                    curVal.append(ch);
                }
            }

        }

        result.add(curVal.toString());

        return result;
    }
}

