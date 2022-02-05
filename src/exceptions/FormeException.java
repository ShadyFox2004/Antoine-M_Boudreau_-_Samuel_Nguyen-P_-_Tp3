package exceptions;

public class FormeException extends RuntimeException
{
    public FormeException()
    {
        this("FormeException");
    }

    public FormeException(String message)
    {
        super(message);
    }

}
