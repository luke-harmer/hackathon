import java.io.*;

public class Application {
    public static void main(String[] args)throws IOException{
        
    //Variables declared and initialised
    final double carbonOxide = 1879.0;
    final double methane = 0.037;
    final double nitrogen = 0.033;
    int i = 0;
    int nGassBill;
    
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);
    
    
    /*If there is an invalid input,
    the loop will go back to the start. If the input is valid, the user will break out of loop and continue.*/
    while(i == 0){
        try{
            System.out.print("Enter the value of your gas bill in m3: ");
            String gasBill = br.readLine();
            nGassBill = Integer.parseInt(gasBill);
            i = 1;
        }
        catch(IllegalArgumentException e){
            continue;
    }
    
    //Calculations
    double nCarbonOxide = (double)nGassBill * carbonOxide;
    double nMethane = (double)nGassBill * methane;
    double nNitrogen = (double)nGassBill * nitrogen;
    double totalEmission = nCarbonOxide + nMethane + nNitrogen;
    
    System.out.println("The totaling emission is " + totalEmission);
    }
}
