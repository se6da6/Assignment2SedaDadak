package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entities.Country;


/**
 * Creating CountryDao class and its constructor
 */
public class CountryDao implements Dao<Country,String> {
    Connection connection;
    
    //add constructor
    public CountryDao(Connection connection)
    {
        this.connection = connection;

    }

    /**
     * findAll method has no parameter and it returns 
     * countries arraylist. The aim of the method is 
     * find all data inside the table(entity)
     */
    public List<Country> findAll()
    {
        List<Country> countries = new ArrayList<>();

        try(Statement statement = connection.createStatement()){
            ResultSet result = statement.executeQuery("SELECT * FROM country");
            while(result.next())
            {
                Country country = new Country();
                country.setCode(result.getString("Code"));
                country.setName(result.getString("Name"));
                country.setCapital(result.getInt("Capital"));
                country.setContinent(result.getString("Continent"));
                country.setCode2(result.getString("Code2"));
                country.setGNP(result.getFloat("GNP"));
                country.setGNPOld(result.getFloat("GNPOld"));
                country.setGovenrmentForm(result.getString("GovernmentForm"));
                country.setHeadOfState(result.getString("HeadOfState"));
                country.setIndepYear(result.getInt("IndepYear"));
                country.setLifeExpectancy(result.getDouble("LifeExpectancy"));
                country.setLocalName(result.getString("LocalName"));
                country.setPopulation(result.getInt("Population"));
                country.setRegion(result.getString("Region"));
                country.setSurfaceArea(result.getDouble("SurfaceArea"));
                countries.add(country);
            }
        }
        catch(SQLException e)
        {
            System.err.println(e.getMessage());
        }
        return countries;

    }
    
    /**
     * Insert method recieve an object of Country class
     * and it does not return anything.
     * The method enables us to insert new data into the table.
     */
     public void insert(Country country)
    {
        try(Statement statement = connection.createStatement())
        {
            String insert = "INSERT INTO country VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(insert);
            ps.setString(1,country.getCode());
            ps.setString(2,country.getName());
            ps.setString(3, country.getContinent());
            ps.setString(4, country.getRegion());
            ps.setDouble(5, country.getSurfaceArea());
            ps.setInt(6, country.getIndepYear());
            ps.setInt(7, country.getPopulation());
            ps.setDouble(8, country.getLifeExpectancy());
            ps.setDouble(9, country.getGNP());
            ps.setDouble(10, country.getGNPOld());
            ps.setString(11, country.getLocalName());
            ps.setString(12, country.getGovernmentForm());
            ps.setString(13, country.getHeadOfState());
            ps.setInt(14, country.getCapital());
            ps.setString(15, country.getCode2());
            ps.executeUpdate();

           
        }   
        catch(SQLException e)
        {
            System.err.println(e.getMessage());
        }

    }
    
    /**
     * Update method recieves an object of Country class
     * and it returns boolean value as true if the update 
     * is successful. The method enables us to update existing data 
     * inside the table.
     */
    public Boolean update(Country country)
    {
        Boolean success = true;
        String update = "UPDATE country SET population=? WHERE code=?";
        try(PreparedStatement ps = connection.prepareStatement(update);)
        {
            ps.setInt(1, country.getPopulation());
            ps.setString(2, country.getCode());
            ps.executeUpdate();

        }
        catch(SQLException e)
        {
            System.err.println(e.getMessage());
            success = false;
        }
        return success;
    }

    /**
     * findById method recieves primary key of the table as a parameter
     * and it returns an object of Country class.
     * The method provide us to find a specific data based on primary key.
     */
    public Country findById(String pk)
    {
        Country country = new Country();
        String select = "SELECT * FROM country WHERE code =?";
        try(PreparedStatement ps = connection.prepareStatement(select))
        {
            ps.setString(1, pk);
            ResultSet result = ps.executeQuery();

            if(result.next())
            {
                country.setCode(result.getString("Code"));
                country.setCapital(result.getInt("Capital"));
                country.setCode2(result.getString("Code2"));
                country.setContinent(result.getString("Continent"));
                country.setGNP(result.getFloat("GNP"));
                country.setGNPOld(result.getFloat("GNPOld"));
                country.setGovenrmentForm(result.getString("GovernmentForm"));
                country.setHeadOfState(result.getString("HeadOfState"));
                country.setIndepYear(result.getInt("IndepYear"));
                country.setLifeExpectancy(result.getDouble("LifeExpectancy"));
                country.setLocalName(result.getString("LocalName"));
                country.setName(result.getString("Name"));
                country.setPopulation(result.getInt("Population"));
                country.setRegion(result.getString("Region"));
                country.setSurfaceArea(result.getDouble("SurfaceArea"));

            }
        }
        catch(SQLException e)
        {
            System.err.println(e.getMessage());
        }
        return country;
    }

    /**
     * delete method recieves primary key of the table as a a parameter
     * and it returns boolean value as true if the deletion is successfull.
     * The method enables us to delete specific data inside the table based on primary key.
     */
    public Boolean delete(String pk)
    {
        Boolean success = false;
        String delete = "DELETE FROM country WHERE code=?";
        try(PreparedStatement ps = connection.prepareStatement(delete))
        {
            ps.setString(1, pk);
            if(ps.executeUpdate() !=0)
            {
                success = true;
            }
        }
        catch(SQLException e){
            System.err.println(e.getMessage());
            success = false;
        }

        return success;
    
    }
}
