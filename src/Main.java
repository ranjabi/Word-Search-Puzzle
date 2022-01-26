import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

  public static int result;

  public static int countLine(String[] args, String filename) {
  // menghitung jumlah baris pada file teks
    int line = 0;
    try {
      File loadFile = new File("../test/" + filename);
      Scanner reader = new Scanner(loadFile);
      while (reader.hasNextLine()) {
        String data = reader.nextLine();
        line++;
      }
      reader.close();
    } catch (FileNotFoundException e) {
      System.out.println("File tidak dapat ditemukan.");
      e.printStackTrace();
    }
    return line;
  }

  static void displaymatrix(char[][] matrix)
  {
    for (int i=0;i<matrix.length;i++)
    {
      System.out.print("[");
      for (int j=0;j<matrix[0].length;j++)
      {
        System.out.print(matrix[i][j] + ",");
      }
      System.out.println("]");
    }
  }

  static void displaypuzzle(String[] matrix)
  {
    System.out.print("[");
    for (int i=0;i<matrix.length;i++)
    {
      System.out.print(matrix[i] + ",");
    }
    System.out.println("]");
  }

  static int countmatrixRows(String[] puzzle)
  {
    int rows=0;
    for (int i=0;i<puzzle.length;i++)
    {
      if (puzzle[i] != "")
      {
        rows++;
      }
      else 
      {
        break;
      }
    }
    return rows;
  }

  static int countmatrixCols(String[] puzzle)
  {
    return puzzle[0].length();
  }

  static boolean horizontal(int wordsLength, int cols, int currentCols)
  // kanan
  {
    return (wordsLength <= cols - currentCols);
  }

  static boolean horizontalBack(int wordsLength, int cols, int currentCols)
  // kiri
  {
    return (wordsLength <= currentCols + 1);
  }  

  static boolean vertical(int wordsLength, int rows, int currentRows)
  // bawah
  {
    return (wordsLength <= rows - currentRows);
  }

  static boolean verticalBack(int wordsLength, int rows, int currentRows)
  // atas
  {
    return (wordsLength <= currentRows + 1);
  }

  static void printResult(char[][] matrix, String[] words)
  // menampilkan kata yang berhasil ditemukan ke layar
  {
      for (int i=0;i<matrix.length;i++)
      {
        for (int j=0;j<matrix[0].length;j++)
        {
            System.out.print(matrix[i][j] + " ");
        }
        System.out.println("");
      }
      System.out.println("");
  }

  static int checkHorizontal(char[][] matrix, String[] words, int tempI, int tempJ, int wordsIdx, int counter, int result)
  {
    counter = 0;
    boolean status = true;
    char[][] tempMatrix = new char[matrix.length][matrix[0].length];
    for (int m=0;m<matrix.length;m++)
    {
      for (int n=0;n<matrix[0].length;n++)
      {
        tempMatrix[m][n] = '-';
      }
    }
    int k = 0;
    while (k<words[wordsIdx].length() && status)
    {
      if (words[wordsIdx].charAt(k) != matrix[tempI][tempJ])
      {
        status = false;
      }
      else 
      {
        tempMatrix[tempI][tempJ] = words[wordsIdx].charAt(k);
        k++;
        tempJ++;
      }
      counter++;
    }
    if (status)
    {
      printResult(tempMatrix,words);
      Main.result++;
    }
    return counter;
  }

  static int checkHorizontalBack(char[][] matrix, String[] words, int tempI, int tempJ, int wordsIdx, int counter, int result)
  {
    counter = 0;
    boolean status = true;
    char[][] tempMatrix = new char[matrix.length][matrix[0].length];
    for (int m=0;m<matrix.length;m++)
    {
      for (int n=0;n<matrix[0].length;n++)
      {
        tempMatrix[m][n] = '-';
      }
    }
    int k = 0;
    while (k<words[wordsIdx].length() && status)
    {
      if (words[wordsIdx].charAt(k) != matrix[tempI][tempJ])
      {
        status = false;
      }
      else 
      {
        tempMatrix[tempI][tempJ] = words[wordsIdx].charAt(k);
        k++;
        tempJ--;
      }
      counter++;
    }
    if (status)
    {
      printResult(tempMatrix,words);
      Main.result++;
    }
    return counter;
  }

  static int checkVertical(char[][] matrix, String[] words, int tempI, int tempJ, int wordsIdx, int counter, int result)
  {
    counter = 0;
    boolean status = true;
    char[][] tempMatrix = new char[matrix.length][matrix[0].length];
    for (int m=0;m<matrix.length;m++)
    {
      for (int n=0;n<matrix[0].length;n++)
      {
        tempMatrix[m][n] = '-';
      }
    }
    int k = 0;
    while (k<words[wordsIdx].length() && status)
    {
      if (words[wordsIdx].charAt(k) != matrix[tempI][tempJ])
      {
        status = false;
      }
      else 
      {
        tempMatrix[tempI][tempJ] = words[wordsIdx].charAt(k);
        k++;
        tempI++;
      }
      counter++;
    }
    if (status)
    {
      printResult(tempMatrix,words);
      Main.result++;
    }
    return counter;
  }

  static int checkVerticalBack(char[][] matrix, String[] words, int tempI, int tempJ, int wordsIdx, int counter, int result)
  {
    counter = 0;
    boolean status = true;
    char[][] tempMatrix = new char[matrix.length][matrix[0].length];
    for (int m=0;m<matrix.length;m++)
    {
      for (int n=0;n<matrix[0].length;n++)
      {
        tempMatrix[m][n] = '-';
      }
    }
    int k = 0;
    while (k<words[wordsIdx].length() && status)
    {
      if (words[wordsIdx].charAt(k) != matrix[tempI][tempJ])
      {
        status = false;
      }
      else 
      {
        tempMatrix[tempI][tempJ] = words[wordsIdx].charAt(k);
        k++;
        tempI--;
      }
      counter++;
    }
    if (status)
    {
      printResult(tempMatrix,words);
      Main.result++;
    }
    return counter;
  }

  static int checkTopRight(char[][] matrix, String[] words, int tempI, int tempJ, int wordsIdx, int counter, int result)
  {
    counter = 0;
    boolean status = true;
    char[][] tempMatrix = new char[matrix.length][matrix[0].length];
    for (int m=0;m<matrix.length;m++)
    {
      for (int n=0;n<matrix[0].length;n++)
      {
        tempMatrix[m][n] = '-';
      }
    }
    int k = 0;
    while (k<words[wordsIdx].length() && status)
    {
      if (words[wordsIdx].charAt(k) != matrix[tempI][tempJ])
      {
        status = false;
      }
      else 
      {
        tempMatrix[tempI][tempJ] = words[wordsIdx].charAt(k);
        k++;
        tempI--;
        tempJ++;
      }
      counter++;
    }
    if (status)
    {
      printResult(tempMatrix,words);
      Main.result++;
    }
    return counter;
  }

  static int checkTopLeft(char[][] matrix, String[] words, int tempI, int tempJ, int wordsIdx, int counter, int result)
  {
    counter = 0;
    boolean status = true;
    char[][] tempMatrix = new char[matrix.length][matrix[0].length];
    for (int m=0;m<matrix.length;m++)
    {
      for (int n=0;n<matrix[0].length;n++)
      {
        tempMatrix[m][n] = '-';
      }
    }
    int k = 0;
    while (k<words[wordsIdx].length() && status)
    {
      if (words[wordsIdx].charAt(k) != matrix[tempI][tempJ])
      {
        status = false;
      }
      else 
      {
        tempMatrix[tempI][tempJ] = words[wordsIdx].charAt(k);
        k++;
        tempI--;
        tempJ--;
      }
      counter++;
    }
    if (status)
    {
      printResult(tempMatrix,words);
      Main.result++;
    }
    return counter;
  }

  static int checkBottomRight(char[][] matrix, String[] words, int tempI, int tempJ, int wordsIdx, int counter, int result)
  {
    counter = 0;
    boolean status = true;
    char[][] tempMatrix = new char[matrix.length][matrix[0].length];
    for (int m=0;m<matrix.length;m++)
    {
      for (int n=0;n<matrix[0].length;n++)
      {
        tempMatrix[m][n] = '-';
      }
    }
    int k = 0;
    while (k<words[wordsIdx].length() && status)
    {
      if (words[wordsIdx].charAt(k) != matrix[tempI][tempJ])
      {
        status = false;
      }
      else 
      {
        tempMatrix[tempI][tempJ] = words[wordsIdx].charAt(k);
        k++;
        tempI++;
        tempJ++;
      }
      counter++;
    }
    if (status)
    {
      printResult(tempMatrix,words);
      Main.result++;
    }
    return counter;
  }

  static int checkBottomLeft(char[][] matrix, String[] words, int tempI, int tempJ, int wordsIdx, int counter, int result)
  {
    counter = 0;
    boolean status = true;
    char[][] tempMatrix = new char[matrix.length][matrix[0].length];
    for (int m=0;m<matrix.length;m++)
    {
      for (int n=0;n<matrix[0].length;n++)
      {
        tempMatrix[m][n] = '-';
      }
    }
    int k = 0;
    while (k<words[wordsIdx].length() && status)
    {
      if (words[wordsIdx].charAt(k) != matrix[tempI][tempJ])
      {
        status = false;
      }
      else 
      {
        tempMatrix[tempI][tempJ] = words[wordsIdx].charAt(k);
        k++;
        tempI++;
        tempJ--;
      }
      counter++;
    }
    if (status)
    {
      printResult(tempMatrix,words);
      Main.result++;
    }
    return counter;
  }


  public static void main(String[] args) {

    int counter = 0;
    Scanner readFileName = new Scanner(System.in);
    System.out.println("Masukkan nama file (sertakan .txt): ");
    String filename = readFileName.nextLine();

    int totalLines = countLine(args, filename);

    String[] puzzle = new String[totalLines];
    int o = 0;

    System.out.println("Isi file yang dibaca: ");
    
    try {
      File loadFile = new File("../test/" + filename);
      Scanner reader = new Scanner(loadFile);
      System.out.println(loadFile.getAbsolutePath());
      while (reader.hasNextLine()) {
        String data = reader.nextLine();
        puzzle[o] = data;
        o++;
        System.out.println(data);
      }
      reader.close();
    } catch (FileNotFoundException e) {
      System.out.println("File tidak ditemukan. ");
      e.printStackTrace();
    }
    
    // hapus spasi
    for (int p=0;p<puzzle.length;p++)
    {
      if (puzzle[p] == "")
      {
        // System.out.println("empty");
      }
      else 
      {
        puzzle[p] = puzzle[p].replaceAll("\\s+","");
        // System.out.println("[" + puzzle[p] + "]");
      }
    }
    
    int matrixRows = countmatrixRows(puzzle);
    int matrixCols = countmatrixCols(puzzle);
    char[][] matrix = new char[matrixRows][matrixCols];
    for (int k=0;k<matrixRows;k++)
    {
      for (int l=0;l<matrixCols;l++)
      {
        matrix[k][l] = puzzle[k].charAt(l);
      }
    }
    // displaymatrix(matrix);
    
    int totalWord = totalLines - matrixRows -1;
    // System.out.println(totalWord);
    String[] words = new String[totalWord];
    int n = 0;
    for (int m=matrixRows+1;m<totalLines;m++)
    {
      words[n] = puzzle[m];
      n++;
    }
    // displaypuzzle(words);

    int rows = matrix.length;
    int cols= matrix[0].length;
    
    long startTime = System.nanoTime();
    // cari first char yang sama di matriks dengan array kata
    int tempCounter = 0;
    for(int wordsIdx=0;wordsIdx<words.length;wordsIdx++) // iterasi setiap kata
    {
      int i, j;

      for(i=0;i<rows;i++) // iterasi baris
      {
        for(j=0;j<cols;j++) // iterasi kolom
        {
          int tempI = i;
          int tempJ = j;
          int wordsLength = words[wordsIdx].length();
          
          if (words[wordsIdx].charAt(0) == matrix[i][j]) // jika karakter awal matriks dengan kata sama dan panjangnya cukup
          {
            if (horizontal(wordsLength,cols,j))
            {
              tempCounter = checkHorizontal(matrix, words, tempI, tempJ, wordsIdx, counter, result); // jika kata cocok
              counter += tempCounter; // counter pencarian bertambah
              tempCounter = 0;
            }
            if (horizontalBack(wordsLength,cols,j))
            {
              tempCounter = checkHorizontalBack(matrix, words, tempI, tempJ, wordsIdx, counter, result); 
              counter += tempCounter;
              tempCounter = 0;
            }
            if (vertical(wordsLength,rows,i))
            {
              tempCounter = checkVertical(matrix, words, tempI, tempJ, wordsIdx, counter, result); 
              counter += tempCounter;
              tempCounter = 0;
            }
            if (verticalBack(wordsLength,rows,i))
            {
              tempCounter = checkVerticalBack(matrix, words, tempI, tempJ, wordsIdx, counter, result); 
              counter += tempCounter;
              tempCounter = 0;
            }
            if (horizontal(wordsLength,cols,j) && verticalBack(wordsLength,rows,i))
            // top right
            {
              tempCounter = checkTopRight(matrix, words, tempI, tempJ, wordsIdx, counter, result); 
              counter += tempCounter;
              tempCounter = 0;
            }
            if (horizontalBack(wordsLength,cols,j) && verticalBack(wordsLength,rows,i))
            // top left
            {
              tempCounter = checkTopLeft(matrix, words, tempI, tempJ, wordsIdx, counter, result); 
              counter += tempCounter;
              tempCounter = 0;
            }
            if (horizontal(wordsLength,cols,j) && vertical(wordsLength,rows,i))
            // bottom right
            {
              tempCounter = checkBottomRight(matrix, words, tempI, tempJ, wordsIdx, counter, result); 
              counter += tempCounter;
              tempCounter = 0;
            }
            if (horizontalBack(wordsLength,cols,j) && vertical(wordsLength,rows,i))
            // bottom left
            {
              tempCounter = checkBottomLeft(matrix, words, tempI, tempJ, wordsIdx, counter, result); 
              counter += tempCounter;
              tempCounter = 0;
            }
          }
        }
      }
    }
    long endTime = System.nanoTime();
    long timeElapsed = endTime - startTime;
 
    System.out.println("Waktu eksekusi program: " + timeElapsed / 1000000 + " ms");

    System.out.println("Jumlah total perbandingan huruf: " + counter);
    System.out.println("Jumlah kata yang ditemukan: " + result);
  }
}