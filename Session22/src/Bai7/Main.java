package Bai7;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String filePath = "dataBai7.txt";
        writeDataToFile(filePath);
        List<Country> countries = readCountriesFromFile(filePath);
        printCountries(countries);
    }

    private static void writeDataToFile(String filePath) {
        try (FileWriter fw = new FileWriter(filePath)) {
            fw.write("1,\"AU\",\"Australia\"\n");
            fw.write("2,\"CN\",\"China\"\n");
            fw.write("3,\"AU\",\"Australia\"\n");
            fw.write("4,\"CN\",\"China\"\n");
            fw.write("5,\"JP\",\"Japan\"\n");
            fw.write("6,\"CN\",\"China\"\n");
            fw.write("7,\"JP\",\"Japan\"\n");
            fw.write("8,\"TH\",\"Thailand\"\n");
            System.out.println("Dữ liệu đã được ghi vào file: " + filePath);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static List<Country> readCountriesFromFile(String filePath) {
        List<Country> countries = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    int id = Integer.parseInt(parts[0].trim());
                    String code = parts[1].replace("\"", "").trim();
                    String name = parts[2].replace("\"", "").trim();
                    countries.add(new Country(id, code, name));
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return countries;
    }

    private static void printCountries(List<Country> countries) {
        System.out.println("Danh sách các quốc gia:");
        for (Country country : countries) {
            System.out.println(country);
        }
    }
}
