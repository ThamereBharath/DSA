class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
      Set<Character> set=new HashSet<>();
      for(char c:brokenLetters.toCharArray()){
        set.add(c);
      }
      String  words[] = text.trim().split(" ");
      int count=0;
      for(String word:words){
        boolean can=true;
        for(char letter:word.toCharArray()){
            if(set.contains(letter)){
                can=false;
                break;
            }   
        }
        if(can){
            count++;
        }
        
      }
      return count;
    }
}
