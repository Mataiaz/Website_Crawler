package com.example;

import java.io.IOException;

public class Find_Element {
    public static void main(String haystack, String domain, int httpCode) throws IOException {

        int i = 0;
        int j = 0;
        int x = 0;
        String needle = "";
        String scamTags[] = {
             "This link has been flagged"
            , "this link has been flagged"
            , "Deceptive site ahead"
            , "deceptive site ahead"
            , "Warning scam"
            , "warning scam"
            , "WARNING Scam"
            , "WARNING: Scam"
            , "WARNING: scam"
            , "Attackers on " + domain
            , "attackers on " + domain
            , "Warning suspected scam"
            , "WARNING: suspected scam"
            , "Warning Suspected phishing"
            , "Warning suspected phishing"
            , "WARNING Suspected phishing"
            , "WARNING suspected phishing"
            , "WARNING: Suspected phishing"
            , "WARNING: suspected phishing"

        };
        String sellingDomainTags[] = {
             "This domain is available for sale!"
            ,"this domain is available for sale!"
            ,"This domain is available for sale"
            ,"this domain is available for sale"
            ,"This Domain is for sale"
            ,"this Domain is for sale"
            ,"The domain " + domain + "is for sale"
            ,"the domain " + domain + "is for sale"
            ,"The domain name " + domain + "is for sale"
            ,"the domain name " + domain + "is for sale"
            ,"The domain name " + domain + "has expired"
            ,"the domain name " + domain + "has expired"
            ,"This domain has expired"
            ,"this domain has expired"
            ,"Buy this domain"
            ,"buy this domain"
            ,"The owner of " + domain + "is selling this domain"
            ,"the owner of " + domain + "is selling this domain"
            ,"Purchase this domain"
            ,"purchase this domain"
            ,"Domain Price"
            ,"Domain price"
            ,"domain price"
            ,"The domain has expired"
            ,"the domain has expired"
            ,domain + "Is available for sale"
            ,domain + "is available for sale"
            ,domain + "Is not in use"
            ,domain + "is not in use"
        };
        String sellingDomainUrlTags[] = {
             "dan.com"
            ,"godaddy.com"
            ,"namecheap.com"
            ,"bluehost.com"
        };
        try {
            outerloop:
            while (x < 4)
            {
                while (j < 25)
                {
                    while(i < 19)
                    {
                        if (haystack.contains(scamTags[i]))
                        {
                            //System.out.println("SCAM\n");
                            needle = scamTags[i];
                            break outerloop;
                        }
                        i++;
                    }
                    if (haystack.contains(sellingDomainTags[j]))
                        {
                            //System.out.println("DOMAIN FOR SALE\n");
                            needle = sellingDomainTags[j];
                            break outerloop;
                        }
                    j++;
                }
                if (haystack.contains(sellingDomainUrlTags[x]))
                        {
                            //System.out.println("DOMAIN FOR SALE\n");
                            needle = sellingDomainUrlTags[x];
                            break outerloop;
                        }
                        x++;
            }
        if (needle.isEmpty())
        {
            System.out.println("Did not find any scam/selling-domain tags");
            Http_Response.main(httpCode, "", domain);
        }
        else if (!needle.isEmpty())
        {
            Connect.main(domain, needle);
        }
        } catch (Exception e) {
            Error_Handler.main(e, "Find_Element", domain);
        }
    }
}
