package view;

import account.Account;
import logichandle.AccountHandle;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {


    public void displayMenu() {
        System.out.println("Mời bạn chọn chức năng:");
        System.out.println("1.Đăng nhập");
        System.out.println("2.Đăng ký");
    }

    public void functionchoice(Scanner scanner, ArrayList<Account> accounts, Account account) {
        AccountHandle accountHandle = new AccountHandle();
        System.out.print("Chọn đi: ");
        int choice = 0;
        try {
            while (true) {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice == 1 || choice == 2)
                    break;
                System.out.print("Chọn sai, chọn lại đi: ");
            }
        } catch (Exception e) {
            System.out.println("Chọn sai, chọn lại: ");
            functionchoice(scanner, accounts, account);
        }
        switch (choice) {
            case 1:
                accountHandle.login(scanner, accounts);
                break;
            case 2:
                accountHandle.register(scanner, accounts, account);
                break;
        }
    }

    public static void menu1(Scanner scanner, ArrayList<Account> accounts, Account account) {
        AccountHandle accountHandle = new AccountHandle();
        System.out.println("Chào mừng " + account.getUsername() + " bạn có thể thực hiện các công việc sau :");
        System.out.println("1 - Thay đổi username");
        System.out.println("2 - Thay đổi email");
        System.out.println("3 - Thay đổi mật khẩu");
        System.out.println("4 - Đăng xuất ");
        System.out.println("0 - Thoát chương trình");
        System.out.print("Chọn đi: ");
        int choice = 0;
        try {
            while (true) {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice >= 0 && choice <= 4)
                    break;
                System.out.print("Chọn sai, chọn lại đi: ");
            }
        } catch (Exception e) {
            System.out.print("Chọn sai, chọn lại: ");
            menu1(scanner, accounts, account);
        }
        switch (choice) {
            case 1:
                accountHandle.changeUsername(scanner, accounts, account);
                break;
            case 2:
                accountHandle.changeEmail(scanner, accounts, account);
                break;
            case 3:
                accountHandle.changePassword(scanner, accounts, account);
                break;
            case 4:
                Menu menu = new Menu();
                menu.displayMenu();
                menu.functionchoice(scanner, accounts, account);
                break;
            case 5:
                return;

        }
    }

    public static void relogin(Scanner scanner, ArrayList<Account> accounts) {
        AccountHandle accountHandle = new AccountHandle();
        System.out.println(" Bạn đã nhập sai mật khẩu: ");
        System.out.println("1 - Đăng nhập lại");
        System.out.println("2 - Quên mật khẩu");
        System.out.print("Mời chọn: ");
        int choice = 0;
        try {
            do {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice == 1 || choice == 2)
                    break;
                System.out.println("Nhập lại ");
            } while (true);

        } catch (Exception e) {
            System.out.println("Nhập sai, nhập lại");
        }
        switch (choice) {
            case 1:
                accountHandle.login(scanner, accounts);
                break;
            case 2:
                accountHandle.forgotPassword(scanner, accounts, accounts);
                break;
        }
    }

}








