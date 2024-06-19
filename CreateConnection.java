import java.sql.*;

public class CreateConnection {
    Connection con;
    PreparedStatement ps;
    Statement stms;
    ResultSet rs;
    public CreateConnection(){
        try {

            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/TestingDB", "root", "pwd123");
            System.out.println("Successful");

         /*   String CreateTable ="CREATE TABLE Product (ID INT PRIMARY KEY, Name VARCHAR(50),Price DOUBLE, Active_for_sell int)";
            Statement smts= con.createStatement();
            smts.execute(CreateTable);
*/
            stms = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            String query = "SELECT * FROM Product";
            rs = stms.executeQuery(query);
            rs.next();
         //   rs.absolute(4); //select row
          //  rs.previous(); // back 1 position
/*
            rs.moveToInsertRow();
            rs.updateInt("ID",1);
            rs.updateString("Name","Coke");
            rs.updateDouble("Price",2);
            rs.updateInt("Active_for_sell",1);
/*
            rs.moveToInsertRow();
            rs.updateInt("ID",2);
            rs.updateString("Name","Pepsi");
            rs.updateDouble("Price",2);
            rs.updateInt("Active_for_sell",1);
/*
            rs.moveToInsertRow();
            rs.updateInt("ID",3);
            rs.updateString("Name","Kizz");
            rs.updateDouble("Price",1.5);
            rs.updateInt("Active_for_sell",1);
/*
            rs.moveToInsertRow();
            rs.updateInt("ID",4);
            rs.updateString("Name","RedBull");
            rs.updateInt("Price",2);
            rs.updateInt("Active_for_sell",0);*
            rs.insertRow();

*/rs.moveToCurrentRow();
           while (rs.next()) {

          //  System.out.println("ID:" + rs.getInt("Emp_Id"));
               System.out.println("ID"+rs.getInt("ID")+ "\n"+
                       "Name"+ rs.getString("Name")+ "\n"+"Price"+ rs.getDouble("Price")
               + "Active_for_sell"+ "\n"+rs.getInt("Active_for_sell"));

        }

/*
           /* String query="CREATE TABLE Employee(Emp_Id INT PRIMARY KEY, Emp_LName varchar(50), Emp_FName varchar(50), Emp_email varchar(50)" +
                    ", emp_phone varchar(15) UNIQUE)";
            Statement smts= con.createStatement();
            smts.execute(query);
            System.out.println("Create Table Done");*/ /*
            String query1 ="INSERT INTO Employee(Emp_Id,Emp_LName,Emp_FName,Emp_email,emp_phone) VALUES(?,?,?,?,?)";
            PreparedStatement ps= con.prepareStatement(query1);
            /*
            ps.setInt(1,1);
            ps.setString(2,"Tren");
            ps.setString(3,"Reaksmey");
            ps.setString(4,"tren.reaksmey@gmail.com");
            ps.setString(5,"0979702721");
/*
            ps.setInt(1,2);
            ps.setString(2,"Sophek");
            ps.setString(3,"Rady");
            ps.setString(4,"tren.reaksmey@gmail.com");
            ps.setString(5,"0979702722");
*//*
            ps.setInt(1,3);
            ps.setString(2,"Chan");
            ps.setString(3,"Pheakkdey");
            ps.setString(4,"tren.reaksmey@gmail.com");
            ps.setString(5,"0979702723");

           /* ps.setInt(1,4);
            ps.setString(2,"Sok");
            ps.setString(3,"Rina");
            ps.setString(4,"tren.reaksmey@gmail.com");
            ps.setString(5,"0979702724");*/
/*
            ps.executeUpdate();
            System.out.println("Insert Successful");
            /*
          String createTable = "CREATE TABLE Staff(ID int, LastName varchar(255),FirstName varchar(255), City varchar(255))";


            System.out.println("Create Succesfull");

            String insertrecord ="INSERT INTO Staff(ID,LastName,FirstName,City) VALUES(1,'Keo','Chenda','PP')";
            smts.executeUpdate(insertrecord);

            String  Selecte = "Select * FROM Staff";
            ResultSet rs= smts.executeQuery(Selecte);
            //Prepare Statement

            */







        } catch (SQLException e) {
          System.out.println(e.getMessage());
        }
    }



}