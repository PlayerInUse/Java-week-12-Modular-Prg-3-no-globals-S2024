/**
 * Week12ModularPRG3
 */

import java.io.*;
import java.util.Random;
import javax.swing.*;


public class Week12ModularPRG3 {

    public static void main(String[] args) {

        String PName1, PName2, msg;
        int [][]Scores = new int[2][2];
        int whoWins;

        String response = "";
        boolean quitgame;

        PName1 = getPName(1);
        PName2 = getPName(2);
        msg = "Names are " + PName1 + " and " + PName2;
        JOptionPane.showMessageDialog(null, msg);

        quitgame =false;
        do {
            RollDicesForPlayers(Scores);
            whoWins = Winner(Scores);
            displayWinner(whoWins, PName1, PName2, Scores);

            msg = "Enter Q to quit or anyting else to continue: ";
            response = JOptionPane.showInputDialog(msg);

            if(response.startsWith("Q") || response.startsWith("q")) {
                quitgame=true;
            }
        }while(quitgame == false);
        JOptionPane.showMessageDialog(null, "Quitting... Bye!");

    }

    public static String getPName(int Pnum){
        String msg,name;

        msg = "Enter Player " + Pnum + "s full name: ";
        name = JOptionPane.showInputDialog(msg);

        return name;
    }

    public static void RollDicesForPlayers (int[][]diceVals){

        int i, j;
        Random rand = new Random();

        for(i=0; i<=1;i++){
            for(j=0;j<=1;j++){
                diceVals[i][j] = rand.nextInt(6)+1;;
            }
        }

    }

    public static int Winner(int[][]diceVals){
        int wins;

        if((diceVals[0][0] == diceVals[0][1]) && (diceVals[1][0] != diceVals[1][1])){
            wins = 1;
        }
        else if ((diceVals[0][0] != diceVals[0][1]) && (diceVals[1][0] == diceVals[1][1])) {
            wins = 2;
        }
        else if ((diceVals[0][0] + diceVals[0][1]) > (diceVals[1][0] + diceVals[1][1])) {
            wins = 1;
        }
        else if ((diceVals[0][0] + diceVals[0][1]) < (diceVals[1][0] + diceVals[1][1])) {
            wins = 2;
        }
        else {
            wins = 0;
        }
        return wins;
    }

    public static void displayWinner(int who, String P1, String P2, int[][]diceVals){
        String msg, WinnerName;

        if(who==1){
            WinnerName = P1;
        }
        else if(who==2){
            WinnerName = P2;
        }
        else{
            WinnerName = "No Winner";
        }

        msg=P1+" thows " + diceVals[0][0] + " and " + diceVals[0][1] + "\n";
        msg = msg + P2 + " throws " + diceVals[1][0] + " and " + diceVals[1][1] + "\n\n";

        if(who==0){
            msg = msg + " it is a draw " + WinnerName;
        }
        else {
            msg = msg + " The winner is " + WinnerName + ", congrats!";

        }
        JOptionPane.showMessageDialog(null, msg);
    }


}