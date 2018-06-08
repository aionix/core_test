package utils;

public class MyExceptions extends Error {

    public MyExceptions(String exceptionText) {
        throw new Error(exceptionText == null ? "" : exceptionText);
    }
}
