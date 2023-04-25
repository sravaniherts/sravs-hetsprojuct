/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author SHOOT
 */
import java.util.ArrayList;
import java.util.List;

public class Booking {
    private static List<String[]> bookingList = new ArrayList<>();
    

    public static boolean bookLesson(String userId, String userName, String lessonName, String shift, int week, double price) {
        List<FitnessLesson> fitnessLessons = FitnessLesson.getFitnessLessons();
        
        
        // find the lesson with the given name, shift, and week
        FitnessLesson lesson = null;
        for (FitnessLesson fitnessLesson : fitnessLessons) {
            if (fitnessLesson.getName().equals(lessonName) && fitnessLesson.getShift().equals(shift) && fitnessLesson.getWeek() == week) {
                lesson = fitnessLesson;
                break;
            }
        }
        
        if (lesson == null) {
            // lesson not found
            return false;
        }
        
        if (lesson.getCapacity() == 0) {
            // capacity filled
            return false;
        }
        
        // decrement capacity
        lesson.setCapacity(lesson.getCapacity() - 1);
        
        // add booking
        String[] booking = new String[] { userId, userName, lessonName, shift, Integer.toString(week), Double.toString(price) };
        bookingList.add(booking);
        
        return true;
    }
    
    public static boolean deleteBooking(String userId, String lessonName, String shift, int week) {
        // find the booking with the given user id, lesson name, shift, and week
        String[] bookingToRemove = null;
        for (String[] booking : bookingList) {
            if (booking[0].equals(userId) && booking[2].equals(lessonName) && booking[3].equals(shift) && booking[4].equals(Integer.toString(week))) {
                bookingToRemove = booking;
                break;
            }
        }
        
        if (bookingToRemove == null) {
            // booking not found
            return false;
        }
        
        // remove booking
        bookingList.remove(bookingToRemove);
        
        // increment capacity
        List<FitnessLesson> fitnessLessons = FitnessLesson.getFitnessLessons();
        for (FitnessLesson fitnessLesson : fitnessLessons) {
            if (fitnessLesson.getName().equals(lessonName) && fitnessLesson.getShift().equals(shift) && fitnessLesson.getWeek() == week) {
                fitnessLesson.setCapacity(fitnessLesson.getCapacity() + 1);
                break;
            }
        }
        
        return true;
    }
    public static List<String[]> getBookingList() {
    return bookingList;
}

    
    public static String[][] generateReport() {
    String[][] report = new String[12][3];
    
    for (int week = 1; week <= 12; week++) {
        int bookingsPerWeek = 0;
        double revenuePerWeek = 0;
        
        for (FitnessLesson lesson : FitnessLesson.getFitnessLessons()) {
            if (lesson.getWeek() == week) {
                for (String[] booking : Booking.getBookingList()) {
                    if (booking[2].equals(lesson.getName()) && booking[3].equals(lesson.getShift()) && booking[4].equals(Integer.toString(week))) {
                        bookingsPerWeek++;
                        revenuePerWeek += Double.parseDouble(booking[5]);
                    }
                }
            }
        }
        
        report[week-1][0] = "Week " + week;
        report[week-1][1] = Integer.toString(bookingsPerWeek);
        report[week-1][2] = Double.toString(revenuePerWeek);
    }
    
    return report;
}
    
    
    static {
        
        // Add some hardcoded bookings
        Booking.bookLesson("1", "Alice", "Yoga", "Morning", 1, 20.0);
Booking.bookLesson("2", "Bob", "Zumba", "Evening", 2, 25.0);
Booking.bookLesson("3", "Charlie", "Boxing", "Afternoon", 3, 30.0);
Booking.bookLesson("4", "David", "Pilates", "Morning", 4, 20.0);
Booking.bookLesson("5", "Eve", "Yoga", "Evening", 5, 20.0);
Booking.bookLesson("6", "Frank", "Zumba", "Morning", 6, 25.0);
Booking.bookLesson("7", "Grace", "Boxing", "Afternoon", 7, 30.0);
Booking.bookLesson("8", "Henry", "Pilates", "Evening", 8, 20.0);
Booking.bookLesson("9", "Ivy", "Yoga", "Morning", 9, 20.0);
Booking.bookLesson("10", "John", "Zumba", "Afternoon", 10, 25.0);
Booking.bookLesson("1", "Alice", "Pilates", "Evening", 3, 30.0);
Booking.bookLesson("2", "Bob", "CrossFit", "Morning", 5, 35.0);
Booking.bookLesson("3", "Charlie", "Spinning", "Evening", 7, 25.0);
Booking.bookLesson("4", "David", "Yoga", "Morning", 4, 20.0);
Booking.bookLesson("5", "Eve", "Boxing", "Evening", 2, 40.0);
Booking.bookLesson("6", "Frank", "Zumba", "Morning", 9, 25.0);
Booking.bookLesson("7", "Grace", "Pilates", "Evening", 1, 30.0);
Booking.bookLesson("8", "Henry", "CrossFit", "Morning", 10, 35.0);
Booking.bookLesson("9", "Ivy", "Yoga", "Morning", 8, 20.0);
Booking.bookLesson("10", "John", "Boxing", "Evening", 6, 40.0);


        
    }



}


