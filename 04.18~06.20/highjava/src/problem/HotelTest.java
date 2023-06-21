package problem;

import java.util.*;

public class HotelTest {
    Scanner sc = new Scanner(System.in);
    Map<Integer, Room> roomMap = new HashMap<>();
    public HotelTest() {
        for (int i = 201; i <= 409; i++) {
            if (i <= 209 || i >= 301 && i <= 309 || i >= 401) {
                String roomType;
                switch (i / 100) {
                    case 2: roomType = "싱글룸"; break;
                    case 3: roomType = "더블룸"; break;
                    case 4: roomType = "스위트룸"; break;
                    default: continue;
                }
                roomMap.put(i, new Room(i, roomType));
            }
        }
    }
    public static void main(String[] args) {
        HotelTest hotelTest = new HotelTest();
        hotelTest.run();
    }

    private void run() {
        System.out.println("*********************************************");
        System.out.println("       호텔문을 열었습니다. 어서오십시요.");
        System.out.println("*********************************************");
        mainView();
    }

    private void mainView() {
        while (true){
            int select = menuView();
            switch (select){
                case 1:
                    checkIn();
                    break;
                case 2:
                    checkOut();
                    break;
                case 3:
                    roomState();
                    break;
                case 4:
                    System.out.println("*********************************************");
                    System.out.println("            호텔문을 닫았습니다.");
                    System.out.println("*********************************************");
                    System.exit(0);
                    return;
                default:
                    System.out.println("1~4 숫자만 입력해주세요.");
                    break;
            }
        }
    }

    private int menuView() {
        System.out.println("-----------------------------------------------------------");
        System.out.println(" 어떤 업무를 하시겠습니까?");
        System.out.println(" 1. 체크인    2. 체크아웃    3. 객실상태    4. 업무종료");
        System.out.println("-----------------------------------------------------------");
        System.out.print("선택>> ");
        String select = sc.nextLine();
        // 정규식 처리
        while (!select.matches("[0-4]")) {
            System.out.println("잘못된 입력입니다. 0~4 사이의 번호를 입력해주세요.");
            System.out.print("선택 >> ");
            select = sc.nextLine();
        }
        return Integer.parseInt(select);
    }

    private void roomState() {
        // HashMap 전체출력
        System.out.println("----------------------------------------------");
        System.out.println("\t\t현재 객실 상태");
        System.out.println("----------------------------------------------");
        System.out.println( "방 번호\t 방 종류\t 투숙객 이름");
        System.out.println("----------------------------------------------");
        List<Room> roomList = new ArrayList<>(roomMap.values());
        roomList.sort(Comparator.comparing(Room::getRoomNum));
        // Comparator.comparing()을 사용하여 Room 클래스의 getRoomNum() 메서드를 기준으로 Room 객체를 비교하는 Comparator 를 생성합니다.
        // Room::getRoomNum 은 정렬을 람다표현식으로 표현하여 코드를 1줄로 단축 시킵니다.
        // roomList.sort()를 사용하여 생성된 Comparator 를 사용하여 Room 객체를 정렬합니다. 정렬된 결과는 roomList 에 저장됩니다.
        for (Room room : roomList) {
            System.out.println(room);
        }
        System.out.println("----------------------------------------------");
    }

    private void checkOut() {
        System.out.println("----------------------------------------------");
        System.out.println("   체크아웃 작업");
        System.out.println("----------------------------------------------");
        System.out.println("체크아웃 할 방 번호를 입력하세요.");
        System.out.print("방번호 입력 >> ");
        String selectRoom = sc.nextLine();
        while (selectRoom.matches("^[0-9]*&")){
            System.out.println("잘못된 입력입니다. 숫자만 입력해주세요");
            System.out.print("선택 >> ");
            selectRoom = sc.nextLine();
        }
        int roomNum = Integer.parseInt(selectRoom);
        if (roomMap.get(roomNum) == null) {
            System.out.println(selectRoom + "호 객실은 존재하지 않습니다.");
            return;
        }
        if (roomMap.get(roomNum).getName() == null) {
            System.out.println(selectRoom + "호 객실에 체크인 한 사람은 없습니다.");
            return;
        }
        System.out.println(selectRoom + "호 객실의 " + roomMap.get(roomNum).getName() + "님 체크아웃을 완료하였습니다.");
        roomMap.get(roomNum).setName(null);
    }
    private void checkIn() {
        System.out.println("----------------------------------------------");
        System.out.println("   체크인 작업");
        System.out.println("----------------------------------------------");
        System.out.println(" * 201~209 : 싱글룸");
        System.out.println(" * 301~309 : 더블룸");
        System.out.println(" * 401~409 : 스위트룸");
        System.out.println("----------------------------------------------");
        System.out.print("방 번호 입력 >>");
        String selectRoom = sc.nextLine();
        while (selectRoom.matches("^[0-9]*&")){
            System.out.println("잘못된 입력입니다. 숫자만 입력해주세요");
            System.out.print("선택 >> ");
            selectRoom = sc.nextLine();
        }
        int roomNum = Integer.parseInt(selectRoom);
        if (roomMap.get(roomNum) == null) {
            System.out.println(selectRoom + "호 객실은 존재하지 않습니다.");
            return;
        }
        if (roomMap.get(roomNum).getName() != null) {
            System.out.println(selectRoom + "호 객실은 이미 손님이 있습니다.\n");
            return;
        }
        System.out.println("누구를 체크인 하시겠습니까?");
        System.out.print("이름 입력 >> ");
        String name = sc.nextLine();
        while (name.length() == 0) {
            System.out.print("입력값이 없습니다. 이름 입력 >>");
            name = sc.nextLine();
        }
        roomMap.get(roomNum).setName(name);
        System.out.println("체크인이 완료되었습니다.");
    }
}
class Room{
    private final int roomNum;
    private final String roomType;
    private String name;

    public Room(int i, String roomType) {
        this.roomNum = i;
        this.roomType =  roomType;
        this.name = null;
    }

    public int getRoomNum() {
        return roomNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("%5d\t%5s\t%7s", roomNum, roomType, name == null ? "-" : name);
    }
}
