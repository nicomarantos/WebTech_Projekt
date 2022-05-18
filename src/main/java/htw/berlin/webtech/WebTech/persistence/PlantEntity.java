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
    @Column(name = "is_saved")
    private Boolean saved;

    public PlantEntity(String commonName, String botanicalName, Boolean saved) {
        this.commonName = commonName;
        this.botanicalName = botanicalName;
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

    public Boolean getSaved() {
        return saved;
    }

    public void setSaved(Boolean saved) {
        this.saved = saved;
    }
}
