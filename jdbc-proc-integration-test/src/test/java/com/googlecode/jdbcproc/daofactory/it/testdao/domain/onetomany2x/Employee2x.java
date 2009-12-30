package com.googlecode.jdbcproc.daofactory.it.testdao.domain.onetomany2x;

import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import java.util.List;

/**
 * Employee for 2x tests
 */
public class Employee2x {

    /** Id */
    @Id
    @Column(name = "id")
    public long getId() { return theId; }
    public void setId(long aId) { theId = aId; }

    /** Firstname */
    @Column(name = "firstname")
    public String getFirstname() { return theFirstname; }
    public void setFirstname(String aFirstname) { theFirstname = aFirstname; }

    /** Lastname */
    @Column(name = "lastname")
    public String getLastname() { return theLastname; }
    public void setLastname(String aLastname) { theLastname = aLastname; }

    /** List of certificates */
    @OneToMany
    @JoinColumn(table = "certificate")
    public List<Certificate2x> getCertificates() { return theCertificates; }
    public void setCertificates(List<Certificate2x> aCertificates) { theCertificates = aCertificates; }

    /** List of certificates */
    private List<Certificate2x> theCertificates;

    /** Lastname */
    private String theLastname;
    /** Firstname */
    private String theFirstname;
    /** Id */
    private long theId;

}
