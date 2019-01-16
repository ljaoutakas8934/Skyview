public class SkyView
{
    private double [] [] view;
    public SkyView (int numRows, int numCols, double [] scanned)
    {

        view = new double[numRows][numCols];


        int d = 1;
        int j = 0;
        // for every row
        for( int i = 0; i < numRows; i++)
        {
            if (d>0)
            {
                for (int n = 0; n < numCols; n++)
                {

                    view [i] [n] = scanned [j];
                    j++;
                }
            }
            else
            {
                for (int n = numCols-1; n>-1; n--)
                {
                    view [i] [n] = scanned [j];
                    j++;
                }
            }
            d = -1 * d;
        }
        System.out.println(this.view[0][1]);
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






    public static void main (String [] args)
    {
        double [] scan = {0.3, 0.7, 0.8, 0.4, 1.4, 1.1, 0.2, 0.5, 0.2, 1.6,0.6,0.9};
        double [] scan2 = {0.3, 0.7, 0.8, 0.4, 1.4, 1.1};

        SkyView sv1 = new SkyView(4,3,scan);
        SkyView sv2 = new SkyView(3,2,scan2);

        System.out.println(sv1);
        System.out.println(sv2);

    }

}
