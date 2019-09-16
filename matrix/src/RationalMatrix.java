
public class RationalMatrix{

    public static boolean isRational_add(Object[][] matrix1, Object[][] matrix2){
        if((matrix1.length != matrix2.length) ||
                (matrix1[0].length != matrix2[0].length)){
            return true;
        }
        return false;
    }

    public  static  boolean isRational_multiply(Object[][] matrix1, Object[][] matrix2){
        if(matrix1[0].length != matrix2.length)
        {
            return false;
        }
        return  true;
    }


}
