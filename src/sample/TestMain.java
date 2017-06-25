package sample;

/**
 * Created by lfarinha on 6/24/17.
 */
public class TestMain
{
    public static void main(String[] args)
    {
       Mysql sql = new Mysql();
       Import csv = new Import("src/sample/names.csv");
//        for(int i=0; i<100; i++) {
//            for (int j=0; j <=4; j++) {
//                System.out.println(csv.returnCustomerData()[i][j]);
//            }
//        }
//       sql.insertRowsInCustomer();
    }
}
