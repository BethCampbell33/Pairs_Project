import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
        int N; // Number of students
        int K; // Number  of projects
        K = 10; 
        N = 10; 
        int noOfOptions = 2;
        int[] projects = new int[K]; // Project allocated = 1 | Project unallocated = 0
        int[] projectCount = new int[K]; // Number of students who selcted each project  
        int[][] orderedProjectCount = new int[K][2]; // Number of students who selcted each project in order low to high
        int[][] kChoices = new int[N][6]; // Student choices - kChoices[n:N][0] = assigned project
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<Integer> initial = new ArrayList<Integer>();
        ArrayList<Integer> ordered = new ArrayList<Integer>();

        for (int i=1; i<K+1; i++) 
        {
            initial.add(i);
            orderedProjectCount[i-1][0] = i;
        }

        list = initial;
        Collections.shuffle(list);

        //Student Choices
        for(int i=0;i<N;i++)
        {
            for(int j=1;j<6;j++)
            {
                kChoices[i][j] = list.get(j);
            }
            list = initial;
            Collections.shuffle(list);
        }

        //Project Count
        for(int i=0;i<N;i++)
        {
            System.out.println();
            System.out.print("Choices : " + (i+1) + " --> ");
            for(int j=1;j<6;j++)
            {
                projectCount[kChoices[i][j]-1] = projectCount[kChoices[i][j]-1] + 1;
                System.out.print(kChoices[i][j] + ", ");
                orderedProjectCount[j-1][1] = projectCount[kChoices[i][j]-1];
            }          
        }

        System.out.println();
        System.out.println("===========================");

        for(int i=0;i<K;i++)
        {   
            ordered.add(projectCount[i]);
            System.out.println("Project " + (i+1) + " -->"+ projectCount[i]);
        }


        for(int i=0;i<N;i++)
        {
            for(int j=1;j<noOfOptions+1;j++)
            {
                if(initial.contains(kChoices[i][j]))
                {
                    kChoices[i][0] = kChoices[i][j];
                    int toRemove = kChoices[i][0];
                    initial.remove(Integer.valueOf(toRemove));
                    break;
                }   
                            
            }
            System.out.println("HERE I'M HERE" + initial) ;
           
        }


        for(int i=0;i<N;i++)
        {
            System.out.println("Student " + i + ": Allocated Project " + kChoices[i][0]);

        }
        for(int i=0;i<K;i++)
        {
            System.out.println(projects[i]);
        }
        
    }
}
