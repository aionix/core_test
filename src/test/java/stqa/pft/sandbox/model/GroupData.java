package stqa.pft.sandbox.model;

public class GroupData {
    private  String name;
    private  String header;
    private  String footer;

    public String getName() {
        return name;
    }
    public String getHeader() {
        return header;
    }
    public String getFooter() {
        return footer;
    }

    public GroupData withName(String name) {
        this.name = name;
        return this;
    }
    public GroupData withHeader(String header) {
        this.header = header;
        return  this;
    }
    public GroupData withFooter(String footer) {
        this.footer = footer;
        return  this;
    }

    @Override
    public String toString() {
        return "GroupData{" +
                "name='" + name + '\'' +
                ", header='" + header + '\'' +
                ", footer='" + footer + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroupData groupData = (GroupData) o;

        if (getName() != null ? !getName().equals(groupData.getName()) : groupData.getName() != null) return false;
        if (getHeader() != null ? !getHeader().equals(groupData.getHeader()) : groupData.getHeader() != null)
            return false;
        return getFooter() != null ? getFooter().equals(groupData.getFooter()) : groupData.getFooter() == null;
    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getHeader() != null ? getHeader().hashCode() : 0);
        result = 31 * result + (getFooter() != null ? getFooter().hashCode() : 0);
        return result;
    }
}
