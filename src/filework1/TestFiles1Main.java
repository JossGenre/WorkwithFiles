package filework1;

import java.io.IOException;
import java.util.Scanner;

public class TestFiles1Main {

    public static void main(String[] args) throws IOException {

        String choise;
        String contin="Y";
        TestFiles1 tf1 = new TestFiles1();
        while (contin.equals("Y")) {

            System.out.println("Выберите метод для работы с программой: ");
            System.out.println("1 - Быстрое добавление студента");
            System.out.println("2 - Добавление студента по ID");
            System.out.println("3 - Вывод всех студентов");
            System.out.println("4 - Вывод студента по ID");
            System.out.println("5 - Удаление студента по ID");
            System.out.println("6 - Изменить данные о студенте по ID");
            System.out.println("7 - Выход");
            Scanner scanner = new Scanner(System.in);
            choise = scanner.nextLine();
            switch (choise) {
                case "1":tf1.addstudent();
                break;
                case "2":tf1.addstudent_po_ID();
                    break;
                case "3":tf1.readall();
                    break;
                case "4":tf1.vyvod_po_ID();
                    break;
                case "5":tf1.delstudent_ID();
                    break;
                case "6":tf1.changeStudentData();
                    break;
                case "7":contin="N";
                    break;
            }

        }



    }
}
