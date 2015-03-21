package week2;

/**
 * Created by Pete on 18.3.2015.
 */
public class AnnotationMatrix {
    private int[][] annotationMatrix;

    public AnnotationMatrix(int[][] annotationMatrix){
        this.annotationMatrix = annotationMatrix;
    }

    public int numOfRows(){
        return annotationMatrix.length;
    }

    public int numOfColumns(){
        return annotationMatrix[0].length;
    }

    public int totalAnnotations(){
        int sum = 0;
        for (int i = 0; i < annotationMatrix.length; i++){
            for (int j = 0; j < annotationMatrix[i].length; j++){
                sum += annotationMatrix[i][j];
            }
        }
        return sum;
    }

    public int rowSum(int row) throws IllegalArgumentException{
        if(row >= annotationMatrix.length){
            throw new IllegalArgumentException("illegal row!");
        }
        int sum = 0;
        for(int i = 0; i < annotationMatrix[row].length; i++){
            sum += annotationMatrix[row][i];
        }
        return sum;
    }

    public int columnSum(int column) throws IllegalArgumentException{
        if(column >= annotationMatrix.length){
            throw new IllegalArgumentException("illegal row!");
        }
        int sum = 0;
        for(int i = 0; i < annotationMatrix.length; i++){
            sum += annotationMatrix[i][column];
        }
        return sum;
    }

    public int getElement(int row, int column){
        return annotationMatrix[row][column];
    }
}
