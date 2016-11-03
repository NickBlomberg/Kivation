package com.nickblomberg.kivation.models;

import com.google.gson.annotations.SerializedName;

/**
 * A model to represent information available concerning the
 * individuals who are providing funds for the loans.
 *
 * @see https://api.kivaws.org/v1/my/lender.json
 * @author Nick Blomberg
 */

public class Lender {
    @SerializedName("lender_id")
    private String lenderId;
    private String name;
    private LoanImage image;

    @SerializedName("whereabouts")
    private String whereAbouts;

    @SerializedName("country_code")
    private String countryCode;

    @SerializedName("member_since")
    private String memberSince;

    @SerializedName("personal_url")
    private String personalUrl;

    private String occupation;

    @SerializedName("loan_because")
    private String loanBecause;

    @SerializedName("occupational_info")
    private String occupationalInfo;

    @SerializedName("loan_count")
    private int loanCount;

    @SerializedName("invitee_count")
    private int inviteeCount;

    public String getLenderId() {
        return lenderId;
    }

    public void setLenderId(String lenderId) {
        this.lenderId = lenderId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LoanImage getImage() {
        return image;
    }

    public void setImage(LoanImage image) {
        this.image = image;
    }

    public String getWhereAbouts() {
        return whereAbouts;
    }

    public void setWhereAbouts(String whereAbouts) {
        this.whereAbouts = whereAbouts;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getMemberSince() {
        return memberSince;
    }

    public void setMemberSince(String memberSince) {
        this.memberSince = memberSince;
    }

    public String getPersonalUrl() {
        return personalUrl;
    }

    public void setPersonalUrl(String personalUrl) {
        this.personalUrl = personalUrl;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getLoanBecause() {
        return loanBecause;
    }

    public void setLoanBecause(String loanBecause) {
        this.loanBecause = loanBecause;
    }

    public String getOccupationalInfo() {
        return occupationalInfo;
    }

    public void setOccupationalInfo(String occupationalInfo) {
        this.occupationalInfo = occupationalInfo;
    }

    public int getLoanCount() {
        return loanCount;
    }

    public void setLoanCount(int loanCount) {
        this.loanCount = loanCount;
    }

    public int getInviteeCount() {
        return inviteeCount;
    }

    public void setInviteeCount(int inviteeCount) {
        this.inviteeCount = inviteeCount;
    }

    @Override
    public String toString() {
        return "Lender{" +
                "lenderId='" + lenderId + '\'' +
                ", name='" + name + '\'' +
                ", image=" + image +
                ", whereAbouts='" + whereAbouts + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", memberSince='" + memberSince + '\'' +
                ", personalUrl='" + personalUrl + '\'' +
                ", occupation='" + occupation + '\'' +
                ", loanBecause='" + loanBecause + '\'' +
                ", occupationalInfo='" + occupationalInfo + '\'' +
                ", loanCount=" + loanCount +
                ", inviteeCount=" + inviteeCount +
                '}';
    }
}
