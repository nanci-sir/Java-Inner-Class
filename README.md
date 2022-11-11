# Java-Inner-Class
Java 内部类
内部类就是定义在一个类里面的类，里面的类可以理解成（寄生），外部类可以理解成（宿主）。

```java
public class People{
   *//* *内部类
\*   public class Heart{
   }
 }
```

## 2. 内部类的使用场景

###  2.1 场景：

当一个事物的内部，还有一个部分需要一个完整的结构进行描述时。

### 2.2 基本作用

内部类通常可以方便访问外部类的成员，包括私有的成员。
内部类提供了更好的封装性，内部类本身就可以用private ，protectecd等修饰，封装性可以做更多控制。

## 3. 内部类的分类

### 3.1静态内部类[了解]

#### 3.1.1 什么是静态内部类？

有static修饰，属于外部类本身。
它的特点和使用与普通类是完全一样的，类有的成分它都有，只是位置在别人里面而已。

格式：外部类名.内部类名 对象名 = new 外部类名.内部类构造器;

```java
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
```

```java
package d1_static;

public class Test {
    public static void main(String[] args) {
        Outer.Inner in = new Outer.Inner();
        in.setName( "张三" );
        in.show();
    }
}
```

#### 3.1.2 静态内部类中是否可以直接访问外部类的静态成员？ 

可以，外部类的静态成员只有一份可以被共享访问。

#### 3.1.3 静态内部类中是否可以直接访问外部类的实例成员？ 

不可以的，外部类的实例成员必须用外部类对象访问。



## 3.2成员内部类（非静态内部类） [了解]

#### 3.2.1什么是成员内部类？

无static修饰，属于外部类的对象。
JDK16之前，成员内部类中不能定义静态成员，JDK 16开始也可以定义静态成员了。

成员内部类创建对象的格式：    

格式：外部类名.内部类名 对象名 = new  外部类构造器.new 内部类构造器();

范例：Outer.Inner in =  new Outer().new  Inner();

#### 3.2.2成员内部类中是否可以直接访问外部类的静态成员？ 

可以，外部类的静态成员只有一份可以被共享访问。

#### 3.2.3成员内部类的实例方法中是否可以直接访问外部类的实例成员？ 

可以的，因为必须先有外部类对象，才能有成员内部类对象，所以可以直接访问外部类对象的实例成员。

```java
package innnerclass;

public class Outer {
    public  class Inner{
        //成员内部类
        private  String name;
        private  int age;
       // public  static  int a;//jdk16以后才支持

       // public  static  void test(){
            //System.out.println(a);
       //}
        public  void show(){
            System.out.println("名称" + name);
        }
        public Inner() {
        }


        public Inner(String name, int age) {
            this.name = name;
            this.age = age;
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
    }
}
```



```java
package innnerclass;

public class Test {
    public static void main(String[] args) {
        Outer.Inner in = new Outer().new Inner(  );
        in.show();


    }
}
```

#### 3.2.4成员内部类是什么样的、有什么特点？

 无static修饰，属于外部类的对象。
 可以直接访问外部类的静态成员，实例方法中可以直接访问外部类的实例成员。

#### 3.2.5 成员内部类如何创建对象？

外部类名.内部类名 对象名 = new  外部类构造器.new 内部类构造器();

```java
package innnerclass;

public class Test2 {
    public static void main(String[] args) {
        class People{
            private int heartbeat = 150;
            class Heart {
                private int heartbeat = 110;

                public void show() {
                    int heartbeat = 78;

                    System.out.println( heartbeat ); // 78
                      System.out.println(this.heartbeat); // 110
                    System.out.println(People.this.heartbeat); // 150       

            }}}}}
```

### 3.3 局部内部类[了解]

```java
package d2_class;

import java.security.PublicKey;

public class Test {
    public static void main(String[] args) {
        class Cat{
            private  String name;
            public int on = 100;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getOn() {
                return on;
            }

            public void setOn(int on) {
                this.on = on;
                Cat c = new Cat();
                c.setName("狗");
            }
        }
    }
}
```

### 3.4 匿名内部类（重点）

#### 3.4.1 内部类之四：匿名内部类概述[重点]

匿名内部类：
本质上是一个没有名字的局部内部类。
作用：方便创建子类对象，最终目的是为了简化代码编写。
格式：new 类|抽象类名|或者接口名() {   重写方法;};

#### 3.4.2 匿名内部类的作用？

方便创建子类对象，最终目的为了简化代码编写。
匿名内部类的格式？

Animal a = new Employee() {
   public void run() {
   }
 };
 a. run();

#### 3.4.5 匿名内部类的特点？

匿名内部类是一个没有名字的内部类，同时也代表一个对象。
匿名内部类的对象类型，相当于是当前new的那个类型的子类类型。

```java
package anonymous;

public class Test {
    public static void main(String[] args) {
        //匿名内部类 编译看左 运行看右
        Animal a = new Animal(){

            @Override
            public void run() {
                System.out.println("老虎吃人");

            }
        };
        a.run();

    }
}
//class Tiger extends  Animal{
 //   @Override
  //  public void run() {
  //      System.out.println("吃人");
  //  }
//}

abstract  class Animal{
    public  abstract  void run();
}
```

#### 3.4.6 匿名内部类常见使用形式

某个学校需要让老师，学生，运动员一起参加游泳比赛

```java
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
```

3.4.7 匿名内部类真实使用场景演示[拓展]

匿名内部类在开发中的真实使用场景演示
给按钮绑定点击事件

```java
package anonymous;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

public class Test3 {
    //通过GUI编程理解匿名类的真实使用场景
    public static void main(String[] args) {
        //1.创建窗口
        JFrame win = new JFrame( "登录窗口" );
        JPanel panel = new JPanel(  );
        //2.按钮
        JButton btn = new JButton( "登录" );
        //匿名内部类使用 监听器
       // btn.addActionListener( new Action() {
         //   @Override
          //  public Object getValue(String s) {
        //        JOptionPane.showMessageDialog( win,"你是🐖！" );
           //     return null;
         //   }
        //简化代码 一行搞定
    btn.addActionListener( e -> JOptionPane.showMessageDialog( win,"你是🐖！" ) );
        //3.对象添加到窗口展示
        win.add(btn);
        //4.展示窗口
        win.setSize( 400,300 );
        win.setLocationRelativeTo( null );
        win.setVisible( true );
    }
}
```
