/* YOUR FULL NAME HERE
[CS2401 - SP24]
This work is to be done individually. It is not permitted to share, reproduce, or alter any part of this
assignment for any purpose. Students are not permitted from sharing code, uploading this
assignment online in any form, or viewing/receiving/modifying code written from anyone else. This
assignment is part of an academic course at The University of Texas at El Paso and a grade will be
assigned for the work produced individually by the student. */
import java.util.Arrays;

class Lab7_Salamah{
    public static void main(String[] args) {
        Airplane[] airplanes = createAirplaneArray();
        System.out.println("-----------------------------------------------------");
        System.out.println("The number of airplanes in the array: " + airplanes.length);
        System.out.println("Printing the Airplane information");
        showAirplaneInfo(airplanes);
        System.out.println("-----------------------------------------------------");
        System.out.println("Linear Search on the array based on ID");
        System.out.println("-----------------------------------------------------");

        int ID = 123;
        LinearSearchID(airplanes, ID);

        ID = 373;
        LinearSearchID(airplanes, ID);

        ID = 926;
        LinearSearchID(airplanes, ID);
        System.out.println("-----------------------------------------------------");
        System.out.println("Iterative Binary Search based on ID");
        System.out.println("-----------------------------------------------------");

        ID = 123;
        IterativeBSID(airplanes, ID);
        System.out.println();

        ID = 373;
        IterativeBSID(airplanes, ID);

        ID = 926;
        IterativeBSID(airplanes, ID);

        System.out.println("-----------------------------------------------------");
        System.out.println("Recursive Binary Search based on ID");
        System.out.println("-----------------------------------------------------");

        ID = 123;
        RecursiveBSID(airplanes, ID);
        System.out.println();

        ID = 373;
        RecursiveBSID(airplanes, ID);

        ID = 926;
        RecursiveBSID(airplanes, ID);


        System.out.println("-----------------------------------------------------");
        System.out.println("Linear Search based on Capacity");
        System.out.println("-----------------------------------------------------");
        int LSCapacity = 32;
        LSisAvailable(airplanes, LSCapacity);

        System.out.println();
        LSCapacity = 64;
        LSisAvailable(airplanes, LSCapacity);

        System.out.println("-----------------------------------------------------");
        System.out.println("Binary Search based on Capacity");
        System.out.println("-----------------------------------------------------");

        int BSCapacity = 32;
        BSisAvailable(airplanes, BSCapacity);
        System.out.println();

        int BSCapacityTwo = 64;
        BSisAvailable(airplanes, BSCapacityTwo);
        System.out.println("-----------------------------------------------------");

    }

    /**
     * Change the body of this method to find the position based on ID
     * The method must use Binary Search in an iterative format
     * 
     * @param airplanes
     * @param BSID
     * @return -1 if possition not found
     * @return position if found
     */

    static int IterativeBSID(Airplane[] airplanes, int BSID) {
        int left=0;
        int right=airplanes.length-1;
        while(right>=left){
            int mid=(right+left)/2;
            if(BSID<airplanes[mid].getID()){
                right=mid-1;
            } else if( BSID==airplanes[mid].getID()){
                System.out.println("Airplane in position "+mid+" has an ID of: "+BSID+".");
                System.out.println(airplanes[mid].toString());
                return mid;
            } else {
                left=mid+1;
            }
        }
        System.out.println("No airplane with ID "+BSID+" found.");
        return -1;
    }

    /**
     * Change the body of this method to find the position based on capacity
     * The method must use Binary Search in a recursive format
     * 
     * @param airplanes
     * @param RBID
     * @return -1 if possition not found
     * @return position if found
     */
    static int RecursiveBSID(Airplane[] airplanes, int RBID){
        System.out.println("I have not implemented this method yet");
        return -1;
    }


    /**
     * Change the body of this method to find the position based on ID
     * The method must use linear Search
     * 
     * @param airplanes
     * @param LSID
     * @return -1 if possition not found
     * @return position if found
     */
    static int LinearSearchID(Airplane[] airplanes, int LSID) {
        for(int i=0;i<airplanes.length;i++){
            if(airplanes[i].getID()==LSID){
                System.out.println("Airplane in position "+i+" has an ID of: "+LSID+".");
                System.out.println(airplanes[i].toString());
                return i;
            }
        }
        System.out.println("No airplane with ID "+LSID+" found.");
        return -1;
    }


    /*
     * Use this method to obtain the capacities and sort them using Arrays.sort()
     */
    static int[] SortbyCapacity (Airplane[] airplanes){
        int[] capacities=new int[airplanes.length];
        for(int i=0;i<airplanes.length;i++){
            capacities[i]=airplanes[i].getCapacity();
        }
        Arrays.sort(capacities);
        return capacities;
    }

    /*
     * Search for a capacity using linear search
     * If the airplane is not found suggest next airplane with bigger capacity
     */
    static int LSisAvailable (Airplane[] airplanes, int LSCapacity){
        for(int i=0;i<airplanes.length;i++){
            if(airplanes[i].getCapacity()==LSCapacity){
                System.out.println("Airplane with capacity "+LSCapacity+" found at position "+i+".");
                return i;
            }
        }

        int difference=airplanes[0].getCapacity();
        int nextCap=0;
        int pos=0;
        for(int i=0;i<airplanes.length;i++){
            if(airplanes[i].getCapacity()>LSCapacity){
                if((airplanes[i].getCapacity()-LSCapacity)<difference){
                    pos=i;
                    nextCap=airplanes[i].getCapacity();
                    difference=airplanes[i].getCapacity()-LSCapacity;
                }
            }
        }
        System.out.println("Airplane with capacity "+LSCapacity+" not found.");
        System.out.println("Airplane with next bigger capacity: "+nextCap);
        return pos;
    }
    

    /*
     * Search for a capacity using binary search
     * If the airplane is not found suggest next airplane with bigger capacity
     */
    static int BSisAvailable(Airplane[] airplanes, int BSCapacity){
        int [] sortedAirplanes= SortbyCapacity(airplanes);
        int left=0;
        int right=sortedAirplanes.length-1;
        while(right>=left){
            int mid=(right+left)/2;
            if(BSCapacity<sortedAirplanes[mid]){
                right=mid-1;
            } else if(BSCapacity==sortedAirplanes[mid]){
                System.out.println("Airplane with capacity "+BSCapacity+" found at position "+mid);
                return mid;
            } else if(BSCapacity>sortedAirplanes[mid]){
                    int nextCap=sortedAirplanes[mid-1];
                    System.out.println("Airplane with capacity "+BSCapacity+" not found.");
                    System.out.println("Airplane with next bigger capacity: "+nextCap);
                    return mid-1;
            }else{
                left=mid+1;
            }
        }

        return -1;
        
        // int difference=sortedAirplanes[0];
        // int nextCap=0;
        // int pos=0;
        // if(right>=0 && right <sortedAirplanes.length){
        //     nextCap=sortedAirplanes[right];
        //     System.out.println("Airplane with capacity "+BSCapacity+" not found.");
        //     System.out.println("Airplane with next bigger capacity: "+nextCap);
        //     return nextCap;
        // } 

        // return -1;
        
    }


    /*
     * Method used to print
     * 
     */
    static void showAirplaneInfo(Airplane[] allAirplane) {
        for (int i = 0; i < allAirplane.length; i++) {
            System.out.println(allAirplane[i].toString());
        }
    }

    static Airplane[] createAirplaneArray() {
        Airplane[] newAirplane = {
                new Airplane(111, "Boeing 747", 20, 920, 2300),
                new Airplane(123, "Boeing 737", 32, 900, 2030),
                new Airplane(222, "Cessna 172", 42, 1600, 2200),
                new Airplane(334, "Boeing 777", 40, 600, 2015),
                new Airplane(333, "Boeing 787", 70, 830, 2230),
                new Airplane(365, "Boeing 717", 58, 720, 2005),
                new Airplane(748, "Airbus A350", 63, 1000, 2050),
                new Airplane(765, "Airbus A380", 35, 500, 2030),
                new Airplane(900, "Airbus A330", 55, 700, 2030),
                new Airplane(926, "Airbus A320", 60, 1610, 2230),
        };
        return newAirplane;
    }
}