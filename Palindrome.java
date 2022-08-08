package project1B;



public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        char[] chars = word.toCharArray();
        Deque deque = (Deque) new ArrayDeque<String>();
        for (int i = 0; i < chars.length; i++) {
            deque.addLast(chars[i]);
        }
        return deque;
    }
    public boolean isPalindrome(String word){
        int length = word.length();
        if(length == 0 || length == 1){
            return true;
        }
        Deque<Character> characterDeque = wordToDeque(word);
        while(characterDeque.size() > 1){
            if(!characterDeque.removeFirst().equals(characterDeque.removeLast())){
                return false;
            }
        }

        return true;
    }
    public boolean isPalindrome(String word, CharacterComparator cc){
        if(word.length()==1 || word.length()==0){
            return true;
        }
        char[] chars = word.toCharArray();
        int i = 0;
        int j = chars.length-1;
        if(word.length() == 2){
            return cc.equalChars(chars[i], chars[j]);
        }
        while(i<j) {
            boolean result = cc.equalChars(chars[i], chars[j]);
            if(result == false){
                return false;
            }
            i++;
            j--;
        }
        return true;

    }



}
