import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.*;

import javax.swing.JFrame;

public class run {
    static Start start=new Start();
    static Game game=new Game();
    static Rank rank=new Rank();


    static JFrame[] frames = { start,game,rank};
    public static void main(String args[]) throws InterruptedException {
        File file=new File("Rank.txt");   //创建文件类
        Game.count=0;
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String temp=null;
        try {
            //BufferedReader br=new BufferedReader(new FileReader(file)); //创建读入缓冲流，按行读入
            InputStreamReader fReader = new InputStreamReader(new FileInputStream("Rank.txt"),"GB2312");
            BufferedReader br = new BufferedReader(fReader);
            temp=br.readLine();   //先读取一行
            while(temp!=null){
                String sbstring = temp.toString();   //转化为string
                int n = sbstring.length();            //测字符串长度
                String []message = new String[5];     //按~拆分 成5个字符串数组，按账号和密码进行信息验证
                int k=0;

                for (int i=0; i<2; i++)
                    message[i]="";
                //我们在写入用户时用~分割， 所以我们利用~在分割开来
                for (int i=0; i<n; i++)
                {
                    if(sbstring.charAt(i)=='~')
                    {
                        //System.out.println("@"+message[k]);
                        k++;
                    }
                    else
                    {
                        message[k] += sbstring.charAt(i);
                    }
                }
                Game.temp=-1;
                Game.count++;
                Game.mem_count=Game.count;
                Game.users[Game.count-1]=new Client();
                Game.users[Game.count-1].name=message[0];
                if(Game.users[Game.count-1].name==null||Game.users[Game.count-1].name.equals("")) {Game.count--;
                    System.out.println("!!!");
                    break;
                }
                //System.out.println(Game.users[Game.count-1].name);
                Game.users[Game.count-1].scores=Integer.parseInt(message[1]);
                temp=br.readLine();  //读取下一行
            }
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Game.temp=-1;
        //Game.count++;
        //System.out.println(Game.count-1);
        for (int index = 0; index < frames.length; index++) {
            frames[index].setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frames[index].setPreferredSize(new Dimension(700,750));
            screencentre(frames[index]);

            frames[index].pack();
        }
        frames[0].setVisible(true);

        // StringBuffer sb=new StringBuffer();
    }
    //使框架显示在屏幕中央
    public static void screencentre(JFrame frame) {

        Toolkit kit = Toolkit.getDefaultToolkit(); // 定义工具包

        Dimension screenSize = kit.getScreenSize(); // 获取屏幕的尺寸

        int screenWidth = screenSize.width; // 获取屏幕的宽

        int screenHeight = screenSize.height; // 获取屏幕的高


        frame.setLocation(screenWidth/4, screenHeight/15);// 设置窗口居中显示
    }

}
