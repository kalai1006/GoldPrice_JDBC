import java.sql.*;

public class GoldPrice {

	public static void main(String[] args)throws ClassNotFoundException, SQLException{
		// TODO Auto-generated method stub
		try {
			// Class.forName("oracle.jdbc.driver.oracleDriver");
			Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","12345");
			Statement s = c.createStatement();
			System.out.println("connection established");
			s.executeQuery("create table Goldprice_details(Datee varchar2(20)not null,gram_1_22k varchar2(10),gram_8_22k varchar2(10),gram_1_24k varchar2(10),gram_8_24k varchar2(10))");
			s.execute("insert into Goldprice_details values('2021-03-31','Rs.4,024','Rs.32,190','Rs.4,303','Rs.34,423')");
			s.execute("insert into Goldprice_details values('2021-03-30','Rs.4,053','Rs.32,424','Rs.4,335','Rs.34,680')");
			s.execute("insert into Goldprice_details values('2021-03-29','Rs.4,088','Rs.32,704','Rs.4,372','Rs.34,975')");
			s.execute("insert into Goldprice_details values('2021-03-28','Rs.4,088','Rs.32,704','Rs.4,372','Rs.34,975')");
			s.execute("insert into Goldprice_details values('2021-03-27','Rs.4,091','Rs.32,737','Rs.4,376','Rs.34,006')");
			s.execute("insert into Goldprice_details values('2021-03-26','Rs.4,095','Rs.32,758','Rs.4,380','Rs.34,038')");
			s.execute("insert into Goldprice_details values('2021-03-25','Rs.4,105','Rs.32,836','Rs.4,389','Rs.34,115')");
			s.execute("insert into Goldprice_details values('2021-03-24','Rs.4,079','Rs.32,634','Rs.4,363','Rs.34,905')");
			s.execute("insert into Goldprice_details values('2021-03-23','Rs.4,100','Rs.32,797','Rs.4,385','Rs.34,076')");
			s.execute("insert into Goldprice_details values('2021-03-22','Rs.4,118','Rs.32,945','Rs.4,404','Rs.34,232')");
			s.execute("insert into Goldprice_details values('2021-03-21','Rs.4,118','Rs.32,945','Rs.4,404','Rs.34,232')");
			ResultSet rs=s.executeQuery("select * from Goldprice_details");
			while(rs.next())
			{
				System.out.print(rs.getString(1)+"     ");
				System.out.print(rs.getString(2)+"     ");
				System.out.print(rs.getString(3)+"     ");
				System.out.print(rs.getString(4)+"     ");
				System.out.println(rs.getString(5)+"     ");
			}
			rs.close();
			System.out.println();
			System.out.println("AFTER UPDATE, DELETE AND ALTER  OPERATIONS");
			System.out.println();
			s.executeUpdate("update Goldprice_details set gram_1_22k='Rs.5,550'where Datee='2021-03-31'");
			s.executeUpdate("delete from Goldprice_details where Datee='2021-03-21'");
			s.execute("alter table Goldprice_details rename column Datee to Date_of_10Days");
			ResultSet rs1=s.executeQuery("select * from Goldprice_details");
			while(rs1.next())
			{
				System.out.print(rs1.getString(1)+"     ");
				System.out.print(rs1.getString(2)+"     ");
				System.out.print(rs1.getString(3)+"     ");
				System.out.print(rs1.getString(4)+"     ");
				System.out.println(rs1.getString(5)+"     ");
			}
			rs1.close();
			System.out.println();
			System.out.println("AFTER PREPARE STATEMENT:");
			System.out.println();
			PreparedStatement ps=c.prepareStatement("insert into Goldprice_details values(?,?,?,?,?)");
			ps.setString(1,"2021-03-20");
			ps.setString(2,"Rs.4,111");
			ps.setString(3,"Rs.32,890");
			ps.setString(4,"Rs.4,397");
			ps.setString(5,"Rs.35,178");
			ps.execute();
			ResultSet rs2=s.executeQuery("select * from Goldprice_details");
			while(rs2.next())
			{
				System.out.print(rs2.getString(1)+"     ");
				System.out.print(rs2.getString(2)+"     ");
				System.out.print(rs2.getString(3)+"     ");
				System.out.print(rs2.getString(4)+"     ");
				System.out.println(rs2.getString(5)+"     ");
			}
			rs2.close();
			System.out.println();
			System.out.println("AFTER CALLABLE STATEMENT:");
			System.out.println();
			CallableStatement cs=c.prepareCall("{call ASSIGNMENT(?,?,?,?,?)}");
			cs.setString(1,"2021-03-19");
			cs.setString(2,"Rs.4,107");
			cs.setString(3,"Rs.32,859");
			cs.setString(4,"Rs.4,393");
			cs.setString(5,"Rs.35,146");
			cs.execute();
			ResultSet rs4=s.executeQuery("select * from Goldprice_details");
			while(rs4.next())
			{
				System.out.print(rs4.getString(1)+"     ");
				System.out.print(rs4.getString(2)+"     ");
				System.out.print(rs4.getString(3)+"     ");
				System.out.print(rs4.getString(4)+"     ");
				System.out.println(rs4.getString(5)+"     ");
			}
			rs4.close();
			s.close();
			c.close();
			
		} 
		catch (Exception e) {
			System.out.println(e);
		}

	}

}
