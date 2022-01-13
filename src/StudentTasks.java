import java.util.Scanner;
public class StudentTasks {
private int courseNum=0;


    public void printStudentMainMenu(Actions actions) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1.Show my Profile");
        System.out.println("2.Show and Select available Courses");
        System.out.println("3.show selected Courses");
        System.out.println("4.exit");
        System.out.println("5.logout");
        System.out.println("enter number of what you want to do:");
        int input = scanner.nextInt();
        switch (input) {
            case 1:
                showMyProfile(actions);
                break;
            case 2:
                showCurrentCourses(actions);
                break;
            case 3:
                showSelectedCourses(actions);
                break;

            case 4:
                System.out.println("GoodBye");
                return;
            case 5:
                actions.doLogout();
                break;
            default:
                System.out.println("wrong Input, enter correct number");
                printStudentMainMenu(actions);

        }


    }

    private void showCurrentCourses(Actions actions) {
       for(int i=0;i<actions.getCoursesList().getListIndex();i++)  {
             if(actions.getCoursesList().getList()[i].getTerm().equals(actions.getCurrentTerm())){
                 System.out.println("id:"+ actions.getCoursesList().getList()[i].getCourseId()+" name:"+actions.getCoursesList().getList()[i].getCourseName()+" unit:"+actions.getCoursesList().getList()[i].getCourseUnit()+" term:"+actions.getCoursesList().getList()[i].getTerm()+" profId:"+actions.getCoursesList().getList()[i].getProfId());

             }
        }
        System.out.println("enter course Id you want select:");
        selectCourse(actions);
    }

    private void showMyProfile(Actions actions) {
        for(int i=0;i<actions.getStudentsList().getListIndex();i++){
            if(actions.getStudentsList().getList()[i].getStudentUser().equals(actions.getUser())){
                System.out.println("fullname:"+actions.getStudentsList().getList()[i].getFullName()+" Id:"+actions.getStudentsList().getList()[i].getStudentId()+" nationalCode:"+actions.getStudentsList().getList()[i].getNationalCode()+" user:"+actions.getStudentsList().getList()[i].getStudentUser());
            }
        }
        printStudentMainMenu(actions);
    }

    private double prevTermAverage(Actions actions){
        String[] crntTerm=actions.getCurrentTerm().split("-");
        String  prevTerm="";
        if(crntTerm[1].equals("2")){
            prevTerm=crntTerm[0]+"1";
        } else {
            prevTerm=(Integer.parseInt(crntTerm[0])-1)+"2";
        }

        double sum=-1;
        for(int i=0;i<actions.getCoursesList().getListIndex();i++)  {
            if(actions.getCoursesList().getList()[i].getTerm().equals(prevTerm)){
                sum=+actions.getCourseTakenList().getList()[i].getScore();
            }
        }

        System.out.println(sum);
        return sum;
        }

        public void selectCourse(Actions actions){
        Scanner scanner=new Scanner(System.in);
        String input=scanner.nextLine();
            for(int i=0;i<actions.getCoursesList().getListIndex();i++) {
                boolean rep=false;
                if (actions.getCoursesList().getList()[i].getCourseId().equals(input)) {
                    for (int j = 0; j < actions.getCourseTakenList().getListIndex(); j++) {

                        if (actions.getCourseTakenList().getList()[j].getCourseId().equals(actions.getCoursesList().getList()[i].getCourseId())) {
                            rep = true;
                            System.out.println("this course before is selected.");
                            break;
                        }


                    }
                }


                    if ((prevTermAverage(actions) == -1 || prevTermAverage(actions) <= 18) && courseNum <= 20 &&!rep) {
                        actions.getCourseTakenList().addCrsTkn(new CourseTaken(input, getStdIdByUser(actions), actions.getCoursesList().getList()[i].getProfId()));
                        System.out.println(input + " added to your courses");
                        courseNum++;
                    } else if (prevTermAverage(actions) >= 18 && courseNum <= 20 &&!rep) {
                        actions.getCourseTakenList().addCrsTkn(new CourseTaken(input, getStdIdByUser(actions), actions.getCoursesList().getList()[i].getProfId()));
                        courseNum++;
                        System.out.println(input + " added to your courses");

                    } else if(!rep) {
                        System.out.println("yor limit is over!");
                    }

            }
            printStudentMainMenu(actions);

        }
        public void showSelectedCourses(Actions actions){
        for (int i=0;i<actions.getCourseTakenList().getListIndex();i++){
            System.out.println("course id:"+actions.getCourseTakenList().getList()[i].getCourseId()+" professorId:"+actions.getCourseTakenList().getList()[i].getProfId()+" Score:"+actions.getCourseTakenList().getList()[i].getScore());
        }
            printStudentMainMenu(actions);
        }

        public String getStdIdByUser(Actions actions) {
            for (int i = 0; i < actions.getStudentsList().getListIndex(); i++) {
                if (actions.getStudentsList().getList()[i].getStudentUser().equals(actions.getUser()))
                    return actions.getStudentsList().getList()[i].getStudentId();
            }
            return "";
        }

}


