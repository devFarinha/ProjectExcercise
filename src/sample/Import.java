package sample;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Import
{
    private String[][] customer = new String[100][100];
    private List<String> firstName = new ArrayList<>();
    private List<String> lastName = new ArrayList<>();

    public Import(String path)
    {
        this.data(path);
        this.generate(this.firstName, this.lastName);
    }

    private void data(String path)
    {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String line;
            int i=0;
            while((line = reader.readLine()) != null)
            {
                this.firstName.add(i, line.split(",")[0]);
                this.lastName.add(i, line.split(",")[1]);
                i++;
            }
<<<<<<< HEAD
=======
            reader.close();
>>>>>>> 1288d67e89e698fee3e4e4585e749dfbb8df5dd1
        }catch (IOException e)
        {
            System.out.println(e);
        }
    }

    private void generate(List firstNames, List lastNames)
    {
        int minDay = 1, maxDay = 31, minMonth = 1, maxMonth = 12, minYear = 1900, maxYear = 2000;
        int minCode = 111, maxCode = 666, minThree = 000, maxThree = 999, minFour = 000, maxFour = 999;
        String[] address = {"8915 Fairview St.","9046 Trusel Street","9151C Lawrence Street","760 Hall St.","899 Howard St.","7413 Main Drive ","710 West Littleton Drive ","9174 Bay St.","319 Birch Hill Lane","8903 North Meadowbrook St."};
        for(int i=0; i<100; i++)
        {
            for (int j=0; j<5; j++)
            {
                switch(j)
                {
                    case 0:
                        this.customer[i][j] = lastNames.get(i).toString();
                        break;
                    case 1:
                        this.customer[i][j] = firstNames.get(i).toString();
                        break;
                    case 2:
                        int day = ThreadLocalRandom.current().nextInt(minDay, maxDay),
                            month =ThreadLocalRandom.current().nextInt(minMonth, maxMonth),
                            year = ThreadLocalRandom.current().nextInt(minYear, maxYear);
                            this.customer[i][j] = ""+month+"/"+day+"/"+year;
                            break;
                    case 3: int index = ThreadLocalRandom.current().nextInt(0,9);
                            this.customer[i][j] = address[index];
                            break;
                    case 4:
                        int code = ThreadLocalRandom.current().nextInt(minCode, maxCode), 
                                three =ThreadLocalRandom.current().nextInt(minThree, maxThree),
                                four = ThreadLocalRandom.current().nextInt(minFour, maxFour);
                        this.customer[i][j] = ""+code+"-"+three+"-"+four;
                        break;
                }
            }
        }
    }

    public String[][] returnCustomerData()
    {
        return this.customer;
    }
}
