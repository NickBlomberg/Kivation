package com.nickblomberg.kivation.models;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import java.util.Date;
import java.util.List;

/**
 * The Loan model represents the data associated with a single loan made through Kiva.
 *
 * @see http://build.kiva.org/api#GET*|loans|:ids
 */
@Parcel(Parcel.Serialization.BEAN)
public class Loan {

    private String id;
    private String name;
    private Description description;
    private String status;

    @SerializedName("funded_amount")
    private String fundedAmount;

    private LoanImage image;
    private String activity;
    private String sector;
    private List<String> themes;
    private String use;
    private Location location;

    @SerializedName("partner_id")
    private int partnerID;

    private String translator;

    @SerializedName("posted_date")
    private Date postedDate;

    @SerializedName("planned_expiration_date")
    private Date plannedExpirationDate;

    @SerializedName("loan_amount")
    private String loanAmount;

    @SerializedName("lender_count")
    private int lenderCount;

    @SerializedName("paid_amount")
    private String paidAmount;

    private Tags tags;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFundedAmount() {
        return fundedAmount;
    }

    public void setFundedAmount(String fundedAmount) {
        this.fundedAmount = fundedAmount;
    }

    public LoanImage getImage() {
        return image;
    }

    public void setImage(LoanImage image) {
        this.image = image;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public List<String> getThemes() {
        return themes;
    }

    public void setThemes(List<String> themes) {
        this.themes = themes;
    }

    public String getUse() {
        return use;
    }

    public void setUse(String use) {
        this.use = use;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public int getPartnerID() {
        return partnerID;
    }

    public void setPartnerID(int partnerID) {
        this.partnerID = partnerID;
    }

    public String getTranslator() {
        return translator;
    }

    public void setTranslator(String translator) {
        this.translator = translator;
    }

    public Date getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(Date postedDate) {
        this.postedDate = postedDate;
    }

    public Date getPlannedExpirationDate() {
        return plannedExpirationDate;
    }

    public void setPlannedExpirationDate(Date plannedExpirationDate) {
        this.plannedExpirationDate = plannedExpirationDate;
    }

    public String getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(String loanAmount) {
        this.loanAmount = loanAmount;
    }

    public int getLenderCount() {
        return lenderCount;
    }

    public void setLenderCount(int lenderCount) {
        this.lenderCount = lenderCount;
    }

    public String getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(String paidAmount) {
        this.paidAmount = paidAmount;
    }

    public Tags getTags() {
        return tags;
    }

    public void setTags(Tags tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description=" + description +
                ", status='" + status + '\'' +
                ", fundedAmount='" + fundedAmount + '\'' +
                ", image=" + image +
                ", activity='" + activity + '\'' +
                ", sector='" + sector + '\'' +
                ", themes=" + themes +
                ", use='" + use + '\'' +
                ", location=" + location +
                ", partnerID=" + partnerID +
                ", translator='" + translator + '\'' +
                ", postedDate=" + postedDate +
                ", plannedExpirationDate=" + plannedExpirationDate +
                ", loanAmount='" + loanAmount + '\'' +
                ", lenderCount=" + lenderCount +
                ", paidAmount='" + paidAmount + '\'' +
                ", tags=" + tags +
                '}';
    }
}
