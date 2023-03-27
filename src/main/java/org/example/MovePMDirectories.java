// wersja 22.03.2022
package org.example;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class MovePMDirectories {
        public static void main(String[] args) {

            String sourceDirectoryPath = "C:\\test\\source";
            String destinationDirectoryPath = "C:\\test\\destination";
            File sourceDirectory = new File(sourceDirectoryPath);
            File destinationDirectory = new File(destinationDirectoryPath);

            List<File> filesInSourceDirectory = new ArrayList<File>();
            List<File> directoriesInSourceDirectory = new ArrayList<File>();

            collectFilesAndDirectories(sourceDirectory, filesInSourceDirectory, directoriesInSourceDirectory);

            List<String> directoryToMoveNames = new ArrayList<String>();

            directoryToMoveNames.add("F317");
            directoryToMoveNames.add("F350");
            directoryToMoveNames.add("F353");
            directoryToMoveNames.add("F401");
            directoryToMoveNames.add("F406");
            directoryToMoveNames.add("F407");
            directoryToMoveNames.add("F408");
            directoryToMoveNames.add("F409");
            directoryToMoveNames.add("F411");
            directoryToMoveNames.add("F459");
            directoryToMoveNames.add("F460");
            directoryToMoveNames.add("F465");
            directoryToMoveNames.add("F485");
            directoryToMoveNames.add("F486");
            directoryToMoveNames.add("F487");
            directoryToMoveNames.add("F489");
            directoryToMoveNames.add("F505");
            directoryToMoveNames.add("F517");
            directoryToMoveNames.add("F519");
            directoryToMoveNames.add("F520");
            directoryToMoveNames.add("F542");
            directoryToMoveNames.add("F542");
            directoryToMoveNames.add("F546");
            directoryToMoveNames.add("F550");
            directoryToMoveNames.add("F553");
            directoryToMoveNames.add("F555");
            directoryToMoveNames.add("F700");
            directoryToMoveNames.add("F701");
            directoryToMoveNames.add("F707");
            directoryToMoveNames.add("F741");
            directoryToMoveNames.add("F742");
            directoryToMoveNames.add("F750");
            directoryToMoveNames.add("F751");
            directoryToMoveNames.add("F752");
            directoryToMoveNames.add("F779");
            directoryToMoveNames.add("F796");
            directoryToMoveNames.add("F800");
            directoryToMoveNames.add("F802");
            directoryToMoveNames.add("F810");


            checkIfExistDirectoryToMoveNames (destinationDirectory, directoryToMoveNames );




            for (File directory : directoriesInSourceDirectory) {
                for (String name : directoryToMoveNames) {
                    if (directory.getName().contains(name)) {

                        if (!destinationDirectory.exists()) {
                            destinationDirectory.mkdir();
                        }
                        File newDirectory = new File(destinationDirectory, directory.getName());
                        if (directory.renameTo(newDirectory)) {
                            System.out.println("Moved directory: " + directory.getAbsolutePath());
                        } else {
                            System.err.println("Failed to move directory: " + directory.getAbsolutePath());
                        }
                    }
                }
            }
        }

    private static void checkIfExistDirectoryToMoveNames(File destinationDirectory, List<String> directoryToMoveNames) {

        if (!destinationDirectory.exists()) {
            destinationDirectory.mkdir();
        }
        for (String name : directoryToMoveNames) {
            File newDirectory = new File(destinationDirectory, name);
            if (!newDirectory.exists()) {
                newDirectory.mkdir();
            }
        }

        }


    private static void collectFilesAndDirectories(File root, List<File> files, List<File> directories) {
        for (File file : root.listFiles()) {
            if (file.isDirectory()) {
                directories.add(file);
                collectFilesAndDirectories(file, files, directories);
            } else {
                files.add(file);
            }
        }
    }
    }

