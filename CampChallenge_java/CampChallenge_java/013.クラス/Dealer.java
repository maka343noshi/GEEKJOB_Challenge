package org.mypackage.sample;

import java.util.*;
import java.io.PrintWriter;

public class Dealer extends Human{
    @Override
    protected void engine(){}
    
    //山札を宣言
    protected ArrayList<Integer> cards = new ArrayList();
    
    //山札にすべてのカードを追加
    public void Dealer(){
        cards.clear();
        for(int j = 1; j <= 4; j++){
            for(int i = 1; i <= 13; i++){
                if(i > 10){
                    cards.add(10);
                }else{
                    cards.add(i);
                }
            }
        }
    }
    public ArrayList<Integer> deel(){
        ArrayList<Integer> deelCard = new ArrayList();
        int card1 = oneCard();
        int card2 = oneCard();
        deelCard.add(card1);
        deelCard.add(card2);
        
        return deelCard;
    }
    
    public ArrayList<Integer> hit(){
        ArrayList<Integer> hitCard = new ArrayList();
        int card1 = oneCard();
        hitCard.add(card1);
        
        return hitCard;
    }
    
    //カードを1枚引く
    protected int oneCard(){
        Random rand = new Random();
        int index = rand.nextInt(cards.size() - 1);
        int card = cards.get(index);
        cards.remove(index);
        return card;
    }
    
    //Dealer()が正常に機能しているか
    public void testDealer(PrintWriter pw){
        pw.print("Deale　Test" + "<br>");
        //Dealer();
        int cardsNum = 0;
        for(int card : cards){
            pw.print(card + "<br>");
            cardsNum ++;
        }
        pw.print("計：" + cardsNum + "枚");
    }
}
