package Test;

import java.util.Date;

public class TestDate
{
    public static void main(String[] args)
    {
        Date date = new Date();
        System.out.println(date);
        System.out.printf("年-月-日格式：%tF%n",date);
    }
}
