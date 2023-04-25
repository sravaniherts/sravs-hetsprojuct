
import java.util.ArrayList;
import java.util.List;

public class FitnessLesson {
    private String name;
    private String shift; // morning or evening
    private String day; // Saturday or Sunday
    private int week; // 1 to 10
    private double price;
    private int capacity;
    private double rating;
    
    public FitnessLesson(String name, String shift, String day, int week, double price, int capacity, double rating) {
        this.name = name;
        this.shift = shift;
        this.day = day;
        this.week = week;
        this.price = price;
        this.capacity = capacity;
        this.rating = rating;
    }
    
    // getters and setters
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getShift() {
        return shift;
    }
    
    public void setShift(String shift) {
        this.shift = shift;
    }
    
    public String getDay() {
        return day;
    }
    
    public void setDay(String day) {
        this.day = day;
    }
    
    public int getWeek() {
        return week;
    }
    
    public void setWeek(int week) {
        this.week = week;
    }
    
    public double getPrice() {
        return price;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    
    public int getCapacity() {
        return capacity;
    }
    
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    
    public double getRating() {
        return rating;
    }
    
    public void setRating(double rating) {
        this.rating = rating;
    }
    
    // methods for adding, editing, and deleting lessons
    
    public static List<FitnessLesson> getFitnessLessons() {
        List<FitnessLesson> fitnessLessons = new ArrayList<>();
        
        // add lessons for 10 weeks
        
        for (int week = 1; week <= 10; week++) {
            // Saturday lessons
            fitnessLessons.add(new FitnessLesson("SPIN", "Morning", "Saturday", week, 15.0, 5, 4.7));
            fitnessLessons.add(new FitnessLesson("YOGA", "Evening", "Saturday", week, 20.0, 5, 4.5));
            // Sunday lessons
            fitnessLessons.add(new FitnessLesson("BODYSCULPT", "Morning", "Sunday", week, 25.0, 5, 4.8));
            fitnessLessons.add(new FitnessLesson("ZUMBA", "Evening", "Sunday", week, 18.0, 5, 4.5));
        }
        
        return fitnessLessons;
    }
    
    public static void addLesson(FitnessLesson lesson) {
        List<FitnessLesson> fitnessLessons = getFitnessLessons();
        fitnessLessons.add(lesson);
    }
    
    public static void editLesson(FitnessLesson oldLesson, FitnessLesson newLesson) {
        List<FitnessLesson> fitnessLessons = getFitnessLessons();
        int index = fitnessLessons.indexOf(oldLesson);
        if (index != -1) {
            fitnessLessons.set(index, newLesson);
        }
    }
    
    public static void deleteLesson(FitnessLesson lesson) {
        List<FitnessLesson> fitnessLessons = getFitnessLessons();
        fitnessLessons.remove(lesson);
    }
    public static List<FitnessLesson> getFitnessLessonsByNameS(String SPIN) {
    List<FitnessLesson> fitnessLessons = getFitnessLessons();
    List<FitnessLesson> Sresult = new ArrayList<>();
    for (FitnessLesson lesson : fitnessLessons) {
        if (lesson.getName().equals(SPIN)) {
            Sresult.add(lesson);
        }
    }
    return Sresult;
}
    public static List<FitnessLesson> getFitnessLessonsByNameY(String YOGA) {
    List<FitnessLesson> fitnessLessons = getFitnessLessons();
    List<FitnessLesson> result = new ArrayList<>();
    for (FitnessLesson lesson : fitnessLessons) {
        if (lesson.getName().equals(YOGA)) {
            result.add(lesson);
        }
    }
    return result;
}
    public static List<FitnessLesson> getFitnessLessonsByNameB(String BODYSCULPT) {
    List<FitnessLesson> fitnessLessons = getFitnessLessons();
    List<FitnessLesson> Bresult = new ArrayList<>();
    for (FitnessLesson lesson : fitnessLessons) {
        if (lesson.getName().equals(BODYSCULPT)) {
            Bresult.add(lesson);
        }
    }
    return Bresult;
}
    public static List<FitnessLesson> getFitnessLessonsByNameZ(String ZUMBA) {
    List<FitnessLesson> fitnessLessons = getFitnessLessons();
    List<FitnessLesson> Zresult = new ArrayList<>();
    for (FitnessLesson lesson : fitnessLessons) {
        if (lesson.getName().equals(ZUMBA)) {
            Zresult.add(lesson);
        }
    }
    return Zresult;
}
    public static List<FitnessLesson> getFitnessLessonsByDaySAT(String Saturday) {
    List<FitnessLesson> fitnessLessons = getFitnessLessons();
    List<FitnessLesson> nresult = new ArrayList<>();
    for (FitnessLesson lesson : fitnessLessons) {
        if (lesson.getDay().equals(Saturday)) {
            nresult.add(lesson);
        }
    }
    return nresult;}
    public static List<FitnessLesson> getFitnessLessonsByDaySUN(String SUNDAY) {
    List<FitnessLesson> fitnessLessons = getFitnessLessons();
    List<FitnessLesson> nresult = new ArrayList<>();
    for (FitnessLesson lesson : fitnessLessons) {
        if (lesson.getDay().equals(SUNDAY)) {
            nresult.add(lesson);
        }
    }
    return nresult;}
    public static void rateLesson(String name, int week, double rating) {
    List<FitnessLesson> fitnessLessons = getFitnessLessons();
    for (FitnessLesson lesson : fitnessLessons) {
        if (lesson.getName().equals(name) && lesson.getWeek() == week) {
            double oldRating = lesson.getRating();
            int numRatings = fitnessLessons.size();
            double newRating = (oldRating * (numRatings - 1) + rating) / numRatings;
            lesson.setRating(newRating);
            break;
        }
    }
    
    
}

}









