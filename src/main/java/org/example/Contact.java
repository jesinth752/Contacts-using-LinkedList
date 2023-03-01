package org.example;

import java.util.logging.Logger;

class Contact {


    private static final Logger log = Logger.getLogger("InfoLogging");

    ContactNode head;


   public class ContactNode {
        String name;
        long phoneno;
        String email;

        ContactNode locator;

        ContactNode(String n, long p, String e) {
            name = n;
            phoneno = p;
            email = e;
            locator = null;

        }
    }
    Contact()
    {
        head=null;

    }

    public void addContact(String n,long p,String e)
    {
        ContactNode cn=new ContactNode(n,p,e);
        ContactNode traverse=head;
        if(head==null)
        {
            head=cn;
        }
        else
        {
            while (traverse.locator!=null)
            {
                traverse=traverse.locator;
            }
            traverse.locator=cn;

        }

        log.info("Contact saved");
    }

    public void savedContacts()
    {
        ContactNode traverse=head;
        String saved;
        while (traverse!=null)
        {
            saved="\nContact:"+traverse.name+"\n" +traverse.phoneno+"\n"+traverse.email;
            log.info(saved);
            traverse=traverse.locator;
        }
    }


    public void searchContact(String n1)
    {

        ContactNode traverse=head;
        String found = null;

        while (traverse!=null)
        {
            if(traverse.name.equals(n1))
            {
                found="Contact:"+traverse.name+"\n" +traverse.phoneno+"\n"+traverse.email;
            }
            traverse=traverse.locator;
        }
        log.info(found);

    }
    public void  deleteContacts(String n2)
    {

        ContactNode traverse=head;
        ContactNode prev=traverse;
        while (traverse!=null)
        {
            if(traverse.name.equals(n2))
            {
                prev.locator=traverse.locator;
                log.info("Deleted");
            }
            prev=traverse;

            traverse=traverse.locator;
        }




    }
}
