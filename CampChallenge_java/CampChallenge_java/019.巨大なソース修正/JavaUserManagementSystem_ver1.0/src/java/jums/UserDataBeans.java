package jums;

import java.sql.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Map;
/**
 *
 * @author maka3
 */
public class UserDataBeans {
    private String name;
    private int year;
    private int month;
    private int day;
    private int type;
    private String tell;
    private String comment;
    
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    
    public int getYear(){
        return year;
    }
    public void setYear(int year){
        this.year = year;
    }
    
    public int getMonth(){
        return month;
    }
    public void setMonth(int month){
        this.month = month;
    }
    
    public int getDay(){
        return day;
    }
    public void setDay(int day){
        this.day = day;
    }
    
    public int getType(){
        return type;
    }
    public void setType(int type){
        this.type = type;
    }
    
    public String getTell(){
        return tell;
    }
    public void setTell(String tell){
        this.tell = tell;
    }
    
    public String getComment(){
        return comment;
    }
    public void setComment(String comment){
        this.comment = comment;
    }
    
    
    //未入力総チェック、未入力項目が一つでもあればfalseを返す。
    public boolean allInaddCheck(){
        ArrayList<String> inputCheck = new ArrayList<String>();
        if(name.equals("")){
            inputCheck.add("name");
        }
        if(year == 0 && month == 0 && day == 0){
            inputCheck.add("birthday");
        }
        if(tell.equals("")){
            inputCheck.add("tell");
        }
        if(comment.equals("")){
            inputCheck.add("comment");
        }
        
        if(inputCheck.size() == 0){
            return true;
        }
        return false;
    }
   
    //UserDataBeansをUserDataDTOに変換
    public UserDataDTO convert(){
        UserDataDTO dto = new UserDataDTO();
        
        dto.setName(this.name);
        //year, month, date をjava.sql.Dateに変換
        dto.setBirthday(java.sql.Date.valueOf(this.year + "-" + this.month + "-" + this.day));
        dto.setType(this.type);
        dto.setTell(this.tell);
        dto.setComment(this.comment);
        
        return dto;
    }
    
    //typeを文字列にして表示
    public String strType(){
        if(type == 1){
            return "エンジニア";
        }else if(type == 2){
            return "営業";
        }else if(type == 3){
            return "その他";
        }else{
            return "データがありません";
        }
    }
}

