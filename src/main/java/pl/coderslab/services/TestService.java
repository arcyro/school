package pl.coderslab.services;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.springframework.stereotype.Component;
import pl.coderslab.utils.RunBuild;


import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLClassLoader;

@Component
public class TestService {

    static final String MESSAGE = "For file: %s unit test return %s";


    /**
     * @param repoName
     * @param className
     * @param packageName
     * @param testPackageName
     * @return
     * @throws ClassNotFoundException
     * @throws IOException
     * @// FIXME: 23.08.17 change passing clazz to JUnit test
     */
    public boolean runTest(String repoName, String className, String packageName, String testPackageName)
            throws ClassNotFoundException, IOException, IllegalAccessException, InstantiationException {
        String reposHomeDirectory = System.getProperty("user.home");

        //load class from directory
        File file = new File(reposHomeDirectory + "/" + repoName + "/");
        System.out.println(file);
        URL url = file.toURI().toURL();
        URL[] urls = new URL[]{url};

        ClassLoader cl = new URLClassLoader(urls);
        //compile class
        /** change compile way */
        RunBuild.runCommand(reposHomeDirectory + "/" + repoName, "javac " + packageName + "/" + className + ".java");
        Class clazz = cl.loadClass(packageName+"."+className);

        //run junit test
        /** @FIXME - It might explode */
        Class<?> testClass = Class.forName(testPackageName + "." + className + "Test");
        Object instance = testClass.newInstance();
        set(instance, "clazz", clazz);
        System.out.println(clazz);
        JUnitCore junit = new JUnitCore();
        Result result = junit.run(testClass);

        return result.wasSuccessful();
    }

    public static boolean set(Object object, String fieldName, Object fieldValue) {
        Class<?> clazz = object.getClass();
        while (clazz != null) {
            try {
                Field field = clazz.getDeclaredField(fieldName);
                field.setAccessible(true);
                field.set(object, fieldValue);
                return true;
            } catch (NoSuchFieldException e) {
                clazz = clazz.getSuperclass();
            } catch (Exception e) {
                throw new IllegalStateException(e);
            }
        }
        return false;
    }
}
