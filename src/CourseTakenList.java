public class CourseTakenList {
        private CourseTaken[] list;



        private int listIndex=0;
        public CourseTakenList(){
            list=new CourseTaken[1000];
        }

        public CourseTakenList(int listNum) {
            list=new CourseTaken[listNum];
        }
        public void addCrsTkn(CourseTaken rslt){
            list[listIndex]=rslt;
            listIndex++;
        }
        public boolean isEmpty(CourseTaken[] list){
            if (listIndex==0)
                return true;
            else
                return false;
        }

        public  void addAll(int index, CourseTaken[] arr) {

            for (int i = 0; i < arr.length; i++) {
                addValue(index + i, arr[i]);
            }

        }

        public  void addValue(int indexOfValue, CourseTaken value) {
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
                System.out.print(list[i]+" ");
            }
            System.out.println();
        }

        public void remove(int index){

            for(int i=index;i<listIndex-1;i++){
                list[i]=list[i+1];
            }
            list[listIndex]=null;
            listIndex--;
        }

        public boolean contains(CourseTaken intNum){
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

        public int getListIndex() {
            return listIndex;
        }

    public CourseTaken[] getList() {
        return list;
    }

    public void setList(CourseTaken[] list) {
        this.list = list;
    }
}




