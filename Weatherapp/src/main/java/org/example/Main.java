package org.example;

import org.json.JSONException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException, JSONException
    {
        Scanner sc = new Scanner(System.in);
        Integer q;
        JsonData bunty = new JsonData();
        while(true)
        {
            System.out.println("enter 1 for weather - enter 2 for Wind speed - enter 3 for pressure - enter 0 to exit");
            q=sc.nextInt();
            if(q==1)
            {
                System.out.println("enter date in yyyy-mm-dd");
                String date = sc.next();
                System.out.println("Temperature :"+JsonData.hm.get(date).getTemperature()+"\n");
            }
            if(q==2)
            {
                System.out.println("enter date in yyyy-mm-dd");
                String date = sc.next();
                System.out.println("Wind speed :"+JsonData.hm.get(date).getWindspeed()+"\n");
            }
            if(q==3)
            {
                System.out.println("enter date in yyyy-mm-dd");
                String date = sc.next();
                System.out.println("Pressure :"+JsonData.hm.get(date).getPressure()+"\n");
            }
            if(q==0)
            {
                break;
            }
        }

    }
}
