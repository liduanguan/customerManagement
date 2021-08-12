package com.liduan.customerManagement.util;

import java.util.*;
public class CMUtility {
    private static Scanner scanner=new Scanner(System.in);

    //read menu selection from char array
    public static char readMenuSelection(){
        char c;
        for (;;){
            String str=readKeyBoard(1,false);
            c=str.charAt(0);
            if(c!='1'&&c!='2'&&c!='3'&&c!='4'&&c!='5'){
                System.out.println("Wrong Selection.Please enter again:");
            }else break;
        }
        return c;
    }
    public static char readChar(){
        String str=readKeyBoard(1,false);
        return str.charAt(0);
    }
    //read a char
    public static char readChar(char defaultValue){
        String str=readKeyBoard(1,true);
        return (str.length()==0)?defaultValue:str.charAt(0);
    }

    //read an int 
    public static int readInt(){
        int n;
        for (;;){
            String str=readKeyBoard(2,false);
            try{
                n=Integer.parseInt(str);
                break;
            }catch (NumberFormatException e){
                System.out.println("Wrong Number.Please enter again：");
            }
        }
        return n;
    }
    //read an int, read defaultValut if no input
    public static int readInt(int defaultValue){
        int n;
        for (;;){
            String str=readKeyBoard(2,true);
            if(str.equals("")){
                return defaultValue;
            }
            try{
                n=Integer.parseInt(str);
                break;
            }catch (NumberFormatException e){
                System.out.println("Wrong Number.Please enter again：");
            }

        }
        return n;
    }
    //read a String
    public static String readString(int limit){
        return readKeyBoard(limit,false);
    }
    //read a String, or defaultValue if no input
    public static String readString(int limit,String defaultValue){
        String str=readKeyBoard(limit,true);
        return str.equals("")? defaultValue:str;
    }
    //read and check if input is Y/N
    public static char readConfirmSelection(){
        char c;
        for (;;){
            String str=readKeyBoard(1,false).toUpperCase();
            c=str.charAt(0);
            if(c=='Y'||c=='N'){
                break;
            }else {
                System.out.println("选择错误，请重新输入：");
            }
        }
        return c;
    }


    private static String readKeyBoard(int limit, boolean blankReturn) {
  String line="";
  while (scanner.hasNextLine()){
      line=scanner.nextLine();
      if (line.length()==0){
          if(blankReturn) return line;
          else continue;
      }
      if (line.length()<1||line.length()>limit){
          System.out.println("输入长度（不大于"+limit+"）错误，请重新输入：");
          continue;
      }
      break;
  }
  return line;
    }


}
