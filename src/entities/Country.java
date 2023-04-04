package entities;

public class Country {
    String Name; //pk
    String Continent;
    String Region;
    Integer SurfaceArea;
    Integer IndepYear;
    Integer Population;
    Integer LifeExpectancy;
    Integer GNP;
    Integer GNPOld;
    String LocalName;
    String GovernmentForm;
    String HeadOfState;
    Integer Capital;
    String Code2;


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

    public Integer getSurfaceArea()
    {
        return SurfaceArea;
    }

    public void setSurfaceArea(Integer surfaceArea)
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

    public Integer getLifeExpectancy()
    {
        return LifeExpectancy;
    }

    public void setLifeExpectancy(Integer lifeExpectancy)
    {
        this.LifeExpectancy = lifeExpectancy;
    }

    public Integer getGNP()
    {
        return GNP;
    }

    public void setGNP(Integer gnp)
    {
        this.GNP = gnp;
    }

    public Integer getGNPOld()
    {
        return GNPOld;
    }

    public void setGNPOld(Integer gnpOld)
    {
        this.GNPOld = gnpOld;
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

    @Override
    public String toString()
    {
        return "Country [Name=" + Name + ", Continent=" + Continent + 
                ", Region=" + Region + ", SurfaceArea="+ SurfaceArea +
                ", IndepYear=" + IndepYear + ", Population=" + Population+
                ", Life Expectancy=" + LifeExpectancy + ", GNP=" + GNP+
                ", GNPOld=" + GNPOld + ", LocalName=" + LocalName + 
                ", GovernmentForm=" + GovernmentForm + ", HeadOfState=" + HeadOfState+
                ", Capital=" + Capital + ", Code2=" + Code2;
    }
}