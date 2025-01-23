import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.Optional;
import java.util.Scanner; // Import the Scanner class to read text files
public class PigLatin {
  public void tester() {
    // String[] lines = loadStrings("words.txt");
    String[] lines = new String[8];
    try {
      File myFile = new File("words.txt");
      Scanner myReader = new Scanner(myFile);
      int counter = 0;
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        lines[counter] = data;
        counter++;
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    System.out.println("there are " + lines.length + " lines");
    for (int i = 0; i < lines.length; i++) {
      System.out.println(pigLatin(lines[i]));
    }
  }
  public Optional<Integer> firstVowelIndex(String sWord) {
    for (int i = 0; i < sWord.length(); i += 1) {
      char c = sWord.charAt(i);
      if (c == 'u' && sWord.charAt(i-1) == 'q') {System.out.println("qu detected"); continue; }
      if (isVowel(sWord.charAt(i)))
        return Optional.of(i);
    }
    return Optional.empty();
  }
  private boolean isVowel(char c) {
    switch
      (Character.toLowerCase(c)) {
        case 'a':
          return true;
        case 'e':
          return true;
        case 'i':
          return true;
        case 'o':
          return true;
        case 'u':
          return true;
      }
    return false;
  }


  public String pigLatin(String word) {
    String ret = pigLatinReal(word);
    System.out.println("piglatin " + word + " -> " + ret);
    return ret;
  }
  public String pigLatinReal(String word) {
    if (word.length() <= 1) {
      System.out.println("Word len <= 1, returning.");
      return word;
    }
    Optional<Integer> firstVowel = firstVowelIndex(word);
    System.out.println("fv: " + firstVowel.toString());
    if (firstVowel.isPresent() ) {
      int f = firstVowel.get();
      if (f == 0) {
        return word + "way";
      } else {
        return word.substring(f) + word.substring(0, f) + "ay";
      }
    } else {
      return word + "ay";
    }
  }
} // PigLatin

