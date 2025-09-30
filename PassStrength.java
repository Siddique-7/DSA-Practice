public class PassStrength {

  public static int findPassStrength(String str){
    int lastVowel = -1;
    int lastConsonant = -1;
    int strength = 0;
    for(int i = 0; i < str.length(); i++){
      Character ch = str.charAt(i);
      if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
        lastVowel = i;
      } else{
        lastConsonant = i;
      }
    }
  }
  public static void main(String[] args){
    String str = "hackerrank";
    System.out.println(findPassStrength(str));
  }
}
