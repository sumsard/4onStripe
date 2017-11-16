import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by RasmusPC on 14/11/2017.
 */
public class BoardView {

    public static void main(String[] args) {

        String[][] boardMultiArray = new String[9][9];
        Boolean turn = false;

        createBoard(boardMultiArray);

        makeAChoice(boardMultiArray, turn);


    }

    private static void makeAChoice(String[][] boardMultiArray, Boolean turn) {
        System.out.println("\nPlease choose where to put your piece by adding writing number from 1-7");
        Scanner input = new Scanner(System.in);
        int i = input.nextInt();

        turn = addPiece(i,boardMultiArray, turn);
        showBoard(boardMultiArray);
        checkForWin(boardMultiArray);
        makeAChoice(boardMultiArray, turn);
    }

    private static void checkForWin(String[][] boardMultiArray) {



    }

    private static boolean addPiece(int i, String[][] boardMultiArray, Boolean turn) {

        int placement = checkWherePieceIsPlaced(i, boardMultiArray);

        if (placement <= 1){
            System.out.println("\nYou cannot place one here!!!!!!!!!!!\n");
            return turn;
        }
        if (!turn) {
            boardMultiArray[placement][i] = "X";
            turn = true;
        } else {
            boardMultiArray[placement][i] = "W";
            turn = false;
        }
        return turn;
    }

    private static int checkWherePieceIsPlaced(int i, String[][] boardMultiArray) {

        int calculatedPlacement = 0;
        for (int j = 2; j <= 8; j++) {
            if (boardMultiArray[j][i].equals("_")) {

            } else {
                calculatedPlacement = j-1;
                return calculatedPlacement;
            }
        }
        return calculatedPlacement;
    }

    private static void createBoard(String[][] boardMultiArray) {
        //Active board is from [2][1] to [7][7]


        //boardMultiArray[2][1] = "M";
        //boardMultiArray[7][7] = "M";
        //boardMultiArray[0][0] = "X";


        for (int i = 0; i < boardMultiArray.length; i++) {
            for (int j = 0; j < boardMultiArray.length; j++ ) {

                boardMultiArray[i][j] = "_";

            }

        }
        for (int i = 0; i < boardMultiArray.length-1; i++) {
            boardMultiArray[0][i] = String.valueOf(i);
        }

        for (int i = 0; i < boardMultiArray.length; i++) {
            boardMultiArray[1][i] = "0";
            boardMultiArray[8][i] = "0";
            boardMultiArray[i][0] = "0";
            boardMultiArray[i][8] = "0";
        }


        //System.out.println(Arrays.deepToString(boardMultiArray));

        showBoard(boardMultiArray);



    }

    private static void showBoard(String[][] boardMultiArray) {
        for (String[] row : boardMultiArray)
        {
            //Arrays.fill(row, 0);
            System.out.println(Arrays.toString(row));
        }
    }
}
