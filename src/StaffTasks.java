import java.time.LocalDate;
import java.util.Scanner;
public class StaffTasks {


    public void printStaffMainMenu(Actions actions) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1.Students Tasks");
        System.out.println("2.Professor Tasks");
        System.out.println("3.Staffs Tasks");
        System.out.println("4.Course Tasks");
        System.out.println("5.Sallary Summary");
        System.out.println("6.exit");
        System.out.println("7.logout");
        System.out.println("enter number of what you want to do:");
        int input = scanner.nextInt();
        switch (input) {
            case 1:
                printSubmenu("students",actions);
                break;
            case 2:
                printSubmenu("professors",actions);
                break;
            case 3:
                printSubmenu("staffs",actions);
                break;
            case 4:
                printSubmenu("courses",actions);
                break;
            case 5:
                printSalarySummary(actions);
                break;
            case 6:
                System.out.println("GoodBye");
                return;
            case 7:
                actions.doLogout();
                break;
            default:
                System.out.println("wrong Input, enter correct number");
                printStaffMainMenu(actions);

        }

    }

    private void printSalarySummary(Actions actions) {
        for (int i=0;i<actions.getStaffsList().getListIndex();i++){
           if(actions.getStaffsList().getList()[i].getStaffUser().equals(actions.getUser())){
               System.out.println("name: "+actions.getStaffsList().getList()[i].getFullName()+" NatinalCode:"+actions.getStaffsList().getList()[i].getNationalCode()+" Year and  Month:"+LocalDate.now().getYear()+" "+LocalDate.now().getMonth()+" salary:"+actions.getStaffsList().getList()[i].getSalary());
               break;
           }
        }
        System.out.println();
        printStaffMainMenu(actions);
    }


    private void printSubmenu(String type,Actions actions){
        Scanner scanner = new Scanner(System.in);

        System.out.println("-1.return main menu");
        System.out.println("1.register new "+type);
        System.out.println("2.delete a "+ type);
        System.out.println("3.edit a " +type);
        System.out.println("4.show "+type);
        System.out.println("enter number of what you want to do:");

        String input = scanner.nextLine();

        doStaffAction(input,type,actions);
    }
    private void doStaffAction(String submenu,String type,Actions actions) {
        Scanner scanner = new Scanner(System.in);
        String[] inpCmd;
        switch (submenu) {
            case "-1":
                printStaffMainMenu(actions);
                break;
            case "1":
                if (type.equals("courses")) {
                    System.out.println("enter: name/id/profId/unit/term");
                    inpCmd = scanner.nextLine().split("/");
                    if (inpCmd.length != 5) {
                        System.out.println("enter in true format as above");
                        doStaffAction("1", type,actions);
                        return;
                    }
                    register(type, inpCmd,actions);
                    printSubmenu(type,actions);
                }else {
                        System.out.println("enter: fullName/nationalCod/birthdate(YY-MM-DD)/address/Id/User/Pass/staffSalary");
                        System.out.println("or enter: fullName/nationalCod/birthdate(YY-MM-DD)/address/Id/User/Pass/ProfessorType");
                       System.out.println("or enter: fullName/nationalCod/birthdate(YY-MM-DD)/address/Id/User/Pass");

                    inpCmd = scanner.nextLine().split("/");

                    if (inpCmd.length != 8 && inpCmd.length != 7) {
                        System.out.println("enter in true format as above");
                        doStaffAction("1", type,actions);
                        return;
                    }
                    register(type, inpCmd,actions);
                    printSubmenu(type,actions);
                }

                break;
            case "2":
                System.out.println("enter id to delete:");
                inpCmd= scanner.nextLine().split("/");
                remove(type,inpCmd[0],actions);
                printSubmenu(type,actions);
                break;

            case "3":
                if (type.equals("courses")) {
                    System.out.println("enter: oldId/name/id/profId/unit/term");
                    inpCmd = scanner.nextLine().split("/");
                    if (inpCmd.length != 6) {
                        System.out.println("enter in true format as above");
                        doStaffAction("3", type,actions);
                        return;
                    }
                    edit(type, inpCmd,actions);
                    printSubmenu(type,actions);
                }else {
                    System.out.println("enter: oldId/fullName/nationalCod/birthdate(YY-MM-DD)/address/Id/User/Pass/salary");
                    System.out.println("or enter: oldId/fullName/nationalCod/birthdate(YY-MM-DD)/address/Id/User/Pass/ProfessorType(f/p)");
                    System.out.println("or enter: oldId/fullName/nationalCod/birthdate(YY-MM-DD)/address/Id/User/Pass");

                    inpCmd = scanner.nextLine().split("/");

                    if (inpCmd.length != 9 && inpCmd.length != 8  ) {
                        System.out.println("enter in true format as below");
                        doStaffAction("3", type,actions);
                        return;
                    }
                    edit(type, inpCmd,actions);
                    printSubmenu(type,actions);
                }
                break;

            case "4":
                showList(type,actions);
                 break;
            default:
                System.out.println("wrong number");
                printStaffMainMenu(actions);
        }
    }

    private void showList(String type,Actions actions) {
    switch(type){
        case "students":
            actions.getStudentsList().showList();

            break;
        case "professors":
            actions.getProfessorsList().showList();
            break;
        case "staffs":
            actions.getStaffsList().showList();
            break;
        case "courses":
            actions.getCoursesList().showList();
            break;
    }
        printSubmenu(type,actions);
    }

    private void remove(String type, String id, Actions actions) {
        if (type.equals("students")) {
         actions.removeStd(id);
        } else if(type.equals("professors")){
            actions.removeProf(id);

        } else if(type.equals("staffs")){
            actions.removeStaff(id);

        } else if (type.equals("courses")){
            actions.removeCourse(id);

        } else{
            doStaffAction("2",type,actions );

        }
    }
    private void edit(String type, String[] cmd, Actions actions) {
        if (type.equals("students")) {
            if ((actions.getUserById(cmd[0],type).equals(cmd[6])) && (cmd[5].equals(cmd[0])) ) {
                actions.editStd(new Students(cmd[1], cmd[2], cmd[3], cmd[4], cmd[5], cmd[6], cmd[7]), cmd[0]);
            } else {
                if (!actions.isUserAvailabe(cmd[6], "students") && !cmd[5].equals(cmd[0])) {
                    System.out.println("new user is not available");
                    doStaffAction("3", type, actions);
                } else if (!actions.isIdAvailabe(cmd[5], "students") && !cmd[5].equals(cmd[0])) {
                    System.out.println("new Id is not available");
                    doStaffAction("3", type, actions);
                } else if ((!cmd[5].equals(cmd[0])&&actions.isIdAvailabe(cmd[5], "students")&&actions.isUserAvailabe(cmd[6], "students")) || (cmd[5].equals(cmd[0])&&actions.isUserAvailabe(cmd[6], "students")) ) {
                    actions.editStd(new Students(cmd[1], cmd[2], cmd[3], cmd[4], cmd[5], cmd[6], cmd[7]), cmd[0]);
                } else {
                    System.out.println("wrong id");

                    doStaffAction("3", type, actions);
                }
            }
        } else if (type.equals("professors")) {
            if (actions.getUserById(cmd[0],type).equals(cmd[6]) && (cmd[5].equals(cmd[0]))) {
                actions.editProf(new Professors(cmd[1], cmd[2], cmd[3], cmd[4], cmd[5], cmd[6], cmd[7], cmd[8]), cmd[0]);

            } else {
                if (!actions.isUserAvailabe(cmd[6] , "professors") && !cmd[5].equals(cmd[0])) {
                    System.out.println("new user is not available");
                    doStaffAction("3", type, actions);
                } else if (!actions.isIdAvailabe(cmd[5], "professors") && !cmd[5].equals(cmd[0])) {
                    System.out.println("new Id is not available");
                    doStaffAction("3", type, actions);
                } else if ((!cmd[5].equals(cmd[0])&&actions.isIdAvailabe(cmd[5], "professors")&&actions.isUserAvailabe(cmd[6], "professors")) || (cmd[5].equals(cmd[0])&&actions.isUserAvailabe(cmd[6], "professors")) ) {
                    actions.editProf(new Professors(cmd[1], cmd[2], cmd[3], cmd[4], cmd[5], cmd[6], cmd[7], cmd[8]), cmd[0]);
                } else {
                    System.out.println("wrong id");
                    doStaffAction("3", type, actions);
                }


            }
        } else if (type.equals("staffs")) {
            if (actions.getUserById(cmd[0],type).equals(cmd[6]) && (cmd[5].equals(cmd[0]))) {
                actions.editStaff(new Staffs(cmd[1], cmd[2], cmd[3], cmd[4], cmd[5], cmd[6], cmd[7], Long.parseLong(cmd[8])), cmd[0]);
            } else {
                if (!actions.isUserAvailabe(cmd[6], "staffs") && !cmd[5].equals(cmd[0])) {
                    System.out.println("new user is not available");
                    doStaffAction("3", type, actions);
                } else if (!actions.isIdAvailabe(cmd[5], "staffs") && !cmd[5].equals(cmd[0])) {
                    System.out.println("new Id is not available");
                    doStaffAction("3", type, actions);
                } else if ((!cmd[5].equals(cmd[0])&&actions.isIdAvailabe(cmd[5], "staffs")&&actions.isUserAvailabe(cmd[6], "staffs")) || (cmd[5].equals(cmd[0])&&actions.isUserAvailabe(cmd[6], "staffs")) ) {
                    actions.editStaff(new Staffs(cmd[1], cmd[2], cmd[3], cmd[4], cmd[5], cmd[6], cmd[7],Long.parseLong(cmd[8])), cmd[0]);


                } else {
                    System.out.println("wrong id");

                    doStaffAction("3", type, actions);
                }
            }
        } else if (type.equals("courses")) {
            if ((cmd[4].equals(cmd[0]))) {
                actions.editCourse(new Courses(cmd[1], cmd[2], cmd[3], Integer.getInteger(cmd[4]), cmd[5]), cmd[0]);
            } else {
                if (!actions.isIdAvailabe(cmd[4], "courses")) {
                    System.out.println("new Id is not available");
                    doStaffAction("3", type, actions);
                } else if (actions.isIdAvailabe(cmd[4], "courses")) {
                    actions.editCourse(new Courses(cmd[1], cmd[2], cmd[3], Integer.parseInt(cmd[4]), cmd[5]), cmd[0]);
                }
            }
        }
    }

    private void register(String type, String[] cmd,Actions actions) {
        if (type.equals("students")) {
            if (actions.isUserAvailabe(cmd[5], "students") && actions.isIdAvailabe(cmd[4], "students")) {
                actions.addStd(new Students(cmd[0], cmd[1], cmd[2], cmd[3], cmd[4], cmd[5], cmd[6]));
                System.out.println("successfully added!");
            }

            else {
                if(!actions.isUserAvailabe(cmd[5], "students")) {
                    System.out.println("user is not available");
                }
                else if (!actions.isIdAvailabe(cmd[4], "students")) {
                    System.out.println("id is not available");

                }
                doStaffAction("1", type,actions);
            }
        } else if(type.equals("professors")) {
            if (actions.isUserAvailabe(cmd[5], "professors") && actions.isIdAvailabe(cmd[4], "professors")) {

                actions.addProf(new Professors(cmd[0], cmd[1], cmd[2], cmd[3], cmd[4], cmd[5], cmd[6], cmd[7]));
                System.out.println("successfully addedd!");
            }
            else {
                if(!actions.isUserAvailabe(cmd[5], "professors")) {
                    System.out.println("user is not available");
                }
                else if (!actions.isIdAvailabe(cmd[4], "professors")) {
                    System.out.println("id is not available");

                }
                doStaffAction("1", type,actions);
            }
        }  else if(type.equals("staffs")) {
            if (actions.isUserAvailabe(cmd[5], "staffs") && actions.isIdAvailabe(cmd[4], "staffs")) {
                actions.addStaff(new Staffs(cmd[0], cmd[1], cmd[2], cmd[3], cmd[4], cmd[5], cmd[6], Long.parseLong(cmd[7])));
                System.out.println("successfully addedd!");
            }
            else {
                if(!actions.isUserAvailabe(cmd[5], "staffs")) {
                    System.out.println("user is not available");
                    doStaffAction("1", type,actions);

                }
                else if (!actions.isIdAvailabe(cmd[4], "staffs")) {
                    System.out.println("id is not available");
                    doStaffAction("1", type,actions);


                }
            }
        } else if(type.equals("courses")) {

            if (actions.isIdAvailabe(cmd[1], "courses")) {
                System.out.println(cmd[4]);
                actions.addCourse(new Courses(cmd[0], cmd[1], cmd[2], Integer.parseInt(cmd[3]), cmd[4]));
                System.out.println("successfully added!");
            }
            else {
                    System.out.println("id is not available");
                doStaffAction("1",type,actions);
            }
        }
    }


}
