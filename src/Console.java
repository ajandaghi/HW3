import org.w3c.dom.ls.LSOutput;

import java.time.LocalDate;
import java.util.Scanner;

public class Console {
    public static void main(String[] args) {
     Actions actions=new Actions();
StudentsList a=new StudentsList();
        actions.setCurrentTerm("1400-2");

        actions.addStd(new Students("reza maleki","0060000001","1990-10-01","Tehran","201","test1","test1"));
        actions.addStd(new Students("javad taghavi","0060000004","1991-05-02","yazd","202","test2","test2"));



        actions.addProf(new Professors("iraj mansoori","0060000002","1960-11-11","Tehran","101","prof1","prof1","p"));
        actions.addProf(new Professors("reza ghalandari","0060000003","1970-11-11","Isfahan","102","prof2","prof2","f"));

        actions.addCourse(new Courses("Math1","501","101",3,"1400-1"));
        actions.addCourse(new Courses("Math2","502","102",4,"1400-2"));
        actions.addCourse(new Courses("Phys2","503","102",4,"1400-2"));


        actions.startProgram();


    }


}
