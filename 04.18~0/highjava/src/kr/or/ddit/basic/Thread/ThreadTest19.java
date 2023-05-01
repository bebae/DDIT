package kr.or.ddit.basic.Thread;

public class ThreadTest19 {
    public static void main(String[] args) {
        DataBox dataBox = new DataBox();

        DataThread in = new DataThread(dataBox);
        DataOutThread out = new DataOutThread(dataBox);
        out.start();
        in.start();
        try {
            in.join();
            out.join();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static class DataBox {
        private String data;

        /**
         *  data 변수에 값이 null 이면 값이 대입될 때까지 대기
         *  data 변수에 값이 있다면 return 후 null 로 초기화
         * @return Sting data
         */
        public synchronized String getData() {
            if(this.data == null) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            String returnData = data;
            System.out.println("스레드가 읽은 데이터 : "+returnData);
            data = null;
            notify();
            return returnData;
        }

        /**
         *  data 변수에 값이 null 이면 값이 대입될 때까지 대기
         *  data 변수에 값이 있다면 return 후 null 로 초기화
         * @param data String
         */
        public synchronized void setData(String data) {
            if(this.data != null) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.data = data;
            System.out.println("Thread에서 새로 저장한 데이터 : "+data);
            notify();
        }
    }

    /**
     *  데이터를 넣는 스레드
     */
    private static class DataThread extends Thread {
        private final DataBox dataBox;

        public DataThread(DataBox dataBox) {
            this.dataBox = dataBox;
        }

        @Override
        public void run() {
            String[] testArr = new String[] {"서울","대전","광주","대구","부산"};
            for(String test : testArr) {
                dataBox.setData(test);
            }
        }
    }

    /**
     * 데이터를 꺼내서 사용하는 스레드
     */
    private static class DataOutThread extends Thread {
        private final DataBox dataBox;

        public DataOutThread(DataBox dataBox) {
            this.dataBox = dataBox;
        }

        @Override
        public void run() {
            for (int i = 1; i <= 5; i++) {
                String data = dataBox.getData();
            }
        }
    }
}
