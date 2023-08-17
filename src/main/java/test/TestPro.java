package test;

import java.util.ArrayList;
import java.util.List;

public class TestPro {
    public static void main(String[] args) {

        char[] cArr = new char[3];
        cArr[0] = '^';
        cArr[1] = (char) (1+'0');
        cArr[2] = 2+'0';

        for (char c : cArr) {
            System.out.println(c);
        }

        System.out.println(cArr[1]);
        System.out.println(cArr[1]-'0');
        System.out.println(cArr[2]);
        System.out.println(cArr[2]-'0');


    }
}
