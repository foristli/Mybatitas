package org.test.mybat.learnbatitas;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        DBOperation dbops=new DBOperation();
        //dbops.selectUser();
        dbops.insertEmployee();
    }
}
