package proxyChecker;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("/Users/hxrvelle/Documents/Java/ip.txt"));
            int lines = 0;
            while (reader.readLine() != null) {
                lines++;
            }
            reader.close();

            int n;
            for (int i = 1; i < lines; i++) {
                if (i % 2 != 0) {
                    n = i;
                    String line = Files.readAllLines(Paths.get("/Users/hxrvelle/Documents/Java/ip.txt")).get(n);
                    String[] switchLine = line.split("\t");
                    String switched = switchLine[0] + ":" + switchLine[1];
                    System.out.println(switched);

                    String ips = switched;
                    try {
                        FileOutputStream fos = new FileOutputStream("/Users/hxrvelle/Documents/Java/t_ip.txt", true);
                        byte[] buffer = ips.getBytes();
                        fos.write(buffer);
                        fos.write(10);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
