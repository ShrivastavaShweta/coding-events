package org.launchcode.codingevents.models;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Tag extends AbstractEntity{
    @Size(min=1, max=25, message = "name can be 1 to 25 characters long")
    @NotNull
    private String name;

    public Tag(String name) {
        this.name = name;
    }

    public Tag() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplayName(){
        return "#" + name + " ";
    }
}
