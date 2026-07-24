package com.example.loan.model;

public class Loan {
    private Long id;
    private String loanNumber;
    private String loanType;
    private Double amount;
    private Double interestRate;
    private Integer termMonths;
    private String customerName;
    private String status;

    public Loan() {}

    public Loan(Long id, String loanNumber, String loanType, Double amount,
                Double interestRate, Integer termMonths, String customerName) {
        this.id = id;
        this.loanNumber = loanNumber;
        this.loanType = loanType;
        this.amount = amount;
        this.interestRate = interestRate;
        this.termMonths = termMonths;
        this.customerName = customerName;
        this.status = "ACTIVE";
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getLoanNumber() { return loanNumber; }
    public void setLoanNumber(String loanNumber) { this.loanNumber = loanNumber; }

    public String getLoanType() { return loanType; }
    public void setLoanType(String loanType) { this.loanType = loanType; }

    public Double getAmount() { return amount; }
    public void setAmount(Double amount) { this.amount = amount; }

    public Double getInterestRate() { return interestRate; }
    public void setInterestRate(Double interestRate) { this.interestRate = interestRate; }

    public Integer getTermMonths() { return termMonths; }
    public void setTermMonths(Integer termMonths) { this.termMonths = termMonths; }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
