package com.game.client;

import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Menu {

    public static AudioInputStream ais;
    public static Clip clip;

    public static String displayRulesRPSLS() {
        return( "ROCK PAPER SCISSORS LIZARD SPOCK\n"+
                "______________________________________\n" +
                "The rules are simple!!\n\n" +
                "Scissors CUTS Paper\n" +
                "Paper COVERS Rock\n" +
                "Rock CRUSHES Lizard\n" +
                "Lizard POISONS Spock\n" +
                "Spock SMASHES Scissors\n" +
                "Scissors DECAPITATES Lizard\n" +
                "Lizard EATS Paper\n" +
                "Paper DISPROVES Spock\n" +
                "Spock VAPORIZES Rock\n\n" +
                "and as it always has, Rock CRUSHES Scissors.\n\n\n");
    }

    public static String displayRulesTicTacToe(){
        return("TIC TAC TOE\n" +
                "__________________________________________________________________\n" +
                "The game is played on a grid that's 3 squares by 3 squares.\n" +
                "You are X, your friend is O (Human vs. Human only).\n" +
                "Players take turns putting their marks in empty squares.\n" +
                "The first player to get 3 of her marks in a row is the winner.\n" +
                "When all 9 squares are full, the game is over.");
    }

    public static void playMusic(String url) throws Exception {
        if(ais != null){
            clip.close();
        }
        URL musicUrl = new URL(url);
        clip = AudioSystem.getClip();
        ais = AudioSystem.getAudioInputStream( musicUrl );
        clip.open(ais);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public static void audioStop() throws IOException {
        ais.close();
        clip.close();
    }
}