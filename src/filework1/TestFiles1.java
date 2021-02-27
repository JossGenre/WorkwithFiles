package filework1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestFiles1 {
static int id;
    public void addstudent () throws IOException {

        File file = new File ("testfile.txt");
        BufferedWriter bw = new BufferedWriter(new FileWriter("testfile.txt", true));
        Scanner scanner = new Scanner(System.in);
//        System.out.println("Введите id студента: ");
//        String id = scanner.nextLine();
        BufferedReader br = new BufferedReader(new FileReader("testfile.txt"));
        String s;
        int maxid=0;
        while ((s= br.readLine())!=null){
            String [] ars = s.split(",");
            if (Integer.parseInt(ars[0])>maxid){
                maxid=Integer.parseInt(ars[0]);
            }
        }
        id=maxid+1;
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

        bw.write(id+","+group+ ","+lastname+ ","+mathmark+ ","+physmark+ ","+itmark+ ","+cherchmark);
        bw.newLine();
        bw.flush();
        bw.close();
        System.out.println("Студент добавлен");
    }

    public void addstudent_po_ID () throws IOException {

        File file = new File ("testfile.txt");
        BufferedWriter bw = new BufferedWriter(new FileWriter("testfile.txt", true));
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите id студента: ");
        String thisid = scanner.nextLine();
        BufferedReader br = new BufferedReader(new FileReader("testfile.txt"));
        String s;

        while ((s= br.readLine())!=null){
            String [] ars = s.split(",");
            if (ars[0].equals(thisid)){
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

        bw.write(thisid+","+group+ ","+lastname+ ","+mathmark+ ","+physmark+ ","+itmark+ ","+cherchmark);
        bw.newLine();
        bw.flush();
        bw.close();
        System.out.println("Студент добавлен");
    }

    public void readall () throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("testfile.txt"));

        System.out.println("Список всех студентов:");
        System.out.println("-------------------------------------------------------------------------------------------------------");
        System.out.println("     Id      Группа     Фамилия     Математика      Физика      Программирование      Инж. Графика     ");
        System.out.println("-------------------------------------------------------------------------------------------------------");
        String s;
        //String [] ars = new String[7];

        while ((s= br.readLine())!=null){
            String [] ars= s.split(",");
            System.out.println("     "+ ars[0]+"        "+ ars[1]+"        "+ ars[2]+"        "+ ars[3]+"              "+ ars[4]+"                 "+ ars[5]+"                   "+ ars[6]+"        ");
        }
        br.close();
    }

    public void vyvod_po_ID() throws IOException {
        Scanner scanner = new Scanner (System.in);
        System.out.println("Введите ID студента для поиска: ");
        String id = scanner.nextLine();


        BufferedReader br = new BufferedReader(new FileReader("testfile.txt"));
        System.out.println("Студент с ID = "+id);
        System.out.println("-------------------------------------------------------------------------------------------------------");
        System.out.println("     Id      Группа     Фамилия     Математика      Физика      Программирование      Инж. Графика     ");
        System.out.println("-------------------------------------------------------------------------------------------------------");
        String s;
        int counter =0;
        while ((s= br.readLine())!=null){
            String [] ars= s.split(",");
            if (ars[0].equals(id)){
                System.out.println("     "+ ars[0]+"        "+ ars[1]+"        "+ ars[2]+"        "+ ars[3]+"              "+ ars[4]+"                 "+ ars[5]+"                   "+ ars[6]+"        ");
           counter++;
            }
        }
        br.close();
if (counter==0) {
    System.out.println("Студента с таким ID е найдено");
}
    }
    public void delstudent_ID() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ID студента для удаления: ");
        String id = scanner.nextLine();
        String s;

        File file = new File("testfile.txt");
        File file2 = new File("testfile2.txt");
        BufferedReader br = new BufferedReader(new FileReader("testfile.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("testfile2.txt", true));
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
        file.delete();
        //System.out.println(file.delete());
       file2.renameTo(file);
        System.out.println("Студент удалён");
    }

    public void changeStudentData () throws IOException {
        Scanner scanner = new Scanner (System.in);
        System.out.println("Введите ID студента, данные которого хотите изменить: ");
        String thisid =scanner.nextLine() ;
        //File file = new File ("testfile.txt");
        RandomAccessFile rafile = new RandomAccessFile("testfile.txt", "rw");

        String s;
        int flag=0;
        while ((s= rafile.readLine())!=null){

            String [] ars = s.split(",");
            if (ars[0].equals(thisid)){
//                System.out.println(rafile.getFilePointer());
//                System.out.println(rafile.readLine());
//                System.out.println(rafile.getFilePointer());
                rafile.seek(rafile.getFilePointer()- (s.length()+2));
                System.out.println(rafile.readLine());
                rafile.seek(rafile.getFilePointer()- (s.length()+2));
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

                String newdata = thisid+","+group+ ","+lastname+ ","+mathmark+ ","+physmark+ ","+itmark+ ","+cherchmark;
                rafile.writeUTF(newdata);
                flag=1;

                System.out.println("Данные успешно изменены");
                return;
            }

        }
        if (flag==0) {
            System.out.println("Студент с таким ID не найден");
        }


    }
}
