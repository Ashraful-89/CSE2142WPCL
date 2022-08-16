import java.io.*;
import java.text.*;
import java.util.*;

public class StudentList {
    public static void main(String[] args) {

        // Check arguments

        if (args[0].equals(Constant.showAll)) {
            System.out.println(Constant.loadingData);
            try {
                BufferedReader bufferedReader = readFile();
                String studentNames = bufferedReader.readLine();
                String names[] = studentNames.split(",");
                for (String name : names) {
                    System.out.println(name.trim());
                }
                bufferedReader.close();
            } catch (Exception e) {

            }
            System.out.println(Constant.loadedData);
        }

        else if (args[0].equals(Constant.showAl)) {
            System.out.println(Constant.loadingData);
            try {
                BufferedReader bufferedReader = readFile();
                String line = bufferedReader.readLine();
                System.out.println(line);
                String i[] = line.split(",");
                Random randomNumber = new Random();
                int anyRandomNumber = randomNumber.nextInt(4);
                System.out.println(i[anyRandomNumber]);
                bufferedReader.close();
            } catch (Exception e) {
            }
            System.out.println(Constant.loadedData);
        }

        else if (args[0].contains(Constant.addOperator)) {
            System.out.println(Constant.loadingData);
            try {
                BufferedWriter bufferedReader = writeFile();
                String t = args[0].substring(1);
                Date date = new Date();
                String dateFormal_d_m_y = "dd/mm/yyyy-hh:mm:ss a";
                DateFormat dateFormat = new SimpleDateFormat(dateFormal_d_m_y);
                String formalDate = dateFormat.format(date);
                bufferedReader.write(", " + t + "\nList last updated on " + formalDate);
                bufferedReader.close();
            } catch (Exception e) {

            }
            System.out.println(Constant.loadedData);
        }

        else if (args[0].contains(Constant.questionMark)) {
            System.out.println(Constant.loadingData);
            try {
                BufferedReader bufferedReader = readFile();
                String studentName = bufferedReader.readLine();
                String names[] = studentName.split(",");
                boolean done = false;
                String str = args[0].substring(1);
                for (int idx = 0; idx < names.length && !done; idx++) {
                    if (names[idx].equals(str)) {
                        System.out.println("We found it!");
                        done = true;
                    }
                }
                bufferedReader.close();
            } catch (Exception e) {

            }
            System.out.println(Constant.loadedData);

        }

        else if (args[0].contains(Constant.showAlll)) {
            System.out.println(Constant.loadingData);
            try {
                BufferedReader bufferedReader = readFile();
                String D = bufferedReader.readLine();
                char Char[] = D.toCharArray();
                boolean in_word = false;
                int count = 0;
                for (char c : Char) {
                    if (c == ' ') {
                        if (!in_word) {
                            count++;
                            in_word = true;
                        } else {
                            in_word = false;
                        }
                    }
                }
                System.out.println(count + " word(s) found " + Char.length);
                bufferedReader.close();
            } catch (Exception e) {

            }
            System.out.println(Constant.loadedData);
        }

        else {
            System.out.println("Wrong The input and try again\n");
        }

    }

    private static BufferedWriter writeFile() throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(
            new FileWriter("students.txt", true));
            return bufferedWriter;

    }
    private static BufferedReader readFile() throws FileNotFoundException {
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(Constant.StudentList)));
        return bufferedReader;
    }
}