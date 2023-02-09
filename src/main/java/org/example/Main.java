package org.example;


import java.util.Scanner;
import java.util.logging.Logger;

class Contact {


    private static final Logger log = Logger.getLogger("InfoLogging");

    ContactNode head;


    class ContactNode {
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

    void addContact(String n,long p,String e)
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

    void savedContacts()
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


     void searchContact(String n1)
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
    void  deleteContacts(String n2)
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

public class Main {
    private static final Logger log = Logger.getLogger("InfoLogging");
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
       Contact c=new Contact();
       String n;
       long p;
       String e;
       String n1;
       String n2;
       int opt;
       do {
           log.info("1.Add Contact\n2.Show Contacts \n3.Search Contact\n4.Delete contact\n5.Exit");
           log.info("Enter option:");
           opt=input.nextInt();

           if(opt!=5) {

               switch (opt) {

                   case 1:
                       log.info("Name:");
                       n = input.next();
                       log.info("Phone No:");
                       p = input.nextLong();
                       log.info("E-Mail:");
                       e = input.next();
                       c.addContact(n, p, e);
                       break;

                   case 2:
                       c.savedContacts();
                       break;
                   case 3:
                       log.info("Search By Name:");
                       n1 = input.next();
                       c.searchContact(n1);
                       break;
                   case 4:
                       log.info("Delete By Name:");
                       n2 = input.next();
                       c.deleteContacts(n2);
                       break;
                   default:
                       log.info("Invalid choice ");
               }
           }
       }while (opt!=5);
    }
}