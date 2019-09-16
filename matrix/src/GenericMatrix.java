public  abstract class GenericMatrix<E extends Number> {
    protected abstract E add(E o1,E o2);
    protected abstract E multiply(E o1,E o2);
    protected  abstract  E zero();

    public E[][] addMatrix(E[][] matrix1,E[][] matrix2){
        if(RationalMatrix.isRational_add(matrix1,matrix2)) {
            throw new RuntimeException("The matrices do not have the same size ");
        }

        E[][] result = (E[][])new Number[matrix1.length][matrix1[0].length];

        for(int i = 0;i < result.length;i++)
            for(int j = 0;j < result[i].length;j++) {
                result[i][j] = add(matrix1[i][j],matrix2[i][j]);
            }
        return result;
    }

    /*
    * 矩阵乘法，第一个矩阵的行乘以第二个矩阵的列，每个数据对应相乘，
    *用i表示第一个矩阵的行，j表示第二个矩阵的列
    * 借助辅助变量k，在第一个矩阵中表示列，第二个矩阵中表示行，
    * 因为第一个矩阵的行是固定的，第二个矩阵的列是固定的。
    * 所有，用一个k表示行列，设计非常巧妙。数据结构中讲了，但是没理解，现在实战，OK了
    *
    * */


    public E[][] multiplyMatrix(E[][] matrix1,E[][] matrix2){
        if(!RationalMatrix.isRational_multiply(matrix1,matrix2)) {
            throw new RuntimeException("The matrices do not compatible size ");
        }

        E[][] result = (E[][])new Number[matrix1.length][matrix2[0].length];

        for(int i = 0;i < matrix1.length;i++)
            for(int j = 0;j < matrix2[0].length;j++) {
                result[i][j] = zero();
                for(int k = 0;k < matrix1[0].length;k++) {
                    result[i][j] = add(result[i][j],multiply(matrix1[i][k],matrix2[k][j]));
                }
            }

        return result;
    }

    public static void printResult(Number[][] m1,Number[][] m2,Number[][] m3,char op) {
        for(int i = 0;i < m1.length;i++) {
            for(int j = 0;j < m1[0].length;j++)
                System.out.print(" "+m1[i][j]);

            if(i == m1.length / 2)
                System.out.print(" "+op+" ");
            else
                System.out.print("   ");

            for(int j = 0;j < m2.length;j++)
                System.out.print(" "+ m2[i][j]);

            if(i == m1.length / 2)
                System.out.print(" = ");
            else
                System.out.print("   ");

            for(int j = 0;j < m3.length;j++)
                System.out.print(m3[i][j]+" ");

            System.out.print("\n");
        }
    }
}

