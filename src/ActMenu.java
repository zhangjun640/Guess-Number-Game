import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class ActMenu extends JPanel{
    JButton buttons[] = {new JButton("  new user"),new JButton("guess new number"),new JButton("rank")};

    public ActMenu() {
        Font font=new Font("Monospaced",Font.BOLD,23);//设置字体
        buttons[0].setFont(font);//设置按钮字体
        buttons[0].setOpaque(false);
        buttons[1].setFont(font);//设置按钮字体
        buttons[1].setOpaque(false);
        buttons[2].setFont(font);//设置按钮字体
        buttons[2].setOpaque(false);
        setLayout(new FlowLayout());

        for (int index = 0; index < buttons.length; index++)
            buttons[index].addActionListener(new ActLis());

        for (int index = 0; index < buttons.length; index++)
            add(buttons[index]);
    }

    public void shutdown() {
        for (int index = 0; index < run.frames.length; index++)
            run.frames[index].setVisible(false);
    }

    private class ActLis implements ActionListener {

        public void actionPerformed(@NotNull ActionEvent e) {
            if (e.getSource() == buttons[0]) {
                shutdown();
                if(Game.count>=1&&Game.users[Game.count - 2].name == null) Game.count--;
                run.frames[1].setVisible(true);
                new Login();
                Game.temp=-1;
                //Game.count++;
                //Game.mem_count=Game.count;
                run.game.greet.setText(Client.greetings(Game.count));
                resetuser();
                //Game.users[Game.count-1]=new Client();
                run.game.process();
                //System.out.println(Game.count);
            }
            else if (e.getSource() == buttons[1]) {
                shutdown();
                if(Game.count>=1&&Game.users[Game.count - 2].name == null) Game.count--;
                run.frames[1].setVisible(true);
                resetnum();
                run.game.process();
            }
            else if (e.getSource() == buttons[2]) {
                shutdown();
                //System.out.println(Game.count-1);
                if(Game.count>=1&&Game.users[Game.count - 2].name == null) Game.count--;
                run.frames[2].setVisible(true);
                run.rank.d.setText(run.rank.printRank());
            }
        }
    }
    /*ActMenu.addWindowListener(new WindowAdapter()
    {
        @Override
        public void windowClosing(WindowEvent e)
        {
            System.out.println("Closed");
            e.getWindow().dispose();
        }
    });*/

    public void resetnum(){
        run.game.guess.setText("");
        run.game.scores.setText("");
        run.game.note.setText("");
        run.game.str="";
    }

    public void resetuser(){
        run.game.nam.setText("");
        run.game.guess.setText("");
        run.game.scores.setText("");
        run.game.note.setText("");
        run.game.str="";
    }
}
