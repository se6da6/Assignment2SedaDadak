import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

import daos.CityDao;
import daos.CountryDao;
import daos.LanguageDao;
import entities.City;
import entities.Country;
import entities.Database;
import entities.Language;



public class App 
{
    public static void main(String[] args) throws Exception 
    {
        System.out.println("Hello, World!");

        List<Language> languageList;
        List<City> cityList;
        //Creating arraylist for  the country class
        List<Country> countryList;
        List<City> cityFindByCountryCodeList;
        List<Country> countryFindByRegionList;
        List<City> cityFindByNameList;
        List<City> cityFindByPopulationList;
        List<Country> countryFindByNameList;


         try (Connection connection = Database.getDatabaseConnection();
         Statement statement =  connection.createStatement();){

            //CityDao
            CityDao cityDao = new CityDao(connection);
            cityList = cityDao.findAll();


            //LanguageDao
            LanguageDao languageDao = new LanguageDao(connection);
            languageList = languageDao.findAll();

             //Creating an instance of CountryDao class and calling findall method
             CountryDao countryDao = new CountryDao(connection);
             countryList = countryDao.findAll();

            System.out.println("Cities printes:");
            for(City city: cityList)
            {
                System.out.println(city);
            }
            

            System.out.println("Languages printes:");
            for(Language language:languageList)
            {
                System.out.println(language);
            }

            //Printing Countries
            System.out.println("Country printes:");
            for(Country country:countryList)
            {
                System.out.println(country);
            }
            
            //Inserting new city
            City insertCity1 = new City();
            insertCity1.setCountryCode("CAN");
            insertCity1.setDistrict("Ontario");
            insertCity1.setName("Kingston");
            insertCity1.setPopulation(118000);

            cityDao.insert(insertCity1);

            //Calling findByCountryCode method
           cityFindByCountryCodeList = cityDao.findByCountryCode("CAN");
           System.out.println("Cities name by country code:");
            for(City city: cityFindByCountryCodeList)
            {
                System.out.println(city);
            }

            //Calling the findByRegionName method
            countryFindByRegionList = countryDao.findCountryByRegion("Central Africa");
            System.out.println("Countries name by region:");
            for(Country country:countryFindByRegionList)
            {
                System.out.println(country);
            }

           //Calling findCityByName method
            cityFindByNameList = cityDao.findByCityName("Tilburg");
            System.out.println("Cities by city name:");
            for(City city: cityFindByNameList)
            {
                System.out.println(city);
            }

              //Calling findCityByPopulation method
            cityFindByPopulationList = cityDao.findByPopulation();
            System.out.println("Cities name by population:");
            for(City city: cityFindByPopulationList)
            {
                System.out.println(city);
            }
            //Calling findCountryByName method
            countryFindByNameList = countryDao.findCountryByName("Angola");
            System.out.println("Countries name by country name:");
            for(Country country:countryFindByNameList)
            {
                System.out.println(country);
            }
            /** 
             * Creating an instance of Country class to insert into 
             * Country entity and inserting new data
             * */
            /*Country insertCountry = new Country();
            insertCountry.setCapital(1);
            insertCountry.setCode("TRK");
            insertCountry.setContinent("Asia");
            insertCountry.setGNP(942.00);
            insertCountry.setGNPOld(839.00);
            insertCountry.setGovenrmentForm("Republic");
            insertCountry.setHeadOfState("Erdogan");
            insertCountry.setIndepYear(1920);
            insertCountry.setLifeExpectancy(79.1);
            insertCountry.setLocalName("Turkiye");
            insertCountry.setName("Turkey");
            insertCountry.setPopulation(81000000);
            insertCountry.setRegion("Euroasia");
            insertCountry.setSurfaceArea(783.562);
            insertCountry.setCode2("TR");

            //calling insert method
            countryDao.insert(insertCountry);

           /**
            * Creating new object of Country class,
            * calling FindById method and  execute update method
            */
           
           /* Country updateCountry = new Country();
            updateCountry = countryDao.findById("TRK");
            System.out.println(updateCountry);
            //updateCountry.setPopulation(85000000);
             Boolean success = countryDao.update(updateCountry);

            if(success==true)
            {
                System.out.println("Country entity successfully updated!");
            }*/

            //Executing Delete method on the recently inserted data
           /*  Boolean succeeded = countryDao.delete("TRK");

            if(succeeded==true)
            {
                System.out.println("Related records deleted successfully!");
            }
            else{
                System.out.println("delete");
            }*/


        
    }
    catch(Exception ex){
        System.out.println("Exception" + ex.getMessage());
    }
}
}
