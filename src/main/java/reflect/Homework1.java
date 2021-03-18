package reflect;

import java.lang.reflect.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;

public class Homework1 {

    /**
     * Prints the declared methods of java.lang.String sorted by name.
     */
    public void streamPipeline1() {
        Arrays.stream(String.class.getDeclaredMethods())
                .map(m -> m.toString())
                .sorted(Comparator.naturalOrder())
                .forEach(System.out::println);
    }

    /**
     *  Prints all distinct names of the declared methods of java.lang.String sorted alphabetically.
     */
    public void streamPipeline2() {
        Arrays.stream(String.class.getDeclaredMethods())
                .map(m -> m.getName())
                .sorted(Comparator.naturalOrder())
                .distinct()
                .forEach(System.out::println);
    }

    /**
     * Prints the declared methods of java.lang.String with two or more parameters whose parameters are all of the same type, sorted by name.
     */
    public void streamPipeline3() {
        Arrays.stream(String.class.getDeclaredMethods())
                .filter(m -> m.getParameterCount() >= 2)
                .filter(m -> Arrays.stream(m.getParameterTypes()).map(p -> p.getName()).distinct().count() == 1)
                .map(m -> m.toString())
                .sorted(Comparator.naturalOrder())
                .forEach(System.out::println);
    }

    /**
     * Prints all distinct return types of the declared methods of java.lang.String sorted alphabetically.
     */
    public void streamPipeline4() {
        Arrays.stream(String.class.getDeclaredMethods())
                .map(m -> m.getReturnType())
                .distinct()
                .map(m -> m.toString())
                .sorted(Comparator.naturalOrder())
                .forEach(System.out::println);
    }

    /**
     * Prints the declared methods of java.lang.String with at least one boolean parameter, sorted by name.
     */
    public void streamPipeline5() {
        Arrays.stream(String.class.getDeclaredMethods())
                .filter(m -> Arrays.stream(m.getParameterTypes()).filter(p -> p.getName() == "boolean").count() > 0)
                .map(m -> m.toString())
                .sorted(Comparator.naturalOrder())
                .forEach(System.out::println);
    }

    /**
     * Prints the declared methods of java.lang.String whose parameters are all of type int, sorted by name.
     */
    public void streamPipeline6() {
        Arrays.stream(String.class.getDeclaredMethods())
                .filter(m -> m.getParameterTypes().length != 0)
                .filter(m -> Arrays.stream(m.getParameterTypes()).allMatch(p -> p.getName()=="int"))
                .map(m -> m.toString())
                .sorted(Comparator.naturalOrder())
                .forEach(System.out::println);
    }

    /**
     * Returns the longest name of the declared methods of java.lang.String.
     */
    public String streamPipeline7() {
        return Arrays.stream(String.class.getDeclaredMethods())
                .map(m -> m.getName())
                .max(Comparator.comparingInt(String::length))
                .get();
    }

    /**
     *  Returns the longest one from the names of the public declared methods of java.lang.String.
     */
    public String streamPipeline8() {
        return Arrays.stream(String.class.getDeclaredMethods())
                .filter(m -> m.toString().startsWith("public"))
                .map(m -> m.getName())
                .max(Comparator.comparingInt(String::length))
                .get();
    }

    /**
     * Returns summary statistics about the number of parameters for the declared methods of java.lang.String.
     */
    public IntSummaryStatistics streamPipeline9() {
        return Arrays.stream(String.class.getDeclaredMethods())
                .mapToInt(m -> m.getParameterCount())
                .summaryStatistics();
    }

    /**
     * Returns the maximum number of parameters accepted by the declared methods of java.lang.String.
     */
    public int streamPipeline10() {
        return Arrays.stream(String.class.getDeclaredMethods())
                .max(Comparator.comparingInt(Method::getParameterCount))
                .get().getParameterCount();
    }

    /**
     * Returns the declared method of java.lang.String with the most number of parameters.
     */
    public Method streamPipeline11() {
        return Arrays.stream(String.class.getDeclaredMethods())
                .max(Comparator.comparingInt(Method::getParameterCount))
                .get();
    }

    /**
     * Prints all distinct parameter types of the declared methods of java.lang.String sorted alphabetically.
     */
    public void streamPipeline12() {
        Arrays.stream(String.class.getDeclaredMethods())
                .flatMap(m -> Arrays.stream(m.getParameterTypes()))
                .distinct()
                .map(m -> m.getName())
                .sorted(Comparator.naturalOrder())
                .forEach(System.out::println);
    }

}
