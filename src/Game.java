import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Game extends JFrame {
    static int length = 4;
    static int count;
    static int temp = -1;
    static int mem_count = count;
    static Client[] users = new Client[100];
    JLabel center = new JLabel();

    JLabel first = new JLabel();
    CustomTextField greet = new CustomTextField("当前用户", "");

    static CustomTextField nam = new CustomTextField("", "");

    JLabel second = new JLabel();
    JTextField correct = new JTextField();
    CustomTextField start = new CustomTextField("请输入数字", "");

    JLabel third = new JLabel();
    JTextField guess = new JTextField();
    JButton startguess = new JButton("确定");

    JLabel forth = new JLabel();
    JTextField scores = new JTextField();
    CustomTextArea note = new CustomTextArea("","");
    JScrollPane sc = new JScrollPane(note);

    Guess one = new Guess(length);
    int[] rnum = new int[length];
    String str = "";

    public Game() {
        super("猜数字");
        initializeUI();
    }

    private void initializeUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        Font font = new Font("楷体", Font.BOLD, 30); // 设置字体
        startguess.setFont(font); // 设置按钮字体

        // 设置按钮背景图片
        startguess.setBorderPainted(false); // 不绘制边框
        startguess.setFocusPainted(false); // 不绘制焦点
        startguess.setContentAreaFilled(false); // 不填充内容区域

        // 将背景面板添加到窗口的中心
        JPanel backgroundPanel = createBackgroundPanel("D:\\1111山东大学的事\\面向对象\\guess 最新版\\guess 最新版\\image.png");
        setContentPane(backgroundPanel);
        backgroundPanel.setLayout(new BorderLayout());

        // 创建一个透明的面板来放置所有组件
        JPanel transparentPanel = new JPanel();
        transparentPanel.setOpaque(false);
        transparentPanel.setLayout(new BorderLayout());

        backgroundPanel.add(transparentPanel, BorderLayout.CENTER);
        transparentPanel.add(new ActMenu(), BorderLayout.NORTH);

        transparentPanel.add(center, BorderLayout.CENTER);
        center.setLayout(new GridLayout(4, 1));

        greet.setFont(new Font("楷体", Font.BOLD, 25));
        greet.setHorizontalAlignment(JTextField.CENTER);
        nam.setFont(new Font("楷体", Font.PLAIN, 30));
        nam.setHorizontalAlignment(JTextField.CENTER);
        center.add(first);
        first.setLayout(new GridLayout(1, 2));
        first.add(greet);
        nam.setEditable(false);
        first.add(nam);
        greet.setEditable(false);
        greet.setText(Client.greetings(count));

        center.add(second);
        second.setLayout(new GridLayout(1, 1));
        second.add(start);
        start.setHorizontalAlignment(JTextField.CENTER);
        correct.setEditable(false);
        start.setEditable(false);
        start.setFont(new Font("楷体", Font.PLAIN, 50));

        guess.setFont(new Font("楷体", Font.PLAIN, 30));
        guess.setHorizontalAlignment(JTextField.CENTER);
        center.add(third);
        third.setLayout(new GridLayout(1, 2));
        third.add(guess);
        third.add(startguess);
        startguess.addActionListener(new ActLis());

        scores.setFont(new Font("楷体", Font.PLAIN, 30));
        scores.setHorizontalAlignment(JTextField.CENTER);
        note.setFont(new Font("楷体", Font.PLAIN, 18));
        center.add(forth);
        forth.setLayout(new GridLayout(1, 2));
        forth.add(scores);
        forth.add(sc);
        scores.setEditable(false);
        note.setOpaque(false);

        process();
    }

    public void process() {
        rnum = one.rand(rnum);
        correct.setText(one.correct(rnum));
    }

    private class ActLis implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == startguess) {
                int[] gnum = new int[length];
                String gstr = guess.getText();
                gnum = one.guess(gstr, gnum);
                for (int i = 0; i <= count - 1; i++) {
                    if (users[i].name == null) continue;
                    if (users[i].name.equals(nam.getText())) {
                        temp = i;
                        break;
                    }
                }
                if (nam.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "请您登录后再进行游戏", "尚未登录！", JOptionPane.ERROR_MESSAGE);
                }
                if (temp == -1 && !nam.getText().equals("")) {
                    Game.count++;
                    Game.users[Game.count - 1] = new Client();
                    str += one.compare(rnum, gnum, users[count - 1]);
                    note.setText(str);
                    users[count - 1].name = nam.getText();
                    scores.setText("" + users[count - 1].name + "当前得分:" + users[count - 1].scores);
                } else if (temp != -1 && !nam.getText().equals("")) {
                    str += one.compare(rnum, gnum, users[temp]);
                    note.setText(str);
                    scores.setText("" + users[temp].name + "当前得分:" + users[temp].scores);
                }
                run.rank.printRank();
            }
        }
    }

    private JPanel createBackgroundPanel(String imagePath) {
        // 创建一个面板用于显示背景图片
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Image backgroundImage = new ImageIcon(imagePath).getImage();
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        };
        panel.setLayout(new BorderLayout());
        return panel;
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Game game = new Game();
            game.setVisible(true);
        });
    }
}