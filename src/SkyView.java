public class SkyView
{
    private double [] [] view;
    public SkyView (int numRows, int numCols, double [] scanned)
    {
        view = new double[numRows][numCols];
        boolean LR = true;
        int index = 0;
        for (int r = 0; r < numRows; r++)
        {
            //for each row
            if (LR)
            {
                for (int c = 0; c < numCols; c++)
                {
                    //left to right
                    view [r] [c] = scanned [index];
                    index++;
                }
            }
            else
            {
                for (int c = numCols-1; c > -1; c--)
                {
                    //right to left
                    view [r] [c] = scanned [index];
                    index++;
                }
            }
            LR = ! LR;
        }
    }

    public String toString ()
    {
        String out ="";
        for (int i = 0; i < this.view.length; i++)
        {
            for (int n = 0; n < this.view[i].length; n++) {
                out = out + this.view [i] [n] + " ";
            }
            out = out + "\n";
        }
        return out;
    }
    
    
    public double getAverage (int startRow, int endRow, int startCol, int endCol)
    {
        double total = 0;
        int index = 0;
        // for every row:
        for (int r = startRow; r < endRow + 1; r++)
        {
            //for every column:
            for (int c = startCol; c < endCol+1; c++)
            {
                total = total + view [r] [c];
                index ++;
            }
        }
        return (total/index);
    }





    public static void main (String [] args)
    {
        double [] scan = {0.3, 0.7, 0.8, 0.4, 1.4, 1.1, 0.2, 0.5, 0.2, 1.6,0.6,0.9};
        double [] scan2 = {0.3, 0.7, 0.8, 0.4, 1.4, 1.1};

        SkyView sv1 = new SkyView(4,3,scan);
        SkyView sv2 = new SkyView(3,2,scan2);

        System.out.println(sv1);
        System.out.println(sv2);
        System.out.println("Average 1: " + sv1.getAverage (1,3,0,2));
        System.out.println("Average 2: " + sv2.getAverage(0,1,0,1));

    }

}
