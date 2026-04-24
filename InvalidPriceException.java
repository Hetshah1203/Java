// User Defined Exception
class InvalidPriceException extends Exception
{
    public InvalidPriceException(String message)
    {
        super(message);
    }
}