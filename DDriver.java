/**this program displays which hours of the day are most likely to have fatal accidents involving drunken drivers.
@author Jasmine Parrish*/ 
public class DDriver {
   public static void main(String[]args)throws java.io.IOException{
      java.io.File driveFile = new java.io.File("accident.txt");// imports accident.txt
      java.util.Scanner data = new java.util.Scanner(driveFile);// makes a scanner to read the document
      double[] accidents= new double[24];// makes an array of doubles for the amount of accidents per hour
      int[] drunk = new int[24];// makes an array of integers for the amount of drunk driving accidents per hour
      while(data.hasNext()){
         data.next();
         data.next();
         data.next();
         int hour = data.nextInt();// The hour the accident occurred
         data.next();
         int drunkDrv = data.nextInt();//represents if accident involved a drunken driver 
         if(hour<24){
            accidents[hour]++;
            if(drunkDrv > 0){
               drunk[hour]++;
            }
         }
      }
      System.out.println("hour  accidents  % drunks");
      double safeHour = 0; //the safest hour to drive
      double danHour = 0;//the most dangerous hour to drive
      double dHour = 0;//the hour with the most drunk people 
      double most = 0;//the most accidents in a single hour
      double least = 20000;//the least amount of accidents in a single hour
      double dMost = 0;// the most amount of drunk drivers in a single hour
      for (int i = 0;i<24;i++){
         double temp = i;// holds the temperary value of the hour as a double
         double avg = drunk[i]*100.0/accidents[i];
         System.out.printf("%2.0f:00",temp);// displays the hour
         System.out.printf("%8.0f",accidents[i]);// displays the accidents in a given hour
         System.out.printf(" %9.2f",avg);// displays the persent of drunk accidents in a given hour
         System.out.println();//goes to next line
         if(accidents[i] <= least){
            least = accidents[i];
            safeHour = i;
         }
         if(accidents[i] > most){
            most = accidents[i];
            danHour = i;
         }
         if(drunk[i] > dMost){
            dMost = drunk[i];
            dHour = i;
         }
      }
      System.out.println("The safest hour to drive is " + (int)safeHour  + ":00" );//displays the hour with the least amount of accidents
      System.out.println("The most dangerous hour to drive is " + (int)danHour + ":00" );// displays the hour with the most accidents
      System.out.println("The hour of most drunk drivers is " + (int)dHour + ":00" );// displays the hour with the most amount of accidents involving a drunk driver
   }
   
}