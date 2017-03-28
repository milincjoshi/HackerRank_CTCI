//Hash Tables: Ransom Note 

import java.util.*;

public class Solution_Hash_Tables_Ransom_Note {
    Map<String, Integer> magazineMap;
    Map<String, Integer> noteMap;
    String magazine,note;
    public Solution(String magazine, String note) {
        
        this.magazine = magazine;
        this.note = note;
        
    }
    
    public boolean solve() {
        
        magazineMap = new HashMap<String, Integer>();
        
        String[] magazine_array = magazine.split(" ");
        String[] note_array = note.split(" ");
        
        if(note_array.length>magazine_array.length){
            return false;
        }
        for(int i=0; i<magazine_array.length; i++){
            Integer c = magazineMap.get(magazine_array[i]);
            if(c == null){
                magazineMap.put(magazine_array[i].toLowerCase(), 1);
            }    
            else{
                magazineMap.put(magazine_array[i].toLowerCase(), c+1);
            }
        }
        //System.out.println(magazineMap);
        
        for(int i=0; i<note_array.length;i++){
            Integer c = magazineMap.get(note_array[i].toLowerCase());
            if(c == null){
                return false;       
            }
            else if((c-1)<0){
                return false;
            }
            else{
                magazineMap.put(note_array[i], c-1);
            }
        }
       // System.out.println(noteMap);
        
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        
        // Eat whitespace to beginning of next line
        scanner.nextLine();
        
        Solution s = new Solution(scanner.nextLine(), scanner.nextLine());
        scanner.close();
        
        boolean answer = s.solve();
        if(answer)
            System.out.println("Yes");
        else System.out.println("No");
      
    }
}
