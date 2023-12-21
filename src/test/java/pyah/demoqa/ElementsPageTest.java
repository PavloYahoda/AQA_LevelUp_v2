package pyah.demoqa;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static pyah.demoqa.ElementsPage.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class ElementsPageTest extends BaseTest {

    //Find and fill TextBox form
    @Test
    @Order(1)
    @DisplayName("Click and fill some elements")
    void findAndClick() throws InterruptedException {

        String fullNameValue = "Jack Black";
        String emailValue = "jackblack@jb.co";
        String currentAddressValue = "113, North street";
        String permanentAddressValue = "9, New Street";

        getHomePage()
                .clickOnElements()
                .clickAndFill(fullNameValue, emailValue, currentAddressValue, permanentAddressValue);

        String nameIsSet = getFilledName();
        String emailIsSet = getFilledEmail();
        String curAddressIsSet = getFilledCurAddress();
        String permAddressIsSet = getFilledPerAddress();

        assertEquals(fullNameValue, nameIsSet, "Full Name field is filled with mistakes");
        assertEquals(emailValue, emailIsSet, "Email field is filled with mistakes");
        assertEquals(currentAddressValue, curAddressIsSet, "Current Address field is filled with mistakes");
        assertEquals(permanentAddressValue, permAddressIsSet, "Permanent Address field is filled with mistakes");
        Thread.sleep(5000);
    }

    //Mark checkboxes
    @Test
    @Order(2)
    @DisplayName("Go to checkboxes")
    void markCheckboxes() throws InterruptedException {
        getElementsPage().workWithCheckboxes();
        boolean count = getElementsPage().isMarkedItems();
        assertTrue(count, "Number of marked checkboxes is correct");
    }
}

