package filework1;

import java.io.*;
import java.util.*;

public class TestFiles1 {
    static int id;
    static Set<Integer> idset = new HashSet<>();

    public void addstudent() throws IOException {

        File file = new File("testfile.txt");
        BufferedWriter bw = new BufferedWriter(new FileWriter("testfile.txt", true));
        Scanner scanner = new Scanner(System.in);
//        System.out.println("Введите id студента: ");
//        String id = scanner.nextLine();
        BufferedReader br = new BufferedReader(new FileReader("testfile.txt"));
        String s;
        int maxid = 0;
        while ((s = br.readLine()) != null) {
            String[] ars = s.split(",");
            //idset.add(Integer.parseInt(ars[0]));
            if (Integer.parseInt(ars[0]) > maxid) {
                maxid = Integer.parseInt(ars[0]);
            }
        }
        id = maxid + 1;
        System.out.println("Введите группу студента: ");
        String group = scanner.nextLine();
        System.out.println("Введите фамилию студента: ");
        String lastname = scanner.nextLine();
        System.out.println("Введите оц по матем студента: ");
        String mathmark = scanner.nextLine();
        System.out.println("Введите оц по физике студента: ");
        String physmark = scanner.nextLine();
        System.out.println("Введите оц по програм студента: ");
        String itmark = scanner.nextLine();
        System.out.println("Введите оц по инж граф студента: ");
        String cherchmark = scanner.nextLine();

        bw.write(id + "," + group + "," + lastname + "," + mathmark + "," + physmark + "," + itmark + "," + cherchmark);
        bw.newLine();
        bw.flush();
        bw.close();
        System.out.println("Студент добавлен");
    }

    public void addstudent_po_ID() throws IOException {

        File file = new File("testfile.txt");
        BufferedWriter bw = new BufferedWriter(new FileWriter("testfile.txt", true));
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите id студента: ");
        String thisid = scanner.nextLine();
        // idset.add(Integer.parseInt(thisid));
        BufferedReader br = new BufferedReader(new FileReader("testfile.txt"));
        String s;

        while ((s = br.readLine()) != null) {
            String[] ars = s.split(",");
            if (ars[0].equals(thisid)) {
                System.out.println("Этот ID же занят другим студентом");
                return;
            }
        }

        System.out.println("Введите группу студента: ");
        String group = scanner.nextLine();
        System.out.println("Введите фамилию студента: ");
        String lastname = scanner.nextLine();
        System.out.println("Введите оц по матем студента: ");
        String mathmark = scanner.nextLine();
        System.out.println("Введите оц по физике студента: ");
        String physmark = scanner.nextLine();
        System.out.println("Введите оц по програм студента: ");
        String itmark = scanner.nextLine();
        System.out.println("Введите оц по инж граф студента: ");
        String cherchmark = scanner.nextLine();

        bw.write(thisid + "," + group + "," + lastname + "," + mathmark + "," + physmark + "," + itmark + "," + cherchmark);
        bw.newLine();
        bw.flush();
        bw.close();
        System.out.println("Студент добавлен");
    }

    public void readall() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("testfile.txt"));

        System.out.println("Список всех студентов:");
        System.out.println("-------------------------------------------------------------------------------------------------------");
        System.out.println("     Id      Группа     Фамилия     Математика      Физика      Программирование      Инж. Графика     ");
        System.out.println("-------------------------------------------------------------------------------------------------------");
        String s;

        while ((s = br.readLine()) != null) {
            String[] ars = s.split(",");
            // System.out.println("     "+ ars[0]+"        "+ ars[1]+"        "+ ars[2]+"        "+ ars[3]+"              "+ ars[4]+"                 "+ ars[5]+"                   "+ ars[6]+"        ");
            System.out.printf("     %-4s%8s%15s%10s%13s%17s%21s\n", ars[0], ars[1], ars[2], ars[3], ars[4], ars[5], ars[6]);

        }
        br.close();
    }

    public void vyvod_po_ID() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ID студента для поиска: ");
        String id = scanner.nextLine();


        BufferedReader br = new BufferedReader(new FileReader("testfile.txt"));
        System.out.println("Студент с ID = " + id);
        System.out.println("---------------------------------------------------------------------------------------------------------------");
        System.out.println("      Id       Группа      Фамилия      Математика       Физика       Программирование       Инж. Графика      ");
        System.out.println("---------------------------------------------------------------------------------------------------------------");
        String s;
        int counter = 0;
        while ((s = br.readLine()) != null) {
            String[] ars = s.split(",");
            if (ars[0].equals(id)) {
                System.out.println("     " + ars[0] + "        " + ars[1] + "        " + ars[2] + "        " + ars[3] + "              " + ars[4] + "                 " + ars[5] + "                   " + ars[6] + "        ");
                counter++;
            }
        }
        br.close();


        if (counter == 0) {
            System.out.println("Студента с таким ID не найдено");
        }
    }


    public void setconfig() throws IOException {
        File file = new File("testfile.txt");
        BufferedReader br = new BufferedReader(new FileReader("testfile.txt"));

        String s;

        while ((s = br.readLine()) != null) {
            String[] ars = s.split(",");
            idset.add(Integer.parseInt(ars[0]));
        }
        br.close();
    }

    public void delstudent_ID() throws IOException
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ID студента для удаления: ");
        String id = scanner.nextLine();
        String s;

        File file = new File("testfile.txt");
        File file2 = new File("testfile2.txt");
        BufferedReader br = new BufferedReader(new FileReader("testfile.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("testfile2.txt", true));

        setconfig();
        if (idset.contains(Integer.parseInt(id))) {

            System.out.println("Удаляем..");
            while ((s = br.readLine()) != null) {
                String[] ars = s.split(",");
                if (!ars[0].equals(id)) {
                    bw.write(s);
                    bw.newLine();
                }
            }
            br.close();
            bw.flush();
            bw.close();
            if (file.delete()) {
                System.out.println("Студент удалён");
                file2.renameTo(file);
            } else {
                System.out.println("Ошибка. Не удалось удалить");
            }
        } else {
            System.out.println("Студент с таким ID не найден");
        }
    }

    public void changeStudentData() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ID студента, данные которого хотите изменить: ");
        String thisid = scanner.nextLine();

        setconfig();
        if (!idset.contains(Integer.parseInt(thisid))) {
            System.out.println("Студента с таккм id не найдено");
        } else {

            RandomAccessFile rafile = new RandomAccessFile("testfile.txt", "rw");

            String s;

            while ((s = rafile.readLine()) != null) {

                String[] ars = s.split(",");

                if (ars[0].equals(thisid)) {

                    rafile.seek(rafile.getFilePointer() - (s.length()+ars[0].length()));
                    System.out.println("Введите группу студента: ");
                    String group = scanner.nextLine();
                    System.out.println("Введите фамилию студента: ");
                    String lastname = scanner.nextLine();
                    System.out.println("Введите оц по матем студента: ");
                    String mathmark = scanner.nextLine();
                    System.out.println("Введите оц по физике студента: ");
                    String physmark = scanner.nextLine();
                    System.out.println("Введите оц по програм студента: ");
                    String itmark = scanner.nextLine();
                    System.out.println("Введите оц по инж граф студента: ");
                    String cherchmark = scanner.nextLine();

                    String newdata = thisid + "," + group + "," + lastname + "," + mathmark + "," + physmark + "," + itmark + "," + cherchmark;

                    rafile.write(newdata.getBytes());

                    System.out.println("Данные успешно изменены");
                    return;
                }
            }
            rafile.close();
        }
    }
}