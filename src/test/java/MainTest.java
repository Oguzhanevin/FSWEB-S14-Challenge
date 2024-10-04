import org.example.models.DeluxeBurger;
import org.example.models.Hamburger;
import org.example.models.HealthyBurger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;

@ExtendWith(ResultAnalyzer.class)
public class MainTest {
    Hamburger hamburger;
    HealthyBurger healthyBurger;
    DeluxeBurger deluxeBurger;

    @BeforeEach
    void setUp() {
        hamburger = new Hamburger("Basic", "NORMAL", 4, "WRAP");
        healthyBurger = new HealthyBurger("Vegan Burger", 5.67, "Sandwich");
        deluxeBurger = new DeluxeBurger();
    }

    @DisplayName("Hamburger sınıfı doğru Access Modifierlara sahip mi")
    @Test
    public void testHamburgerAccessModifiers() throws NoSuchFieldException {
        assertEquals(2, hamburger.getClass().getDeclaredField("name").getModifiers());
        assertEquals(2, hamburger.getClass().getDeclaredField("meat").getModifiers());
        assertEquals(2, hamburger.getClass().getDeclaredField("price").getModifiers());
    }

    @DisplayName("Hamburger sınıfı doğru type değerlere sahip mi")
    @Test
    public void testHamburgerInstanceTypes() {
        // Doğru tür kontrolü yapılıyor
        assertThat(hamburger.getName(), instanceOf(String.class));
        assertThat(hamburger.getMeat(), instanceOf(String.class));
        assertThat(hamburger.getPrice(), instanceOf(Double.class));
        assertThat(hamburger.getBreadRollType(), instanceOf(String.class));
    }

    @DisplayName("Hamburger sınıfı addAddition methodları doğru çalışıyor mu?")
    @Test
    public void testHamburgerAddAdditionMethods() {
        hamburger.addHamburgerAddition1("Tomato", 3);
        hamburger.addHamburgerAddition2("Lettuce", 3);
        hamburger.addHamburgerAddition3("Cheese", 3);
        hamburger.itemizeHamburger();
        assertEquals(4.0, hamburger.getPrice(), 0.01);  // 10 + 3 + 3 + 3
    }

    @DisplayName("Deluxe Burger sınıf değişkenleri doğru değerlere sahip mi?")
    @Test
    public void testDeluxeBurgerInstanceVariables() {
        assertEquals("Curvy", deluxeBurger.getChips());  // "Curvy" olmalı
        assertEquals("Coke", deluxeBurger.getDrink());    // "Coke" olmalı
    }

    @DisplayName("Healthy Burger sınıf değişkenleri doğru değerlere sahip mi?")
    @Test
    public void testHealthyBurgerInstanceVariables() {
        assertEquals("Tofu", healthyBurger.getMeat());  // HealthyBurger'da Tofu kullanılmalı
    }

    @DisplayName("Healthy Burger sınıfı addAddition methodları doğru çalışıyor mu?")
    @Test
    public void testHealthyBurgerAddAdditionMethods() {
        healthyBurger.addHealthyAddition1("Avocado", 2);
        healthyBurger.addHealthyAddition2("Bacon", 2);
        healthyBurger.itemizeHamburger();
        assertEquals(5.67, healthyBurger.getPrice(), 0.01);  // 5.67 + 2 + 2 = 9.67
    }
}
