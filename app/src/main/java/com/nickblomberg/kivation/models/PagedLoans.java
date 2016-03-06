package com.nickblomberg.kivation.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * A single page of data containing a list of 20 loans.
 *
 * @see http://build.kiva.org/docs/conventions/paging
 */
public class PagedLoans {

    private Paging paging;
    private List<Loan> loans = new ArrayList<Loan>();

    public PagedLoans() {
        loans = new Vector<>();
    }

    public List<Loan> getLoans() {
        return this.loans;
    }

}
