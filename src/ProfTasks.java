import java.util.Scanner;

public class ProfTasks {
    public void printProfMainMenu(Actions actions) {
        System.out.println("1.show my profile");
        System.out.println("2.insert student score");
        System.out.println("3.Sallary summary");
        System.out.println("4.exit");
        System.out.println("5.logout");

        System.out.println("select number as above:");
        Scanner scanner=new Scanner(System.in);
        int input=scanner.nextInt();
        scanner.nextLine();
        switch(input){
            case 1:
                showMyProfile(actions);
                break;
            case 2:
               insertScore(actions);
               break;
            case 3:
                System.out.println("enter year and term number as format: YYYY-Term");
               String term =scanner.nextLine();
                calulateSallary(term,actions);
                printProfMainMenu(actions);
                break;
            case 4:
                System.out.println("GoodBye");
                return;

            case 5:
                actions.doLogout();
                break;
            default:
                System.out.println("wrong input, try again");
                break;
        }

    }

    public void insertScore(Actions actions) {
        for (int i = 0; i < actions.getProfessorsList().getListIndex(); i++) {
            for (int j = 0; j < actions.getCourseTakenList().getListIndex(); j++) {
                if (actions.getCourseTakenList().getList()[j].getProfId().equals(actions.getProfessorsList().getList()[i].getProfId())) {
                    System.out.println("courseId:"+actions.getCourseTakenList().getList()[j].getCourseId()+" studentId:"+actions.getCourseTakenList().getList()[j].getStudentId()+" profId:"+actions.getCourseTakenList().getList()[j].getProfId());

                }
            }
        }
        System.out.println("to Isert or edit Score, enter: courseId/studentId/score");
        Scanner scanner=new Scanner(System.in);
        String[] input =scanner.nextLine().split("/");
        if(input.length!=3) {
            System.out.println("wrong command");
            insertScore(actions);
        }
        boolean insrt=false;
        for (int i = 0; i < actions.getCourseTakenList().getListIndex(); i++) {
            if(actions.getCourseTakenList().getList()[i].getCourseId().equals(input[0]) && actions.getCourseTakenList().getList()[i].getStudentId().equals(input[1])){
                actions.getCourseTakenList().getList()[i].setScore(Double.parseDouble(input[2]));
                insrt=true;
            }
        }

        if(!insrt){
            System.out.println("wrong Id");
        } else {
            System.out.println("score is inserted.");
        }
        printProfMainMenu(actions);
        }


    public void showMyProfile(Actions actions) {
        for(int i=0;i<actions.getProfessorsList().getListIndex();i++){
            if(actions.getProfessorsList().getList()[i].getProfUser().equals(actions.getUser())){
                System.out.println("fullname:"+actions.getProfessorsList().getList()[i].getFullName()+" Id:"+actions.getProfessorsList().getList()[i].getProfId()+" nationalCode:"+actions.getProfessorsList().getList()[i].getNationalCode()+" user:"+actions.getProfessorsList().getList()[i].getProfUser());
            }
        }
        printProfMainMenu(actions);
    }

    public void calulateSallary(String term,Actions actions){
        Long sum=0L; Long slry = 0L;
        for (int i=0;i<actions.getProfessorsList().getListIndex();i++){
            if(actions.getProfessorsList().getList()[i].getProfUser().equals(actions.getUser())){
                for (int j=0;j<actions.getCoursesList().getListIndex();j++){
                    if(actions.getCoursesList().getList()[j].getProfId().equals(actions.getProfessorsList().getList()[i].getProfId()) && actions.getCoursesList().getList()[j].getTerm().equals(term) ){ //&& actions.getProfessorsList().getList()[i].getProfType().equals("f")
                        sum+=actions.getCoursesList().getList()[j].getCourseUnit();
                        if(actions.getProfessorsList().getList()[i].getProfType().equals("f")){slry=5000000L;}
                    }
                }
                System.out.println("Name:"+actions.getProfessorsList().getList()[i].getFullName()+" nationalCode:"+actions.getProfessorsList().getList()[i].getNationalCode()+" profId:"+actions.getProfessorsList().getList()[i].getProfId()+" term:"+term+" (sum of teaching unit in this term:)"+sum+" sallary:"+(sum*1000000+slry)+" Type:"+ actions.getProfessorsList().getList()[i].getProfType());
            }
        }
    }
}
