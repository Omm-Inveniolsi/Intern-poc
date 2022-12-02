package code.javapoc.main;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import code.javapoc.pojo.Headerpojo;
import code.javapoc.pojo.Linepojo;
//import com.company.demo.HeaderPojo;
//import com.company.demo.LinePojo; 
public class Readcsv {
    public static void main(String[] args) {
           Readcsv.read("D://read-file-java-poc1.csv");
       }
       public static final String delimiter = ";";
       public static void read(String csvFile) {
          try {
             File file = new File(csvFile);
             FileReader fr = new FileReader(file);
             BufferedReader br = new BufferedReader(fr);
             String line = "";
             while((line = br.readLine()) != null) {
                if (line.startsWith("HAUDIT")) {
                    Headerpojo headerLineItem = new Headerpojo();
                    headerLineItem.setRecordType(line.split(";")[0]);
                    headerLineItem.setTotalLines(Integer.parseInt(line.split(";")[1]));
                    headerLineItem.setTotalAmt(Double.parseDouble(line.split(";")[2]));
                    headerLineItem.setMinAmt(Double.parseDouble(line.split(";")[3]));
                    headerLineItem.setCurrentDate(line.split(";")[4]);
                    System.out.println(headerLineItem);
                }else {
                    ArrayList<String> lineItemList = new ArrayList<String>();
                    Linepojo lineItem = new Linepojo();
                    lineItem.setRecordType(line.split(";")[0]);
                    lineItem.setLineNumber(Integer.parseInt(line.split(";")[1]));
                    lineItem.setRefDocNum(line.split(";")[2]);
                    lineItem.setCity(line.split(";")[3]);
                    lineItem.setAmount(Double.parseDouble(line.split(";")[4]));                 
                }
             }
             br.close();
             } catch(IOException ioe) {
                ioe.printStackTrace();
             }
       }
}