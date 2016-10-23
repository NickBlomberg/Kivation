package com.nickblomberg.kivation.models;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import java.util.Date;

/**
 * The Loan model represents the data associated with a single loan made through Kiva.
 *
 * @see http://build.kiva.org/api#GET*|loans|:ids
 */
@Parcel(Parcel.Serialization.BEAN)
public class Loan {

    private String id;
    private String name;
    private String status;
    private LoanImage image;
    private Location location;
    private String activity;
    private String sector;
    private String theme;
    private String use;
    private String translator;

    @SerializedName("funded_amount")
    private String fundedAmount;

    @SerializedName("paid_amount")
    private String paidAmount;

    @SerializedName("partner_id")
    private String partnerID;

    @SerializedName("posted_date")
    private Date postedDate;

    @SerializedName("loan_amount")
    private String loanAmount;

    @SerializedName("lender_count")
    private String lenderCount;

    @SerializedName("funded_date")
    private Date fundedDate;

    @SerializedName("paid_date")
    private Date paidDate;

    @Override
    public String toString() {
        return "Loan{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", image=" + image +
                ", location=" + location +
                ", activity='" + activity + '\'' +
                ", sector='" + sector + '\'' +
                ", theme='" + theme + '\'' +
                ", use='" + use + '\'' +
                ", translator='" + translator + '\'' +
                ", fundedAmount='" + fundedAmount + '\'' +
                ", paidAmount='" + paidAmount + '\'' +
                ", partnerID='" + partnerID + '\'' +
                ", postedDate=" + postedDate +
                ", loanAmount='" + loanAmount + '\'' +
                ", lenderCount='" + lenderCount + '\'' +
                ", fundedDate=" + fundedDate +
                ", paidDate=" + paidDate +
                '}';
    }

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

    public String getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(String paidAmount) {
        this.paidAmount = paidAmount;
    }

    public LoanImage getImage() {
        return image;
    }

    public void setImage(LoanImage image) {
        this.image = image;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
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

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getUse() {
        return use;
    }

    public void setUse(String use) {
        this.use = use;
    }

    public String getPartnerID() {
        return partnerID;
    }

    public void setPartnerID(String partnerID) {
        this.partnerID = partnerID;
    }

    public Date getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(Date postedDate) {
        this.postedDate = postedDate;
    }

    public String getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(String loanAmount) {
        this.loanAmount = loanAmount;
    }

    public String getLenderCount() {
        return lenderCount;
    }

    public void setLenderCount(String lenderCount) {
        this.lenderCount = lenderCount;
    }

    public Date getFundedDate() {
        return fundedDate;
    }

    public void setFundedDate(Date fundedDate) {
        this.fundedDate = fundedDate;
    }

    public Date getPaidDate() {
        return paidDate;
    }

    public void setPaidDate(Date paidDate) {
        this.paidDate = paidDate;
    }

    public String getTranslator() {
        return translator;
    }

    public void setTranslator(String translator) {
        this.translator = translator;
    }
}
