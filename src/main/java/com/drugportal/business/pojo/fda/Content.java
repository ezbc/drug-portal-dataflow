
package com.drugportal.business.pojo.fda;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "package_label_principal_display_panel",
    "spl_unclassified_section",
    "do_not_use",
    "active_ingredient",
    "warnings",
    "inactive_ingredient",
    "effective_time",
    "openfda",
    "keep_out_of_reach_of_children",
    "spl_product_data_elements",
    "set_id",
    "dosage_and_administration",
    "version",
    "stop_use",
    "purpose",
    "questions",
    "when_using",
    "id",
    "indications_and_usage"
})
public class Content {

    @JsonProperty("package_label_principal_display_panel")
    private List<String> packageLabelPrincipalDisplayPanel = null;
    @JsonProperty("spl_unclassified_section")
    private List<String> splUnclassifiedSection = null;
    @JsonProperty("do_not_use")
    private List<String> doNotUse = null;
    @JsonProperty("active_ingredient")
    private List<String> activeIngredient = null;
    @JsonProperty("warnings")
    private List<String> warnings = null;
    @JsonProperty("inactive_ingredient")
    private List<String> inactiveIngredient = null;
    @JsonProperty("effective_time")
    private String effectiveTime;
    @JsonProperty("openfda")
    private Openfda openfda;
    @JsonProperty("keep_out_of_reach_of_children")
    private List<String> keepOutOfReachOfChildren = null;
    @JsonProperty("spl_product_data_elements")
    private List<String> splProductDataElements = null;
    @JsonProperty("set_id")
    private String setId;
    @JsonProperty("dosage_and_administration")
    private List<String> dosageAndAdministration = null;
    @JsonProperty("version")
    private String version;
    @JsonProperty("stop_use")
    private List<String> stopUse = null;
    @JsonProperty("purpose")
    private List<String> purpose = null;
    @JsonProperty("questions")
    private List<String> questions = null;
    @JsonProperty("when_using")
    private List<String> whenUsing = null;
    @JsonProperty("id")
    private String id;
    @JsonProperty("indications_and_usage")
    private List<String> indicationsAndUsage = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("package_label_principal_display_panel")
    public List<String> getPackageLabelPrincipalDisplayPanel() {
        return packageLabelPrincipalDisplayPanel;
    }

    @JsonProperty("package_label_principal_display_panel")
    public void setPackageLabelPrincipalDisplayPanel(List<String> packageLabelPrincipalDisplayPanel) {
        this.packageLabelPrincipalDisplayPanel = packageLabelPrincipalDisplayPanel;
    }

    @JsonProperty("spl_unclassified_section")
    public List<String> getSplUnclassifiedSection() {
        return splUnclassifiedSection;
    }

    @JsonProperty("spl_unclassified_section")
    public void setSplUnclassifiedSection(List<String> splUnclassifiedSection) {
        this.splUnclassifiedSection = splUnclassifiedSection;
    }

    @JsonProperty("do_not_use")
    public List<String> getDoNotUse() {
        return doNotUse;
    }

    @JsonProperty("do_not_use")
    public void setDoNotUse(List<String> doNotUse) {
        this.doNotUse = doNotUse;
    }

    @JsonProperty("active_ingredient")
    public List<String> getActiveIngredient() {
        return activeIngredient;
    }

    @JsonProperty("active_ingredient")
    public void setActiveIngredient(List<String> activeIngredient) {
        this.activeIngredient = activeIngredient;
    }

    @JsonProperty("warnings")
    public List<String> getWarnings() {
        return warnings;
    }

    @JsonProperty("warnings")
    public void setWarnings(List<String> warnings) {
        this.warnings = warnings;
    }

    @JsonProperty("inactive_ingredient")
    public List<String> getInactiveIngredient() {
        return inactiveIngredient;
    }

    @JsonProperty("inactive_ingredient")
    public void setInactiveIngredient(List<String> inactiveIngredient) {
        this.inactiveIngredient = inactiveIngredient;
    }

    @JsonProperty("effective_time")
    public String getEffectiveTime() {
        return effectiveTime;
    }

    @JsonProperty("effective_time")
    public void setEffectiveTime(String effectiveTime) {
        this.effectiveTime = effectiveTime;
    }

    @JsonProperty("openfda")
    public Openfda getOpenfda() {
        return openfda;
    }

    @JsonProperty("openfda")
    public void setOpenfda(Openfda openfda) {
        this.openfda = openfda;
    }

    @JsonProperty("keep_out_of_reach_of_children")
    public List<String> getKeepOutOfReachOfChildren() {
        return keepOutOfReachOfChildren;
    }

    @JsonProperty("keep_out_of_reach_of_children")
    public void setKeepOutOfReachOfChildren(List<String> keepOutOfReachOfChildren) {
        this.keepOutOfReachOfChildren = keepOutOfReachOfChildren;
    }

    @JsonProperty("spl_product_data_elements")
    public List<String> getSplProductDataElements() {
        return splProductDataElements;
    }

    @JsonProperty("spl_product_data_elements")
    public void setSplProductDataElements(List<String> splProductDataElements) {
        this.splProductDataElements = splProductDataElements;
    }

    @JsonProperty("set_id")
    public String getSetId() {
        return setId;
    }

    @JsonProperty("set_id")
    public void setSetId(String setId) {
        this.setId = setId;
    }

    @JsonProperty("dosage_and_administration")
    public List<String> getDosageAndAdministration() {
        return dosageAndAdministration;
    }

    @JsonProperty("dosage_and_administration")
    public void setDosageAndAdministration(List<String> dosageAndAdministration) {
        this.dosageAndAdministration = dosageAndAdministration;
    }

    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    @JsonProperty("version")
    public void setVersion(String version) {
        this.version = version;
    }

    @JsonProperty("stop_use")
    public List<String> getStopUse() {
        return stopUse;
    }

    @JsonProperty("stop_use")
    public void setStopUse(List<String> stopUse) {
        this.stopUse = stopUse;
    }

    @JsonProperty("purpose")
    public List<String> getPurpose() {
        return purpose;
    }

    @JsonProperty("purpose")
    public void setPurpose(List<String> purpose) {
        this.purpose = purpose;
    }

    @JsonProperty("questions")
    public List<String> getQuestions() {
        return questions;
    }

    @JsonProperty("questions")
    public void setQuestions(List<String> questions) {
        this.questions = questions;
    }

    @JsonProperty("when_using")
    public List<String> getWhenUsing() {
        return whenUsing;
    }

    @JsonProperty("when_using")
    public void setWhenUsing(List<String> whenUsing) {
        this.whenUsing = whenUsing;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("indications_and_usage")
    public List<String> getIndicationsAndUsage() {
        return indicationsAndUsage;
    }

    @JsonProperty("indications_and_usage")
    public void setIndicationsAndUsage(List<String> indicationsAndUsage) {
        this.indicationsAndUsage = indicationsAndUsage;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
