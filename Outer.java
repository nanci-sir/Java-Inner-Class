package d1_static;
//外部类
public class Outer {
    public  static int a  = 10;
    private  String hobby;//属于静态外部类对象，不能直接访问
    public  static class  Inner{
        private String name;
        private int age;
        public  static  String schoolName;
//静态成员内部类
        public Inner() {
        }

        public Inner(String name, int age) {
            this.name = name;
            this.age = age;
        }
        public  void show(){

        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public static String getSchoolName() {
            return schoolName;
        }

        public static void setSchoolName(String schoolName) {
            Inner.schoolName = schoolName;
        }
    }
}
