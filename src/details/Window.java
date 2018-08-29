package details;

import javax.swing.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

class Window extends JFrame {

    Window(String title, int width, int height) {
        super(title);
        setSize(width, height);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    void drawImage(BufferedImage buffer, int x, int y, ImageObserver observer) {
        getGraphics().drawImage(buffer,  x, y, observer);
    }
}
