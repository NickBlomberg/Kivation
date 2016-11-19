package com.nickblomberg.kivation.models.responses;

import com.nickblomberg.kivation.models.Loan;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * The response received by Retrofit when fetching a list of Loans.
 *
 * @see http://build.kiva.org/docs/conventions/paging
 */
public class LoansResponse {

    private List<Loan> loans = new ArrayList<Loan>();

    public LoansResponse() {
        loans = new Vector<>();
    }

    public List<Loan> getLoans() {
        return this.loans;
    }

}
