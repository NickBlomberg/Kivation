package com.nickblomberg.kivation.models.responses;

import com.nickblomberg.kivation.models.Lender;

import java.util.List;

/**
 * Represents the response received by retrofit when requesting
 * one or more lenders from the Kiva API.
 *
 * @author Nick Blomberg
 */

public class LenderResponse {
    private List<Lender> lenders;

    public List<Lender> getLenders() {
        return lenders;
    }

    public void setLenders(List<Lender> lenders) {
        this.lenders = lenders;
    }

    @Override
    public String toString() {
        return "LenderResponse{" +
                "lenders=" + lenders +
                '}';
    }
}
