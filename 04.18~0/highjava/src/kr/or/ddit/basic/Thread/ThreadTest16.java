package kr.or.ddit.basic.Thread;

// 은행의 입출금을 스레드로 처리하는 예제
public class ThreadTest16 {     // 이클래스의 객체가 공통으로 사용할 객체

    private int balance;        // 잔액이 저장될 변수
    private final String name;

    ThreadTest16(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    // 입금 처리 메소드
    public void deposit(int money) {
        balance += money;
    }

    // 출금 처리 메소드 ( 반환값을 출금 성공/실패)
    public synchronized boolean withdraw(int money) {
        if(balance >= money) {
            for(long i=1L; i<=1_000_000_000L; i++) {}   // 시간 지연용
            balance -= money;
            System.out.println("메소드의 balance = " + balance);
            return true;
        }
        return false;       // 출금 실패!
    }


    public static void main(String[] args) {
        ThreadTest16 acount = new ThreadTest16(null);
        acount.setBalance(10000);       // 잔액을 10000원 설정

        // 스레드는 익명 객체로 구현
        Runnable r = () -> {
            boolean result = acount.withdraw(6000);
            System.out.println(Thread.currentThread().getName()+"스레드의 result = " + result+", balance = " + acount.getBalance());
        };

        Thread th1 = new Thread(r, "A");
        Thread th2 = new Thread(r, "B");

        th1.start();
        th2.start();
    }
}
