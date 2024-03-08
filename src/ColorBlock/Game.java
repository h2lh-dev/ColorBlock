package ColorBlock;

import javax.swing.SwingUtilities;

public class Game {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Graphic graphic = new Graphic();
            graphic.setVisible(true);
        });
    }
}

