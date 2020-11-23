
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Calculator {
    //emmision factor constants
    final double carbonOxide = 1879.0;
    final double methane = 0.037;
    final double nitrogen = 0.033;
    double nCarbonOxide;
    double nMethane;
    double nNitrogen;
    double nGassBill;
    double totalEmission;
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);
    
    
    public double total(){
        nCarbonOxide = (double)nGassBill * carbonOxide;
        nMethane = (double)nGassBill * methane;
        nNitrogen = (double)nGassBill * nitrogen;
        totalEmission = (nCarbonOxide + nMethane + nNitrogen) / 1e6;
        return Math.round(totalEmission * 100.0) / 100.0; //returns totalEmission rounded to 2 d.p
    }  
        
    
}

/*The calculation operates on a gas bill value in meters cubed unit of measure of natural gas. Burning natural gas emits CO2 (Carbon Dioxide), CH4 (Methane) and N20 (Nitrous Oxide) and therefore their individual emission factors are also taken to account.

To obtain the Green House Gasses (GHG) emissions the following calculation is executed:
Value of Natural Gas (m3) x CO2 Emission Factor (m3) = CO2 GHG Emissions (g)
Value of Natural Gas (m3) x CH4 Emission Factor (m3) = CH4 GHG Emissions (g)
Value of Natural Gas (m3) x N20 Emission Factor (m3) = N20 GHG Emissions (g)

Quantities of each GHG emission are converted to a common unit using a Global Warming Potential. The Global Warming Potential (GWP) of a gas refers to the total contribution to global warming resulting from the emission of one unit of that gas relative to one unit of the reference gas, carbon dioxide, which is assigned a value of 1.
CO2 GHG Emissions (g) x CO2 GWP value = CO2 Equivalent Value
CH4 GHG Emissions (g) x CH4 GWP value = CH4 Equivalent Value
N20 GHG Emissions (g) x N20 GWP value = N20 Equivalent Value

The Equivalent Values of each emission can be added up to provide a total representing GHG emissions.
CO2 Equivalent Value + CH4 Equivalent Value + N20 Equivalent Value = Total
   
*/