import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
//Apache Commons IO
import org.apache.commons.io.FileUtils;

public class FileContentMatcher {

	public static void main(String[] args) throws IOException {

		Scanner scan = new Scanner(System.in);

		System.out.print("Search a word: ");
		String textToMatch = scan.next();
		scan.close();
		ArrayList<String> paths = new ArrayList<String>();
		String content;
		int found = 0;
		int notFound = 0;
		int totalFiles;
		FilenameFilter filter = new FilenameFilter() {
			public boolean accept(File dir, String name) {
				//Filetype
				return name.endsWith(".txt");
			}
		};
		
		// Filepath
		File path = new File("U:\\webservicesassignments\\tekstitiedostot");
		File[] listOfFiles = path.listFiles(filter);
		for (File file : listOfFiles) {
			content = FileUtils.readFileToString(file, "UTF-8");
			if (content.contains(textToMatch)) {
				System.out.println("--------------------------------------");
				System.out.println("Found in: " + file.getAbsolutePath());
				paths.add(file.getAbsolutePath());
				found++;
			} else {
				// System.out.println("No found\n" + content);
				notFound++;
			}
		}
		/*
		 * for (String pth : paths) { System.out.println(pth); }
		 */
		totalFiles = found + notFound;
		System.out.println("--------------------------------------");
		System.out.println("Found in " + found + " files.\nNot found in " + notFound + " files.\nThe total number of files: " + totalFiles);
	}
}