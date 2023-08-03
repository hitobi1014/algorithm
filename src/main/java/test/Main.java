package test;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        char[] cArr = {'C', 'A', 'B', 'C','C'};
        System.out.println(String.copyValueOf(cArr));
        String str = String.copyValueOf(cArr);
        int cnt = str.length() - str.replace(String.valueOf('C'), "").length();
        System.out.println(cnt);
    }

    static void solution(){

    }


}
