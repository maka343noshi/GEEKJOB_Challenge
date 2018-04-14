/*
    sql文を発行します。
 */
package process;

/**
 *
 * @author maka3
 */
public class issueSQL {
    String sql = "";
    
    public void allcase(){
        this.sql = "select * from itemINF";
    }
    
    public void idsearch(String id){
        this.sql = "select * from itemINF where itemID = ";
        this.sql += id;
    }
    
    public void terms(String name, int group, int min, int max){
        this.sql = "select * from itemINF where ";
        int i = 0;
        if(name.length() != 0){
            this.sql += "itemName like '%" + name + "%'";
            i = 1;
        }
        if(group != 0){
            if(i == 1){
                this.sql += " and";
            }
            this.sql += " itemGroup = " + group;
        }
        if(min != 0 && max != 0){
            if(i == 1){
                this.sql += " and";
            }
            this.sql += " itemPrice < " + min + " and itemPrice > " + max;
        }else if(min != 0 && max == 0){
            if(i == 1){
                this.sql += " and";
            }
            this.sql += " itemPrice < " + min;
        }else if(min == 0 && max != 0){
            if(i == 1){
                this.sql += " and";
            }
            this.sql += " itemPrice < " + max;
        }
    }
    
    public String getsql(){
        return this.sql;
    }
}
