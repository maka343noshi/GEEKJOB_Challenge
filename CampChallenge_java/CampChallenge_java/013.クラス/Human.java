package org.mypackage.sample;

import java.util.*;
import java.io.PrintWriter;

abstract class Human {
    abstract protected void engine();
    
    protected ArrayList<Integer> myCards = new ArrayList();
    
    //手札の合計
    public int open(){
        int openNum = 0;
        for(int num : myCards){
            openNum += num;
        }
        return openNum;
    }
    
    //手札にカードを加える
    public void setCard(ArrayList<Integer> setCard){
        myCards.addAll(setCard);
    }
    
    //カードを引くかどうか
    public boolean checkSum(){
        if(open() < 17){
            return true;
        }else{
            return false;
        }
    }
    //結果の表示　あなたの手持ちのカードは？
    public String yourCard(){
        String yourCard = "";
        for(int i : myCards){
            yourCard += i;
            yourCard += "　";
        }
        return yourCard;
    }
    
}
