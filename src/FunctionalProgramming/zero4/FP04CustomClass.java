package FunctionalProgramming.zero4;


import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Course {
    private String name;
    private String category;
    private int reviewScore;
    private int noOfStudents;


    public Course(String name, String category, int reviewScore, int noOfStudents) {
        this.name = name;
        this.category = category;
        this.reviewScore = reviewScore;
        this.noOfStudents = noOfStudents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getReviewScore() {
        return reviewScore;
    }

    public void setReviewScore(int reviewScore) {
        this.reviewScore = reviewScore;
    }

    public int getNoOfStudents() {
        return noOfStudents;
    }

    public void setNoOfStudents(int noOfStudents) {
        this.noOfStudents = noOfStudents;
    }

    public String toString(){
        return name + ":" + noOfStudents + ":" + reviewScore;
    }
}

public class FP04CustomClass {

    public static void main(String[] args) {
        List<Course> courses = Arrays.asList(new Course("Spring","Framework",98,20000),
                new Course("API","Microservices",96,22000),
                new Course("Microservices","Microservices",91,25000),
                new Course("FullStack","FullStack",91,14000),
                new Course("AWS","Cloud",92,21000),
                new Course("Azure","Cloud",99,21000),
                new Course("Docker","Cloud",92,20000),
                new Course("Kubernetes","Cloud",91,20000)
        );

        // allMatch , noneMatch, anyMatch(if 1 course matches the predicate it will return true)
        Predicate<Course> reviewScoreGreaterThan95Predicate = course -> course.getReviewScore() > 95;

        Predicate<Course> reviewScoreGreaterThan90Predicate = course -> course.getReviewScore() > 90;

        Predicate<Course> reviewScoreLessThan90Predicate = course -> course.getReviewScore() < 90;


        System.out.println(courses.stream().allMatch(reviewScoreGreaterThan95Predicate));

        System.out.println(courses.stream().noneMatch(reviewScoreLessThan90Predicate));

        System.out.println(courses.stream().anyMatch(reviewScoreLessThan90Predicate));

        Comparator<Course> comparingByNoOfStudents = Comparator
                .comparing(Course::getNoOfStudents).reversed();

        System.out.println(courses.stream()
                .sorted(comparingByNoOfStudents).collect(Collectors.toList()));

    }
}
