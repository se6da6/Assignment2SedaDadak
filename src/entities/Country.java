package entities;

public class Country {
    //Attributes of class and columns of the table
    String Code; //Primary Key
    String Name; 
    String Continent;
    String Region;
    Double SurfaceArea;
    Integer IndepYear;
    Integer Population;
    Double LifeExpectancy;
    Double GNP;
    Double GNPOld;
    String LocalName;
    String GovernmentForm;
    String HeadOfState;
    Integer Capital;
    String Code2;

    //Creating getter and setters for the attributes
    public String getCode()
    {
        return Code;
    }

    public void setCode(String code)
    {
        this.Code = code;
    }
    public String getName()
    {
        return Name;
    }

    public void setName(String name)
    {
        this.Name = name;
    }

    public String getContinent()
    {
        return Continent;
    }

    public void setContinent(String continent)
    {
        this.Continent = continent;
    }

    public String getRegion()
    {
        return Region;
    }

    public void setRegion(String region)
    {
        this.Region = region;
    }

    public Double getSurfaceArea()
    {
        return SurfaceArea;
    }

    public void setSurfaceArea(Double surfaceArea)
    {
        this.SurfaceArea = surfaceArea;
    }

    public Integer getIndepYear()
    {
        return IndepYear;
    }

    public void setIndepYear(Integer indepYear)
    {
        this.IndepYear = indepYear;
    }

    public Integer getPopulation()
    {
        return Population;
    }

    public void setPopulation(Integer population)
    {
        this.Population = population;
    }

    public Double getLifeExpectancy()
    {
        return LifeExpectancy;
    }

    public void setLifeExpectancy(Double lifeExpectancy)
    {
        this.LifeExpectancy = lifeExpectancy;
    }

    public Double getGNP()
    {
        return GNP;
    }

    public void setGNP(double d)
    {
        this.GNP = d;
    }

    public Double getGNPOld()
    {
        return GNPOld;
    }

    public void setGNPOld(double d)
    {
        this.GNPOld = d;
    }

    public String getLocalName()
    {
        return LocalName;
    }

    public void setLocalName(String localName)
    {
        this.LocalName = localName;
    }

    public String getGovernmentForm()
    {
        return GovernmentForm;
    }

    public void setGovenrmentForm(String governmentForm)
    {
        this.GovernmentForm = governmentForm;
    }

    public String getHeadOfState()
    {
        return HeadOfState;
    }

    public void setHeadOfState(String headOfState)
    {
        this.HeadOfState = headOfState;
    }

    public Integer getCapital()
    {
        return Capital;
    }

    public void setCapital(Integer capital)
    {
        this.Capital = capital;
    }

    public String getCode2()
    {
        return Code2;
    }

    public void setCode2(String code2)
    {
        this.Code2 = code2;
    }

    /**
     * Enable to see all the values inside the entity
     */
    @Override
    public String toString()
    {
        return  "Country [Code" + Code+ "Name=" + Name + ", Continent=" + Continent + 
                ", Region=" + Region + ", SurfaceArea="+ SurfaceArea +
                ", IndepYear=" + IndepYear + ", Population=" + Population+
                ", Life Expectancy=" + LifeExpectancy + ", GNP=" + GNP+
                ", GNPOld=" + GNPOld + ", LocalName=" + LocalName + 
                ", GovernmentForm=" + GovernmentForm + ", HeadOfState=" + HeadOfState+
                ", Capital=" + Capital + ", Code2=" + Code2 + "]";
    }
}