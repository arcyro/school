package pl.coderslab.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 
 * Check http://commons.apache.org/proper/commons-exec/tutorial.html
 * @author 
 *
 */
public class RunBuild {

	public static void runCommand(String path, String command) throws IOException {
		List<String> commands = new ArrayList<>();
		commands.add("bash");
		commands.add("-c");
		commands.add(command);

		ProcessBuilder pb = new ProcessBuilder(commands);
		//
		File workingFolder = new File(path);
		pb.directory(workingFolder);

		Process proc = pb.start();

		BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()));
		BufferedReader stdError = new BufferedReader(new InputStreamReader(proc.getErrorStream()));

		// read the output from the command
		System.out.println("Here is the standard output of the command:\n");
		String s = null;
		while ((s = stdInput.readLine()) != null) {
			System.out.println(s);
		}

		// read any errors from the attempted command
		System.out.println("Here is the standard error of the command (if any):\n");
		while ((s = stdError.readLine()) != null) {
			System.out.println(s);
		}
	}

	public static void showEnv() {
		Map<String, String> env = System.getenv();
		for (String envName : env.keySet()) {
			System.out.format("%s=%s%n", envName, env.get(envName));
		}

	}

	/**
	 *  Only for debug
	 * @param args
	 */
	public static void main(String[] args) {
		try {

			runCommand(System.getenv().get("PWD"), "pwd; whoami; pwd;");
		} catch (IOException e) {
			e.printStackTrace();
		}
		// showEnv();
	}

}
