package week2;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Pete on 18.3.2015.
 */
public class Main {
    public static void main(String[] args){
        int[][] annotationMatrix = {{62, 12},
                                    {6, 44}
        };
        List annotationNames = Arrays.asList("running", "walking");
        new AnnotationCalc(new AnnotationMatrix(annotationMatrix), annotationNames).getCohenKappa();
    }
}
