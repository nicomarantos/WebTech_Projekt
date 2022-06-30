package htw.berlin.webtech.WebTech.web.api;

public class Plant {
    private long id;
    private String commonName;
    private String botanicalName;
    private String description;
    private Integer wateringperiod;

    private Integer wateringperiodCurrent;

    private Integer day;
    private boolean saved;

    public Plant(long id, String commonName, String botanicalName, String description, Integer wateringperiod, Integer wateringperiodCurrent,Integer day, boolean saved) {
        this.id = id;
        this.commonName = commonName;
        this.botanicalName = botanicalName;
        this.description = description;
        this.wateringperiod = wateringperiod;
        this.wateringperiodCurrent = wateringperiodCurrent;
        this.day = day;
        this.saved = saved;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public String getBotanicalName() {
        return botanicalName;
    }

    public void setBotanicalName(String botanicalName) {this.botanicalName = botanicalName;}

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {this.description = description;}

    public Integer getWateringperiod() {
        return wateringperiod;
    }

    public void setWateringperiod(Integer wateringperiod) {this.wateringperiod = wateringperiod;}

    public Integer getWateringperiodCurrent() {
        return wateringperiodCurrent;
    }

    public void setWateringperiodCurrent(Integer wateringperiodCurrent) {this.wateringperiodCurrent = wateringperiodCurrent;}

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {this.day = day ;}

    public boolean isSaved() {return saved;}

    public void setSaved(boolean saved) {
        this.saved = saved;
    }
}
