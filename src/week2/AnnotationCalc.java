package week2;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

/**
 * Created by Pete on 18.3.2015.
 */
public class AnnotationCalc {

    private int[][] annotationMatrix;
    private List annotationNames;

    public AnnotationCalc(int[][] annotationMatrix, List annotationNames){
        this.annotationMatrix = annotationMatrix;
        this.annotationNames = annotationNames;
    }

    public double getCohenKappa(){

        return kappa();
    }

    public double kappa(){
        double pre = pre();
        double pra = pra();
        double kappa = (pra - pre) / (1 - pre);
        DecimalFormat df = (DecimalFormat) NumberFormat.getNumberInstance(Locale.ENGLISH);
        df.applyPattern("0.00");
        System.out.println("k = (" + pra+ " - " + pre + ") / (1 - " + pre + ") = " + df.format(kappa));

        return kappa;
    }

    public double pre(){
        double  pre = 0;
        int total = totalAnnotations();
        for(int i = 0; i < annotationMatrix.length; i++){
            int columnSum = columnSum(i);
            int rowSum = rowSum(i);
            System.out.println("P(" + annotationNames.get(i) + " | A and B) = " + columnSum + " * " + rowSum + " / (" + total + " * " + total + ")");
            pre += (1.0 * columnSum * rowSum) / (total * total);
        }

        System.out.println("-> Pr(e)= " + pre);
        return pre;
    }


    private int rowSum(int row) throws IllegalArgumentException{
        if(row >= annotationMatrix.length){
            throw new IllegalArgumentException("illegal row!");
        }
        int sum = 0;
        for(int i = 0; i < annotationMatrix[row].length; i++){
            sum += annotationMatrix[row][i];
        }
        return sum;
    }

    private int columnSum(int column) throws IllegalArgumentException{
        if(column >= annotationMatrix.length){
            throw new IllegalArgumentException("illegal row!");
        }
        int sum = 0;
        for(int i = 0; i < annotationMatrix.length; i++){
            sum += annotationMatrix[i][column];
        }
        return sum;
    }

    private double pra(){
        int sum = 0;
        int i = 0;
        while(i < annotationMatrix.length){
            sum += annotationMatrix[i][i];
            i++;
        }
        return 1.0* sum / totalAnnotations();
    }

    private int totalAnnotations(){
        int sum = 0;
        for (int i = 0; i < annotationMatrix.length; i++){
            for (int j = 0; j < annotationMatrix[i].length; j++){
                sum += annotationMatrix[i][j];
            }
        }
        return sum;
    }




}
