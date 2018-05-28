
package views;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;

/**
 *
 * @author ibrar
 */
public class Background extends JDesktopPane {

    protected void paintComponent(Graphics graphics) {
        Image image = new ImageIcon("src/images/login_bg.jpg").getImage();
        try {
            Graphics2D graphics2D = (Graphics2D) graphics;
            double y = image.getHeight(null);
            double x = image.getWidth(null);
            graphics2D.scale(getWidth() / x, getHeight() / y);
            graphics2D.drawImage(image, 0, 0, this);

        } catch (Exception e) {
        }
    }

}
