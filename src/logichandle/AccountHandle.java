package logichandle;

import account.Account;

import java.util.ArrayList;
import java.util.Scanner;

import view.Menu;

public class AccountHandle {

    public void login(Scanner scanner, ArrayList<Account> accounts) {
        System.out.print("Mời nhập username: ");
        String username = scanner.nextLine();
        System.out.print("Mời nhập passwword: ");
        String passwword = scanner.nextLine();
        boolean check = false;
        for (Account account : accounts) {
            if (account.getUsername().equals(username)) {
                check = true;
                if (account.getPassword().equals(passwword)) {
                    Menu.menu1(scanner, accounts, account);
                } else {
                    Menu.relogin(scanner, accounts);
                }
            }
            if (!check) {
                System.out.println("Kiểm tra lại username: ");
                login(scanner, accounts);
            }
        }

    }

    public void register(Scanner scanner, ArrayList<Account> accounts, Account account) {
        System.out.print("Nhập tên đăng nhập mới: ");
        account.setUsername(newUsername(scanner, accounts, account));
        System.out.println("Nhập mật khẩu mới: ");
        account.setPassword(newPassword(scanner, accounts, account));
        System.out.println("Nhập email: ");
        account.setEmail(newEmail(scanner, accounts, account));
        accounts.add(account);
        System.out.println(accounts);
    }

    private String newEmail(Scanner scanner, ArrayList<Account> accounts, Account account) {
        String regex = "^[a-zA-Z0-9\\.]+@[a-zA-Z]+(\\.[a-zA-Z]+)$";
        String newEmail;
        while (true) {
            System.out.print("Email: ");
            newEmail = scanner.nextLine();
            if (!newEmail.matches(regex)) {
                System.out.println("Không đúng định dạng! Nhập lại ");
            } else
                break;
        }
        do {
            if (!account.getUsername().equals(newEmail))
                break;
            System.out.print("Email này đã có người sử dụng, nhập cái khác: ");
        } while (true);
        return newEmail;
    }


    private String newPassword(Scanner scanner, ArrayList<Account> accounts, Account account) {
        String regex = "^(?=.*[A-Z])(?=.*[\\.;\\,_-])\\S{7,15}$";
        String newPassword;
        while (true) {
            System.out.print("Password: ");
            newPassword = scanner.nextLine();
            if (newPassword.matches(regex)) {
                break;
            } else
                System.out.println("Không đúng định dạng! Password dài từ 7 đến 15 ký tự, chứa ít nhất 1 ký tự in hoa, 1 ký tự đặc biệt, Nhập lại ");
        }
        return newPassword;
    }

    private String newUsername(Scanner scanner, ArrayList<Account> accounts, Account account) {
        String newusername;
        do {
            newusername = scanner.nextLine();
            if (!account.getUsername().equals(newusername))
                break;
            System.out.print("Username mới phải chưa có trong hệ thống, nhập lại: ");
        } while (true);
        return newusername;
    }


    public void forgotPassword(Scanner scanner, ArrayList<Account> accounts, ArrayList<Account> account) {
        System.out.print("Mời bạn nhập Email: ");
        String email = scanner.nextLine();
        for (Account account1 : accounts) {
            if (account1.getEmail().equals(email)) {
                System.out.println("Bạn được phép đổi mật khẩu");
                System.out.print("Mật khẩu mới là: ");
                String newpass1;
                do {
                    newpass1 = scanner.nextLine();
                    if (!account1.getPassword().equals(newpass1))
                        break;
                    System.out.println("Bạn phải nhập mật khẩu mới khác với các mật khẩu bạn đã từng dùng, Nhập lại: ");
                } while (true);
                do {
                    System.out.print("Kiểm tra lại mật khẩu: ");
                    String newpass2 = scanner.nextLine();
                    if (newpass1.equals(newpass2))
                        break;
                    System.out.println("Mật khẩu k trùng khớp, mời nhập lại: ");
                } while (true);
                account1.setPassword(newpass1);
            } else {
                System.out.println("Chưa tồn tại email, vui lòng thử lại");
                forgotPassword(scanner, accounts, account);
            }
            System.out.println("Tài khoản mới là: " + account1);
        }
    }


    public void changeUsername(Scanner scanner, ArrayList<Account> accounts, Account account) {
        System.out.print("Nhập username mới bạn muốn: ");
        String newusername;
        do {
            newusername = scanner.nextLine();
            if (!account.getUsername().equals(newusername))
                break;
            System.out.print("Username mới phải khác Username cũ và chưa có trong hệ thống, nhập lại: ");
        } while (true);
        account.setUsername(newusername);
        System.out.println("Tài khoản mới là: " + account);
        Menu menu = new Menu();
        menu.displayMenu();
        menu.functionchoice(scanner, accounts, account);

    }

    public void changeEmail(Scanner scanner, ArrayList<Account> accounts, Account account) {
        System.out.print("Nhập Email mới bạn muốn: ");
        String newemail;
        do {
            newemail = scanner.nextLine();
            if (!account.getUsername().equals(newemail))
                break;
            System.out.print("Email mới phải khác Email cũ, nhập lại: ");
        } while (true);
        account.setEmail(newemail);
        System.out.println("Tài khoản mới là: " + account);
        Menu menu = new Menu();
        menu.displayMenu();
        menu.functionchoice(scanner, accounts, account);
    }

    public void changePassword(Scanner scanner, ArrayList<Account> accounts, Account account) {
        System.out.print("Nhập Password mới bạn muốn: ");
        String newpassword = scanner.nextLine();
        account.setPassword(newpassword);
        System.out.print("Tài khoản mới là: " + account);
    }
}


