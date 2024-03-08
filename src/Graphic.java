import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;



public class Graphic extends JFrame {
    private ColorBlock map; // Matrice représentant la carte
    private MapPanel mapPanel = new MapPanel();
    private static int cptTours = 0;
    private JLabel counterLabel;
    private String[][] lvl;
    private int nblvl = 1;
    private int cptlvl = 0;
    static Random random = new Random();

    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;

    public Graphic() {
        setTitle("ColorBlock");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        counterLabel = new JLabel("" + cptTours);
            counterLabel.setBounds(383, 10, 100, 30); 

            // Initialisation de la carte (exemple avec une carte simple)
            try {
                lvl = fileToTab("res/lvl" +(cptlvl+1)+".csv");
            }catch (IOException e) {
                e.printStackTrace();
            }
            
            lvl = rdStrings();

            map = new ColorBlock(3,lvl);

            // Créer un panneau personnalisé pour afficher la carte et le joueur

            getContentPane().add(mapPanel);

            // ajoute le boutton 

            // new GridLayout(2,1,0,50)
            mapPanel.setLayout(null);

            mapPanel.add(counterLabel);

            button1 = createResizedButton(0, 3, 525, 85,  true);
            button2 = createResizedButton(1, 3, 525, 155, true);
            button3 = createResizedButton(2, 3, 525, 225, true);
            button4 = createResizedButton(3, 0, 295, 295, false);
            button5 = createResizedButton(3, 1, 365, 295, false);
            button6 = createResizedButton(3, 2, 435, 295, false);
            
            JButton win = new JButton();

            win.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("false");
                    
                    if(map.win(lvl) == true){
                        cptlvl++;
                        changelvl();
                        System.out.println("true");
                    }
                }
    });
            win.setBounds(365,395,40,40);

            //mapPanel.add(buttonPanel);
            mapPanel.add(button1);
            mapPanel.add(button2);
            mapPanel.add(button3);
            mapPanel.add(button4);
            mapPanel.add(button5);
            mapPanel.add(button6);
            mapPanel.add(win);

            // Centrer la fenêtre
            setLocationRelativeTo(null);
    }

    public void changelvl(){
        try {
            lvl = fileToTab("res/lvl" +(cptlvl+1)+".csv");
        }catch (IOException e) {
            e.printStackTrace();
        }


        map = new ColorBlock(3,lvl);
        
        mapPanel.repaint();
        
        button1.setIcon(newIcon(0, 3));
        button2.setIcon(newIcon(1, 3));
        button3.setIcon(newIcon(2, 3));
        button4.setIcon(newIcon(3, 0));
        button5.setIcon(newIcon(3, 1));
        button6.setIcon(newIcon(3, 2));

    }

    private Icon newIcon(int xtab, int ytab){
        ImageIcon originalIcon = new ImageIcon("img/paint" + map.tab[xtab][ytab].getColorName() + ".png");

        Image scaledImage = originalIcon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(scaledImage);

        return resizedIcon;
    }

    private JButton createResizedButton(int xtab, int ytab ,int x, int y,boolean line) {

        ImageIcon originalIcon = new ImageIcon("img/paint" + map.tab[xtab][ytab].getColorName() + ".png");

        Image scaledImage = originalIcon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(scaledImage);
        JButton button = new JButton(resizedIcon);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(line == true){
                    map.changeLineColor(map.tab[xtab][ytab].getColor(),xtab);
                }else{
                    map.changeColumnColor(map.tab[xtab][ytab].getColor(),ytab);
                }
                cptTours++;
                updateCounterLabel();
                // Redessiner la carte avec les nouvelles couleurs
                mapPanel.repaint();
            }
        });
        button.setBounds(x,y,40,40);

        return button;
    }

    public static String[][] fileToTab(String csvFilePath) throws IOException {
        List<String[]> csvData = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Diviser la ligne en tableau de chaînes en utilisant la virgule comme séparateur
                String[] row = line.split(",");
                csvData.add(row);
            }
        }

        return csvData.toArray(new String[0][0]);
    }

    private void updateCounterLabel() {
        counterLabel.setText(""+cptTours);
    }
    
    public Color modColor(String couleur) {
        switch (couleur) {
            case "YELLOW":
                return Color.YELLOW;
            case "ORANGE":
                return Color.ORANGE;
            case "RED":
                return Color.RED;
            case "GREEN": 
                return Color.GREEN;
            case "MAGENTA":
                return Color.MAGENTA;
            case "WHITE":
                return Color.WHITE;
            case "BLUE":
                return Color.BLUE;
            case "PINK":
                return Color.PINK;
            case "CYAN":
                return Color.CYAN;
            default:
                return Color.CYAN;
        }
    }

    private class MapPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            // Dessiner la carte en fonction de la matrice
            for (int i = 0; i < lvl.length-1;i++){
                for(int j = 0;j<lvl[i].length-1; j++){
                    g.setColor(modColor(lvl[i][j]));
                    g.fillRect(j*50+50, i*50+100, 50, 50);
                }
            }


            for (int i = 0; i < map.tab.length-1; i++) {
                for (int j = 0; j < map.tab[i].length-1; j++) {
                    g.setColor(map.tab[i][j].getColor()); // map.tab[i][j].getColor()
                    g.fillRect(j * 70+280, i * 70+70, 70, 70); // Dessiner une case
                }
            }
        }
        
    }

    public String[][] rdStrings(){
        String[][] lvl = new String[4][4];
        for(int i = 0; i< 4; i++){
            System.out.println("test");
            for(int i2 = 0; i2< 4 ;i2++){
                System.out.println("test2");
                if(i2 == lvl[i].length-1 || i == lvl.length-1 ){
                    lvl[i][i2] = randomPencil();
                }else{
                    lvl[i][i2] = "RED";
                }
            }    
        }
        return lvl;
    }

        public String randomPencil(){
            int nombreAleatoire = random.nextInt(8) + 1;
            switch (nombreAleatoire) {
                case 1:
                    return "BLUE";
                case 2:
                    return "CYAN";
                case 3:
                    return "GREEN";
                case 4:
                    return "MAGENTA";
                case 5:
                    return "ORANGE";
                case 6:
                    return "PINK";
                case 7:
                    return "RED";
                case 8:
                    return "YELLOW";
                default:
                    return "BLUE";
            }
        }
}

