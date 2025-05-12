package de.zeroco.employee.management;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

public class Utility {
	
	public static String createDirIfNotExist(String path) throws IOException {
        if (path == null || path.trim().isEmpty()) return "";
        File file = new File(path);
        if (!file.exists()) {
            if (!file.mkdirs()) {
                throw new IOException("Failed to create directory: " + path);
            }
        }
        return file.getAbsolutePath();
    }
	
	public static String createFile(String path, String fileName) throws IOException {
        if (path == null || path.trim().isEmpty() || fileName == null || fileName.trim().isEmpty()) return "";
        String fullPath = createDirIfNotExist(path) + File.separator + fileName;;
        File file = new File(fullPath);
        if (!file.exists()) {
            if (!file.createNewFile()) {
                throw new IOException("Failed to create file: " + fullPath);
            }
        }
        return file.getAbsolutePath();
    }
	
	public static boolean ifFileExist(String path) {
        if (path == null || path.trim().isEmpty()) return false;
        File file = new File(path);
        return file.exists();
    }
	
	public static String writeHeadersInCsv(String[] headers, String path, String fileName) throws IOException {
	    if (path == null || path.trim().isEmpty() || headers == null || headers.length == 0 || fileName == null || fileName.trim().isEmpty()) return "";
	    String filePath = createFile(path, fileName);
	    File file = new File(filePath);
	    if (file.length() == 0) {
	        try (CSVWriter writer = new CSVWriter(new FileWriter(filePath, true))) {
	            writer.writeNext(headers);
	        } catch (IOException e) {
	            throw new IOException("Failed to write into file: " + path, e);
	        }
	    }
	    return filePath;
	}
	
	public boolean EntityFile(String fileName) {
		try {
			createFile(Configuration.FILE_DIRECTORY_PATH, fileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}
	
    public static void validateCSVHeaders(String filePath, String[] headers) {
        try (CSVReader csvReader = new CSVReader(new FileReader(filePath))) {
            String[] fileHeaders = csvReader.readNext();
            if (fileHeaders == null || fileHeaders.length == 0) {
                throw new IllegalArgumentException("File headers are empty or malformed.");
            }
            for (String header : fileHeaders) {
                if (header == null || header.isEmpty()) {
                    throw new IllegalArgumentException("File headers contain null or empty values.");
                }
            }
            if (!Arrays.equals(fileHeaders, headers)) {
                throw new IllegalArgumentException("File headers do not match the expected headers.");
            }
        } catch (IOException | IllegalArgumentException e) {
            e.getMessage();
        }
    }
    
}
