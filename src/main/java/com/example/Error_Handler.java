package com.example;

import java.io.IOException;

public class Error_Handler {
    public static void main(Exception e, String id, String domain) throws IOException {
        if (id.equals("Input"))
        {
            String eString = String.valueOf(e);
            if (eString.contains("is null"))
            {
                System.out.println("FINISHED\n");
            }
        }
        if (id.equals("Connect"))
        {
            String eString = String.valueOf(e);
            int httpCode = 0;
            if (eString.contains("timed out"))
            {
                httpCode = 522;
                Http_Response.main(httpCode, "", domain);
            }
            if (eString.contains("Connection refused"))
            {
                httpCode = 502;
                Http_Response.main(httpCode, "", domain);
            }
            if (!eString.isEmpty())
            {
                httpCode = 404;
                Http_Response.main(httpCode, "", domain);
            }
            else 
            {
                System.out.print("ERROR: there was an error in class " + id + "\n" + e  + "\n");
            }
        }
        if (id.equals("Find_Element"))
        {
            System.out.print("ERROR: there was an error in class " + id + "\n" + e  + "\n");
        }
        if (id.equals("Http_Response"))
        {
            System.out.print("ERROR: there was an error in class " + id + "\n" + e  + "\n");
        }
        if (id.equals("Output"))
        {
            //System.out.print("ERROR: there was an error in class " + id + "\n" + e + "\n");
        }
    }
}
