import java.util.*;

public class PassStrength {

    // Method to calculate password strength
    public static int findPassStrength(String str){
        int vowelCount = 0;
        int consonantCount = 0;

        for(int i = 0; i < str.length(); i++){
            char ch = Character.toLowerCase(str.charAt(i));
            
            if(ch >= 'a' && ch <= 'z'){ // Only consider alphabetic chars
                if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                    vowelCount++;
                } else{
                    consonantCount++;
                }
            }
        }

        // Example strength formula:
        // strength = (number of vowels * 2) + (number of consonants * 1) + length of password
        int strength = (vowelCount * 2) + consonantCount + str.length();
        return strength;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter password: ");
        String password = sc.nextLine();

        int strength = findPassStrength(password);
        System.out.println("Password strength: " + strength);

        sc.close();
    }
}
