package chapter13.exam07;

class Student {
    public int sno;
    public String name;

    public Student(int sno, String name) {
        this.sno = sno;
        this.name = name;
    }

    // 학번과 이름이 같다면 true를 리턴
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Student) {
            Student student = (Student) obj;
            return (sno== student.sno) && (name.equals(student.name));
        } else {
            return false;
        }
    }
    public int hashCode() {
        return sno + name.hashCode();
    }
}
