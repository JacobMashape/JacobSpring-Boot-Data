package com.psybergate.spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Audit {

    @Id
    @GeneratedValue
    private long auditID;

    private String name;

    private String review;

    public Audit() {
    }

    public Audit(String name, String review) {
        this.name = name;
        this.review = review;
    }

    public long getAuditID() {
        return auditID;
    }

    public void setAuditID(long auditID) {
        this.auditID = auditID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}
