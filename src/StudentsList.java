    public class StudentsList {
        private Students[] list;
        private int listIndex=0;

        public StudentsList(){
            list=new Students[1000];
        }

        public StudentsList(int listNum) {
            list=new Students[listNum];
        }
        public void addStd(Students std){
            list[listIndex]=std;
            listIndex++;
        }
        public boolean isEmpty(Students[] list){
            if (listIndex==0)
                return true;
            else
                return false;
        }

        public  void addAll(int index,Students[] arr) {

            for (int i = 0; i < arr.length; i++) {
                addValue(index + i, arr[i]);
            }

        }

        public  void addValue(int indexOfValue, Students value) {
            listIndex++;
            for (int i = listIndex; i > 0; i--) {
                if (i > indexOfValue) {
                    list[i] = list[i-1];
                } else if (i == indexOfValue) {
                    list[indexOfValue] = value;
                }
            }

        }

        public void showList(){
            for (int i = 0; i < listIndex; i++) {
                System.out.println("fullname:"+list[i].getFullName()+" Id:"+list[i].getStudentId()+" nationalCode:"+list[i].getNationalCode()+" user:"+list[i].getStudentUser());
            }
        }

        public void remove(int index){

            for(int i=index;i<listIndex-1;i++){
                list[i]=list[i+1];
            }
            list[listIndex]=null;
            listIndex--;
        }

        public boolean contains(Students intNum){
            for (int i=0;i<listIndex;i++) {
                if(list[i]==intNum)
                    return true;
            }

            return false;
        }

        public void clear(){
            for (int i=0;i<listIndex;i++) {
                list[i]=null;
            }
            listIndex=0;
        }

        public Students[] getList() {
            return list;
        }

        public void setList(Students[] list) {
            this.list = list;
        }

        public int getListIndex() {
            return listIndex;
        }
    }


