package htw.berlin.webtech.WebTech.persistence;

import javax.persistence.*;

@Entity(name = "plants")
public class PlantEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "common_name", nullable = false)
    private String commonName;
    @Column(name = "botanical_name", nullable = false)
    private String botanicalName;
    @Column(name = "description", nullable = true) // sollte noch auf false geändert werden
    private String description;
    @Column(name = "watering_period", nullable = true) // sollte noch auf false geändert werden
    private Integer wateringperiod;
    @Column(name = "watering_period_current", nullable = true) // sollte noch auf false geändert werden
    private Integer wateringperiodCurrent;

    @Column(name = "day", nullable = true) // sollte noch auf false geändert werden
    private Integer day;
    @Column(name = "is_saved")
    private Boolean saved;

    public PlantEntity(String commonName, String botanicalName, String description, Integer wateringperiod, Integer wateringperiodCurrent,Integer day, Boolean saved) {
        this.commonName = commonName;
        this.botanicalName = botanicalName;
        this.description = description;
        this.wateringperiod = wateringperiod;
        this.wateringperiodCurrent = wateringperiodCurrent;
        this.day = day;
        this.saved = saved;
    }

    protected PlantEntity(){}

    public Long getId() {
        return id;
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

    public void setBotanicalName(String botanicalName) {
        this.botanicalName = botanicalName;
    }

    public String getDescription() {return description;}
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

    public Boolean getSaved() {
        return saved;
    }

    public void setSaved(Boolean saved) {
        this.saved = saved;
    }
}
