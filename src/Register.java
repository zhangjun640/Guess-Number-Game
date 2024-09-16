import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;

/**
 * 此类完成对注册页面的编写， 用户需填写 账户，密码
 *
 * 并且会进行验证操作， 如姓名是否合法（中文）
 *
 */
@SuppressWarnings("serial")
public class Register extends JFrame implements ActionListener{

    JButton jb1, jb2;  //按钮
    JLabel jlb1, jlb2, jlb3,jlb4,jlb5, jlb6;  //标签
    JTextField jtf3,jtf4;   //文本框
    JPasswordField jpf; //密码框
    JPanel jp3, jp4,jp6,jp7;		//面板

    public Register() {
        // TODO Auto-generated constructor stub
        //按钮
        jb1 = new JButton("提交");
        jb1.setFont(new Font("楷体",Font.BOLD,18) );
        jb2 = new JButton("登录");
        jb2.setFont(new Font("楷体",Font.BOLD,18) );
        //设置按钮监听
        jb1.addActionListener(this);
        jb2.addActionListener(this);
        //标签信息

        jlb3 = new JLabel("     账号");
        jlb3.setFont(new Font("楷体",Font.BOLD,16) );
        jlb4 = new JLabel("     密码");
        jlb4.setFont(new Font("楷体",Font.BOLD,16) );
        jtf3 = new JTextField(10);
        jtf3.setFont(new Font("serial",Font.PLAIN,16) );
        jtf4 = new JTextField(10);
        jtf4.setFont(new Font("serial",Font.PLAIN,16) );

        jp3 = new JPanel();
        jp4 = new JPanel();
        jp6 = new JPanel();
        jp7 = new JPanel();
        //将对应信息加入面板中

        jp3.add(jlb3);
        jp3.add(jtf3);

        jp4.add(jlb4);
        jp4.add(jtf4);


        jp6.add(jb1);
        jp6.add(jb2);


        //将JPane加入JFrame中
        //this.add(jp7);  //先加入提示语


        this.add(jp3);
        this.add(jp4);

        this.add(jp6);

        //设置布局
        this.setTitle("注册信息");
        this.setLayout(new GridLayout(3,1));
        this.setSize(300, 200);    //设置窗体大小
        this.setLocationRelativeTo(null);//在屏幕中间显示(居中显示)
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);  //设置仅关闭当前窗口

        this.setVisible(true);  //设置可见
        this.setResizable(false);	//设置不可拉伸大小

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (e.getActionCommand()=="提交")
        {
            try {
                register();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
        else if (e.getActionCommand()=="登录")
        {
            new Login();
        }

    }
    //验证注册信息，并做处理
    public void register() throws IOException
    {
        //判断信息是否补全
        if (jtf3.getText().isEmpty()||jtf4.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "信息有空缺，请补全！","消息提示",JOptionPane.WARNING_MESSAGE);
        }

        //判断账户名和密码是否包含中文
        /*else if (new Check().checkcountname(jtf3.getText())||new Check().checkcountname(jtf4.getText()))
        {
            JOptionPane.showMessageDialog(null, "用户名或密码存在中文，不合法!","消息提示",JOptionPane.WARNING_MESSAGE);
        }*/
        //满足要求
        else if (!jtf3.getText().isEmpty()&&!jtf4.getText().isEmpty())
        {
            //注册成功， 打包为信息数组传递给UserMessage进行更新操作
            String []message = new String[2];

            message[0] = jtf3.getText();
            message[1] = jtf4.getText();
            if (!new Check().check2(message[0]))   //调用Check的check方法检测用户是否存在， 如果不存在执行
            {
                new UserMessage().write(message);   //调用UserMseeage的write方法进行写操作， 将信息格式化存入
                JOptionPane.showMessageDialog(null,"注册成功！","提示消息",JOptionPane.WARNING_MESSAGE);
                dispose();  //使窗口消失

                new Login();
            }
            else
            {
                JOptionPane.showMessageDialog(null,"账号已存在，请重新输入！","提示消息",JOptionPane.WARNING_MESSAGE);
                //dispose();
            }
        }
    }

    //清空账号和密码框
    private void clear() {
        // TODO Auto-generated method stub

        jtf3.setText("");
        jtf4.setText("");
    }
}

