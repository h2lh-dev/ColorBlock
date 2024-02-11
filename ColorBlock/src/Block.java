class Block {
    
    // Codes ANSI pour les couleurs du texte
    public static final String RESET = "\u001B[0m";
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";
    public static final String ORANGE = "\u001B[38;2;255;165;0m";

    private String color;
    private Boolean pinceau;

    public Block(){
        this.color = WHITE;
        this.pinceau = false;
    }

    public Block(String color,Boolean pinceau){
        this.color = modColor(color);
        this.pinceau = pinceau;
    }

    public void changeColor(String newColor){
        this.color = modColor(newColor);
    }

    public static String modColor(String couleur) {
        switch (couleur) {
            case "YELLOW":
            case YELLOW:
                return YELLOW;
            case "ORANGE":
            case ORANGE :
                return ORANGE;
            case "RED":
            case RED:
                return RED;
            case "GREEN":
            case GREEN: 
                return GREEN;
            case "PURPLE":
            case PURPLE:
                return PURPLE;
            case "WHITE":
            case WHITE:
                return WHITE;
            case "BLUE":
            case BLUE:
                return BLUE;
            default:
                return RESET;
        }
    }
    
    public String toString(){
        if(this.pinceau == true){
            return this.color + "I" + RESET;
        }
        return this.color + "#" + RESET;
    }

    public String getColor() {
        return color;
    }

    public boolean getPinceau(){
        return pinceau;
    }


    

}
