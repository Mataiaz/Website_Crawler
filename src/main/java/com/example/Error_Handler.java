package com.example;

import java.io.IOException;

public class Error_Handler {
    public static void main(Exception e, String id, String domain) throws IOException {
        String eString = String.valueOf(e);
        if (id.equals("Input"))
        {
            if (eString.contains("is null"))
            {
                System.out.println("FINISHED\n");
            }
        }
        if (id.equals("Connect"))
        {
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
            if (eString.contains("Can't open the specified"))
            {
                Create_File.main(null);
            }
            //System.out.print("ERROR: there was an error in class " + id + "\n" + e + "\n");
        }
    }
}
