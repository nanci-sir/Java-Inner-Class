package anonymous;

        import java.sql.SQLOutput;

public class Teat2 {
    //匿名内部类可以作为一个对象，直接传输给方法。
    public static void main(String[] args) {
        Swimming s =new Swimming() {
            @Override
            public void swim() {
                //接口不能创造对象 这是匿名类的对象
                System.out.println("学生快乐自由泳");
            }
        };
        go(s);
        System.out.println("&&&&&&&&&&&&&&&&&&&");
        Swimming s1 =new Swimming() {
            @Override
            public void swim() {
                //接口不能创造对象 这是匿名类的对象
                System.out.println("老师游泳");
            }
        };
        go(s1);
       //方法的入参形式
        System.out.println("&&&&&&&&&&&&&&&&&&&");
        go(new Swimming() {
            @Override
            public void swim() {
                //接口不能创造对象 这是匿名类的对象
                System.out.println("运动员游泳");
            }
        });

    }
    //某个学校需要让老师，学生，运动员一起参加游泳比赛
    public static  void go (Swimming s){
        System.out.println("开始");
        s.swim();
        System.out.println("结束");
    }
}
//匿名内部类不需要子类
//class  Student implements  Swimming{

//  @Override
//  public void swim() {
//     System.out.println("学生快乐自由泳");
//   }
//}
interface  Swimming{
    void  swim();
}
