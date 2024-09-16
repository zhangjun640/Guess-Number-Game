import javax.swing.*;
import java.awt.*;

class CustomButton extends JButton {
    private Image backgroundImage;

    public CustomButton(String text, String imagePath) {
        super(text);
        try {
            backgroundImage = new ImageIcon(imagePath).getImage();
        } catch (Exception e) {
            e.printStackTrace();
        }
        setOpaque(false); // 设置按钮透明
        setContentAreaFilled(false); // 设置不填充内容区域
        setBorderPainted(false); // 设置不绘制边框
        setFocusPainted(false); // 设置不绘制焦点
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
        super.paintComponent(g);
    }
}