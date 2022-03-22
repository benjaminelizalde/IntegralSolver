import java.text.DecimalFormat;
import java.util.*;
import javax.swing.JOptionPane;

public class IntegralSolver {

    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("###.#####");

        double boundA = Double.parseDouble(JOptionPane.showInputDialog("Enter your A bound"));
    
        double boundB = Double.parseDouble(JOptionPane.showInputDialog("Enter your B bound"));
    
        int intervals = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of intervals you want to approximate to"));

        double deltaX = (boundB - boundA)/ intervals;

        if((SimpsonsApproximation(deltaX, intervals, boundA )== -.0001)){
            JOptionPane.showMessageDialog(null, "A bound: " + boundA + '\n' + " B bound " + boundB  + '\n' +  intervals + " intervals" + '\n' + 
        "Delta x" + deltaX + '\n' + "The final answer to this midpoint approximation is " + df.format(approximateIntegral(deltaX,intervals, boundA))
        + "\n" + "The final trapezoidal approximation is " + df.format(trapezoidApproximation(deltaX,intervals,boundA)) + 
        '\n' + "There are an odd amount of subintervals therfore Simpsons method of integration cannot be used."); 
        }else{
            JOptionPane.showMessageDialog(null, "A bound: " + boundA + '\n' + " B bound " + boundB  + '\n' +  intervals + " intervals" + '\n' + 
        "Delta x" + deltaX + '\n' + "The final answer to this midpoint approximation is " + df.format(approximateIntegral(deltaX,intervals, boundA))
        + "\n" + "The final trapezoidal approximation is " + df.format(trapezoidApproximation(deltaX,intervals,boundA)) + 
        '\n' + "The final simpsons approximation is " + SimpsonsApproximation(deltaX, intervals, boundA)); 
        }

        System.out.println("The final trapezoidal approximation is " + df.format(trapezoidApproximation(deltaX,intervals,boundA)));
        System.out.println("The final answer to this midpoint approximation is " + df.format(approximateIntegral(deltaX,intervals, boundA)));
        
     }
   
    public static double approximateIntegral(double dx, int intervals, double a_bound){
            double ans = 0.0;
        for(int i = 0; i < intervals; i++){
            double x = (a_bound + (.5 * dx)) + (i*dx);
           // ans = ans + function;
           ans = ans + (Math.cos(x)/x);
        }
        return ans * dx;
    }

    public static double trapezoidApproximation(double dx, int intervals, double a_bound){
        double ans = 0.0;
        for(int i = 0; i <= intervals; i++){
            double x = a_bound + (i*dx);
            
            if(i != 0 && i != intervals){
                //ans = ans + (2*(/*function*/));
                ans = ans + (2*(Math.cos(x)/x));
            } 
            else{
                //ans = ans + (/*function*/);
                ans = ans + (Math.cos(x)/x);
            }
        }
        return ans * (dx/2); 
    }

    public static double SimpsonsApproximation(double dx, int intervals, double a_bound){
       
        double ans = 0.0;
        if(intervals%2 != 0){
            return -.0001;
        }
        for(int i = 0; i <= intervals; i++){
            double x = a_bound + (i*dx);
            
            if(i == 0 || i == intervals){
               // ans = ans + (/*function*/);
               ans = ans + (Math.cos(x)/x);
            } else if(i%2 == 0){
                //ans = ans + (2*(/*function*/));
                ans = ans + (2*(Math.cos(x)/x));
            } else{
                //ans = ans + (4*(/*function*/));
                ans = ans + (4*(Math.cos(x)/x));
            } 
        }
        return ans * (dx/3);
    }
        
}
