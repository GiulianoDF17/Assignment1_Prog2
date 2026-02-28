public class Task1 {

    public static double min(double[][] numss){
        double min = Double.POSITIVE_INFINITY;

        for(int i = 0; i < numss.length; i++){
            for(int j = 0; j < numss[i].length; j++){
                if(numss[i][j] < min){
                    min = numss[i][j];
                }
            }
        }
        return min;
    }

    public static double[] minOfRow(double[][] numss) {
        double[] result = new double[numss.length];

        for (int i = 0; i < numss.length; i++) {
            double min = Double.POSITIVE_INFINITY;
            for (int j = 0; j < numss[i].length; j++) {
                if (numss[i][j] < min) {
                    min = numss[i][j];
                }
            }
            result[i] = min;
        }
        return result;
    }

    public static double[] minOfCol(double[][] numss) {
        int maxCols = 0;

        for (int i = 0; i < numss.length; i++) {
            if (numss[i].length > maxCols) {
                maxCols = numss[i].length;
            }
        }

        double[] result = new double[maxCols];

        for (int col = 0; col < maxCols; col++) {
            double min = Double.POSITIVE_INFINITY;
            boolean found = false;

            for (int row = 0; row < numss.length; row++) {
                if (col < numss[row].length) {
                    if (numss[row][col] < min) {
                        min = numss[row][col];
                    }
                    found = true;
                }
            }

            result[col] = found ? min : Double.NaN;
        }

        return result;
    }

    public static double[][] add(double[][] numss1, double[][] numss2) {
        int maxRows = Math.max(numss1.length, numss2.length);
        double[][] result = new double[maxRows][];

        for (int i = 0; i < maxRows; i++) {
            int ln1 = (i < numss1.length) ? numss1[i].length : 0;
            int ln2 = (i < numss2.length) ? numss2[i].length : 0;

            int maxCols = Math.max(ln1, ln2);
            result[i] = new double[maxCols];

            for (int j = 0; j < maxCols; j++) {
                double val1 = (i < numss1.length && j < ln1) ? numss1[i][j] : 0;
                double val2 = (i < numss2.length && j < ln2) ? numss2[i][j] : 0;
                result[i][j] = val1 + val2;
            }
        }

        return result;
    }

    public static double[][] deleteRow(double[][] numss, int idx) {
        if (idx < 0 || idx >= numss.length) return numss;

        double[][] result = new double[numss.length - 1][];

        int newRow = 0;
        for (int i = 0; i < numss.length; i++) {
            if (i != idx) {
                result[newRow++] = numss[i];
            }
        }

        return result;
    }

    public static double[][] appendArray(double[][] numss1, double[][] numss2) {
        double[][] result = new double[numss1.length + numss2.length][];

        for (int i = 0; i < numss1.length; i++) {
            result[i] = numss1[i];
        }

        for (int i = 0; i < numss2.length; i++) {
            result[numss1.length + i] = numss2[i];
        }

        return result;
    }

    public static double[][] expendArray(double[][] numss1, double[][] numss2) {
        int maxRows = Math.max(numss1.length, numss2.length);
        double[][] result = new double[maxRows][];

        for (int i = 0; i < maxRows; i++) {
            int len1 = (i < numss1.length) ? numss1[i].length : 0;
            int len2 = (i < numss2.length) ? numss2[i].length : 0;

            result[i] = new double[len1 + len2];

            for (int j = 0; j < len1; j++) {
                result[i][j] = numss1[i][j];
            }

            for (int j = 0; j < len2; j++) {
                result[i][len1 + j] = numss2[i][j];
            }
        }

        return result;
    }

    public static double[][] transposeMatrix(double[][] numss) {
        int rows = numss.length;
        int cols = numss[0].length;

        double[][] result = new double[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[j][i] = numss[i][j];
            }
        }

        return result;
    }

}
