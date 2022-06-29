package htw.berlin.webtech.WebTech.web.api;

import javax.validation.constraints.*;

public class PlantCreateManipulationRequest {
    private long id;
    @NotBlank(message = "Please provide a Commaonname name.")
    private String commonName;
    @NotBlank(message = "Please provide a Botancialnname name.")
    private String botanicalName;
    @NotBlank(message = "Please provide a Descriptionn name.")
    private String description;
    @PositiveOrZero(message = "The Number need to be positiv or 0.")
    private Integer wateringperiod;
    @PositiveOrZero(message = "The Number need to be positiv or 0.")
    private Integer wateringperiodCurrent;
    @NotNull(message = "Please provide between True or False")
    private boolean saved;

    public PlantCreateManipulationRequest(long id, String commonName, String botanicalName, String description, int wateringperiod, int wateringperiodCurrent, boolean saved) {
        this.id = id;
        this.commonName = commonName;
        this.botanicalName = botanicalName;
        this.description = description;
        this.wateringperiod = wateringperiod;
        this.wateringperiodCurrent = wateringperiodCurrent;
        this.saved = saved;
    }

    public PlantCreateManipulationRequest() {}

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

    public void setBotanicalName(String botanicalName) {
        this.botanicalName = botanicalName;
    }

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


    public boolean isSaved() {
        return saved;
    }

    public void setSaved(boolean saved) {
        this.saved = saved;
    }
}
