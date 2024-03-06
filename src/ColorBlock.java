import java.awt.Color;
import java.util.Scanner;

class ColorBlock{

    Block[][] tab;

    public ColorBlock(int size, String[][] result){
        this.tab = new Block[size+1][size+1];
        for(int i =0;i<size+1;i++){

            for(int i2=0;i2<size+1;i2++){
                if(i2 == result[i].length-1 || i == result.length-1 ){
                    this.tab[i][i2] = new Block(result[i][i2],true);
                }else{
                    this.tab[i][i2] = new Block();
                }
            }
        }
    }

    public ColorBlock(String[][] result){
        this.tab = new Block[result.length][];
        for(int i =0;i<result.length;i++){
            this.tab[i] = new Block[result[i].length];
            for(int i2=0;i2<result[i].length;i2++){
                if(i2 != result[i].length-1 || i != result.length-1 ){
                    this.tab[i][i2] = new Block(result[i][i2],false);
                }else{
                    this.tab[i][i2] = new Block();
                }
            }
        }
    }

    public String toString(){
        String c = "";
        for(int i =0;i<this.tab.length;i++){
            for(int i2=0;i2<this.tab[i].length;i2++){
                if((i2 == this.tab[i].length-1 || i == this.tab.length-1) && this.tab[i][i2].getPinceau() == false ){
                    
                }else{
                    c = c + this.tab[i][i2]; 
                }
                
            }
            c = c+ '\n';
        }
        return c;
    }

    public void changeLineColor(Color color, int idx){
        for(int i =0;i < this.tab[idx].length;i++){
            this.tab[idx][i].changeColor(color);
        }
    }

    public void changeColumnColor(Color color, int idx){
        for(int i =0;i < this.tab[idx].length;i++){
            this.tab[i][idx].changeColor(color);
        }
    }
    
    public boolean win(String[][] result){
        ColorBlock bResult = new ColorBlock(result);
        for(int i =0;i<bResult.tab.length-1;i++){
            for(int i2=0;i2<bResult.tab[i].length-1;i2++){
                if(!this.tab[i][i2].getColorName().equals(result[i][i2])){
                    return false;
                }
            }
        }
        return true;
    }

    public void game(String[][] result){
        ColorBlock bResult = new ColorBlock(result);
        Scanner scanner = new Scanner(System.in);
        int nbCoups = 0;
        while(this.win(result) == false){
            System.out.println(bResult);
            System.out.println(this);
            System.out.println("Choisissez une case à jouer.");
            int r = scanner.nextInt();
            System.out.println("");
            switch (r) {
                case 1:
                    this.changeLineColor(this.tab[0][3].getColor(), 0);
                    break;
                case 2:
                    this.changeLineColor(this.tab[1][3].getColor(), 1);
                    break;
                case 3:
                    this.changeLineColor(this.tab[2][3].getColor(), 2);
                    break;
                case 4:
                    this.changeColumnColor(this.tab[3][0].getColor(), 0);
                    break;
                case 5:
                    this.changeColumnColor(this.tab[3][1].getColor(), 1);
                    break;
                case 6:
                    this.changeColumnColor(this.tab[3][2].getColor(), 2);
                    break;
                default:
                    break;
            }
            nbCoups++;
        }
        System.out.println(bResult);
        System.out.println("Félicitations, tu as gagné en " + nbCoups + " coups");
    }

    public Block getBlock(int x,int y){
        return this.tab[y][x];
    }

}