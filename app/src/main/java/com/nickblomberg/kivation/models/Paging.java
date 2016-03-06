package com.nickblomberg.kivation.models;

import com.google.gson.annotations.SerializedName;

/**
 * The data received from the Kiva API is limited using data paging. When requesting Loan data,
 * responses will contain 20 Loans per request.
 *
 * @see http://build.kiva.org/docs/conventions/paging
 */
public class Paging {

    @SerializedName("page")
    private long currentPage;

    @SerializedName("page_size")
    private int pageSize;

    @SerializedName("total")
    private long totalLoans;

    @SerializedName("pages")
    private long totalPages;

    public long getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(long currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotalLoans() {
        return totalLoans;
    }

    public void setTotalLoans(long totalLoans) {
        this.totalLoans = totalLoans;
    }

    public long getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(long totalPages) {
        this.totalPages = totalPages;
    }
}
