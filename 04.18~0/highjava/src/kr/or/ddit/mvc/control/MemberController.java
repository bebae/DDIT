package kr.or.ddit.mvc.control;

import kr.or.ddit.mvc.service.IMemberService;
import kr.or.ddit.mvc.service.MemberServiceImpl;
import kr.or.ddit.mvc.vo.MemberVo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MemberController {
    private final IMemberService service;
    private final Scanner scan;

    public MemberController() {
        service = new MemberServiceImpl();
        scan = new Scanner(System.in);
    }

    public static void main(String[] args) {
        MemberController controller = new MemberController();
        controller.start();
    }

    public void start() {
        menuPrint();
    }

    public void menuPrint() {
        int menu = -1;
        while (true) {
            System.out.println("----------------------");
            System.out.println("1. 자료 추가");
            System.out.println("2. 자료 삭제");
            System.out.println("3. 자료 수정");
            System.out.println("4. 전체 자료 출력");
            System.out.println("5. 원하는 항목만 수정");
            System.out.println("0. 작업 끝");
            System.out.println("----------------------");
            System.out.print("메뉴 입력 >>> ");
            menu = Integer.parseInt(scan.nextLine());
            switch (menu) {
                case 1:
                    insertMember(); break;
                case 2:
                    deleteMember(); break;
                case 3:
                    updateMember(); break;
                case 4:
                    selectMember(); break;
                case 5:
                    updateMember2(); break;
                case 0:
                    System.out.println("프로그램을 종료합니다. ㅠㅠ");
                    System.exit(0);
                    return;
                default:
                    System.out.println("잘못된 입력입니다. ㅠㅠ");
                    break;
            }
        }
    }

    public boolean checkDuplicateMemberId(String memberId){
        boolean isDuplicate = true;
        int cnt = service.getMemberCount(memberId);
        if (cnt == 0) {
            isDuplicate = false;
        }
        return isDuplicate;
    }

    public void insertMember() {
        String id = "";
        boolean isDuplicate = true;

        while (isDuplicate) {
            System.out.print("회원 ID ▶");
            id = scan.nextLine();

            isDuplicate = checkDuplicateMemberId(id);

            if (isDuplicate) {
                System.out.println("이미 존재하는 id 입니다. 다시 입력하세요.");
            }
        }

        System.out.print("패스워드 ▶ ");
        String pass = scan.nextLine();
        System.out.print("이름  ▶ ");
        String name = scan.nextLine();
        System.out.print("주소  ▶ ");
        String addr = scan.nextLine();
        System.out.print("전화번호  ▶ ");
        String phone = scan.nextLine();

        // 입력 받은 자료 VO객체에 저장
        MemberVo memVo = new MemberVo();
        memVo.setMem_id(id);
        memVo.setMem_pass(pass);
        memVo.setMem_name(name);
        memVo.setMem_addr(addr);
        memVo.setMem_tel(phone);

        // Insert the member info to the DB
        int result = service.insertMember(memVo);
        if (result > 0) {
            System.out.println("insert ㄱㄱ Good!");
        } else {
            System.out.println("insert Failed ㅠㅠ");
        }

    }

    public void deleteMember() {
        System.out.print("지울 ID를 입력해주세요 ▶");
        String id = scan.nextLine();

        int result = service.deleteMember(id);
        if (result > 0) {
            System.out.println("delete ㄱㄱ Good!");
        } else {
            System.out.println("delete Failed ㅠㅠ");
        }
    }

    public void updateMember() {
        System.out.print("수정할 ID ▶");
        String id = scan.nextLine();
        System.out.print("새로운 이름 ▶");
        String name = scan.nextLine();
        System.out.print("새로운 주소  ▶");
        String addr = scan.nextLine();
        System.out.print("새로운 전화번호 ▶");
        String phone = scan.nextLine();
        
        MemberVo memVo = new MemberVo();
        memVo.setMem_id(id);
        memVo.setMem_name(name);
        memVo.setMem_addr(addr);
        memVo.setMem_tel(phone);

        int result = service.updateMember(memVo);
        if (result > 0) {
            System.out.println("update ㄱㄱ Good!");
        } else {
            System.out.println("update Failed ㅠㅠ");
        }
    }
    
    public void selectMember() {
        System.out.println("----------------------------------------");
        System.out.println("ID\t\t이름\t주소\t\t전화번호");
        System.out.println("----------------------------------------");

        List<MemberVo> memList = service.getAllMember();
        if(memList == null || memList.size() == 0){
            System.out.println("\t회원 목록이 없습니다 ㅠㅠ");
        } else {
            for(MemberVo memVo : memList){
                System.out.println(memVo.getMem_id() + "\t" + memVo.getMem_name() + "\t" + memVo.getMem_addr() + "\t" + memVo.getMem_tel());
            }
        }
       
        System.out.println("----------------------------------------");
    }

    public void updateMember2() {
        String id = "";
        boolean isDuplicate = true;

        while (isDuplicate) {
            System.out.print("회원 ID ▶");
            id = scan.nextLine();

            isDuplicate = !checkDuplicateMemberId(id);

            if (isDuplicate) {
                System.out.println("존재하지 않는 id 입니다. 다시 입력하세요.");
            }
        }
        System.out.println("수정 사항");
        System.out.println("----------------------");
        System.out.println(" 1. 패스워드");
        System.out.println(" 2. 회원이름");
        System.out.println(" 3. 전화번호");
        System.out.println(" 4. 주소");
        System.out.println("----------------------");
        System.out.print("수정할 항목 ▶ ");
        int menu = Integer.parseInt(scan.nextLine());
        String select = ""; // 수정할 컬럼명
        switch (menu) {
            case 1:
                select = "mem_pass"; System.out.print("새로운 패스워드 ▶ "); break;
            case 2:
                select = "mem_name"; System.out.print("새로운 회원이름 ▶ "); break;
            case 3:
                select = "mem_tel"; System.out.print("새로운 전화번호 ▶ "); break;
            case 4:
                select = "mem_addr"; System.out.print("새로운 주소 ▶ "); break;
            default:
                System.out.println("입력 실패 ㅠㅠ"); return;
        }
        String update = scan.nextLine();

        // 수정할 정보를 Map에 추가
        // key값 정보 ==> 회원ID(memid), 수정할 컬럼명(field), 수정할 데이터(data)
        Map<String, String> map = new HashMap<>();
        map.put("memid", id);
        map.put("field", select);
        map.put("data", update);

        int cnt = service.updateMember2(map);

        if (cnt > 0) {
            System.out.println("update2 ㄱㄱ Good!");
        } else {
            System.out.println("update2 Failed ㅠㅠ");
        }
    }

}
