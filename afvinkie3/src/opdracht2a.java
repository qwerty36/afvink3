import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by richard on 11/20/15.
 */
public class opdracht2a
{
    private String inhoud;
    private String file = "C:\\Users\\richard\\IdeaProjects\\afvink3\\afvinkie3\\src\\Homo_sapiens.gene_info";
    private static BufferedReader readloop;
    private List<opdracht2> arl = new ArrayList();

    public static void main(String[] args)
    {
        opdracht2a a1 = new opdracht2a();
        a1.check();
    }

    public void check()
    {
        //objecten hebben als private attribuut gene_id, symbol en chromosome_map_location.
        long etime;
        long etime2;

        try
        {
            readloop = new BufferedReader(new FileReader(file));
            for (int i=0; i<20; i++)
            {
                String line1 = readloop.readLine();
                if (i>0)
                {
                    //System.out.println(line1);
                    String[] arr1 = line1.split("\t");
                    String gene_id = arr1[1];
                    String symbol = arr1[2];
                    String locus = arr1[7];
                    String[] arr2 = new String[3];
                    arr2[0] = gene_id;
                    arr2[1] = symbol;
                    arr2[2] = locus;
                    etime = System.nanoTime();
                    arl.add(new opdracht2(arr2));
                    etime2 = System.nanoTime() - etime;
                    System.out.printf("Elapsed time: %fs%n", ((double) etime2 / 1000000000.0));
                    // Inserten in het midden:  O = 1
                    // Aflezen
                }

            }

        }
        catch (IOException e)
        {
            System.out.println(e.toString());
        }
        finally
        {
            System.out.println(arl);
            arl.sort(null);
            System.out.println(arl);

        }
    }
}