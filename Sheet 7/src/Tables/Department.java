/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tables;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Etaf Bilal
 */
@Entity
@Table(name = "department")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Department.findAll", query = "SELECT d FROM Department d")
    , @NamedQuery(name = "Department.findByDname", query = "SELECT d FROM Department d WHERE d.dname = :dname")
    , @NamedQuery(name = "Department.findByDnumer", query = "SELECT d FROM Department d WHERE d.dnumer = :dnumer")
    , @NamedQuery(name = "Department.findByMgrssn", query = "SELECT d FROM Department d WHERE d.mgrssn = :mgrssn")
    , @NamedQuery(name = "Department.findByMgrstartdate", query = "SELECT d FROM Department d WHERE d.mgrstartdate = :mgrstartdate")})
public class Department implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "Dname")
    private String dname;
    @Id
    @Basic(optional = false)
    @Column(name = "Dnumer")
    private Integer dnumer;
    @Basic(optional = false)
    @Column(name = "Mgr_ssn")
    private String mgrssn;
    @Basic(optional = false)
    @Column(name = "Mgr_start_date")
    @Temporal(TemporalType.DATE)
    private Date mgrstartdate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "department")
    private Set<DeptLocations> deptLocationsSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dnum")
    private Set<Project> projectSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dno")
    private Set<Employee> employeeSet;

    public Department() {
    }

    public Department(Integer dnumer) {
        this.dnumer = dnumer;
    }

    public Department(Integer dnumer, String dname, String mgrssn, Date mgrstartdate) {
        this.dnumer = dnumer;
        this.dname = dname;
        this.mgrssn = mgrssn;
        this.mgrstartdate = mgrstartdate;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public Integer getDnumer() {
        return dnumer;
    }

    public void setDnumer(Integer dnumer) {
        this.dnumer = dnumer;
    }

    public String getMgrssn() {
        return mgrssn;
    }

    public void setMgrssn(String mgrssn) {
        this.mgrssn = mgrssn;
    }

    public Date getMgrstartdate() {
        return mgrstartdate;
    }

    public void setMgrstartdate(Date mgrstartdate) {
        this.mgrstartdate = mgrstartdate;
    }

    @XmlTransient
    public Set<DeptLocations> getDeptLocationsSet() {
        return deptLocationsSet;
    }

    public void setDeptLocationsSet(Set<DeptLocations> deptLocationsSet) {
        this.deptLocationsSet = deptLocationsSet;
    }

    @XmlTransient
    public Set<Project> getProjectSet() {
        return projectSet;
    }

    public void setProjectSet(Set<Project> projectSet) {
        this.projectSet = projectSet;
    }

    @XmlTransient
    public Set<Employee> getEmployeeSet() {
        return employeeSet;
    }

    public void setEmployeeSet(Set<Employee> employeeSet) {
        this.employeeSet = employeeSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dnumer != null ? dnumer.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Department)) {
            return false;
        }
        Department other = (Department) object;
        if ((this.dnumer == null && other.dnumer != null) || (this.dnumer != null && !this.dnumer.equals(other.dnumer))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tables.Department[ dnumer=" + dnumer + " ]";
    }
    
}
