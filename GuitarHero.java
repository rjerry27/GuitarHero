import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class GuitarHero {

    public GuitarHero(){
        File fileName = new File("/Users/Richard/IdeaProjects/GuitarHero/src/example.txt");
        String text;
        try {
            BufferedReader input = new BufferedReader(new FileReader(fileName));
            int row = 0;
            String [][] grid = null;
            String [] notes = {"G#","G","F#","F","E","D#","D","C#","C","B","A#","A","G#","G","F#"
                                    ,"F","E","D#","D","C#","C","B","A#","A","G#","G","F#","F","E"};
            int [][] helper = {{29,24,19,14,10,5},
                               {28,23,18,13,9,4},
                               {27,22,17,12,8,3},
                               {26,21,16,11,7,2},
                               {25,20,15,10,6,1}};

            while((text=input.readLine())!=null) {

                String [] song = text.split(",");

                if (grid==null){
                    grid = new String [30][song.length+1];
                    grid[0][0] = "Measure";
                    for (int m = 1; m < song.length; m++)
                        grid[0][m] = ""+m;
                    for (int r = 1; r < notes.length; r++)
                        grid[r][0] = ""+notes[r-1];
                }

                for(int measure = 0; measure<song.length;measure++){
                    for (int col = 0; col < 6; col++){
                        if (song[measure].charAt(col)=='*'||song[measure].charAt(col)=='o')
                            grid[helper[row][col]][measure+1]="o";
                    }
                }

                row++;
            }

            for (int r = 0; r < grid.length; r++){
                for (int c = 0; c < grid[0].length; c++){
                    if (grid[r][c] == null)
                        System.out.print("\t");
                    else
                        System.out.print(grid[r][c]+"\t");
                }
                System.out.println();
            }

        }catch(IOException e){
            System.out.println(e.toString());
        }
    }

    public static void main (String[]args){
        GuitarHero app = new GuitarHero();

    }

}
