import java.io.*;

public class EmployeeSalaryAverage {
    public static void main(String[] args) {
        String inputFile = "employees.txt";
        String outputFile = "employee_averages.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {

            String line;
            while ((line = br.readLine()) != null) {
                try {
                    String[] parts = line.split("\\s+");
                    if (parts.length != 4) {
                        System.out.println("Invalid line format: " + line);
                        continue;
                    }

                    String name = parts[0];
                    double[] salaries = new double[3];
                    double sum = 0;

                    for (int i = 0; i < 3; i++) {
                        double salary = Double.parseDouble(parts[i + 1]);
                        if (salary < 0) {
                            throw new NegativeNumberException("Negative salary found for " + name);
                        }
                        salaries[i] = salary;
                        sum += salary;
                    }

                    double average = sum / 3.0;
                    bw.write(name + " " + average);
                    bw.newLine();

                } catch (NumberFormatException e) {
                    System.out.println("Invalid salary format in line: " + line);
                } catch (NegativeNumberException e) {
                    System.out.println(e.getMessage());
                }
            }

            System.out.println("Processing complete. Results written to " + outputFile);

        } catch (FileNotFoundException e) {
            System.out.println("Input file not found: " + inputFile);
        } catch (IOException e) {
            System.out.println("I/O error: " + e.getMessage());
        }
    }
}
