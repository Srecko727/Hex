/////////////////////////////////////////////////////////////////
//             Lab 3: Hex and Binary Decoder                   //
//   By: Jose Rivera, Frederico Lacerda, and Srecko Markovic   //
/////////////////////////////////////////////////////////////////

import java.util.*;
//                      TEST FOR GitHub
public class HexAndBinaryDecoder
{
    public static void main (String[] args)
    {
        int userInput;          //Initializes persistent variables
        String getsSolved;
        Scanner scnr = new Scanner(System.in);      //initializes scanner
        while(true)             //Starts decoder
        {
            System.out.println("Choose an option:");    //menu interface
            System.out.println("1. Decode a hex string.");
            System.out.println("2. Decode a binary string.");
            System.out.println("3. Convert binary to hex.");
            System.out.println("4. Quit.");

            userInput = scnr.nextInt();

            switch (userInput)
            {
                case 1:
                    System.out.println("Please enter the hex string:");
                    getsSolved = scnr.next();
                    System.out.println("Result: " + hexStringDecode(getsSolved));
                    break;
                case 2:
                    System.out.println("Please enter the binary string:");
                    getsSolved = scnr.next();
                    System.out.println("Result: " + binaryStringDecode(getsSolved));
                    break;
                //case 3:
                case 4:         //closes program
                    System.out.println("Quitting program.");
                    //(false)
                    return;
                default:
                    System.out.println("Please enter a proper menu option");
                    break;
            }
        }
    }
    public static long hexStringDecode(String hex)
    {
        long result = 0;
        double growth = hex.length() - 1;
        long changedCharacter;

        for (int i=0; i<hex.length(); i++)
        {
            if (hex.substring(i,i+1).equals("x"))
                changedCharacter = 0;
            else if(Character.isLetter(hex.charAt(i)))
                changedCharacter = hexCharDecode(hex.charAt(i));
            else
                changedCharacter = Integer.parseInt(hex.substring(i,i+1));
            result = result + (long)(changedCharacter * (Math.pow(16,growth)));
            growth--;
        }
        return result;
    }
    public static short hexCharDecode(char hexChar)
    {
        short changeLetter = 0;

            if (hexChar == 'A' || hexChar == 'a')
            changeLetter = 10;

            else if (hexChar == 'B' || hexChar == 'b')
            changeLetter = 11;

            else if (hexChar == 'C' || hexChar == 'c')
            changeLetter = 12;

            else if (hexChar == 'D' || hexChar == 'd')
            changeLetter = 13;

            else if (hexChar == 'E' || hexChar == 'e')
            changeLetter = 14;

            else if (hexChar == 'F' || hexChar == 'f')
            changeLetter = 15;

        return changeLetter;
    }
    public static long binaryStringDecode(String bin)
    {
        long result = 0;
        double growth = bin.length() - 1;
        for (int i = 0; i < bin.length(); i++)
        {
            if (bin.substring(i,i+1).equals("b"))
                result = 0;
            else if (bin.substring(i,i+1).equals("1"))
            {
                result = result + (long)Math.pow(2,growth);
            }
            growth--;
        }
        return result;
    }
    /*public static String binaryToHex(String bin)
    {
                    EXTRA CREDIT
    }*/
}
