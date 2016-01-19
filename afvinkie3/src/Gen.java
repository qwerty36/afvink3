import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Gen implements Comparable {
    private String gene_id;                         //objecten hebben als private attribuut gene_id, symbol en chromosome_map_location.
    private String symbol;                                        //Creëer ook de bijbehorende getters en setters voor deze attributen
    private String locus;
    public Gen(String[] arr)
    {
        gene_id = arr[0];
        symbol = arr[1];
        locus = arr [2];
    }
    public void setGene_id(String a)
    {
        gene_id = a;
    }

    public String getGene_id()
    {
        return gene_id;
    }

    public void setSymbol(String b)
    {
        symbol = b;
    }

    public String getSymbol()
    {
        return symbol;
    }

    public void setLocus(String c)
    {
        locus = c;
    }

    public String getLocus()
    {
        return locus;
    }
    @Override
    public String toString()
    {
        return ("\n\ngene_id:   "+gene_id+"\nsymbol:    "+symbol+"\nlocus:     "+locus);
    }


    public int compareTo(Object gen)
    {
        String locusaa;
        int f1 = 0;
        int f2 = 0;
        Gen a = (Gen)gen;

        for (int i = 0; i<2; i++)
        {
            if (i == 0)
            {
                locusaa = a.getLocus();
            }
            else
            {
                locusaa = this.getLocus();
            }
            String first = locusaa.substring(0, 2);
            Pattern p1 = Pattern.compile("d{2}");
            Matcher b1 = p1.matcher(first);
            Pattern p2 = Pattern.compile("d{1}.");
            Matcher b2 = p2.matcher(first);
            Pattern p3 = Pattern.compile("[XY].");
            Matcher b3 = p3.matcher(first);


            if (b2.matches())
            {
                first = first.substring(0, 1);
            }

            if (b3.matches())
            {
                Pattern p4 = Pattern.compile("X.");
                Matcher b4 = p3.matcher(first);
                Pattern p5 = Pattern.compile("Y.");
                Matcher b5 = p3.matcher(first);

                if (b4.matches())
                {
                    first = "98";
                }
                if (b5.matches())
                {
                    first = "99";
                }
            }
            if (i==0)
            {
                try {f1 = Integer.parseInt(first);}
                catch (NumberFormatException nfe){
                    f1 = Integer.parseInt(first.substring(0,first.length()-1));
                }
            }
            else
            {
                try {f2 = Integer.parseInt(first);}
                catch (NumberFormatException nfe){
                    f1 = Integer.parseInt(first.substring(0,first.length()-1));
                }
            }
        }

        if (f1<f2)
        {
            return -1;
        }
        if (f1>f2)
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }

}