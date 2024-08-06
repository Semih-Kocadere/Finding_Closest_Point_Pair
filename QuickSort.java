import java.awt.geom.Point2D;

public class QuickSort {


    /**
     * Default Contructor
     */
    public QuickSort() {
        //Empty constructor --- do nothing
    }

    /**
     * The main function that implements QuickSort
     *
     * @param arr        --> Array to be sorted
     * @param startIndex --> First index of arr[]
     * @param lastIndex  --> Last index of arr[]
     * @param orderBy    --> compareX or compareY
     *                   compareX: sort minimum to maximum arr[] by X point
     *                   compareY: sort minimum to maximum arr[] by Y point
     */
    public void sort(Point2D.Double[] arr, int startIndex, int lastIndex, String orderBy) {
        //Write your codes here
        if(orderBy.equals("compareX")){
            firstPartition(arr, startIndex, lastIndex);
        }
        else if(orderBy.equals("compareY")){
            secondPartition(arr, startIndex, lastIndex);
        }
        else{
            System.out.println("wrong_parameter or wrong_parameters");
        }
    }

    /**
     * A utility function to swap two elements
     *
     * @param arr --> Array to be sorted
     * @param i   --> first index
     * @param j   --> second index
     */
    private void swap(Point2D.Double[] arr, int i, int j) {
        //Write your codes here
        Point2D.Double temp;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        //Done.
    }

    /**
     * Get Median of 3 order by Point.X
     *
     * @param arr   --> Array to be sorted
     * @param left  --> First index of arr[]
     * @param right --> Last index of arr[]
     * @return
     */
    private Point2D.Double getMedianX(Point2D.Double[] arr, int left, int right) {
        //Write your codes here
        int middle = (left + right) / 2;
        //left & right are indices of the terms in array. so, right is directly the right most element in the array.

        // sort left, right, and middle using Get M;edian of 3
        if (arr[left].getX() > arr[middle].getX()) swap(arr, left, middle);
        if (arr[left].getX() > arr[right].getX())  swap(arr, left, right);
        if (arr[middle].getX() > arr[right].getX()) swap(arr, middle, right);

        swap(arr, middle, right-1); //Place the pivot in front of the last element of the array.
        return arr[right-1]; //Return the pivot.
    }

    /**
     * Get Median of 3 order by Point.Y
     *
     * @param arr   --> Array to be sorted
     * @param left  --> First index of arr[]
     * @param right --> Last index of arr[]
     * @return
     */
    private Point2D.Double getMedianY(Point2D.Double[] arr, int left, int right) {
        //Write your codes here
        int middle = (left + right) / 2;
        //left & right are indices of the terms in array. so, right is directly the right most element in the array.

        // sort left, right, and middle using Get Median of 3
        if (arr[left].getY() > arr[middle].getY()) swap(arr, left, middle);
        if (arr[left].getY() > arr[right].getY())  swap(arr, left, right);
        if (arr[middle].getY() > arr[right].getY()) swap(arr, middle, right);

        swap(arr, middle, right-1); //Place the pivot in front of the last element of the array.
        return arr[right-1]; //Return the pivot.
    }

    /**
     * This function takes median of three as pivot, places
     * the pivot element at the end of the sorted
     * array, and places all smaller (smaller than pivot)
     * to left of pivot and all greater elements to right of pivot
     * Sort order by Point.X
     *
     * @param arr        --> Array to be sorted
     * @param startIndex --> First index of arr[]
     * @param lastIndex  --> Last index of arr[]
     * @return pivot index
     */
    private int firstPartition(Point2D.Double[] arr, int startIndex, int lastIndex) {
        //Write your codes here
        if (lastIndex - startIndex < 3){
            int center = (lastIndex + startIndex) / 2;

            if (arr[startIndex].getX() > arr[center].getX()) swap(arr, startIndex, center);
            if (arr[startIndex].getX() > arr[lastIndex].getX()) swap(arr, startIndex, lastIndex);
            if (arr[center].getX() > arr[lastIndex].getX()) swap(arr, center, lastIndex);

            return center;
        }
        Point2D.Double pivot = getMedianX(arr, startIndex, lastIndex);
        int i = startIndex;
        int j = lastIndex-1;

        while (true) {
            while (arr[++i].getX() < pivot.getX());
            while (arr[--j].getX() > pivot.getX());
            if(i < j) swap(arr, i, j);
            else break;
        }
        swap(arr, i, lastIndex-1);

        firstPartition(arr, startIndex, i-1);
        firstPartition(arr, i+1, lastIndex);

        return i;
    }

    /**
     * This function takes median of three as pivot, places
     * the pivot element at the end of the sorted
     * array, and places all smaller (smaller than pivot)
     * to left of pivot and all greater elements to right of pivot
     * Sort order by Point.Y
     *
     * @param arr        --> Array to be sorted
     * @param startIndex --> First index of arr[]
     * @param lastIndex  --> Last index of arr[]
     * @return pivot index
     */
    private int secondPartition(Point2D.Double[] arr, int startIndex, int lastIndex) {

        if (lastIndex - startIndex < 3){
            int center = (lastIndex + startIndex) / 2;

            if (arr[startIndex].getY() > arr[center].getY()) swap(arr, startIndex, center);
            if (arr[startIndex].getY() > arr[lastIndex].getY()) swap(arr, startIndex, lastIndex);
            if (arr[center].getY() > arr[lastIndex].getY()) swap(arr, center, lastIndex);
            return center;
        }
        Point2D.Double pivot = getMedianY(arr, startIndex, lastIndex);
        int i = startIndex;
        int j = lastIndex-1;
        while (true) {
            while (arr[++i].getY() < pivot.getY());
            while (arr[--j].getY() > pivot.getY());
            if(i < j) swap(arr, i, j);
            else break;
        }
        swap(arr, i, lastIndex-1);
        secondPartition(arr, startIndex, i-1);
        secondPartition(arr, i+1, lastIndex);

        return i;
    }

}
