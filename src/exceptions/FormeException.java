package exceptions;

public class FormeException extends RuntimeException
{
    public FormeException()
    {
        this("Rien de plus a dire.");
    }

    public FormeException(String message)
    {
        System.err.println("FormeException:" + message);
    }

}
