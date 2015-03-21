package week2;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

/**
 * Created by Pete on 18.3.2015.
 *
 * Class to calculate Cohen's kappa for a given matrix
 */
public class AnnotationCalc {

    private AnnotationMatrix annotationMatrix;
    private List annotationNames;

    public AnnotationCalc(AnnotationMatrix annotationMatrix, List annotationNames){
        this.annotationMatrix = annotationMatrix;
        this.annotationNames = annotationNames;
    }

    public double getCohenKappa(){
        return kappa();
    }

    public double kappa(){
        double pra = pra();
        double pre = pre();
        double kappa = (pra - pre) / (1 - pre);
        DecimalFormat df = (DecimalFormat) NumberFormat.getNumberInstance(Locale.ENGLISH);
        df.applyPattern("0.00");
        System.out.println("k = (" + pra+ " - " + pre + ") / (1 - " + pre + ") = " + df.format(kappa));

        return kappa;
    }

    public double pre(){
        double  pre = 0;
        int total = annotationMatrix.totalAnnotations();
        for(int i = 0; i < annotationMatrix.numOfRows(); i++){
            int columnSum = annotationMatrix.columnSum(i);
            int rowSum = annotationMatrix.rowSum(i);
            System.out.println("P(" + annotationNames.get(i) + " | A and B) = " + columnSum + " * " + rowSum +
                    " / (" + total + " * " + total + ") = " + (1.0 * columnSum * rowSum) / (total * total));
            pre += (1.0 * columnSum * rowSum) / (total * total);
        }

        System.out.println("-> Pr(e)= " + pre);
        return pre;
    }

    private double pra(){
        int sum = 0;
        int i = 0;
        int totalAnnotations = annotationMatrix.totalAnnotations();
        String print = "Pr(a) = (";
        while(i < annotationMatrix.numOfColumns()){
            sum += annotationMatrix.getElement(i, i);

            if(i != annotationMatrix.numOfColumns() - 1){
                print += annotationMatrix.getElement(i, i) + " + ";
            }else{
                print += annotationMatrix.getElement(i, i) + ")";
            }
            i++;
        }
        print += "/" + totalAnnotations + " = " + 1.0* sum / totalAnnotations;
        System.out.println(print);

        return 1.0* sum / totalAnnotations;
    }
}
