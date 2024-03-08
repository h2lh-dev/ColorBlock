package ColorBlock;
import java.awt.Color;

class Block {

    private Color color;
    private Boolean pinceau;

    public Block(){
        this.color = Color.WHITE;
        this.pinceau = false;

    }

    public Block(String color,Boolean pinceau){
        this.color = modColor(color);
        this.pinceau = pinceau;
    }

    public void changeColor(Color color){
        this.color = color;
    }

   
    public Color modColor(String couleur) {
        switch (couleur) {
            case "BLUE":
                return Color.BLUE;
            case "CYAN":
                return Color.CYAN;
            case "GREEN":
                return Color.GREEN;
            case "MAGENTA": 
                return Color.MAGENTA;
            case "ORANGE":
                return Color.ORANGE;
            case "PINK":
                return Color.PINK;
            case "RED":
                return Color.RED;
            case "YELLOW":
                return Color.YELLOW;
            default:
                return Color.RED;
        }
    }

    public Color getColor() {
        return color;
    }

    public String getColorName() {
        // Compare la couleur avec les constantes prédéfinies de Color
        if (this.color.equals(Color.BLUE)) {
            return "BLUE";
        } else if (this.color.equals(Color.CYAN)) {
            return "CYAN";
        } else if (this.color.equals(Color.GREEN)) {
            return "GREEN";
        } else if (this.color.equals(Color.MAGENTA)) {
            return "MAGENTA";
        } else if (this.color.equals(Color.ORANGE)) {
            return "ORANGE";
        } else if (this.color.equals(Color.PINK)) {
            return "PINK";
        } else if (this.color.equals(Color.RED)) {
            return "RED";
        } else if (this.color.equals(Color.YELLOW)) {
            return "YELLOW";
        } else {
            return "RED";
        }
    }
      

    public boolean getPinceau(){
        return pinceau;
    }


    

}
