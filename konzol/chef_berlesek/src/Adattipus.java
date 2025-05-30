import java.sql.Date;

public class Adattipus {
    public int uid;
    public int chefid;
    public Date startdate;
    public Date enddate;
    public Integer daily_rate;
    public String name;
    public String cuisine;
    
    public Adattipus(int uid, int chefid, Date startdate, Date enddate, Integer daily_rate, String name, String cuisine) {
        this.uid = uid;
        this.chefid = chefid;
        this.startdate = startdate;
        this.enddate = enddate;
        this.daily_rate = daily_rate;
        this.name = name;
        this.cuisine = cuisine;
    }

    public int getUid() {
        return uid;
    }
    public void setUid(int uid) {
        this.uid = uid;
    }
    public int getChefid() {
        return chefid;
    }
    public void setChefid(int chefid) {
        this.chefid = chefid;
    }
    public Date getStartdate() {
        return startdate;
    }
    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }
    public Date getEnddate() {
        return enddate;
    }
    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }
    public Integer getDaily_rate() {
        return daily_rate;
    }
    public void setDaily_rate(Integer daily_rate) {
        this.daily_rate = daily_rate;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCuisine() {
        return cuisine;
    }
    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public Adattipus(String string){
        String[] parts = string.split(",");
        this.uid = Integer.parseInt(parts[0]);
        this.chefid = Integer.parseInt(parts[1]);
        this.startdate = Date.valueOf(parts[2]);
        this.enddate = Date.valueOf(parts[3]);
        this.daily_rate = Integer.parseInt(parts[4]);
        this.name = parts[5];
        this.cuisine = parts[6];
    }
    
}
