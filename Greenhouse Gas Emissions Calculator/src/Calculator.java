
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Calculator {
    //emmision factor constants
    final double carbonOxide = 1879.0;
    final double methane = 0.037;
    final double nitrogen = 0.033;
    int nGassBill;
    double totalEmission;
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);
    
    
    public double total(){
        double nCarbonOxide = (double)nGassBill * carbonOxide;
        double nMethane = (double)nGassBill * methane;
        double nNitrogen = (double)nGassBill * nitrogen;
        
        totalEmission = (nCarbonOxide + nMethane + nNitrogen) / 1e6;
        return Math.round(totalEmission * 100.0) / 100.0; //returns totalEmission rounded to 2 d.p
    }  
        
    
}
