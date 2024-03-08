package ColorBlock;
public class UseColorBlock {
    
    public static void main(String[] args){
        String[][] lvl1 = {
            {"YELLOW", "ORANGE", "ORANGE","ORANGE"},
            {"YELLOW", "RED", "GREEN","RED"},
            {"YELLOW", "PURPLE", "PURPLE","PURPLE"},
            {"YELLOW","RED","GREEN","WHITE"}
        };

        ColorBlock game = new ColorBlock(3,lvl1);
        game.game(lvl1);

        String[][] lvl2 = {
            {"GREEN", "GREEN", "GREEN","GREEN"},
            {"RED", "RED", "RED","RED"},
            {"RED", "YELLOW", "PURPLE","PURPLE"},
            {"RED","YELLOW","GREEN","WHITE"}
        };

        game = new ColorBlock(3,lvl2);
        game.game(lvl2);
    }
}
