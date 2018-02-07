import edu.duke.*;
/**
 * Write a description of WordLengthsDefinitivo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WordLengths {
    
    public int indexOf(int[] list, String word){
        /*Si word tiene la longitud que el numero de la lista, devuelve el lugar.
         * ejemplo si are es 3, y list es 3, devuelve 3.
         */
        for (int i=0; i < list.length; i++){
            //System.out.println("length " +word.length());
            if (list[i] == word.length()) {
                return i;
            }
        }
        return -1;
    }
    
    public String indexOfWord(int[] list, String word){
        /*Este metodo retorna las palabas que encuentra
         */
        for (int i=0; i < list.length; i++){
            //System.out.println("length " +word.length());
            if (list[i] == word.length()) {
                return word;
            }
        }
        return "a";
    }
    
    void countWordLengths(FileResource resource, int []counts){
        //For every word in filerresource, convert it to lowercase, count the length and store it in counts.
        int[] length = new int[counts.length];
        String[] words = new String[counts.length];
        int idx = 0;
        for (int i=0; i < counts.length; i++){
            /*el problema era que length tenia 31 stocks, si, pero todos eran 0 y no rulaba
            la funcion. Agregando esto ya funciona indexOf(). Si quiero que salga la palabra en
            el print voy a necesitar hacer otro metodo como el de arriba del todo
            */
            length[idx]=idx; 
            idx +=1;
        }
        
        for (String s: resource.words()){
           int index = indexOf(length,s);
           String idxWord = indexOfWord(length,s);
           StringBuilder newWord = new StringBuilder(idxWord);
           String myNewWord = "";
           //if this does not work in every case, consider doing it with character.isletter()
           if (newWord.charAt(0) == ',' ||  newWord.charAt(newWord.length()-1) == ',' || 
               newWord.charAt(0) == '.' ||  newWord.charAt(newWord.length()-1) == '.'){
               myNewWord = newWord.substring(0,newWord.length()-1);
               idxWord = indexOfWord(length,myNewWord);
               index = indexOf(length,myNewWord);
            }
           else {
               idxWord = indexOfWord(length,newWord.toString());
            }
            
           if (index != -1){
               counts[index] +=1;
               words[index] = idxWord;
           }
        }
        
        for (int i=0; i < counts.length; i++){
            if(counts[i] != 0){
                System.out.println( counts[i] + " words of " + length[i]+ " letters.\t" +  " Last one addded: "+ words[i]);
            }
        }
    }
    
    
    void testCountWordLenghts(){
        FileResource sr = new FileResource("manywords.txt");
        int[] counts = new int [31];
        countWordLengths(sr,counts);
        
    }
}
