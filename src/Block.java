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
            default:
                return Color.BLACK;
        }
    }

    public Color getColor() {
        return color;
    }

    public String getColorName() {
        // Compare la couleur avec les constantes prédéfinies de Color
        if (this.color.equals(Color.RED)) {
            return "RED";
        } else if (this.color.equals(Color.GREEN)) {
            return "GREEN";
        } else if (this.color.equals(Color.BLUE)) {
            return "BLUE";
        } else if (this.color.equals(Color.YELLOW)) {
            return "YELLOW";
        } else if (this.color.equals(Color.BLACK)) {
            return "BLACK";
        } else if (this.color.equals(Color.WHITE)) {
            return "WHITE";
        } else if (this.color.equals(Color.ORANGE)) {
            return "ORANGE";
        } else if (this.color.equals(Color.PINK)) {
            return "PINK";
        } else if (this.color.equals(Color.GRAY)) {
            return "GRAY";
        } 
        else {
            return "UNKNOWN";
        }
    }
      

    public boolean getPinceau(){
        return pinceau;
    }


    

}
