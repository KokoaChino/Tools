// int n = Integer.parseInt(reader.readLine());
// int[] a = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        try (FileInputStream file = new FileInputStream("src\test.txt");
             FileOutputStream outputStream = new FileOutputStream("output.txt", true)) {

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}