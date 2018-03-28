package method;

import java.io.PrintWriter;
import java.io.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public class FileClass {
    
    String fileName = null;
    String format = null;

    //コンストラクタ、ファイル名をセット
    protected FileClass(String name){
        fileName = name;
        format = "yyyy-MM-dd HH:mm:ss";
    }
    
    //時刻を出力
    public String time(){
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(now);
    }
    
    
    //fileNameのファイルを新規作成
    public boolean createFile(PrintWriter out) throws IOException {
        //Fileインスタンス生成
        File file = new File(fileName);
        boolean success = false; 
        int i = 0;
        while(success == false && i <= 2){
            if(file.createNewFile()){
                out.println("ファイルの作成に成功" + "<br>");
                success = true;
            }else{
                if (file.exists()){
                    out.print("ファイルはすでに存在します" + "<br>");
                    if(file.delete()){
                        out.print("新規作成します" + "<br>");
                    } else {
                        out.print("予期しないエラー" + "<br>");
                        break;
                    }
                }else{
                    out.print("予期しないエラー" + "<br>");
                    break;
                }
            }
            i++;
        }
        return success;
    }
    
    //fileNameに書き込み
    public boolean write(String write, PrintWriter out){
        boolean success = false;
        try{
            //インスタンス生成
            File file = new File(fileName);
            BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
            //ファイル書き込み
            bw.write(write);
            bw.newLine();
            
            bw.close();
        //例外処理
        } catch (IOException ex) {
            out.print("正常に書き込めませんでした" + ex);
            success = false;
        }
        
        return success;
    }
    
    //fileNameのデータをすべて読み込み
    public String readAll(PrintWriter out) {
        String readFile = "";  
        try {
            String str = null;
            //インスタンス生成
            File file = new File(fileName);
            BufferedReader br = new BufferedReader(new FileReader(file));
            //ファイル読み込み
            while((str = br.readLine()) != null){
                readFile += str;
                readFile += "<br>";
            }
            br.close();
        //例外処理
        } catch (FileNotFoundException ex) {
            out.print("正常に読み込めませんでした。" + ex);
            readFile = "error000";
        }catch (IOException ex) {
            out.print("正常に読み込めませんでした。" + ex);
            readFile = "error001";
        } 
        //読み込んだ文字列を返す
        return readFile;
    }
    
}
