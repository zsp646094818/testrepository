package com.example.demo;


import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class test {
    public static void main(String[] args) {
        String aString = getTxt("C:\\Users\\zsp\\Desktop\\安全整改\\关键索引检测整改\\allneedindex.txt");
        String[] s = aString.split("\\n");
        for (String x : s) {
            printIndexSql(x);
        }

    }

    public static String getTxt(String filename) {
        String txt = readFileContent(filename);
        System.out.println("原文本=" + txt);
        // txt = txt.replace("\n", "");
        return txt;
    }

    public static String readFileContent(String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;
        StringBuffer sbf = new StringBuffer();
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempStr;
            while ((tempStr = reader.readLine()) != null) {
                sbf.append(tempStr + "\n");
            }
            reader.close();
            return sbf.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return sbf.toString();
    }

    public static void printIndexSql(String a) {
        if (!StringUtils.isEmpty(a)) {
            String tablename = a.split(",索引:")[0].replace("表:", "");
            String indexname = a.split(",索引:")[1].split(",列:")[0];
            String columnName = a.split(",列:")[1].replace("索引不存在或异常", "");
            System.out.println("CREATE INDEX " + indexname + " on " + tablename + "(" + columnName + ");");
        }
    }
}
