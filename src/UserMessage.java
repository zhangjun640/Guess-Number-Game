import java.io.*;
/**
 * 此类事对用户信息的 写入和读取操作
 *
 */
public class UserMessage
{
    /*
     * 将注册的信息写入文本
     */
    public void write(String[] message)throws IOException
    {
        File file=new File("Message.txt");
        String messagesum="";
        for (int i=0; i<2; i++)  //将信息格式化存储
            messagesum+=message[i]+"~";
        if(!file.exists())
            file.createNewFile();
        FileOutputStream out=new FileOutputStream(file,true); //建立输出对象，true表示追加
        StringBuffer sb=new StringBuffer();      //创建字符串流
        sb.append(messagesum+"\n");				//向字符串流中添加信息
        out.write(sb.toString().getBytes("gb2312"));         //将字符串流中的信息写入文本
        out.close();			//关闭
    }
    /*
     *   读取信息，将用户名信息返回（如果不存在返回null），和Check类配合使用
     */
    public String[] read(String countname) throws IOException
    {
        File file=new File("Message.txt");
        if(!file.exists()||file.isDirectory())
            throw new FileNotFoundException();
        BufferedReader br=new BufferedReader(new FileReader(file));
        String temp=null;
        StringBuffer sb=new StringBuffer();
        temp=br.readLine();

        String []message = new String[5];     //按~拆分 成5个字符串数组，按账号和密码进行信息验证
        while(temp!=null){
            String sbstring = temp.toString();
            int n = sbstring.length();            //测字符串长度
            for (int i=0; i<5; i++)
                message[i] = "";

            int k=0;
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
            if (message[2].equals(countname))  //返回找到用户的信息
            {
                return message;
            }
            temp=br.readLine();
        }
        return null;
    }



    //
    //更新密码
    public String updatepwd(String countname,String pwd) throws IOException
    {
        File file=new File("Message.txt");
        if(!file.exists()||file.isDirectory())
            throw new FileNotFoundException();
        //读文件
        BufferedReader br=new BufferedReader(new FileReader(file));
        String temp=null;
        StringBuffer sb=new StringBuffer();
        //写文件
        //FileOutputStream out=new FileOutputStream(file,false);
        StringBuffer sb1=new StringBuffer();

        String moneystring="";

        temp=br.readLine();
        String []message = new String[2];     //按~拆分 成5个字符串数组，按账号和密码进行信息验证
        while(temp!=null){
            String sbstring = temp.toString();
            int n = sbstring.length();            //测字符串长度
            for (int i=0; i<2; i++)
                message[i] = "";

            int k=0;
            for (int i=0; i<n; i++)      //拆乘5个String
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

            if (message[0].equals(countname))   //找到该账户名
            {
                //修改密码
                for (int i=0; i<3; i++)
                    sb1.append(message[i]+"~");
                sb1.append(pwd+"~");
                sb1.append(message[4]+"~\n");
            }
            else
            {
                sb1.append(temp+"\n");
            }
            temp=br.readLine();
        }
        /*
         * 说明：
         * 本来的想法是在原文件对象中覆盖内容，但是发现覆盖后文本为空， 无法解决
         * 但重新创建文件对象，则可以完成操作
         */
        File file1=new File("Message.txt");
        if(!file1.exists())
            file1.createNewFile();
        FileOutputStream out=new FileOutputStream(file1,false);
        out.write(sb1.toString().getBytes("gb2312"));
        out.close();

        return moneystring;
    }

}

