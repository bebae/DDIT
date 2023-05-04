package kr.or.ddit.basic.JavaIOTest;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Scanner;

public class PhoneBookTest {

    private static final String PATH = "d:/D_Other/phonebook.txt";
    Scanner scanner = new Scanner(System.in);
    HashMap<String, Phone> phoneBook = new HashMap<>();
    public void Start(){
        phoneBook.put("홍길동", new Phone("홍길동", "대전 중구 계룡로", "010-1234-5678"));
        phoneBook.put("김민수", new Phone("김민수", "대전 서구 배재로", "010-1234-5678"));
    }
    public static void main(String[] args) throws IOException {
        PhoneBookTest pbt = new PhoneBookTest();
        // 프로그램 시작 시 파일로부터 데이터를 읽어옴
        // 객체 입력용 스트림 객체 생성
        ObjectInputStream oin = new ObjectInputStream(
                new BufferedInputStream(Files.newInputStream(Paths.get(PATH)))
        );
        Object obj = null;
        pbt.Start();
        pbt.mainView();
    }

    public void mainView(){
        while (true) {
            int menuNum = displayMenu();
            switch (menuNum) {
                case 1:
                    InsertedPhoneBookTest();
                    break;
                case 2:
                    UpdatedPhoneBookTest();
                    break;
                case 3:
                    DeletedPhoneBookTest();
                    break;
                case 4:
                    SearchedPhoneBookTest();
                    break;
                case 5:
                    printAllPhoneBook();
                    break;
                case 0:
                    System.out.println("프로그램을 종료합니다...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("잘못된 번호입니다. 다시 입력해주세요.\n");
                    break;
            }
        }
    }
    public int displayMenu() {
        System.out.println("-------------------");
        System.out.println("    메  뉴");
        System.out.println("1. 전화번호 등록");
        System.out.println("2. 전화번호 수정");
        System.out.println("3. 전화번호 삭제");
        System.out.println("4. 전화번호 검색");
        System.out.println("5. 전화번호 전체 출력");
        System.out.println("0. 프로그램 종료");
        System.out.println("--------------------");

        System.out.print("번호 입력 >> ");
        String menuNum = scanner.nextLine();
        // 정규식 처리
        while (!menuNum.matches("[0-6]")) {
            System.out.println("잘못된 입력입니다. 0~6 사이의 번호를 입력해주세요.");
            System.out.print("번호 입력 >> ");
            menuNum = scanner.nextLine();
        }
        return Integer.parseInt(menuNum);
    }

    // 수정, 삭제, 추가가 발생했을 때 파일로 출력하는 메소드
    public void writeToFile() {
        FileOutputStream fout = null;
        try {
            fout = new FileOutputStream("d:/D_Other/object.bin");
            BufferedOutputStream bout = new BufferedOutputStream(fout);
            ObjectOutputStream oout = new ObjectOutputStream(bout);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void InsertedPhoneBookTest() {
        System.out.println("\n새롭게 등록할 정보를 입력하세요.");
                    System.out.print("이름 >> ");
        String name = scanner.nextLine();
                    if (phoneBook.containsKey(name)) {
            System.out.println("'" + name + "'은 이미 등록된 사람입니다.\n");
            return;
        }
                    System.out.print("전화번호 >> ");
        String phoneNumber = scanner.nextLine();
                    System.out.print("주소 >> ");
        String address = scanner.nextLine();

        Phone phone = new Phone(name, address, phoneNumber);
        phoneBook.put(name, phone);
        System.out.println("'" + name + "' 전화번호 등록 완료!!\n");

        // 데이터 추가 후 파일로 출력
        writeToFile();
    }
    public void UpdatedPhoneBookTest() {
        System.out.println("\n수정할 이름의 정보를 입력하세요.");
        System.out.print("이름 >> ");
        String nameToEdit = scanner.nextLine();
        if (!phoneBook.containsKey(nameToEdit)) {
            System.out.println("'" + nameToEdit + "'은 등록되지 않은 사람입니다.\n");
            return;
        }
        System.out.print("수정할 전화번호 >> ");
        String phoneNumberToEdit = scanner.nextLine();
        System.out.print("수정할 주소 >> ");
        String addressToEdit = scanner.nextLine();

        Phone editedPhone = new Phone(nameToEdit, addressToEdit, phoneNumberToEdit);
        phoneBook.put(nameToEdit, editedPhone);                                     // 키 값이 같다면 수정됨
        System.out.println("'" + nameToEdit + "' 전화번호 수정 완료!!\n");

        // 데이터 수정 후 파일로 출력
        writeToFile();
    }
    public void DeletedPhoneBookTest() {
        System.out.println("\n삭제할 이름의 정보를 입력하세요.");
        System.out.print("이름 >> ");
        String nameToDelete = scanner.nextLine();
        if (!phoneBook.containsKey(nameToDelete)) {
            System.out.println("'" + nameToDelete + "'은 등록되지 않은 사람입니다.\n");
            return;
        }
        phoneBook.remove(nameToDelete);
        System.out.println("'" + nameToDelete + "' 전화번호 삭제 완료!!\n");

        // 데이터 삭제 후 파일로 출력
        writeToFile();
    }
    public void SearchedPhoneBookTest() {
        Phone searchedPhone;
        System.out.println("\n검색할 이름의 정보를 입력하세요.");
        System.out.print("이름 >> ");
        String nameToSearch = scanner.nextLine();
        if (!phoneBook.containsKey(nameToSearch)) {
            System.out.println("'" + nameToSearch + "'은 등록되지 않은 사람입니다.\n");
            return;
        }
        searchedPhone = phoneBook.get(nameToSearch);
        System.out.println("-------------------------------------------------------");
        System.out.printf("%-8s%-15s%-20s\n", "이름", "전화번호", "주소");
        System.out.println("-------------------------------------------------------");
        System.out.printf("%-8s%-15s%-20s\n", searchedPhone.getName(), searchedPhone.getPhoneNumber(), searchedPhone.getAddress());
        System.out.println("-------------------------------------------------------");
        System.out.println("검색 끝...\n");
    }
    public void printAllPhoneBook() {
        System.out.println("-------------------------------------------------------");
        System.out.printf("%-7s%-8s%-14s%-24s\n", "번호", "이름", "전화번호", "주소");
        System.out.println("-------------------------------------------------------");
        int index = 1;
        for (String key : phoneBook.keySet()) {
            Phone temp = phoneBook.get(key);
            System.out.printf("  %-5s%-6s%-15s%-20s\n", index++, temp.getName(), temp.getPhoneNumber(), temp.getAddress());
        }
        System.out.println("-------------------------------------------------------");
        System.out.println("출력 끝...\n");
    }
    private static class Phone implements Serializable {
        private final String name;
        private final String address;
        private final String phoneNumber;

        Phone(String name, String address, String phoneNumber) {
            this.name = name;
            this.address = address;
            this.phoneNumber = phoneNumber;
        }

        public String getName() {
            return name;
        }

        public String getAddress() {
            return address;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }
    }
}

