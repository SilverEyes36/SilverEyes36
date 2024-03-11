public class BlueRayDisk {
    public String title;
    public String director;
    public int yearOfRelease;
    public double cost;
    BlueRayDisk(String title, String director, int year, double cost){
        this.title = title;
        this.director = director;
        yearOfRelease = year;
        this.cost = cost;
    }
    @Override
    public String toString(){
        String s = "$"+cost+" "+yearOfRelease+" "+title+", "+director;
        return s;
    }
    public String getTitle(){
        return title;
    }

}
