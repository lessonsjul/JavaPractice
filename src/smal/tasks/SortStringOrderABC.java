package smal.tasks;

import java.io.*;
import java.util.Arrays;
import java.util.stream.Collectors;

public class SortStringOrderABC {

    public static void main(String[] args) {

        String filename = getFileName();

        if(filename != null){
            String[] content= getFileContent(filename);

            sortStringOrderABC(content);

            writeContentIntoTheFile(filename,content);
        }else{
            System.out.println("Не введено имя файла");
        }
    }

    private static String getFileName() {

        String filename = null;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            filename = reader.readLine();
            reader.close();
        } catch (IOException e) {
            System.out.println("We can't read name your file");
        }

        return filename;
    }

    private static String[] getFileContent(String fileName){
        String[] content = null;
        try {
            FileInputStream fio = new FileInputStream(fileName);
            byte[] buff = new byte[fio.available()];
            fio.read(buff);
            String contentString = new String(buff);
            content = contentString.split("\\s");
            fio.close();
        } catch (IOException e) {
            System.out.println("Please, check name and existing of file!");
        }

        return content;
    }

    private static void sortStringOrderABC(String[] content){
        Arrays.sort(content);
    }

    private static void writeContentIntoTheFile(String fileName, String[] content){
        try {
            FileOutputStream fos = new FileOutputStream(new File("sorted_" + fileName));

            String outputcontent = Arrays.stream(content).collect(Collectors.joining("\n"));

            fos.write(outputcontent.getBytes());
            fos.flush();
            fos.close();
        } catch (IOException e) {
            System.out.println("We have problem with file and his writable");
        }
    }
}
