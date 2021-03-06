package com.googlecode.jdbcproc.daofactory.it.testdao.domain.onetomany2x;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

public class Grandfather {
    private String name;
    private List<Father> sons;

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany
    @JoinColumn(table = "son")
    public List<Father> getSons() {
        return sons;
    }

    public void setSons(List<Father> sons) {
        this.sons = sons;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Grandfather other = (Grandfather) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }
}
