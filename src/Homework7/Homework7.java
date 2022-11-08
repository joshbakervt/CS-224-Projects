package Homework7;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;

public class Homework7 {
    public static int sortAndCount(ArrayList<Integer> l, int first, int last) {
        // count is the number of inversions to be used
        int r = 0;
        // If l has one element
        if(first == last) {
            // return 0 (and the list l)
            return 0;
        }
        // Divide the list into two halves A and B
        // Going to do this by including start and end indices in our sortAndCount calls
        int mid = (first + last) / 2;
        // Call sortAndCount
        int ra =sortAndCount(l, first, mid);
        int rb = sortAndCount(l, (mid+1), last);
        r = mergeAndCount(l, first, mid, last);
        // Return r = ra + rb + r (and the sorted list l)
        r += ra + rb;
        return r;
    }

    public static int mergeAndCount(ArrayList<Integer> l, int first, int mid, int last) {
        // Using these are our indices
        int left = first;
        int right = (mid+1);
        // Want to keep track of sorted elements from l
        int lenArray = last - first + 1;
        int[] sortedVals = new int[lenArray];
        // Count is the number of inversions
        int count = 0;
        // Curr is our index in l
        int curr = 0;
        // Iterate through l
        while(left <= mid && right <= last) {
            // If left <= right, no inversions
            if(l.get(left) <= l.get(right)) {
                sortedVals[curr] = l.get(left);
                left++;
            }
            // Otherwise, we need to perform an inversion
            else {
                sortedVals[curr] = l.get(right);
                right++;
                count += mid - left + 1;
            }
            curr++;
        }
        // Iterate through the rest of the list
        while (left <= mid) {
            sortedVals[curr] = l.get(left);
            left++;
            curr++;
        }
        while (right <= last) {
            sortedVals[curr] = l.get(right);
            right++;
            curr++;
        }
        // Set l to the sorted list
        for(int i = 0; i < sortedVals.length; i++) {
            l.set(first + i, sortedVals[i]);
        }
        return count;
    }

    public static void main(String[] args) {
        // Data is where read in values are stored
        String data;
        int parsed;
        // Prompt for an input.txt file name
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a filename: ");
        // Exception handling for nonexistent files
        try {
            String filename = input.nextLine();
            File inputFile = new File(filename);
            Scanner fileReader = new Scanner(inputFile);
            // Read entirety of file and push values to int ArrayList l
            while (fileReader.hasNextLine()) {
                data = fileReader.nextLine();
                ArrayList<Integer> l = new ArrayList<>();
                // Split by spacing
                String[] splitString = data.split(" ");
                for(int i = 0; i < splitString.length; i++) {
                    parsed = Integer.parseInt(splitString[i]);
                    l.add(parsed);
                }
//                System.out.println("Running Sort-and-Count on " + Arrays.toString(splitString) + "...");
                // Call sortAndCount and output the results
                int len = l.size() - 1;
                System.out.print("Inversions: " + sortAndCount(l, 0, len) + ". ");
                System.out.print("Sorted array:");
                for(int i = 0; i < l.size(); i++) {
                    System.out.print(" " + l.get(i));
                }
                System.out.println(".");
            }
            // Close yo files
            fileReader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Was unable to locate the file");
        }
        // Read from the file a list of array elements one line at a time

    }

}


