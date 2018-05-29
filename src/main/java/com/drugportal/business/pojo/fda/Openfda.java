
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
    "manufacturer_name",
    "unii",
    "product_type",
    "spl_set_id",
    "route",
    "generic_name",
    "brand_name",
    "product_ndc",
    "substance_name",
    "spl_id",
    "application_number",
    "is_original_packager",
    "package_ndc"
})
public class Openfda {

    @JsonProperty("manufacturer_name")
    private List<String> manufacturerName = null;
    @JsonProperty("unii")
    private List<String> unii = null;
    @JsonProperty("product_type")
    private List<String> productType = null;
    @JsonProperty("spl_set_id")
    private List<String> splSetId = null;
    @JsonProperty("route")
    private List<String> route = null;
    @JsonProperty("generic_name")
    private List<String> genericName = null;
    @JsonProperty("brand_name")
    private List<String> brandName = null;
    @JsonProperty("product_ndc")
    private List<String> productNdc = null;
    @JsonProperty("substance_name")
    private List<String> substanceName = null;
    @JsonProperty("spl_id")
    private List<String> splId = null;
    @JsonProperty("application_number")
    private List<String> applicationNumber = null;
    @JsonProperty("is_original_packager")
    private List<Boolean> isOriginalPackager = null;
    @JsonProperty("package_ndc")
    private List<String> packageNdc = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("manufacturer_name")
    public List<String> getManufacturerName() {
        return manufacturerName;
    }

    @JsonProperty("manufacturer_name")
    public void setManufacturerName(List<String> manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    @JsonProperty("unii")
    public List<String> getUnii() {
        return unii;
    }

    @JsonProperty("unii")
    public void setUnii(List<String> unii) {
        this.unii = unii;
    }

    @JsonProperty("product_type")
    public List<String> getProductType() {
        return productType;
    }

    @JsonProperty("product_type")
    public void setProductType(List<String> productType) {
        this.productType = productType;
    }

    @JsonProperty("spl_set_id")
    public List<String> getSplSetId() {
        return splSetId;
    }

    @JsonProperty("spl_set_id")
    public void setSplSetId(List<String> splSetId) {
        this.splSetId = splSetId;
    }

    @JsonProperty("route")
    public List<String> getRoute() {
        return route;
    }

    @JsonProperty("route")
    public void setRoute(List<String> route) {
        this.route = route;
    }

    @JsonProperty("generic_name")
    public List<String> getGenericName() {
        return genericName;
    }

    @JsonProperty("generic_name")
    public void setGenericName(List<String> genericName) {
        this.genericName = genericName;
    }

    @JsonProperty("brand_name")
    public List<String> getBrandName() {
        return brandName;
    }

    @JsonProperty("brand_name")
    public void setBrandName(List<String> brandName) {
        this.brandName = brandName;
    }

    @JsonProperty("product_ndc")
    public List<String> getProductNdc() {
        return productNdc;
    }

    @JsonProperty("product_ndc")
    public void setProductNdc(List<String> productNdc) {
        this.productNdc = productNdc;
    }

    @JsonProperty("substance_name")
    public List<String> getSubstanceName() {
        return substanceName;
    }

    @JsonProperty("substance_name")
    public void setSubstanceName(List<String> substanceName) {
        this.substanceName = substanceName;
    }

    @JsonProperty("spl_id")
    public List<String> getSplId() {
        return splId;
    }

    @JsonProperty("spl_id")
    public void setSplId(List<String> splId) {
        this.splId = splId;
    }

    @JsonProperty("application_number")
    public List<String> getApplicationNumber() {
        return applicationNumber;
    }

    @JsonProperty("application_number")
    public void setApplicationNumber(List<String> applicationNumber) {
        this.applicationNumber = applicationNumber;
    }

    @JsonProperty("is_original_packager")
    public List<Boolean> getIsOriginalPackager() {
        return isOriginalPackager;
    }

    @JsonProperty("is_original_packager")
    public void setIsOriginalPackager(List<Boolean> isOriginalPackager) {
        this.isOriginalPackager = isOriginalPackager;
    }

    @JsonProperty("package_ndc")
    public List<String> getPackageNdc() {
        return packageNdc;
    }

    @JsonProperty("package_ndc")
    public void setPackageNdc(List<String> packageNdc) {
        this.packageNdc = packageNdc;
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
