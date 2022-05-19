package com.RPSLS.game;

import com.RPSLS.templates.DefaultJFrame;
import com.RPSLS.templates.DefaultTextArea;
import com.RPSLS.templates.JPanelBlack;

class FinalScreen{
    DefaultJFrame finalScreen;
    FinalScreen(){
        finalScreen = new DefaultJFrame(2,1);

        JPanelBlack thankYou = new JPanelBlack();
        String winnerText = Game.determineOverallWinner() + " has won!!\n\n" +
                "THANK YOU FOR PLAYING!!";
        DefaultTextArea displayWinner = new DefaultTextArea(winnerText, 40);
        thankYou.add(displayWinner);

        finalScreen.add(thankYou);
        finalScreen.validate();
    }
}