package demos;

import java.util.List;

import static utilities.CSVReader.get;
import static utilities.ExcelReader.get1;

public class DataReader {
    public static void main(String args[]){
        //readCsv();
        readExcel();
    }

    public static void readCsv(){
        String filename = "/Users/sdodia/Desktop/SeleniumProjectJava/UserAccounts.csv";
        List<String[]> records = get(filename);

        //Iterating through the list
        for (String[] record: records) {
            for (String field : record) {
                System.out.println(field);
            }
        }
    }

    public static void readExcel(){
        String filename = "/Users/sdodia/Desktop/SeleniumProjectJava/UserLogin.xls";
        String[][] data = get1(filename);
        for (String[] record : data) {
            System.out.println();
            System.out.println(record[0]);
            System.out.println(record[1]);
            System.out.println(record[2]);
        }
    }
}
