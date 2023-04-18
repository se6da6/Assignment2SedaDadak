package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entities.City;

public class CityDao implements Dao<City/*Entity name*/, Integer/*pk type */>{
    Connection connection;
    
    //add constructor
    public CityDao(Connection connection)
    {
        this.connection = connection;

    }

    //
    public List<City> findAll(){
        List<City> cities = new ArrayList<>();

        try (Statement statement = connection.createStatement())
        {
            ResultSet result = statement.executeQuery("SELECT * FROM city");
            while(result.next())
            {
                City city = new City();
                city.setCountryCode(result.getString("CountryCode"));
                city.setDistrict(result.getString("District"));
                city.setID(result.getInt("ID"));
                city.setName(result.getString("Name"));
                city.setPopulation(result.getInt("Population"));
                cities.add(city);//add everything in arraylist
            }
            
        }
        catch(SQLException e)
        {
            System.err.println(e.getMessage());
        }

        return cities;//returning our arraylist
    }

    /**
     * findByCityName method recieves countryCode as a parameter and 
     * it returns the arraylist of the city arraylist which consist of the requiered data.
     * The method shows the city names which has the same countryCode 
     *  
    */
    public List<City> findByCountryCode(String countryCode)
    {
        List<City> cities = new ArrayList<>();
        
        String select ="SELECT * FROM city WHERE countryCode=? ";
        try(PreparedStatement ps = connection.prepareStatement(select);)
        {
            ps.setString(1, countryCode);
            ResultSet result = ps.executeQuery();
            while(result.next())
            {
                City city = new City();
                city.setCountryCode(result.getString("CountryCode"));
                city.setDistrict(result.getString("District"));
                city.setID (result.getInt("ID"));
                city.setName(result.getString("Name"));
                city.setPopulation(result.getInt("Population"));
                cities.add(city);
            }
        }
        catch(SQLException e)
        {
            System.err.println(e.getMessage());
        }
        return cities;
       
    }
    /**
     * findByCityName method recieves name of the city as a parameter
     * and it returns the arraylist of the city arraylist which consist of the requiered data.
     * Method shows the city's information in accordance with the specifis city name
     */
    public List<City> findByCityName(String name)
    {
        List<City> cities = new ArrayList<>();
        City city = new City();
        String select ="SELECT * FROM city WHERE name=? ";
        try(PreparedStatement ps = connection.prepareStatement(select);)
        {
            ps.setString(1, name);
            ResultSet result = ps.executeQuery();
            while(result.next())
            {
                city.setCountryCode(result.getString("CountryCode"));
                city.setDistrict(result.getString("District"));
                city.setID (result.getInt("ID"));
                city.setName(result.getString("Name"));
                city.setPopulation(result.getInt("population"));
                
                cities.add(city);
            }
        }
        catch(SQLException e)
        {
            System.err.println(e.getMessage());
        }
        return cities;
       
    }

    /**
     * findByPopulation method does not recieve any parameter and
     * it returns the arraylist of the city arraylist which consist of cities with population greater than 1 million.
     *  
     */
    public List<City> findByPopulation()
    {
        List<City> cities = new ArrayList<>();
        
        String select ="SELECT * FROM city WHERE population > 1000000 ";
        try(PreparedStatement ps = connection.prepareStatement(select);)
        {
            
            ResultSet result = ps.executeQuery();
            while(result.next())
            {
                City city = new City();
                city.setCountryCode(result.getString("CountryCode"));
                city.setDistrict(result.getString("District"));
                city.setID (result.getInt("ID"));
                city.setName(result.getString("Name"));
                city.setPopulation(result.getInt("Population"));
                cities.add(city);
            }
        }
        catch(SQLException e)
        {
            System.err.println(e.getMessage());
        }
        return cities;
       
    }
    
    public void insert(City city)
    {
        try(Statement statement = connection.createStatement())
        {
            String insert = "INSERT INTO city VALUES (?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, null);
            ps.setString(2, city.getName());
            ps.setString(3, city.getCountryCode());
            ps.setString(4, city.getDistrict());
            ps.setInt(5, city.getPopulation());
            ps.executeUpdate();

            ResultSet keys = ps.getGeneratedKeys();

            if (keys.next())
            {
                city.setID(keys.getInt(1));

            }
        }
        catch(SQLException e)
        {
            System.err.println(e.getMessage());
        }
    }
    
    public Boolean update(City city)
    {
        Boolean success = true;
        String update = "UPDATE city SET population=? WHERE id=?";
        try(PreparedStatement ps = connection.prepareStatement(update);)
        {
            ps.setInt(1, city.getPopulation());
            ps.setInt(2, city.getID());
            ps.executeUpdate();

        }
        catch(SQLException e)
        {
            System.err.println(e.getMessage());
            success = false;
        }
        return success;
    }

    public City findById(Integer pk)
    {
        City city = new City();
        String select ="SELECT * FROM city WHERE id =?";
        try(PreparedStatement ps = connection.prepareStatement(select);)
        {
            ps.setInt(1, pk);
            ResultSet result = ps.executeQuery();

            if(result.next())
            {
                city.setCountryCode(result.getString("CountryCode"));
                city.setDistrict(result.getString("District"));
                city.setID (result.getInt("ID"));
                city.setName(result.getString("Name"));
                city.setPopulation(result.getInt("Population"));

            }

        }
        catch(SQLException e)
        {
            System.err.println(e.getMessage());
        }
        return city;
    }

    public Boolean delete(Integer pk)
    {
        Boolean success = false;
        String delete  = "DELETE FROM city WHERE id=?";
        try(PreparedStatement ps = connection.prepareStatement(delete)){
            ps.setInt(1, pk);
            if(ps.executeUpdate() !=0)
            {
                success = true;
            }
        }
        catch(SQLException e){
            System.err.println(e.getMessage());
        }

        return success;
    }
}
