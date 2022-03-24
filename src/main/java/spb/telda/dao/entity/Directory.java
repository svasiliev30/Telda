package spb.telda.dao.entity;

import org.springframework.stereotype.Component;

/**
 * Entity Региона
 * id - номер присвоенный региону в bd
 * regionIdentifier - идентификатор региона
 * name - нахвание региона
 * shortName - сокращенное наименование региона
 */
@Component
public class Directory {

    private String id;
    private int regionIdentifier;
    private String name;
    private String shortName;

    public Directory (){
    }

    public Directory(String id, int regionIdentifier, String name, String shortName) {
        this.id = id;
        this.regionIdentifier = regionIdentifier;
        this.name = name;
        this.shortName = shortName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getRegionIdentifier() {
        return regionIdentifier;
    }

    public void setRegionIdentifier(int regionIdentifier) {
        this.regionIdentifier = regionIdentifier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    @Override
    public String toString() {
        return "Directory{" +
                "id='" + id + '\'' +
                ", regionIdentifier=" + regionIdentifier +
                ", name='" + name + '\'' +
                ", shortName='" + shortName + '\'' +
                '}';
    }
}
