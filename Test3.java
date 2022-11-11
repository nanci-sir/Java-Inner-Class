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
