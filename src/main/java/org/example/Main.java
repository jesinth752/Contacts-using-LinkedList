package org.example;


import java.util.Scanner;
import java.util.logging.Logger;


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