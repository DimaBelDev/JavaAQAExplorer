package ru.dima.study.lesson_6;

import java.io.*;


public class AppData {

    private static final String CSV_SEPARATOR = ";,";
    private  String[] header;
    private  int[][] data;

    public AppData(String[] header, int[][] data) {
        this.header = header;
        this.data = data;
    }

    public void save(String filePath) {

        try (BufferedWriter csvWriter = new BufferedWriter(new FileWriter(filePath))) {

            for (int i = 0; i < header.length; i++) {
                if(i == header.length - 1){
                    csvWriter.append(escapeSpecialCharacters(header[i]));
                } else {
                    csvWriter.append(escapeSpecialCharacters(header[i])).append(CSV_SEPARATOR);
                }
            }
            csvWriter.newLine();

            for (int i = 0; i < data.length;i++) {
                for (int j = 0; j < data[i].length;j++ ) {
                    if(j == data[i].length - 1){
                        csvWriter.append(String.valueOf(data[i][j]));
                    } else {
                        csvWriter.append(String.valueOf(data[i][j])).append(CSV_SEPARATOR);
                    }
                }
                csvWriter.newLine();
            }

            System.out.println("Values written to the CSV file successfully!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load(String filePath) {

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

            header = reader.readLine().split(CSV_SEPARATOR);

            int rowCount = (int) reader.lines().count();
            data = new int[rowCount][header.length];

            try (BufferedReader dataReader = new BufferedReader(new FileReader(filePath))) {
                dataReader.readLine();
                for (int i = 0; i < rowCount; i++) {
                    String[] line = dataReader.readLine().split(CSV_SEPARATOR);
                    for (int j = 0; j < line.length; j++) {
                        data[i][j] = Integer.parseInt(line[j]);
                    }
                }
            }

            System.out.println("Data loaded successfully.");

            showHeaderAndData();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String escapeSpecialCharacters(String value) {
        if (value.contains(",") || value.contains("\"") || value.contains("\n")) {
            return "\"" + value.replace("\"", "\"\"") + "\"";
        } else {
            return value;
        }
    }

    private void showHeaderAndData() {
        for (String columnHeader : header) {
            System.out.printf("%-15s", columnHeader);
        }
        System.out.println();

        for (int[] row : data) {
            for (int cell : row) {
                System.out.printf("%-15d", cell);
            }
            System.out.println();
        }
    }

    public String[] getHeader() {
        return header;
    }

    public int[][] getData() {
        return data;
    }

    public void setHeader(String[] header) {
        this.header = header;
    }

    public void setData(int[][] data) {
        this.data = data;
    }

}
