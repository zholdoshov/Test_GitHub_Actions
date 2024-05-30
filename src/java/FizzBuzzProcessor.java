public class FizzBuzzProcessor
{
    public static void main()
    {
        for (int i = 1; i <= 100; i++) {
            System.out.println(convert(i));
        }
    }

    public static String convert(int fizzBuzz) throws IllegalArgumentException {

        if (fizzBuzz <= 0) {
            throw new IllegalArgumentException();
        }
        if (fizzBuzz % 15 == 0) {
            return "FizzBuzz";
        }
        if (fizzBuzz % 3 == 0) {
            return "Fizz";
        }
        if (fizzBuzz % 5 == 0) {
            return "Buzz";
        }
        return String.valueOf(fizzBuzz);
    }
}
