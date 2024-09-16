import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Start extends JFrame {
    JLabel title = new JLabel("猜数字", JLabel.CENTER);
    CustomButton[] buttons = {
            new CustomButton("新游戏", "D:\\1111山东大学的事\\面向对象\\guess 最新版\\guess 最新版\\image1.jpg"),
            new CustomButton("排行", "D:\\1111山东大学的事\\面向对象\\guess 最新版\\guess 最新版\\image1.jpg"),
            new CustomButton("退出", "D:\\1111山东大学的事\\面向对象\\guess 最新版\\guess 最新版\\image1.jpg")};
    JPanel buttonPanel = new JPanel(new GridLayout(3, 1));
    JPanel contentPane = new JPanel() {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            // 绘制背景图片
            ImageIcon imageIcon = new ImageIcon("");
            Image image = imageIcon.getImage();
            g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        }
    };

    public Start() {
        super("猜数字");
        Font font = new Font("楷体", Font.BOLD, 25); // 设置字体
        for (CustomButton button : buttons) {
            button.setFont(font);
            button.addActionListener(new StartLis());
            buttonPanel.add(button);
        }

        title.setFont(new Font("楷体", Font.BOLD, 100));

        contentPane.setLayout(new BorderLayout());
        contentPane.add(title, BorderLayout.NORTH);
        contentPane.add(buttonPanel, BorderLayout.CENTER);

        setContentPane(contentPane);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private class StartLis implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == buttons[0]) {
                setVisible(false);
                run.rank.d.setText(run.rank.printRank());
                run.frames[1].setVisible(true);
                new Login();
            } else if (e.getSource() == buttons[1]) {
                setVisible(false);
                run.frames[2].setVisible(true);
                run.rank.d.setText(run.rank.printRank());
            } else if (e.getSource() == buttons[2]) {
                System.exit(0);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Start();
        });
    }
}
