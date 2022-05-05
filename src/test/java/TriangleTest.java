import Triangle.Triangle;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Yulya Telysheva
 */

public class TriangleTest {
    private static Logger logger = LoggerFactory.getLogger(TriangleTest.class);

    @BeforeAll
    static void beforeAll() {
        logger.info("INFO");
        logger.debug("DEBUG");
        logger.error("ERROR");
    }

    @Test
    void standardConstructorTest() {
        assertAll(
                () -> assertEquals(new Triangle().getA(), 1, "Standard constructor returns wrong side A"),
                () -> assertEquals(new Triangle().getB(), 1, "Standard constructor returns wrong side B"),
                () -> assertEquals(new Triangle().getC(), 1, "Standard constructor returns wrong side C")
        );
    }


    @Test
    public void sideEqualsOrLessThanZeroTrowsException() {
        assertAll(
                () -> assertThrows(ArithmeticException.class, () ->
                        new Triangle(0, 1, 1), "Zero side A doesn't throw Exception"),
                () -> assertThrows(ArithmeticException.class, () ->
                        new Triangle(1, 0, 1), "Zero side B doesn't throw Exception"),
                () -> assertThrows(ArithmeticException.class, () ->
                        new Triangle(1, 1, 0), "Zero side C doesn't throw Exception"),
                () -> assertThrows(ArithmeticException.class, () ->
                        new Triangle(-10, 11, 12), "Negative side A doesn't throw Exception"),
                () -> assertThrows(ArithmeticException.class, () ->
                        new Triangle(100, -80, 75), "Negative side B doesn't throw Exception"),
                () -> assertThrows(ArithmeticException.class, () ->
                        new Triangle(50, 51, -27), "Negative side C doesn't throw Exception")
        );
    }

    @Test
    public void zeroSideMessageException() {
        ArithmeticException AE = assertThrows(ArithmeticException.class, () ->
                new Triangle(2, 0, 3));
        assertEquals("Side can't be less or equals than zero!", AE.getMessage());
    }

    @Test
    public void wrongSide() {
        assertAll(
                () -> assertThrows(ArithmeticException.class, () ->
                        new Triangle(4, 2, 2), "Side A is equals to the sum of the sides B and C"),
                () -> assertThrows(ArithmeticException.class, () ->
                        new Triangle(3, 6, 3), "Side B is equals to the sum of the sides A and C"),
                () -> assertThrows(ArithmeticException.class, () ->
                        new Triangle(4, 4, 8), "Side C is equals to the sum of the sides B and A"),
                () -> assertThrows(ArithmeticException.class, () ->
                        new Triangle(8, 3, 3), "Side A is greater than the sum of the sides B and C"),
                () -> assertThrows(ArithmeticException.class, () ->
                        new Triangle(8, 20, 5), "Side B is greater than the sum of the sides A and C"),
                () -> assertThrows(ArithmeticException.class, () ->
                        new Triangle(5, 4, 14), "Side C is greater than the sum of the sides A and B")
        );
    }

    @Test
    public void wrongSideMessage() {
        ArithmeticException AE = assertThrows(ArithmeticException.class, () ->
                new Triangle(2, 10, 15));
        assertEquals("Side can't be greater than the sum of the other two sides!", AE.getMessage());
    }

    @ParameterizedTest
    @MethodSource("trianglePerimeter")
    void anyObjectParametrizedTest(Triangle triangle) {
        assertEquals(triangle.getPerimeter(), 20);
    }

    private static Stream<Arguments> trianglePerimeter() {
        return Stream.of(
                Arguments.of(new Triangle(7, 7, 6)),
                Arguments.of(new Triangle(9, 2, 9)),
                Arguments.of(new Triangle(8, 8, 4))
        );
    }

    @Test
    void triangleSquare() {
        assertAll(
                () -> assertEquals(new Triangle().getSquare(), 0.44, "getSquare returns wrong result with standard constructor"),
                () -> assertEquals(new Triangle(10, 15, 24).getSquare(), 41.08, "getSquare returns wrong result"),
                () -> assertEquals(new Triangle(100, 64, 88).getSquare(), 2778.18, "getSquare returns wrong result")
        );
    }
}
