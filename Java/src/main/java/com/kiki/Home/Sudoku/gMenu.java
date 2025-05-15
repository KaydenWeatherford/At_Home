package com.kiki.Home.Sudoku;

public class gMenu{
    
    private Object[] options = {"new", "info", "help", "board", "quit"};
    private Object choice;
    
    public gMenu(){
        
    }
    
    public void help(){
            System.out.println("\nTo start a new game, type \"new\" ");
            System.out.println("To see how to play, type \"info\" ");
            System.out.println("To see commands, type \"help\"");
            System.out.println("To see the board, type \"board\"");
            System.out.println("To quit, type \"quit\"\n");
    }

    public void info(){
        System.out.println("\nA 9×9 square must be filled in with numbers from 1-9" +
                            "\nwith no repeated numbers in each line, horizontally or vertically." +
                            "\nTo challenge you more, there are 3×3 squares marked out in the grid," +
                            "\nand each of these squares can\'t have any repeat numbers either." + 
                            "\nTo play, type the numbers in this format: \"row colum number\" \n");
    }
}