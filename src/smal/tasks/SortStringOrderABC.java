package smal.tasks;

import java.io.*;
import java.util.Arrays;
import java.util.stream.Collectors;

public class SortStringOrderABC {

    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String filename = null;
        try {
            filename = reader.readLine();
            System.out.println(filename);
        } catch (IOException e) {
            System.out.println("We cant read you file");
        }

        String[] content= null;
        try {
            FileInputStream fio = new FileInputStream(filename);
            byte[] buff = new byte[fio.available()];
            fio.read(buff);
            String contentString = new String(buff);
            content = contentString.split("\\s");
            Arrays.sort(content);
            System.out.println(Arrays.toString(content));
            fio.close();
        } catch (IOException e) {
            System.out.printf("Please, check name and existing of file!");
        }

        try {
            FileOutputStream fos = new FileOutputStream(new File("sorted_" + filename));
            String outputcontent = Arrays.stream(content).collect(Collectors.joining("\n"));

            fos.write(outputcontent.getBytes());
            fos.flush();
            fos.close();

            System.out.println(outputcontent);
        } catch (IOException e) {
            System.out.println("We have problem with file and his writable");
        }

    }
}
