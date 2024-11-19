/*
 * Class: CMSC203 
 * Instructor: Aygun
 * Description: The TwoDimRaggedArrayUtility class provides methods for performing operations on ragged
 two-dimensional arrays. It includes functionality to calculate row and column totals, find the highest 
 and lowest values in specific columns, and calculate the overall total of all values in the array.
 * Due: 11/18/2024
 * Platform/compiler:Eclipse
 * I pledge that I have completed the programming assignment independently.
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: Leslie N. Guevara Amaya
*/
import java.io.*;
import java.util.ArrayList;

public class TwoDimRaggedArrayUtility {

    public static double[][] readFile(File file) throws FileNotFoundException {
        ArrayList<double[]> dataList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(" ");
                double[] row = new double[values.length];
                for (int i = 0; i < values.length; i++) {
                    row[i] = Double.parseDouble(values[i]);
                }
                dataList.add(row);
            }
        } catch (IOException e) {
            throw new FileNotFoundException("File not found: " + e.getMessage());
        }
        return dataList.toArray(new double[0][]);
    }

    public static void writeToFile(double[][] data, File file) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (double[] row : data) {
                for (double value : row) {
                    writer.write(value + " ");
                }
                writer.newLine();
            }
        }
    }

    public static double getRowTotal(double[][] data, int row) {
        double total = 0.0;
        for (double value : data[row]) {
            total += value;
        }
        return total;
    }

    public static double getColumnTotal(double[][] data, int col) {
        double total = 0.0;
        for (double[] row : data) {
            if (col < row.length) {
                total += row[col];
            }
        }
        return total;
    }

    public static double getTotal(double[][] data) {
        double total = 0.0;
        for (double[] row : data) {
            for (double value : row) {
                total += value;
            }
        }
        return total;
    }

    public static double getHighestInColumn(double[][] data, int col) {
        double max = Double.NEGATIVE_INFINITY;
        for (double[] row : data) {
            if (col < row.length) {
                max = Math.max(max, row[col]);
            }
        }
        return max;
    }

    public static double getLowestInColumn(double[][] data, int col) {
        double min = Double.POSITIVE_INFINITY;
        for (double[] row : data) {
            if (col < row.length) {
                min = Math.min(min, row[col]);
            }
        }
        return min;
    }
}
