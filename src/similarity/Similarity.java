package similarity;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.helper.Validate;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Element;
import java.io.IOException;
import java.util.Scanner;


public class Similarity {

    public static double sim(String s1, String s2) {
    String ll = s1, ss = s2;
    if (s1.length() < s2.length()) 
    { 
      ll = s2; ss = s1;
    }
    int l_Length = ll.length();
    if (l_Length == 0) 
    { 
        return 1.0; 
    }
    return (l_Length - distance(ll, ss)) / (double) l_Length;
  }
    
    public static int distance(String s1, String s2) {
    s1 = s1.toLowerCase();
    s2 = s2.toLowerCase();
    
    int[] arr = new int[s2.length() + 1];
    for (int i = 0; i <= s1.length(); i++) 
    {
      int l_Value = i;
      for (int j = 0; j <= s2.length(); j++) 
      {
        if (i == 0)
          arr[j] = j;
        else 
        {
          if (j > 0) 
          {
            int n_Value = arr[j - 1];
            if (s1.charAt(i - 1) != s2.charAt(j - 1))
              n_Value = Math.min(Math.min(n_Value, l_Value),arr[j]) + 1;
            arr[j - 1] = l_Value;
            l_Value = n_Value;
          }
        }
      }
      if (i > 0)
        arr[s2.length()] = l_Value;
    }
    return arr[s2.length()];
  }
    
    public static void print_sim(String s1, String s2) {
    System.out.println(String.format(
      "%.3f similarity:", sim(s1, s2), s1, s2));
  }
    
    
    public static void main(String[] args) throws IOException 
    {  
    String s1,s2,str1,str2;
    Scanner scn = new Scanner(System.in);
    System.out.print("Website1:");
    s1 = scn.nextLine();
    System.out.print("Website2:");
    s2 = scn.nextLine();
    Document d1 = Jsoup.connect(s1).get();
    Document d2 = Jsoup.connect(s2).get();
    str1 = d1.body().text();
    str2 = d2.body().text();
    str1 = str1.replaceAll("\\s*\\babout\\b\\s* | \\s*\\bafter\\b\\s* | \\s*\\bas\\b\\s* | \\s*\\bat\\b\\s* | \\s*\\bbefore\\b\\s* | \\s*\\bbut\\b\\s* | \\s*\\bby\\b\\s* | \\s*\\bfrom\\b\\s* | \\s*\\bin\\b\\s* | \\s*\\bof\\b\\s* | \\s*\\bon\\b\\s* | \\s*\\bto\\b\\s* | \\s*\\bam\\b\\s* | \\s*\\bis\\b\\s* | \\s*\\bare\\b\\s* | \\s*\\bwas\\b\\s* | \\s*\\bwere\\b\\s* | \\s*\\bdo\\b\\s* | \\s*\\does\\b\\s* | \\s*\\ba\\b\\s* | \\s*\\bin\\b\\s*", " ");
    str2 = str2.replaceAll("\\s*\\babout\\b\\s* | \\s*\\bafter\\b\\s* | \\s*\\bas\\b\\s* | \\s*\\bat\\b\\s* | \\s*\\bbefore\\b\\s* | \\s*\\bbut\\b\\s* | \\s*\\bby\\b\\s* | \\s*\\bfrom\\b\\s* | \\s*\\bin\\b\\s* | \\s*\\bof\\b\\s* | \\s*\\bon\\b\\s* | \\s*\\bto\\b\\s* | \\s*\\bam\\b\\s* | \\s*\\bis\\b\\s* | \\s*\\bare\\b\\s* | \\s*\\bwas\\b\\s* | \\s*\\bwere\\b\\s* | \\s*\\bdo\\b\\s* | \\s*\\does\\b\\s* | \\s*\\ba\\b\\s* | \\s*\\bin\\b\\s*", " ");
    print_sim(str1,str2);
    }
    
}
