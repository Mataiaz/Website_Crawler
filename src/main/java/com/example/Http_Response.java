package com.example;

import java.io.IOException;

public class Http_Response {
    public static void main(int httpCode, String scamOrSelling, String domain) throws IOException {
        String printHttpText = String.valueOf(httpCode);
        
        int i = 0;
        String status = "";
        String httpCodeFound = "";
        String httpCodeList[] = {
                "Http Code did not match any from internal list"
                        , "100 = Continue"
                        , "101 = Switching Protocols"
                        , "102 = Processing"
                        , "200 = OK"
                        , "201 = Created"
                        , "202 = Accepted"
                        , "203 = Non-authoritative Information"
                        , "204 = No Content"
                        , "205 = Reset Content"
                        , "206 = Partial Content"
                        , "207 = Multi-Status"
                        , "208 = Already Reported"
                        , "226 = IM Used"
                        , "300 = Multiple Choices"
                        , "301 = Moved Permanently"
                        , "302 = Found"
                        , "303 = See Other"
                        , "304 = Not Modified"
                        , "305 = Use Proxy"
                        , "307 = Temporary Redirect"
                        , "308 = Permanent Redirect"
                        , "400 = Bad Request"
                        , "401 = Unauthorized"
                        , "402 = Payment Required"
                        , "403 = Forbidden"
                        , "404 = Not Found"
                        , "405 = Method Not Allowed"
                        , "406 = Not Acceptable"
                        , "407 = Proxy Authentication Required"
                        , "408 = Request Timeout"
                        , "409 = Conflict"
                        , "410 = Gone"
                        , "411 = Length Required"
                        , "412 = Precondition Failed"
                        , "413 = Payload Too Large"
                        , "414 = Request-URI Too Long"
                        , "415 = Unsupported Media Type"
                        , "416 = Requested Range Not Satisfiable"
                        , "417 = Expectation Failed"
                        , "418 = Im a teapot"
                        , "421 = Misdirected Request"
                        , "422 = Unprocessable Entity"
                        , "423 = Locked"
                        , "424 = Failed Dependency"
                        , "426 = Upgrade Required"
                        , "428 = Precondition Required"
                        , "429 = Too Many Requests"
                        , "431 = Request Header Fields Too Large"
                        , "444 = Connection Closed Without Response"
                        , "451 = Unavailable For Legal Reasons"
                        , "499 = Client Closed Request"
                        , "500 = Internal Server Error"
                        , "501 = Not Implemented"
                        , "502 = Bad Gateway"
                        , "503 = Service Unavailable"
                        , "504 = Gateway Timeout"
                        , "505 = HTTP Version Not Supported"
                        , "506 = Variant Also Negotiates"
                        , "507 = Insufficient Storage"
                        , "508 = Loop Detected"
                        , "510 = Not Extended"
                        , "511 = Network Authentication Required"
                        , "522 = Timed out"
                        , "599 = Network Connect Timeout" };
                        
        try {
            while (i < 65) {
                if (httpCodeList[i].contains(printHttpText))
                {
                    httpCodeFound = httpCodeList[i];
                    break;
                }
                i++;
            }
            if ((httpCode >= 200 && httpCode <= 226) && scamOrSelling.isEmpty())
            {
                //status = domain + "UP - " + httpCode + " (" + httpCode + ")";
                System.out.println("\nUP - " + domain + " " + httpCode + " (" + httpCodeFound + ")");
            }
            else if ((httpCode >= 400 && httpCode <= 511) || !scamOrSelling.isEmpty() || httpCode == 522)
            {
                //status = domain + "DOWN - " + httpCode + " " + scamOrSelling + " (" + httpCodeFound + ")";
                System.out.println("\nDOWN - " + scamOrSelling + " " + domain + " " + httpCode + " (" + httpCodeFound + ")");
            }
            if(i == 65)
            {
                System.out.println(httpCodeList[0]);
            }
        System.out.println("-------------------------------------------");
            Output.main(App.rowNbr, App.fileLocation, status);
        } catch (Exception e) {
            Error_Handler.main(e, "Http_Response", domain);
        }
    }
}
